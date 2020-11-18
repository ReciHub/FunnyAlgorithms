import time
import wave, struct, math, random

#Function For converting back
def Code_to_Txt():
    txt = code
    #Coverts it using the dictionary
    Out = [k for i in txt.split() for k,v in ENCODE_DICT.items() if i==v]
    newtxt = ''.join(Out)
    #Removes the two hashtags
    newtxt = newtxt[1:len(newtxt) -1]
    #Prints
    print(newtxt)


#Disctionary containing what to decode it from
ENCODE_DICT = { ' ':'//', 'A':'.-', 'B':'-...', 'C':'-.-.', 'D':'-..', 'E':'.', 'F':'..-.', 'G':'--.', 'H':'....',
                    'I':'..', 'J':'.---', 'K':'-.-', 'L':'.-..', 'M':'--', 'N':'-.','O':'---', 'P':'.--.', 'Q':'--.-',
                    'R':'.-.', 'S':'...', 'T':'-','U':'..-', 'V':'...-', 'W':'.--','X':'-..-.', 'Y':'-.--', 'Z':'--..',
                    '1':'.----', '2':'..---', '3':'...--','4':'....-', '5':'.....', '6':'-....','7':'--...', '8':'---..', '9':'----.',
                    '0':'-----', ', ':'--..--', '.':'.-.-.-','?':'..--..', '/':'-..-.', '-':'-....-','[':'-.--.', ']':'-.--.-', '#':'-..-', ':':'---..-.'}

#Opens A New wav For A Slowed Down Output
WavWrite = wave.open('./Output.wav', 'w')
#Opens The Wav File For Reading
WavRead = wave.open('./sound.wav', 'r')
#Opens Wavs For Data Reference
Dot = wave.open('./Audio/dot.wav', 'r')
Dash = wave.open('./Audio/dash.wav', 'r')
Gap = wave.open('./Audio/gap.wav', 'r')

#Gets Those Wav Files Data
DotFind = Dot.readframes(Dot.getnframes())
DashFind = Dash.readframes(Dash.getnframes())
GapFind = Gap.readframes(Gap.getnframes())

#Configures The Output
WavWrite.setnchannels(WavRead.getnchannels())
WavWrite.setsampwidth(WavRead.getsampwidth())
WavWrite.setframerate(WavRead.getframerate()/128)

#Gets The Data From Source Wav
frames = WavRead.readframes(WavRead.getnframes())
#Pushes it to the output
WavWrite.writeframes(frames)

#Sets Variables To Default
code = ''
xStart = 10000
x = xStart
y = 0
GapCount = 0

#Loops through data
while x > 0:
    if x == xStart - 4:
        #Fixes A Error with spacing
        code = code + " "
        GapCount = GapCount + 1
    #Looks For Data Being Equal To Dotfind and makes sure it is not to long
    if (frames.find(DotFind) != -1) and (frames.find(DotFind) < int(len(DashFind))):
        #Removes Used Data From Frames
        frames = frames[:frames.find(DotFind)] + frames[frames.find(DotFind) + len(DotFind) - 1:]
        #Adds the "Morse Code" To the output string
        code = code + '.'
        #Resets Gap count
        GapCount = 0
    #Looks For Data Being Equal To Dashfind and makes sure it is not to long
    elif (frames.find(DashFind) != -1) and (frames.find(DashFind) < int(len(DashFind))):
        #Removes Used Data From Frames
        frames = frames[:frames.find(DashFind)] + frames[frames.find(DashFind) + len(DashFind) - 1:]
        #Adds the "Morse Code" To the output string
        code = code + '-'
        #Resets Gap count
        GapCount = 0
    #Looks For Data Being Equal To Gapfind and makes sure it is not to long
    elif (frames.find(DotFind) != -1) and (frames.find(GapFind) < int(len(DashFind))):
        #Removes Used Data From Frames
        frames = frames[:frames.find(GapFind)] + frames[frames.find(GapFind) + len(GapFind) - 1:]
        #Adds the "Morse Code" To the output string
        code = code + ' '
        #Adds 1 to Gap Count
        GapCount = GapCount + 1
        if GapCount == 4:
            #Adds a space where it should be
            code = code + "// "
    #Ends when done
    else:
        y = y + 1
        if y < 3:
            break
    x-=1

#Prints The Encoded Text
print(code)

#Closes all open wavs
WavWrite.close()
WavRead.close()
Dot.close()
Dash.close()
Gap.close()

#Converts The Encoded Text To Original
Code_to_Txt()
