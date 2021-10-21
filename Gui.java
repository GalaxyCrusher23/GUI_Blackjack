import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
- Start Menu
- Instruction Screen
- Username Menu
- Game Screen 
- Lose Screen
*/

public class Gui implements ActionListener{
  public static JFrame window = new JFrame();
  public static int windowWidth = 400;
  public static int windowLength = 400;

  public static JPanel startMenu = new JPanel();
  public static JPanel instructMenu = new JPanel();
  public static JPanel gameMenu = new JPanel();
  public static JPanel loseMenu = new JPanel();
  //public static Paint paint = new Paint();

  private static int titlefontSize = 32;
  private static int namefontSize = 24;
  private static Color light_blue = new Color(100, 100, 255);
  private static Color dark_blue = new Color(0, 0, 125);

  public static int screen = 0;


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
    button.addActionListener(new Gui());
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

    JButton back = button(instructMenu, "Back", 0, 0, 100, 50);
    back.setBackground(dark_blue);
    back.setForeground(Color.WHITE);

    JButton next = button(instructMenu, "Next", windowWidth/2-50, windowLength/2+50, 100, 50);
    next.setBackground(dark_blue);
    next.setForeground(Color.WHITE);

    instructMenu.setVisible(true);
  }

  public static void game(){
    gameMenu = panel(window, windowWidth, windowLength);
    gameMenu.setLayout(null);

    gameMenu.setBackground(light_blue);

    JButton back = button(gameMenu, "Back", 0, 0, 100, 50);
    back.setBackground(dark_blue);
    back.setForeground(Color.WHITE);

    JButton hit = button(gameMenu, "Hit", windowWidth-100, 20, 100, 50);
    hit.setBackground(dark_blue);
    hit.setForeground(Color.WHITE);

    JButton stand = button(gameMenu, "Stand", windowWidth-100, 90, 100, 50);
    stand.setBackground(dark_blue);
    stand.setForeground(Color.WHITE);

    JButton forfeit = button(gameMenu, "Forfeit", windowWidth-100, 160, 100, 50);
    forfeit.setBackground(dark_blue);
    forfeit.setForeground(Color.WHITE);

    JButton doubleDown = button(gameMenu, "DoubleD", windowWidth-100, 230, 100, 50);
    doubleDown.setBackground(dark_blue);
    doubleDown.setForeground(Color.WHITE);

    JTextField bet = new JTextField();
    bet.setBounds(windowWidth/2, windowLength/2, 100, 25);
    gameMenu.add(bet);

    JLabel house = tag(gameMenu, "House", 20, 20, 200, 100);
    house.setForeground(Color.WHITE);
    house.setFont(new Font("Serif", Font.PLAIN, namefontSize));

    JLabel user = tag(gameMenu, "User", 20, 150, 200, 100);
    user.setForeground(Color.WHITE);
    user.setFont(new Font("Serif", Font.PLAIN, namefontSize));

    /*
    gameMenu.add(paint);
    paint.drawing();
    */

    gameMenu.setVisible(true);
  }

  public static void lose(){
    loseMenu = panel(window, windowWidth, windowLength);
    loseMenu.setLayout(null);

    loseMenu.setBackground(light_blue);

    loseMenu.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    String btxt = e.getActionCommand();

    switch(btxt){
      case "Play": case "Rules":
        startMenu.setVisible(false);
        if(btxt.equals("Play")){
          screen = 1;
        } else {
          screen = 2;
        }
        break;
      case "Back":
        instructMenu.setVisible(false);
        gameMenu.setVisible(false);
        screen = 0;
        break;
      default:
        break;
    }
  }
}