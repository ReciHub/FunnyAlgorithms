include Math


include Math

def get_cylinder_volume(radius, height)
    return Math::PI * radius ** 2 * height
end


print "Enter the radius of the cylinder: "
r = Float gets
print "Enter the height of the cylinder: "
h = Float gets

puts("The volume of the cylinder is:", get_cylinder_volume(r, h))
