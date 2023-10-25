import random
from PIL import Image, ImageDraw

# Set the dimensions of the canvas
width, height = 800, 600

# Create a blank canvas
canvas = Image.new('RGB', (width, height), 'white')
draw = ImageDraw.Draw(canvas)

# Define the number of shapes to generate
num_shapes = 100

for _ in range(num_shapes):
    # Generate random parameters for the shapes
    x1, y1 = random.randint(0, width), random.randint(0, height)
    x2, y2 = random.randint(0, width), random.randint(0, height)
    fill_color = (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
    
    # Ensure that x2 is greater than x1 for the rectangle
    if x1 > x2:
        x1, x2 = x2, x1
    
    # Ensure that y2 is greater than y1 for the ellipse
    if y1 > y2:
        y1, y2 = y2, y1
    
    # Choose a random shape to draw (rectangle or ellipse)
    shape_type = random.choice(['rectangle', 'ellipse'])
    
    if shape_type == 'rectangle':
        draw.rectangle([x1, y1, x2, y2], fill=fill_color)
    else:
        draw.ellipse([x1, y1, x2, y2], fill=fill_color)

# Save the generated art
canvas.save("generated_art.png")

