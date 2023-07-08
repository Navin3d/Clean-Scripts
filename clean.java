import java.io.File;

public class clean {

    public static void deleteTargetFolders(File rootDir) {
        File[] files = rootDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().equals("target")) {
                        System.out.println("Deleting: " + file.getAbsolutePath());
                        deleteFolderRecursive(file);
                    } else {
                        deleteTargetFolders(file);
                    }
                }
            }
        }
    }

    public static void deleteFolderRecursive(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolderRecursive(file);
                } else {
                    file.delete();
                }
            }
        }

        folder.delete();
    }

    public static void main(String[] args) {
        // Get the root directory dynamically
        String rootDirectory = System.getProperty("user.dir");

        File rootDir = new File(rootDirectory);
        deleteTargetFolders(rootDir);
    }
}
