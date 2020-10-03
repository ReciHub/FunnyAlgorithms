#include<iostream>
#include<cmath>
#include<GL/glut.h>

using namespace std;

const int W = 500;
const int H = 500;

float cube[8][4] = {
    {-1.0,-1.0,1.0,1.0}, 
    {1.0,-1.0,1.0,1.0},  
    {1.0,1.0,1.0,1.0},   
    {-1.0,1.0,1.0,1.0},  
    {-1.0,-1.0,-1.0,1.0},
    {1.0,-1.0,-1.0,1.0},
    {1.0,1.0,-1.0,1.0},
    {-1.0,1.0,-1.0,1.0}, 
};

void init()
{
    glClearColor(1.0,1.0,1.0,1.0);
    glEnable(GL_DEPTH_TEST);
}

void render();
void reshape(int, int);
void drawCube();
void mulMatrix(float[8][4], float[4][4]);

int main(int argc, char** argv)
{
    cout<<"------------------\n";
    cout<<"3D Transformations\n";
    cout<<"------------------\n";
    
    glutInit(&argc,argv);
    glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE | GLUT_DEPTH);
    glutInitWindowPosition(500,200);
    glutInitWindowSize(W,H);
    glutCreateWindow("3D Transformations");

    glutDisplayFunc(render);
    glutReshapeFunc(reshape);
    init();

    glutMainLoop();
    return 0;
}


void render()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    //for actually viewing the cube (or bringing the cube in the fov)
    glTranslatef(0.0,0.0,-8.0);
    glRotatef(-30.0,1.0,1.0,1.0);
    int choice;
    do {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        drawCube();
        cout<<"What transformation would you like to do ->\n";
        cout<<"1. Translation\n2. Scaling\n3. Rotation\n4. Exit\n";
        cout<<"Enter Code-> ";
        cin>>choice;
        switch(choice)
        {
            case 1: 
            {
                float tx,ty,tz;
                float newCube[8][4];
                cout<<"Enter X translation offset -> ";
                cin>>tx;
                cout<<"Enter Y translation offset-> ";
                cin>>ty;
                cout<<"Enter Z translation offset -> ";
                cin>>tz;
                
                for(int i=0;i<8;i++)
                {
                    cube[i][0] += tx;
                    cube[i][1] += ty;
                    cube[i][2] += tz;
                }
                break;
            }
            case 2:
            {
                float sx,sy,sz;
                cout<<"Enter X Scaling factor -> ";
                cin>>sx;
                cout<<"Enter Y Scaling factor -> ";
                cin>>sy;
                cout<<"Enter Z scaling factor -> ";
                cin>>sz;
                float T[4][4] = {{sx,0.0,0.0,0.0},{0.0,sy,0.0,0.0},{0.0,0.0,sz,0.0},{0.0,0.0,0.0,1.0}};
                mulMatrix(cube,T);
                break;
            }
            case 3: 
            {
                float ax,ay,az;
                cout<<"Enter angle of rotation along X axis (in degrees) -> ";
                cin>>ax;
                cout<<"Enter angle of rotation along Y axis (in degrees) -> ";
                cin>>ay;
                cout<<"Enter angle of rotation along Z axis (in degrees) -> ";
                cin>>az;
                ax = ax*(3.14/180);
                ay = ay*(3.14/180);
                az = az*(3.14/180);
                float TX[4][4] = {{1.0,0.0,0.0,0.0},{0.0,cos(ax),-1*sin(ax),0.0},{0.0,sin(ax),cos(ax),0.0},{0.0,0.0,0.0,1.0}};
                float TY[4][4] = {{cos(ay),0.0,sin(ay),0.0},{0.0,1.0,0.0,0.0},{-1*sin(ay),0.0,cos(ay),0.0},{0.0,0.0,0.0,1.0}};
                float TZ[4][4] = {{cos(az),-1*sin(az),0.0,0.0},{sin(az),cos(az),0.0,0.0},{0.0,0.0,1.0,0.0},{0.0,0.0,0.0,1.0}};
                mulMatrix(cube,TX);
                mulMatrix(cube,TY);
                mulMatrix(cube,TZ);
                break;
            }
        }
        glutSwapBuffers();
    } while(choice != 4);
    return;
}

void reshape(int w,int h)
{
    glViewport(0,0,w,h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0,1.0,2.0,50.0);
    glMatrixMode(GL_MODELVIEW);
}

void drawCube()
{
    glBegin(GL_QUADS);

    glColor3f(1.0,0.0,0.0);
    for(int i=0;i<4;i++)
        glVertex3f(cube[i][0],cube[i][1],cube[i][2]);
    glColor3f(0.0,1.0,0.0);
    for(int i=4;i<8;i++)
        glVertex3f(cube[i][0],cube[i][1],cube[i][2]);
    for(int i=1;i<=3;i++)
    {
        if(i==1)
            glColor3f(0.0,0.0,1.0);
        else if(i==2)
            glColor3f(1.0,1.0,0.0);
        else 
            glColor3f(1.0,0.0,1.0);
        glVertex3f(cube[i-1][0],cube[i-1][1],cube[i-1][2]);
        glVertex3f(cube[i][0],cube[i][1],cube[i][2]);
        glVertex3f(cube[i+4][0],cube[i+4][1],cube[i+4][2]);
        glVertex3f(cube[i+3][0],cube[i+3][1],cube[i+3][2]);
    }
    glColor3f(0.0,1.0,1.0);
    glVertex3f(cube[0][0],cube[0][1],cube[0][2]);
    glVertex3f(cube[3][0],cube[3][1],cube[3][2]);
    glVertex3f(cube[7][0],cube[7][1],cube[7][2]);
    glVertex3f(cube[4][0],cube[4][1],cube[4][2]);

    glEnd();
    glutSwapBuffers();
}

void mulMatrix(float c[8][4], float t[4][4])
{
    float newC[8][4];
    for(int i=0;i<8;i++)
    {
        for(int j=0;j<4;j++)
        {
            newC[i][j] = 0;
            for(int k=0;k<4;k++)
                newC[i][j] += c[i][k] * t[k][j];
        }
    }
    for(int i=0;i<8;i++)
        for(int j=0;j<4;j++)
            c[i][j] = newC[i][j];
}