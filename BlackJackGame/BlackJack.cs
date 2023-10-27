using System;
using System.Collections.Generic;
using System.Linq;

namespace BlackJack
{
    internal class Program
    {
        static List<Card> deckOfCards = new List<Card>()
            {
                new Card(CardNumber.Ace, Suit.Spades, 11, false),
                new Card(CardNumber.Ace, Suit.Hearts, 11, false),
                new Card(CardNumber.Ace, Suit.Diamonds, 11, false),
                new Card(CardNumber.Ace, Suit.Clubs, 11, false),
                 new Card(CardNumber.King, Suit.Spades, 10, false),
                new Card(CardNumber.King, Suit.Hearts, 10, false),
                new Card(CardNumber.King, Suit.Diamonds, 10, false),
                new Card(CardNumber.King, Suit.Clubs, 10, false),
                 new Card(CardNumber.Queen, Suit.Spades, 10, false),
                new Card(CardNumber.Queen, Suit.Hearts, 10, false),
                new Card(CardNumber.Queen, Suit.Diamonds, 10, false),
                new Card(CardNumber.Queen, Suit.Clubs, 10, false),
                 new Card(CardNumber.Jack, Suit.Spades, 10, false),
                new Card(CardNumber.Jack, Suit.Hearts, 10, false),
                new Card(CardNumber.Jack, Suit.Diamonds, 10, false),
                new Card(CardNumber.Jack, Suit.Clubs, 10, false),
                 new Card(CardNumber.Ten, Suit.Spades, 10, false),
                new Card(CardNumber.Ten, Suit.Hearts, 10, false),
                new Card(CardNumber.Ten, Suit.Diamonds, 10, false),
                new Card(CardNumber.Ten, Suit.Clubs, 10, false),
                 new Card(CardNumber.Nine, Suit.Spades, 9, false),
                new Card(CardNumber.Nine, Suit.Hearts, 9, false),
                new Card(CardNumber.Nine, Suit.Diamonds, 9, false),
                new Card(CardNumber.Nine, Suit.Clubs, 9, false),
                 new Card(CardNumber.Eight, Suit.Spades, 8, false),
                new Card(CardNumber.Eight, Suit.Hearts, 8, false),
                new Card(CardNumber.Eight, Suit.Diamonds, 8, false),
                new Card(CardNumber.Eight, Suit.Clubs, 8, false),
                 new Card(CardNumber.Seven, Suit.Spades, 7, false),
                new Card(CardNumber.Seven, Suit.Hearts, 7, false),
                new Card(CardNumber.Seven, Suit.Diamonds, 7, false),
                new Card(CardNumber.Seven, Suit.Clubs, 7, false),
                 new Card(CardNumber.Six, Suit.Spades, 6, false),
                new Card(CardNumber.Six, Suit.Hearts, 6, false),
                new Card(CardNumber.Six, Suit.Diamonds, 6, false),
                new Card(CardNumber.Six, Suit.Clubs, 6, false),
                 new Card(CardNumber.Five, Suit.Spades, 5, false),
                new Card(CardNumber.Five, Suit.Hearts, 5, false),
                new Card(CardNumber.Five, Suit.Diamonds, 5, false),
                new Card(CardNumber.Five, Suit.Clubs, 5, false),
                 new Card(CardNumber.Four, Suit.Spades, 4, false),
                new Card(CardNumber.Four, Suit.Hearts, 4, false),
                new Card(CardNumber.Four, Suit.Diamonds, 4, false),
                new Card(CardNumber.Four, Suit.Clubs, 4, false),
                 new Card(CardNumber.Three, Suit.Spades, 3, false),
                new Card(CardNumber.Three, Suit.Hearts, 3, false),
                new Card(CardNumber.Three, Suit.Diamonds, 3, false),
                new Card(CardNumber.Three, Suit.Clubs, 3, false),
                 new Card(CardNumber.Two, Suit.Spades, 2, false),
                new Card(CardNumber.Two, Suit.Hearts, 2, false),
                new Card(CardNumber.Two, Suit.Diamonds, 2, false),
                new Card(CardNumber.Two, Suit.Clubs, 2, false),
            };

        static void Main(string[] args)
        {

            Console.WriteLine("Welcome to BlackJack, May I know your name?");
            string playerName = Console.ReadLine();

            while (string.IsNullOrEmpty(playerName))
            {
                Console.WriteLine("Please enter a valid name");
                playerName = Console.ReadLine();
            }

            Console.WriteLine("Do you want to play BlackJack");
            string gameInput = Console.ReadLine();

            while (string.IsNullOrEmpty(gameInput))
            {
                Console.WriteLine("Please enter a valid input");
                gameInput = Console.ReadLine();
            }

            bool continuePlaying = true;

            while (continuePlaying)
            {
                if (gameInput.ToLowerInvariant().Trim() == "yes")
                {
                    Result r = PlayBlackJack(playerName);

                    switch (r)
                    {
                        case Result.Win:
                            Console.WriteLine($"{playerName} Wins!");
                            break;
                        case Result.Lose:
                            Console.WriteLine($"{playerName} Loses!");
                            break;
                        case Result.Draw:
                            Console.WriteLine($"Game Draw!");
                            break;
                        default:
                            Console.WriteLine("Invalid");
                            break;

                    }

                    foreach (Card card in deckOfCards)
                    {
                        card.IsUsed = false;
                    }

                    Console.WriteLine("Do you want to play again?");
                    gameInput = Console.ReadLine();
                }
                else
                {
                    Console.WriteLine("Thanks for playing");
                    continuePlaying = false;
                }
            }

            Console.ReadKey();
        }


        private static Card DealCard()
        {
            Random rand = new Random();

            while (true)
            {
                int index = rand.Next(0, deckOfCards.Count);
                Card cardDealt = deckOfCards[index];
                if (!cardDealt.IsUsed)
                {
                    cardDealt.IsUsed = true;

                    return cardDealt;
                }
                continue;

            }

        }

        private static Result CheckForWin(int playerCount, int dealerCount)
        {
            if (playerCount > 22)
            {
                return Result.Lose;
            }

            if (dealerCount > 22)
            {
                return Result.Win;
            }


            if (playerCount == 21 && dealerCount == 21)
            {
                return Result.Draw;

            }

            if (playerCount == 21)
            {
                return Result.Win;
            }

            if (dealerCount == 21)
            {
                return Result.Draw;
            }

            int compare = playerCount.CompareTo(dealerCount);

            switch (compare)
            {
                case 0:
                    return Result.Draw;
                case 1: return Result.Win;
                case -1: return Result.Lose;
            }



            return Result.Draw;
        }

        private static Result PlayBlackJack(string playerName)
        {
            Stack<Card> dealerCards = new Stack<Card>();
            Stack<Card> playerCards = new Stack<Card>();
            int dealerCount = 0;
            int playerCount = 0;

            while (playerCards.Count != 2)
            {
                AddCardToPlayer(ref playerCount, playerCards);
            }

            while (dealerCards.Count != 2)
            {
                AddCardToPlayer(ref dealerCount, dealerCards);

            }

            if (dealerCards.Count == 2 && playerCards.Count == 2)
            {
                CheckForWin(playerCount, dealerCount);


                Console.WriteLine($"{playerName}");
                foreach (Card card in playerCards)
                {
                    Console.WriteLine($"{card}");

                }

                Console.WriteLine($"Dealer");
                foreach (Card card in dealerCards)
                {
                    Console.WriteLine($"{card}");

                }

                while (playerCount < 22)
                {
                    Console.WriteLine("What do you want to do next?");
                    Console.WriteLine("Hit");
                    Console.WriteLine("Stand");

                    string nextOption = Console.ReadLine();

                    while (string.IsNullOrEmpty(nextOption))
                    {

                        Console.WriteLine("Please enter a valid option");
                        nextOption = Console.ReadLine();

                    }

                    switch (nextOption?.ToLower()?.Trim())
                    {
                        case "hit":
                            Card card = DealCard();

                            AddCardToPlayer(ref playerCount, playerCards);

                            Console.WriteLine($"{playerName}");
                            foreach (Card pcard in playerCards)
                            {
                                Console.WriteLine($"{pcard}");

                            }

                            if (playerCount == 21)
                            {
                                while (dealerCount <= 17)
                                {
                                    AddCardToPlayer(ref dealerCount, dealerCards);
                                    Console.WriteLine($"Dealer");
                                    foreach (Card dcard in dealerCards)
                                    {
                                        Console.WriteLine($"{dcard}");

                                    }

                                }
                                return CheckForWin(playerCount, dealerCount);
                            }

                            break;
                        case "stand":
                            while (dealerCount <= 17)
                            {
                                AddCardToPlayer(ref dealerCount, dealerCards);
                                Console.WriteLine($"Dealer");
                                foreach (Card dcard in dealerCards)
                                {
                                    Console.WriteLine($"{dcard}");

                                }

                            }
                            return CheckForWin(playerCount, dealerCount);

                        default:
                            Console.WriteLine("Please enter a valid option");
                            break;
                    }
                }



            }

            return CheckForWin(playerCount, dealerCount);

        }

        private static void AddCardToPlayer(ref int playerCount, Stack<Card> playerCards)
        {
            Card cardDealt = DealCard();
            int futureCount = playerCount + cardDealt.Value;

            if (futureCount > 21)
            {

                Card aceCard = playerCards.FirstOrDefault(x => x.Number == CardNumber.Ace);

                if (aceCard != null && aceCard.Value == 11)
                {
                    aceCard.Value = 1;
                    playerCount -= 10;
                }
                else if (cardDealt.Number == CardNumber.Ace)
                {
                    cardDealt = new Card(CardNumber.Ace, cardDealt.Suit, 1, true);

                }

            }

            playerCards.Push(cardDealt);
            playerCount += cardDealt.Value;
        }
    }

    public class Card
    {
        public CardNumber Number { get; set; }

        public Suit Suit { get; set; }

        public int Value { get; set; }

        public bool IsUsed { get; set; }

        public Card(CardNumber cardNumber, Suit suit, int value, bool isUsed)
        {
            this.Number = cardNumber;
            this.Suit = suit;
            this.Value = value;
            this.IsUsed = isUsed;
        }

        public override string ToString()
        {
            return $"{Number} of {Suit}";

        }
    }

    public enum Suit
    {

        Hearts,

        Spades,

        Diamonds,

        Clubs


    }

    public enum CardNumber
    {
        Ace,
        King,
        Queen,
        Jack,
        Ten,
        Nine,
        Eight,
        Seven,
        Six,
        Five,
        Four,
        Three,
        Two

    }

    public enum Result
    {
        Win,

        Draw,

        Lose
    }
}
