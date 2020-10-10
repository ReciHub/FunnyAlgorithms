import time
import wave, struct, math, random

WavSetter = wave.open('./Audio/dot.wav')
SampleRate = WavSetter.getframerate()
SampleWidth = WavSetter.getsampwidth()
SampleChannels = WavSetter.getnchannels()

obj = wave.open('sound.wav','w')
obj.setnchannels(SampleChannels)
obj.setsampwidth(SampleWidth)
obj.setframerate(SampleRate*128)

WavSetter.close()

MORSE_CODE_DICT = { ' ':'/', 'A':'.-', 'B':'-...', 'C':'-.-.', 'D':'-..', 'E':'.', 'F':'..-.', 'G':'--.', 'H':'....',
                    'I':'..', 'J':'.---', 'K':'-.-', 'L':'.-..', 'M':'--', 'N':'-.','O':'---', 'P':'.--.', 'Q':'--.-',
                    'R':'.-.', 'S':'...', 'T':'-','U':'..-', 'V':'...-', 'W':'.--','X':'-..-', 'Y':'-.--', 'Z':'--..',
                    '1':'.----', '2':'..---', '3':'...--','4':'....-', '5':'.....', '6':'-....','7':'--...', '8':'---..', '9':'----.',
                    '0':'-----', ', ':'--..--', '.':'.-.-.-','?':'..--..', '/':'-..-.', '-':'-....-','[':'-.--.', ']':'-.--.-', '#':'-..-', ':':'---..-.'}


def Txt_to_Morse():
    txt = input('Enter Text to Convert to Morse: ')
    txt = '#' + txt + '#'
    code = [MORSE_CODE_DICT[i.upper()] + ' ' for i in txt if i.upper() in MORSE_CODE_DICT.keys()]
    morse=''.join(code)
    print(morse)
    for m in morse:
        if m=='.':
            WavSetter = wave.open('./Audio/dot.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()
        elif m=='-':
            WavSetter = wave.open('./Audio/dash.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()
        elif m=='/':
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()
        else:
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()


Txt_to_Morse()

obj.close()