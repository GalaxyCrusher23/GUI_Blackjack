import javax.swing.*;

class Main {
  public static void main(String[] args) {
    while(!(Gui.screen<0)){
      gameplay();
    }
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
      default:
        break;
    }
  }
}