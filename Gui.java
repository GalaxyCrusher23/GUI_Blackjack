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
  public static JPanel gameMenu = new JPanel();
  public static JPanel loseMenu = new JPanel();

  private static int titlefontSize = 32;
  private static Color light_blue = new Color(100, 100, 255);
  private static Color dark_blue = new Color(0, 0, 125);


  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  public static JLabel tag(JPanel panel, String text, int x, int y, int width, int height) {
    JLabel label = new JLabel(text);
    label.setBounds(x, y, width, height);
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

    startMenu.setBackground(light_blue);

    JLabel title = tag(startMenu, "Blackjack", windowWidth/2-(int)(titlefontSize/0.38), 0, 200, 100);
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Serif", Font.BOLD, titlefontSize));

    JButton play = button(startMenu, "Play", windowWidth/2-50, windowLength/2, 100, 50);
    play.setBackground(dark_blue);
    play.setForeground(Color.WHITE);

    JButton rules = button(startMenu, "Rules", windowWidth/2-50, windowLength/2+75, 100, 50);
    rules.setBackground(dark_blue);
    rules.setForeground(Color.WHITE);

    startMenu.setVisible(true);
  }

  public static void instruct(){
    instructMenu = panel(window, windowWidth, windowLength);
    instructMenu.setLayout(null);

    instructMenu.setBackground(light_blue);

    JLabel title = tag(instructMenu, "Instructions", windowWidth/2-(int)(titlefontSize/0.38), 0, 500, 100);
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Serif", Font.BOLD, titlefontSize));

    JButton back = button(instructMenu, "Back", windowWidth-100, windowLength-75, 100, 50);
    back.setBackground(dark_blue);
    back.setForeground(Color.WHITE);

    instructMenu.setVisible(true);
  }

  public static void game(){
    gameMenu = panel(window, windowWidth, windowLength);
    gameMenu.setLayout(null);

    gameMenu.setBackground(light_blue);

    gameMenu.setVisible(true);
  }

  public static void lose(){
    loseMenu = panel(window, windowWidth, windowLength);
    loseMenu.setLayout(null);

    loseMenu.setBackground(light_blue);

    loseMenu.setVisible(true);
  }
}