from tkinter import *
from tkinter.ttk import *


from time import strftime

root = Tk()
root.title("Clock")
root.resizable(0,0)

def time():
    string = strftime('%I:%M:%S %p')
    label.config(text=string)
    label.after(1000, time)


label = Label(root, font=("Arial", 100), background="black", foreground="cyan")
label.pack(anchor='center')

time()

mainloop()