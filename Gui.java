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
  public static int windowWidth = 400;
  public static int windowLength = 400;

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

  public static JLabel tag(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
    JLabel label = new JLabel(text);
    label.setBounds(x, y, width, height);
    label.setFont(new Font("Serif", Font.BOLD, fontSize));
    panel.add(label);
    return label;
  }

  public static JButton button(JPanel panel, String text, int x, int y, int width, int height){
    JButton button = new JButton(text);
    button.setBounds(x, y, width, height);
    panel.add(button);
    //button.addActionListener(new GUI());
    return button;
  }

  

  public static void start(){
    startMenu = panel(window, windowWidth, windowLength);
    startMenu.setLayout(null);

    startMenu.setBackground(new Color(0, 125, 0));

    JLabel title = tag(startMenu, "Blackjack", windowWidth/2-50, 0, 200, 100, 19);
    title.setForeground(Color.WHITE);

    JButton play = button(startMenu, "Play", windowWidth/2, windowLength/2, 100, 100);
    play.setBackground(Color.YELLOW);
    play.setForeground(Color.BLACK);

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