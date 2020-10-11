import time
import wave, struct, math, random

#Opens Dot.wav as all audio settings EG
WavSetter = wave.open('./Audio/dot.wav')
SampleRate = WavSetter.getframerate()
SampleWidth = WavSetter.getsampwidth()
SampleChannels = WavSetter.getnchannels()

#Opens A New Wav File For Output
obj = wave.open('sound.wav','w')
#Sets its settings to the EG
obj.setnchannels(SampleChannels)
obj.setsampwidth(SampleWidth)
obj.setframerate(SampleRate*128)

#Closes the EG
WavSetter.close()

#Disctionary containing what to encode it to
ENCODE_DICT = { ' ':'/', 'A':'.-', 'B':'-...', 'C':'-.-.', 'D':'-..', 'E':'.', 'F':'..-.', 'G':'--.', 'H':'....',
                    'I':'..', 'J':'.---', 'K':'-.-', 'L':'.-..', 'M':'--', 'N':'-.','O':'---', 'P':'.--.', 'Q':'--.-',
                    'R':'.-.', 'S':'...', 'T':'-','U':'..-', 'V':'...-', 'W':'.--','X':'-..-', 'Y':'-.--', 'Z':'--..',
                    '1':'.----', '2':'..---', '3':'...--','4':'....-', '5':'.....', '6':'-....','7':'--...', '8':'---..', '9':'----.',
                    '0':'-----', ', ':'--..--', '.':'.-.-.-','?':'..--..', '/':'-..-.', '-':'-....-','[':'-.--.', ']':'-.--.-', '#':'-..-', ':':'---..-.'}

#The To Audio Algorythm
def Txt_to_Morse():
    #Gets The Text
    txt = input('Enter Text to Convert to Morse: ')
    #This is a simple fix for an error in the future
    txt = '#' + txt + '#'
    #Encodes The Text
    code = [ENCODE_DICT[i.upper()] + ' ' for i in txt if i.upper() in ENCODE_DICT.keys()]
    Encoded=''.join(code)
    #Prints it
    print(Encoded)
    #Loops through and converts each symbol to audio
    for m in Encoded:
        if m=='.':
            #Opens Wav File As Data
            WavSetter = wave.open('./Audio/dot.wav', 'r')
            #Gets its Data
            frames = WavSetter.readframes(WavSetter.getnframes())
            #Writes Data To Output
            obj.writeframes(frames)
            #Closes Wav File
            WavSetter.close()
        elif m=='-':
            #Opens Wav File As Data
            WavSetter = wave.open('./Audio/dash.wav', 'r')
            #Gets its Data
            frames = WavSetter.readframes(WavSetter.getnframes())
             #Writes Data To Output
            obj.writeframes(frames)
            #Closes Wav File
            WavSetter.close()
        elif m=='/':
            #Opens Wav File As Data
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            #Gets its Data
            frames = WavSetter.readframes(WavSetter.getnframes())
            #Writes Data To Output
            obj.writeframes(frames)
            #Closes Wav File
            WavSetter.close()

            #Repetes Above
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            frames = WavSetter.readframes(WavSetter.getnframes())
            obj.writeframes(frames)
            WavSetter.close()
        else:
            #Opens Wav File As Data
            WavSetter = wave.open('./Audio/gap.wav', 'r')
            #Gets its Data
            frames = WavSetter.readframes(WavSetter.getnframes())
             #Writes Data To Output
            obj.writeframes(frames)
            #Closes Wav File
            WavSetter.close()

#Calls the main function
Txt_to_Morse()

#Ends By Closing The Output Wav
obj.close()