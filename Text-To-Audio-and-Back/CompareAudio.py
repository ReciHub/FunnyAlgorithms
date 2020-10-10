import time
import pyttsx3 as pyttsx
import wave, struct, math, random

WavWrite = wave.open('./Output.wav', 'r')
WavRead = wave.open('./HelloComparison.wav', 'r')

WF = WavWrite.readframes(WavWrite.getnframes())
RF = WavRead.readframes(WavRead.getnframes())

if WF == RF:
    print("Same")

WavRead.close()
WavWrite.close()