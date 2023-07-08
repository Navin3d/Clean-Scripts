import os

def delete_venv(root_dir):
    for dirpath, dirnames, filenames in os.walk(root_dir):
        for dirname in dirnames[:]:
            if dirname == 'venv':
                venv_path = os.path.join(dirpath, dirname)
                print(f"Deleting: {venv_path}")
                delete_folder_recursive(venv_path)
                dirnames.remove(dirname)

def delete_folder_recursive(folder_path):
    if os.path.exists(folder_path):
        for root, dirs, files in os.walk(folder_path, topdown=False):
            for file in files:
                file_path = os.path.join(root, file)
                os.remove(file_path)
            for dir in dirs:
                dir_path = os.path.join(root, dir)
                os.rmdir(dir_path)
        os.rmdir(folder_path)
        print(f"Deleted: {folder_path}")

# Get the root directory dynamically
root_directory = os.path.dirname(os.path.abspath(__file__))

delete_venv(root_directory)
