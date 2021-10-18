import java.util.Random;

public class Cards{

    //Needs to print the card image!

    //maybe an error in the future
    public int[][] cards = [[1,2,3,4,5,6,7,8,9,10,11,12,13]*4];
    private int cardValue = 0;
    private int suitValue = 0;
    
    public int getcards() {
      cardValue = rand.nextInt(13)+1;
      suitValue = rand.nextInt(4)+1;

      if (cards[suitValue][cardValue] == 0) {
        while (true){
           cardValue = rand.nextInt(13)+1; 
        }
      }

      cards[suitValue][cardValue] = 0;
      return cardValue;
    }

   //public int getsuitsValue() {
   // return suitValue;
   // }

    public int[][] resetCards(int[][] cards){
      for (int x = 0; x < 4; x++){
        for (int y= 0; y < 13; y++) {
          cards[x][y] = y+1;
        }
      }
      return cards;
    }   
}