
# Flappy Bird Game in C++ using SDL

This is a simplified version of the classic Flappy Bird game implemented in C++ using the Simple DirectMedia Layer (SDL) library. The game features a bird that the player controls, and the goal is to navigate the bird through a series of pipes without colliding with them.

## Prerequisites

Before running the game, make sure you have the following:

- C++ development environment.
- Simple DirectMedia Layer (SDL) and SDL_image libraries installed. You can download them from the official SDL website: https://www.libsdl.org/download-2.0.php
- Two image files: `bird.png` and `pipe.png`, placed in the same directory as your source code. You can find sample images online or create your own.


4. Use the `SPACE` key to make the bird jump and navigate through the pipes.

## Game Controls

- Press `SPACE` to make the bird jump.

## Game Rules

- The game ends if the bird collides with a pipe or if it falls to the ground.
- Try to achieve the highest score by navigating the bird through as many pipes as possible.

## Code Structure

- The code is organized into classes: `Bird` and `Pipe`, each responsible for specific game elements.
- The main loop handles game updates, collision detection, and rendering.

## License

This project is open-source and available under the [MIT License](LICENSE).
