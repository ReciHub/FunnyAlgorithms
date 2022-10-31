def return_coins(user_money : int, coin_list : list) -> list:
    """Function that returns the minimum amount of coins to convert
    a given amount of money

    Args:
        user_money (int): provided amount of money
        coin_list (list): list with the value of coins

    Returns:
        list: minimum amount of coins from the provided list
    """
    user_coins = []
    for coin in coin_list:
        while(user_money >= coin):
            user_coins.append(coin)
            user_money -= coin
    return user_coins        

def run() -> None:
    """Run function, asks the user how much money would be converted into coins.
    """
    print("How much money is to be converted into coins?")
    user_input = int(input())
    coin_list = [25, 10, 5, 2, 1]
    user_coins = return_coins(user_input, coin_list)
    print(user_coins)

if __name__ == "__main__":
    run()