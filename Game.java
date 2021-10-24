public class Game{

  public static int cash = 1000; 
  public static int userTotal;
  public static int houseTotal;
  public static int bet = 0;
  public static int userCount;
  public static int houseCount;
  public static int [] userHand = {0, 0, 0, 0, 0};
  public static int [] houseHand = {0 ,0 ,0 ,0 ,0};
  public static int uTotal;
  public static int hTotal;
  public static boolean userWon;
  public static int dealNumber = 1;
  
  public static Player user = new Player();
  public static Player house = new Player();
  
  public static void setBet(String input)
  {
    bet = Integer.parseInt(input);
  }

  public static int getBet()
  {
    return bet;
  }

  public static void changeCash(int userInputBet)
  {
    cash -= userInputBet;
  }

  public static void returnCash(int userChoice)
  {
    //Calls only if didWin is true
    switch (userChoice)
    {
      case 1: //Hit or Stand
        cash += bet*2;
        break;
      case 2: //DoubleDown
        cash += bet*4;
        break;
      case 3: //Surrender/Forfeit
        cash += bet/3;
        break;
      default: //Should never reach Default
        System.out.println("Why did it go here?");
        break;
    }
    
  }

  public static boolean didWin()
  {
    if (userTotal > 21)
    {
      userWon = false;
    }
    else if (houseTotal > 21)
    {
      userWon = true;
    }
    else if (userTotal <= houseTotal)
    {
      userWon = false;
    } else {
      userWon = true;
    }
    return userWon;
  }

  public static void userHit()
  {
    user.setHand(userHand);
    user.setCount(userCount);
    user.setPlayerCards();
    userHand = user.getPlayerHand();
    userCount = user.getPlayerCount();
    userTotal = user.getPlayerTotal();
  }

  public static void houseHit()
  {
    house.setHand(houseHand);
    house.setCount(houseCount);
    house.setPlayerCards();    
    houseHand = house.getPlayerHand();
    houseCount = house.getPlayerCount();
    houseTotal = house.getPlayerTotal();
  }

  public static void resetVar()
  {
    for (int x = 0; x < 5; x++)
    {
      userHand[x] = 0;
      houseHand[x] = 0;
    }
    houseCount = 0;
    userCount = 0;
    userTotal = 0;
    houseTotal = 0;
    dealNumber++;
    Cards.resetCards();
  }

  public static void dealCards()
  {
    for (int x = 0; x < 2; x++)
    {
      userHit();
    }
    houseHit();
    
  }
}