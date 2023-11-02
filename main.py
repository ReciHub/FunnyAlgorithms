import pygame
import sys

# Initialize Pygame
pygame.init()

# Constants
WIDTH, HEIGHT = 800, 600
BIRD_WIDTH, BIRD_HEIGHT = 50, 50
FPS = 30

# Colors
WHITE = (255, 255, 255)

# Create the display surface
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Animated Bird')

# Load bird image
bird_img = pygame.image.load('bird.png')  # Make sure you have an image file named 'bird.png'

# Initial bird position
bird_x = WIDTH // 2
bird_y = HEIGHT // 2

# Bird animation variables
bird_speed_x = 5

# Main game loop
clock = pygame.time.Clock()
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Move the bird
    bird_x += bird_speed_x

    # Clear the screen
    screen.fill(WHITE)

    # Draw the bird
    screen.blit(bird_img, (bird_x, bird_y))

    pygame.display.flip()
    clock.tick(FPS)

pygame.quit()
sys.exit()
