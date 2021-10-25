import javax.swing.*;

class Main{
  public static void main(String[] args) {
    Game game1 = new Game();
    gameplay();
  }

  public static void gameplay(){
    switch(Gui.screen){
      case 0:
        Gui.start();
        break;
      case 1:
        Gui.game();
        break;
      case 2:
        Gui.instruct();
        break;
      case 3:
        Gui.lose();
        break;
      default:
        break;
    }
  }

}