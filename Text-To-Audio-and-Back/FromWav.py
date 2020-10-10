import time
import wave, struct, math, random

def Morse_to_Txt():
    txt = morse
    Out = [k for i in txt.split() for k,v in MORSE_CODE_DICT.items() if i==v]
    newtxt = ''.join(Out)
    newtxt = newtxt[1:len(newtxt) -1]
    print(newtxt)
	
MORSE_CODE_DICT = { ' ':'//', 'A':'.-', 'B':'-...', 'C':'-.-.', 'D':'-..', 'E':'.', 'F':'..-.', 'G':'--.', 'H':'....',
                    'I':'..', 'J':'.---', 'K':'-.-', 'L':'.-..', 'M':'--', 'N':'-.','O':'---', 'P':'.--.', 'Q':'--.-',
                    'R':'.-.', 'S':'...', 'T':'-','U':'..-', 'V':'...-', 'W':'.--','X':'-..-.', 'Y':'-.--', 'Z':'--..',
                    '1':'.----', '2':'..---', '3':'...--','4':'....-', '5':'.....', '6':'-....','7':'--...', '8':'---..', '9':'----.',
                    '0':'-----', ', ':'--..--', '.':'.-.-.-','?':'..--..', '/':'-..-.', '-':'-....-','[':'-.--.', ']':'-.--.-', '#':'-..-', ':':'---..-.'}

WavWrite = wave.open('./Output.wav', 'w')
WavRead = wave.open('./sound.wav', 'r')
Dot = wave.open('./Audio/dot.wav', 'r')
Dash = wave.open('./Audio/dash.wav', 'r')
Gap = wave.open('./Audio/gap.wav', 'r')

DotFind = Dot.readframes(Dot.getnframes())
DashFind = Dash.readframes(Dash.getnframes())
GapFind = Gap.readframes(Gap.getnframes())


WavWrite.setnchannels(WavRead.getnchannels())
WavWrite.setsampwidth(WavRead.getsampwidth())
WavWrite.setframerate(WavRead.getframerate()/128)

frames = WavRead.readframes(WavRead.getnframes())
WavWrite.writeframes(frames)

morse = ''
xStart = 10000
x = xStart
y = 0
GapCount = 0

while x > 0:
    #print(len(frames))
    if x == xStart - 4:
        morse = morse + " "
        GapCount = GapCount + 1
    if (frames.find(DotFind) != -1) and (frames.find(DotFind) < int(len(DashFind))):
        #print("Found")
        #print(str(frames.find(DotFind)) + ' : Dot')
        frames = frames[:frames.find(DotFind)] + frames[frames.find(DotFind) + len(DotFind) - 1:]
        morse = morse + '.'
        GapCount = 0
    elif (frames.find(DashFind) != -1) and (frames.find(DashFind) < int(len(DashFind))):
        #print("Found")
        #print(str(frames.find(DashFind)) + ' : Dash')
        frames = frames[:frames.find(DashFind)] + frames[frames.find(DashFind) + len(DashFind) - 1:]
        morse = morse + '-'
        GapCount = 0
    elif (frames.find(DotFind) != -1) and (frames.find(GapFind) < int(len(DashFind))):
        #print("Found")
        #print(str(frames.find(GapFind)) + ' : Gap')
        frames = frames[:frames.find(GapFind)] + frames[frames.find(GapFind) + len(GapFind) - 1:]
        morse = morse + ' '
        GapCount = GapCount + 1
        if GapCount == 4:
            morse = morse + "// "
    else:
        y = y + 1
        if y < 3:
            break
    x-=1
    #print(x)

print(morse)

WavWrite.close()
WavRead.close()
Dot.close()
Dash.close()
Gap.close()

Morse_to_Txt()
