#include <stdio.h>
#include <math.h>

float calcVolume(float radius, float height){
	return M_PI*radius*radius*height;
}

int main()
{
	float radius, height;

	printf("Enter the radius of cylinder: ");
	scanf("%f", &radius);
	printf("Enter the height of cylinder: ");
	scanf("%f", &height);
	printf("The volume of given cylinder is %f\n", calcVolume(radius, height));
	return 0;
}