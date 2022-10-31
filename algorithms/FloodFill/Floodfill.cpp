#include <bits/stdc++.h>
#include <graphics.h> 

int main() 
{ 
	int gd = DETECT, gm; 
  
	initgraph(&gd, &gm, " "); 

	int x_circle = 250; 
	int y_circle = 250; 
	int radius=100; 
	
	int border_color = WHITE; 
	
	setfillstyle(HATCH_FILL,RED); 
	
	circle(x_circle,y_circle,radius); 
	
	floodfill(x_circle,y_circle,border_color); 

	getch();  
	closegraph(); 
	
	return 0; 
} 
