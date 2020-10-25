//initial variables and introduction

int x = 1;
int y = 2;

Console.Write(n/ "Hello, welcome to the user form.");
Console.Write(n/ "Here, we try to understand through your data, which company suits you.");
Console.WriteLine(n/ "Now can you tell me what your name is?");

string name = Console.ReadLine();

//body

Console.Write(n/"First we would like to know, do you prefer the color black or yellow? Believe me, this is extremely important.");
Console.WriteLine("Type {0} for black. Type {1} for yellow.", x, y);
int firstResponse = int.Parse(Console.ReadLine());

if (firstResponse == x) {
    Console.Write("I'm starting to think you like a car company that starts with U ... well let's go to the next question!");
}
else if (firstResponse == y) {
    Console.Write("So suspicious ... I think you like a two-digit car company ... well let's move on to the next question!");
}
else {
    Console.Write("Wait...what?");
}

Console.WriteLine("Do you prefer higher quality or lower cost? For quality, type {0}, for cost, type {1}.", x, y);
int secondResponse = int.Parse(Console.ReadLine());

if (secondResponse == x) {
    Console.WriteLine("I'm almost coming up with an answer!");
}
else if (firstResponse == x || secondResponse == y) {
    Console.WriteLine("You confuse me. But let's continue!");
}
else {
    Console.WriteLine("I'm getting close to a response for the answer.");
}

Console.WriteLine("Do you prefer economy cars or first class cars? Enter 1 for economy, enter 2 for the other.");
int thirdResponse = int.Parse(Console.ReadLine());

//Conclusion

if (firstResponse == x || secondResponse == x || thirdResponse == y) {
    Console.WriteLine("Obviously you {0} match with Uber! To be honest, I also combine more with Uber, but please don't tell anyone, I have to be impartial. This is our secret!", name);
}
else if (firstResponse == x || secondResponse == y || thirdResponse == y) {
    Console.WriteLine("Obviously you {0} match with Uber! To be honest, I also combine more with Uber, but please don't tell anyone, I have to be impartial. This is our secret!", name);
}
else if (firstResponse == y || secondResponse == x || thirdResponse == y) {
    Console.WriteLine("Obviously you {0} match with Uber! To be honest, I also combine more with Uber, but please don't tell anyone, I have to be impartial. This is our secret!", name);
}
else if (firstResponse == x || secondResponse == x || thirdResponse == x) {
    Console.WriteLine("Obviously you {0} match with Uber! To be honest, I also combine more with Uber, but please don't tell anyone, I have to be impartial. This is our secret!", name);
}
else if (firstResponse == y || secondResponse == y || thirdResponse == y) {
    Console.WriteLine("Apparently {0}, you match with 99 Pop, good trip!", name);
}
else if (firstResponse == y || secondResponse == y || thirdResponse == x ) {
    Console.WriteLine("Apparently {0}, you match with 99 Pop, good trip!", name);
}
else if (firstResponse == y || secondResponse == x || thirdResponse == x ) {
    Console.WriteLine("Apparently {0}, you match with 99 Pop, good trip!", name);
}
else if (firstResponse == x || secondResponse == y || thirdResponse == x ) {
    Console.WriteLine("Apparently {0}, you match with 99 Pop, good trip!", name);
}
else {
    Console.WriteLine("EXCUSE {0} BUT I DON'T IDENTIFY, I FAILED MY MISSION!", name);
}




