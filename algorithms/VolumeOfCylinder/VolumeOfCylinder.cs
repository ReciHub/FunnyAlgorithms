using System;

namespace volumeOfCylinder
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter the radius of the cylinder: ");
            var r = Console.ReadLine();
            double radius = Convert.ToDouble(r);

            Console.Write("Enter the height of the cylinder: ");
            var h = Console.ReadLine();
            double height = Convert.ToDouble(h);

            double volume = getVolumeOfCylinder(radius, height);

            Console.WriteLine($"The volume of the cylinder is: {volume}");
        }

        private static double getVolumeOfCylinder(double r, double h)
        {
            return Math.PI * Math.Pow(r,2) * h;
        }
    }
}