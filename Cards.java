import java.util.Random;

public class Cards{

    private static Random rand = new Random();
    
    private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};    
    private static int cardValue = 0;
    private static int suitValue = 0;

    public static void cCards(int[] cards)
    {
      while (cards[cardValue] == 0){
          cardValue = rand.nextInt(13); 
      }
      cards[cardValue] = 0;
    }
    
    public static int getcards() {

      cardValue = rand.nextInt(13);
      suitValue = rand.nextInt(4);


      while (cards[suitValue][cardValue] == 0){
        cardValue = rand.nextInt(13); 
      }

      cards[suitValue][cardValue] = 0;

      //cardDrawing();

      switch (cardValue)
      {
        case 1:
          cardValue = 11;
          break;
        case 11:
        case 12:
        case 13:
          cardValue = 10;
          break;
        default:
          break;
      }

      return cardValue;
    }

    /*public static void cardDrawing(int cvalue, int svalue){
      int cardLimit = 5;
      int cardX = 20;
      int cardY = 50;
      int cardGap = 30;
      JLabel[] userDrawCards = new JLabel[cardLimit];
      JLabel[] houseDrawCards = new JLabel[cardLimit];
      
      for(int i = 0; i < cardLimit; i++){
        userDrawCards[i] = new JLabel(Integer.toString(cvalue));
        switch(svalue){
          case 0: case 1:
            userDrawCards.setForeground(Color.RED);
            break;
          case 2: case 3:
            userDrawCards.setForeground(Color.BLACK);
            break;
          default:
            break;
        }
        userDrawCards[i].setBounds(cardX+(cardGap*i), cardY+180, 100, 100);
        Gui.gameMenu.add(userDrawCards[i]);
      }

    }*/

    public static void resetCards()
    {
      for (int x = 0; x < 4; x++)
      {
        for (int y = 0; y < 13; y++)
        {
          cards[x][y] = y+1;
        }
      }
    }   
}