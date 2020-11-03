using System;

class MainClass {
  public static void Main (string[] args) {
    //Corpo - Body

    Console.WriteLine("Hello welcome! I'm the Birthday Guesser! ");
    Console.WriteLine("Now I'm going to ask you a few questions to know your birthday!");

    Console.WriteLine("What year were you born?");
    int yearBirth = int.Parse(Console.ReadLine());

    Console.WriteLine("What year is it now?");
    int yearActual = int.Parse(Console.ReadLine());

    int age = yearActual - yearBirth;

    Console.WriteLine("Your age is 1,110 years old! Just kidding, your real age is {0}", age);
  }
}
