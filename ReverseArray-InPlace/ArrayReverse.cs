using System;
using System.Threading;

namespace testeCSharp
{
    class Program
    {
        static void Main(string[] args){


            //Example of use
            int[] arrayInt = {1, 2, 3, 4};
            string[] arrayString = {"0", "1", "2", "3"};

            arrayInt = ArrayReverse<int>(arrayInt, arrayInt.Length);
            arrayString = ArrayReverse<string>(arrayString, arrayString.Length);


            foreach (string item in arrayString)
            {
                System.Console.Write(item);
            }

        }

        static T[] ArrayReverse<T>(T[] array, int arrayLength){
            
            T[] arrayReverse = new T[arrayLength];

            for (int i = arrayLength - 1; i > -1; i--)
            {

                arrayReverse[(arrayLength - 1) - i] = array[i];

            }

            return arrayReverse;

        }
        
    }

}