
import os
from turtle import position

BASE_PATH = './algorithms'

def load_dirs():
    tree = list(os.walk(BASE_PATH))
    dirs = tree[0][1]
    return dirs

# --- Missing Readme.md files

def generate_readme(dir):
    with open('./scripts/readme.template.md', 'r') as file:
        data = file.read()
        data = data.replace('{title}', dir)
        return data

def create_readme(dirs):
    print('Creating Readme.md where it should exists')
    for dir in dirs:
        readme_exists = os.path.exists(f'{BASE_PATH}/{dir}/Readme.md')
        if not readme_exists:
            print(f'Creating Readme.md to: {BASE_PATH}/{dir}')
            content = generate_readme(dir)
            file = open(f'{BASE_PATH}/{dir}/Readme.md', 'w')
            file.write(content)
            file.close()

# --- Generating index

def generate_content(dirs):
    content = ''
    dirs = sorted(list(dirs))
    for dir in dirs:
        path = dir.replace(' ', '%20')
        content += f'- [{dir}](algorithms/{path}/Readme.md)\n'
    return content

def update_file(content):
    with open('Readme.md', 'r') as f:
        contents = f.readlines()
        start_index = contents.index('<!-- algorithm_start -->\n')
        end_index = contents.index('<!-- algorithm_end -->\n')
    
    contents = [row for idx, row in enumerate(contents) if idx <= start_index or idx >= end_index]

    # print(start_index, end_index)

    contents = [*contents[0:start_index+1], content, *contents[start_index+1:end_index+1]]

    with open('Readme.md', 'w') as f:
        contents = "".join(contents)
        f.write(contents)

def update_algorithm_list(dirs):
    print('Updating Algorithms section on Readme.md')
    content = generate_content(dirs)
    update_file(content)

# ---

if __name__ == '__main__':
    print('Executing scripts')
    dirs = load_dirs()
    # create_readme(dirs)
    update_algorithm_list(dirs)