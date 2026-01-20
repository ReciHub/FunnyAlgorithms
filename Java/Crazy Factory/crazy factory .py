import pygame
import random

# Initialize Pygame
pygame.init()

# Constants
SCREEN_WIDTH, SCREEN_HEIGHT = 800, 600
WHITE = (255, 255, 255)
FPS = 60

# Set up the screen
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("Crazy Factory Game")

# Load images
factory_worker = pygame.image.load("factory_worker.png")
falling_object = pygame.image.load("falling_object.png")

# Game variables
worker_width, worker_height = factory_worker.get_size()
object_width, object_height = falling_object.get_size()
worker_x = (SCREEN_WIDTH - worker_width) // 2
object_x = random.randint(0, SCREEN_WIDTH - object_width)
object_y = 0
object_speed = 5

clock = pygame.time.Clock()

# Game loop
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Move the falling object
    object_y += object_speed
    if object_y > SCREEN_HEIGHT:
        object_x = random.randint(0, SCREEN_WIDTH - object_width)
        object_y = 0

    # Check collision
    if object_y + object_height > SCREEN_HEIGHT - 50 and \
            worker_x < object_x < worker_x + worker_width:
        # Handle collision (for example, increase score)
        pass

    # Draw everything
    screen.fill(WHITE)
    screen.blit(factory_worker, (worker_x, SCREEN_HEIGHT - worker_height - 50))
    screen.blit(falling_object, (object_x, object_y))

    pygame.display.flip()

    # Limit frames per second
    clock.tick(FPS)

# Quit Pygame
pygame.quit()
