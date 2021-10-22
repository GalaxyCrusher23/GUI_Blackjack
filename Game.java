public class Game{

  public static int cash = 1000;  
  public static int userTotal;
  public static int houseTotal;
  public static int bet = 0;
  public static int userCount;
  public static int houseCount;
  public static int [] userHand = {0,0,0,0,0};
  public static int [] houseHand = {0,0,0,0,0};
  public static boolean userStand;
  public static int userAction = 0;
  
  public static Player user = new Player();
  public static Player house = new Player();
  public static Winner win = new Winner();
  
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
    for (int x = 0; x < 5; x++){
      userHand[x] = 0;
      houseHand[x] = 0;
    }
    houseCount = 0;
    userCount = 0;
    Cards.resetCards();
    userStand = false;
  }

  //Main Game Loop //call it in main

  private void gameLoop()
  {
    resetVar();
    for (int x = 0; x < 2; x++)
    {
      userHit();
    }
    houseHit();

    if (!(userTotal > 21) || !(userStand))
    {
        while (true)
        {
          switch (userAction)
          {
          case 1: //hit
          userHit();
            break;    
          case 2: //Stand
            userStand = true;
            break;    
          case 3: //doubleDown
            userHit();
            userStand = true;
            break;    
          case 4: //Surrender
            break;    
          case 5: //Insurance
            break;
          default:
            break;
          }
        }
      }
      if (win.total(userTotal,houseTotal))
      {
        cash += bet*2;
      }
  }
}