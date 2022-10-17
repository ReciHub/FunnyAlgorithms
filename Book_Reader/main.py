from PyPDF2 import PdfFileReader
import pyttsx3

print('-'*40)
print(f'{" "*12}PDF to audiobook')
print('-'*40)

path = input('paste the path to your .pdf book without spaces: ')
audioName = input('type the name to the saved audio from the book: ')

pdfReader = PdfFileReader(open(path, 'rb'))

speaker = pyttsx3.init()

for page_num in range(pdfReader.numPages):
    print(f'page: {page_num + 1}')
    text = pdfReader.getPage(page_num).extractText()
    speaker.say(text)
    speaker.runAndWait()

    option = int(input('''
    1 - next page
    2 - stop reading
    '''))

    if option == 2:
        break
speaker.stop()

willSave = int(input('1 - Create audio file\n2 - exit\n'))

if willSave == 1:
    final_audio = ''

    for page_num in range(pdfReader.numPages):
        final_audio += pdfReader.getPage(page_num).extractText()

    speaker.save_to_file(final_audio, f'audios/{audioName}.mp3')
    speaker.runAndWait()
