#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Simulating energy level
int EnergyLevel = 20;

// Function to simulate waiting (procrastination)
void wait(int minutes) {
    printf("Waiting for %d minutes...\n", minutes);
    EnergyLevel -= minutes; // Procrastination drains energy
}

// Function to find the nearest sibling (younger sibling)
int findNearestSibling() {
    // Randomly decide if a younger sibling is nearby
    srand(time(NULL));
    int found = rand() % 2;
    return found;
}

// Function to attempt a bribe
void attemptBribe(int sibling, const char* briberyItem) {
    if (sibling) {
        printf("Bribing younger sibling with %s...\n", briberyItem);
    } else {
        printf("No sibling found to bribe. Looks like you're out of luck!\n");
    }
}

// Function to simulate snack acquisition
void getSnackWithoutMoving() {
    // Step 1: Summon a sibling
    int sibling = findNearestSibling();
    if (!sibling) {
        printf("No snack for you. Time to starve.\n");
        return;
    }

    // Step 2: Bribe the sibling
    const char* briberyItems[] = {"Candy", "Allowance", "Extra TV Time", "A Compliment"};
    int randomIndex = rand() % 4;
    attemptBribe(sibling, briberyItems[randomIndex]);

    // Step 3: Wait for snack delivery
    printf("Waiting for snack delivery...\n");
    wait(5);

    // Randomly decide if the sibling returns with a snack
    int snackReceived = rand() % 2;
    if (!snackReceived) {
        printf("You've lost a sibling. Maybe next time be nicer.\n");
    } else {
        printf("Success! You've acquired a snack without moving.\n");
        printf("Snack satisfaction increased by 100%%!\n");
    }
}

int main() {
    getSnackWithoutMoving();
    return 0;
}
