#include <stdio.h>

int main(void) {
	// your code goes here
	
	float radius,height,volume;
	
	 printf("Enter the radius of the cylinder:");
         scanf("%f",&radius);
        printf("Enter the height of the cylinder::");
         scanf("%f",&height);

         volume = (22 * radius * radius * height) / 7;

        printf("The volume of Cylinder is: %f", volume);


	return 0;
}
