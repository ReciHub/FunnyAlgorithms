//okay, we know that the volume of a cylinder is expressed as:
// V = π * r² * h
// So, it's pretty simple for us
// We can use Math.PI to express the pi value

// In this function, the radius and height MUST have the same unit of measurement
function volumeCylinder(radius, height) {
    // Our function will the the volume valume in the unit used
    return Math.PI * radius * radius * height;
}

//Testing
const radius = 5;
const height = 12;
const volume = volumeCylinder(radius, height)
console.log(volume)