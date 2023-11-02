import pygame

'''
This program shows how to extract an animation from a spritesheet.
Image credit: https://pixabay.com/gifs/sand-clock-hourglass-rotating-8826/
'''

# Constants
BLUE = (0, 0, 255)
RED = (255, 0, 0)


# Set up pygame
pygame.init()
window = pygame.display.set_mode((1000, 700))
pygame.display.set_caption("Spritesheet Animator")
clock = pygame.time.Clock()

# Load spritesheet
sprite = pygame.image.load("spritesheet.png")
sprite_small = pygame.transform.scale(sprite, (300, 300))
sprite_columns = 3
sprite_rows = 3
frame_width = 612
frame_height = 612
frame_small_width = 100
frame_small_height = 100
frame_count = 9

# Run main loop
running = True
frame = 0
x = 0
y = 0
x_small = 0
y_small = 0
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    
    # Run logic
    frame += 1
    if frame == frame_count:
        frame = 0
    
    # Calculate frame positions
    x = (frame % sprite_rows) * frame_width
    y = (frame // sprite_rows) * frame_height
    x_small = (frame % sprite_rows) * frame_small_width + 10
    y_small = (frame // sprite_rows) * frame_small_height + 10

    # Draw screen
    window.fill(BLUE)
    window.blit(
        sprite,
        (344, 44, 612, 612),
        (x, y, frame_width, frame_height)
    )
    window.blit(
        sprite_small,
        (10, 10, 300, 300)
    )
    pygame.draw.rect(window, RED, [x_small, y_small, frame_small_width, frame_small_height], 5)

    pygame.display.flip()

    # Set framerate
    clock.tick(10)


pygame.quit()