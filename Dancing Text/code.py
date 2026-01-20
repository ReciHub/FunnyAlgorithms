import time
import os

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def dancing_text(text, duration=5):
    frame_duration = 0.1  # Adjust this value to change the speed of the dance

    for _ in range(int(duration / frame_duration)):
        clear_screen()
        for _ in range(3):
            print("  \o/  " + text)
            print("   |   " + text)
            print("  / \  " + text)
            time.sleep(frame_duration)
            clear_screen()
            time.sleep(frame_duration)

if __name__ == "__main__":
    text_to_dance = input("Enter the text you want to make dance: ")
    dancing_text(text_to_dance)

