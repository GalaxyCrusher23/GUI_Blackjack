import javax.swing.*;
import java.awt.*;

/*
- Start Menu
- Instruction Screen
- Username Menu
- Game Screen 
- Lose Screen
*/

public class Gui{
  public static JFrame window = new JFrame();
  public static windowWidth = 400;
  public static windowLength = 400;

  public static JPanel startMenu = new JPanel();
  public static JPanel instructMenu = new JPanel();
  public static JPanel userMenu = new JPanel();
  public static JPanel gameMenu = new JPanel();
  public static JPanel loseMenu = new JPanel();


  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  public static JLabel tag(JPanel panel, String text, int x, int y, int width, int length) {
    JLabel label = new JLabel(text, SwingConstants.CENTER);
    label.setBounds(x, y, width, length);
    panel.add(label);
    return label;
  }

  public static void start(){
    startMenu = panel(window, windowWidth, windowLength);

    startMenu.setBackground(Color.DARK_GREEN);

    JLabel title = tag(startMenu, "Blackjack", (int)windowWidth/2, 10, (int)windowWidth*0.75, (int)windowLength*0.75);

    title.setForeground(Color.WHITE);

    startMenu.setVisible(true);
  }

  public static void insturct(){
  
  }

  public static void user(){

  }

  public static void game(){

  }

  public static void lose(){

  }
}