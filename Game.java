public class Game{

  public static int cash = 1000;  
  public static int userTotal;
  public static int houseTotal;
  private int userCount;
  private int houseCount;
  public int [] userHand;
  public int [] houseHand;
  private boolean userStand;
  private int userAction = 0;
  
  Player user = new Player();
  Player house = new Player();
  Winner win = new Winner();
  
  private void userHit()
  {
    user.setHand(userHand);
    user.setCount(userCount);
    user.setPlayerCards();
    userHand = user.getPlayerHand();
    userCount = user.getPlayerCount();
    userTotal = user.getPlayerTotal();
  }

  private void houseHit()
  {
    house.setHand(houseHand);
    house.setCount(houseCount);
    house.setPlayerCards();    
    houseHand = house.getPlayerHand();
    houseCount = house.getPlayerCount();
    houseTotal = house.getPlayerTotal();
  }

  private void resetVar()
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

/*
  private double getuserBet(String userInput)
  {
    try
    {
      userBet = (double)userInput;
    }
    catch (Exception e){
      System.out.println("Not a valid number.");
    }
  }
  */

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
      win.total(userTotal,houseTotal);
  }
}