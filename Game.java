public class Game {

  private int cash = 1000;  
  private int userTotal;
  private int houseTotal;
  private int userCount;
  private int houseCount;
  public int [] userHand;
  public int [] houseHand;
  private boolean userStand;

  private userAction = 0;

  Player user = new Player();
  Player house = new Player();

  private void userHit()
  {
    user.setHand(userHand);
    user.setCount(userCount);
    user.setplayerCards();
    userHand = user.getHand();
    userCount = user.getCount();
    userTotal = user.getplayerTotal();
  }

  private void houseHit()
  {
    house.setHand(houseHand);
    house.setCount(houseCount);
    house.setplayerCards();    
    houseHand = house.getHand();
    houseCount = house.getCount();
    houseTotal = house.getplayerTotal();
  }

  private void resetVar()
  {
    userHand = {0,0,0,0,0};
    houseHand = {0,0,0,0,0};
    houseCount = 0;
    userCount = 0;
    Cards.resetCards();
    userStand = false;
  }

  private double getuserBet(String userInput)
  {
    try
    {
      userBet = (double)userInput;
    }
    catch (Exception e){
      System.out.println("Not a valid number.")
    }
  }

  //Main Game Loop //call it in main

  Game.resetVar();

  for (int i = 0; i < 2; i++)
  {
    Game.userHit();
  }
  Game.houseHit();

  if (userTotal <= 21) || (userStand != true)
  {
    while true
    {
      switch (userAction)
      {
      case 1: //hit
      Game.userHit();
        break;    
      case 2: //Stand
        userStand = true;
        break;    
      case 3: //doubleDown
        Game.userHit();
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

  
}