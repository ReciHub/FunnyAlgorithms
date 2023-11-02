import time
import winsound

def annoying_alarm_clock(duration, snooze_time):
    # Play the alarm sound progressively louder
    for i in range(1, duration + 1):
        winsound.Beep(500, 100)  # Play a beep sound
        time.sleep(i)  # Wait for i seconds

    # After the alarm duration, ask if the user wants to snooze
    snooze = input("Press 's' to snooze for {} seconds, or any other key to stop: ".format(snooze_time))
    if snooze.lower() == 's':
        time.sleep(snooze_time)
        annoying_alarm_clock(duration, snooze_time)  # Recursively snooze

if __name__ == "__main__":
    alarm_duration = 30  # Duration of the alarm (in seconds)
    snooze_time = 300  # Snooze time (in seconds)

    print("Annoying Alarm Clock - It gets louder over time!")
    print("Press Ctrl+C to stop the alarm at any time.")

    try:
        annoying_alarm_clock(alarm_duration, snooze_time)
    except KeyboardInterrupt:
        print("\nAlarm stopped.")
