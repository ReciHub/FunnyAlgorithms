from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import math


def init():
    glClearColor(0.0, 0.0, 0.0, 1.0)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()

    gluOrtho2D(0, 400, 0, 400)


def EllipsePlotPoints(x_centre, y_centre, x, y):
    glVertex2i(x_centre + x, x_centre + y)
    glVertex2i(x_centre - x, y_centre + y)
    glVertex2i(x_centre + x, y_centre - y)
    glVertex2i(x_centre - x, y_centre - y)
    glVertex2i(x_centre + y, y_centre + x)
    glVertex2i(x_centre - y, y_centre + x)
    glVertex2i(x_centre + y, y_centre - x)
    glVertex2i(x_centre - y, y_centre - x)


def MidPointEllipseDraw(rx,ry,x_centre, y_centre):
    x = 0
    y = ry

    # EllipsePlotPoints(x_centre, y_centre, x, y)

    D1 = ((ry**2)-(rx*rx*ry)+(0.25*rx*rx))
    dx=(2*rx*ry*x)
    dy=(2*rx*rx*y)

    glColor3f(0.5, 1.0, 0.0)
    glPointSize(3.0)
    glBegin(GL_POINTS)

    while dx < dy:

        print("(", x + x_centre, ",", y + y_centre, ")")
        glVertex2i(x + x_centre,  y + y_centre)

        print("(", -x + x_centre, ",", y + y_centre, ")")
        glVertex2i(-x + x_centre, y + y_centre)

        print("(", x + x_centre, ",", -y + y_centre, ")")
        glVertex2i(x + x_centre, -y + y_centre)

        print("(", -x + x_centre, ",", -y + y_centre, ")")
        glVertex2i(-x + x_centre,  -y + y_centre)

        if D1 < 0:
            x += 1
            dx = dx + (2 * ry * ry)
            D1 = D1 + dx + (ry * ry)

        else:
            x += 1
            y -= 1
            dx = dx + (2 * ry * ry)
            dy = dy - (2 * rx * rx)
            D1 = D1 + dx - dy + (ry * ry)

        # EllipsePlotPoints(x_centre, y_centre, x, y)

    d2 = (((ry * ry) * ((x + 0.5) * (x + 0.5))) +
          ((rx * rx) * ((y - 1) * (y - 1))) -
           (rx * rx * ry * ry))

    while (y>=0):
        print("(", x + x_centre, ",", y + y_centre, ")")
        glVertex2i(x + x_centre,  y + y_centre)

        print("(", -x + x_centre, ",", y + y_centre, ")")
        glVertex2i(-x + x_centre, y + y_centre)

        print("(", x + x_centre, ",", -y + y_centre, ")")
        glVertex2i(x + x_centre, -y + y_centre)

        print("(", -x + x_centre, ",", -y + y_centre, ")")
        glVertex2i(-x + x_centre,  -y + y_centre)
 
        # Checking and updating parameter
        # value based on algorithm
        if (d2 > 0):
            y -= 1
            dy = dy - (2 * rx * rx)
            d2 = d2 + (rx * rx) - dy
        else:
            y -= 1
            x += 1
            dx = dx + (2 * ry * ry)
            dy = dy - (2 * rx * rx)
            d2 = d2 + dx - dy + (rx * rx)

        # EllipsePlotPoints(x_centre, y_centre, x, y)
        

    glEnd()
    glFlush()


def main():
    x = int(input("\nEnter centre:\n\tx: "))
    y = int(input("\n\ty: "))
    rx = int(input("\nEnter centre:\n\trx: "))
    ry = int(input("\n\try: "))
    print("starting window....")
    glutInit(sys.argv)
    glutInitDisplayMode(GLUT_RGB)
    glutInitWindowSize(500, 500)
    glutInitWindowPosition(0, 0)
    glutCreateWindow("Plot Ellipse using Midpoint Ellipse Drawing Algorithm")
    glutDisplayFunc(lambda: MidPointEllipseDraw(rx,ry,x,y))
    init()
    glutMainLoop()


main()
