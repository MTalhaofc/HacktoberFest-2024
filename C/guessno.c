#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_ATTEMPTS 10

int main() {
    int number, guess, attempts = 0;
    
    // Seed the random number generator
    srand(time(0));
    number = rand() % 100 + 1; // Random number between 1 and 100

    printf("Welcome to the Number Guessing Game!\n");
    printf("I have selected a number between 1 and 100.\n");
    printf("You have %d attempts to guess it.\n", MAX_ATTEMPTS);

    // Game loop
    while (attempts < MAX_ATTEMPTS) {
        printf("Enter your guess: ");
        scanf("%d", &guess);
        attempts++;

        if (guess < 1 || guess > 100) {
            printf("Please guess a number between 1 and 100.\n");
            attempts--; // Do not count invalid attempts
            continue;
        }

        if (guess < number) {
            printf("Too low! Try again.\n");
        } else if (guess > number) {
            printf("Too high! Try again.\n");
        } else {
            printf("Congratulations! You've guessed the number %d in %d attempts!\n", number, attempts);
            break;
        }
        
        if (attempts == MAX_ATTEMPTS) {
            printf("Sorry! You've used all your attempts. The correct number was %d.\n", number);
        }
    }

    return 0;
}
