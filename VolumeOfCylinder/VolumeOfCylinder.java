import java.util.Scanner;

class VolumeOfCylinder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the radius of the cylinder:");
        double r = s.nextDouble();
        System.out.println("Enter the height of the cylinder::");
        double h = s.nextDouble();

        double volume = getVolumeOfCylinder(r, h);

        System.out.println("The volume of Cylinder is: " + volume);

    }

    private static double getVolumeOfCylinder(double r, double h) {
        return (22 * r * r * h) / 7;
    }
}
