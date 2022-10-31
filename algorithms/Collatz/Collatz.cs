namespace ConsoleApp6
{
    static class Collatz
    {
        public static string Conjecture(int num)
        {
            if (num > 0)
            {
                var count = 0;
                while (num > 1)
                {
                    num = ((num % 2 == 0) ? num / 2 : num * 3 + 1);
                    count++;
                }

                return "Reached 1 after " + count + " iterations";
            }
            else
                return "Invalid number";
        }
    }
}
