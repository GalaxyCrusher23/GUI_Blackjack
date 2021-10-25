public class Game{

  //Declares static variables, with some have an initial value such as the arrays and cash
  public static int cash = 1000; 
  public static int userTotal; //Represents the card total or sum
  public static int houseTotal;
  public static int bet = 0;
  public static int userCount; //Reprents how much cards the user has (is needed for the index of the arrays)
  public static int houseCount;
  public static int [] userHand = {0, 0, 0, 0, 0}; //Array that stores the value of the cards in the user's hand
  public static int [] userSuit = {0, 0, 0, 0, 0}; //Array that stores the value of the suit colours from the user's hand
  public static int [] houseHand = {0 ,0 ,0 ,0 ,0};
  public static int [] houseSuit = {0 ,0 ,0 ,0 ,0};
  public static boolean userWon; //did user win or not?
  public static int dealNumber = 0; //Round number
  
  //Creates objects from the Player class
  public static Player user = new Player();
  public static Player house = new Player();
  
  public static void setBet(String input)
  {
    //Sets the bet number from the input textbox
    bet = Integer.parseInt(input);
  }

  public static int getBet()
  {
    //Returns the bet number
    return bet;
  }

  public static void changeCash(int userInputBet)
  {
    //Subtracts bet from cash
    cash -= userInputBet;
  }

  public static void returnCash(int userChoice)
  {
    //Calls only if didWin is true
    //Checks what the payout should be based on the user's choice
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
    //Methods that checks if user won or not (returns a true for win, or false for lost)
    if (userTotal > 21) //Checks if user bust
    {
      userWon = false;
    }
    else if (houseTotal > 21) //Checks if house bust while user did not
    {
      userWon = true;
    }
    else if (userTotal <= houseTotal) //Checks if house has a higher or equal total then user
    {
      userWon = false;
    } else { //If it not any of three cases, user must have a higher total than house
      userWon = true;
    }
    return userWon;
  }

  public static void userHit()
  {
    //Procedure that handles userHit by calling multiple methods from the player class using the User object
    user.setHand(userHand); //Passes the userHand array to Player class
    user.setSuits(userSuit); //Passes the suit array to Player class
    user.setCount(userCount); //Passes the user card total to Player Class
    user.setPlayerCards(); //Calls the method that recieves the card from Player
    user.setPlayerSuits();//Calls the method that recieves the suit from Player
    userHand = user.getPlayerHand(); //Gets the value and stores it
    userCount = user.getPlayerCount(); //Gets the array and stores it
    userTotal = user.getPlayerTotal(); //Gets the value and stores it 
    userSuit = user.getPlayerSuits();//Gets the array and stores it
  }

  public static void houseHit()
  {
    //Procedures that handles the house hitting by calling multiple methods from the player class using the House object
    //Functionaly is identical to userHit() instead with user object, it is using house object
    house.setHand(houseHand);
    house.setSuits(houseSuit);
    house.setCount(houseCount);
    house.setPlayerCards();
    house.setPlayerSuits();    
    houseHand = house.getPlayerHand();
    houseCount = house.getPlayerCount();
    houseTotal = house.getPlayerTotal();
    houseSuit = house.getPlayerSuits();
  }

  public static void resetVar()
  {
    //Procedure that resets all the variables
    for (int x = 0; x < 5; x++)
    {
      //Goes through all the arrays for hand and suit and resets it to 0
      userHand[x] = 0;
      houseHand[x] = 0;
      houseSuit[x] = 0;
      userSuit[x] = 0;
    }
    //Resets variables to 0
    houseCount = 0;
    userCount = 0;
    userTotal = 0;
    houseTotal = 0;
    dealNumber++; //Adds one to dealNumber, represetning the round
    Cards.resetCards(); //Resets the 52 card deck from the Card Class.
  }

  public static void dealCards()
  {
    //Procedure that handles the inital dealing of the cards
    userHit();
    userHit();
    houseHit();
  }
}