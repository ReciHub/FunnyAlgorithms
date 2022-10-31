
import os

BASE_PATH = './algorithms'

def main():
    tree = list(os.walk(BASE_PATH))
    dirs = tree[0][1]
    create_readme(dirs)

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


if __name__ == '__main__':
    print('Executing scripts')
    main()