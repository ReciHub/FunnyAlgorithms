#include <iostream>
#include<graphics.h>
#include<conio.h>
void flood_fill(int,int,int,int);
using namespace std;
int main()
{int gd=DETECT,gm;
initgraph(&gd,&gm,"");
int old_color=0,new_color=BLUE;   //old_color is the color of background before filling.
        //new_color is the color we want to fill.
//making triangle having multiple colour boundary.
setcolor(4);
line(100,100,200,200);
setcolor(5);
line(100,100,200,150);
setcolor(3);
line(200,150,200,200);
flood_fill(150,130,old_color,new_color);//selecting an internal coordinate(150,130) as seed or as starting point.
getch();
closegraph();
    return 0;
}

void flood_fill(int x,int y,int old_color,int new_color)
{
    if(getpixel(x,y)==old_color)
    {   putpixel(x,y,new_color);
         flood_fill1(x+1,y,old_color,new_color);
        flood_fill1(x-1,y,old_color,new_color);
        flood_fill1(x,y+1,old_color,new_color);
        flood_fill1(x,y-1,old_color,new_color);

    }


}
