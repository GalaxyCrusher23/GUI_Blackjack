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
  public static JFrame window = new JFrame("Blackjack");
  public static int windowWidth = 600;
  public static int windowLength = 400;

  public static JPanel startMenu = new JPanel();
  public static JPanel instructMenu = new JPanel();
  public static JPanel gameMenu = new JPanel();
  public static JPanel loseMenu = new JPanel();
  public static JTextField bet = new JTextField();
  //public static Paint paint = new Paint();

  private static int titlefontSize = 32;
  private static int namefontSize = 24;
  private static int cardfontSize = 48;
  private static int pgfontSize = 11;
  private static boolean isBack = true;
  private static Color light_blue = new Color(100, 100, 255);
  private static Color dark_blue = new Color(0, 0, 125);
  private static Color dark_red = new Color(125, 0, 0);

  private static int rulesX = 17;
  private static int rulesY = 50;
  private static int rulesGap = 25;
  private static int cardX = 20;
  private static int cardY = 80;
  private static int cardGap = 80;

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

  public static JButton button(JPanel panel, String text, int x, int y, int width, int height, boolean action){
    JButton button = new JButton(text);
    button.setBounds(x, y, width, height);
    panel.add(button);
    if(action){
      button.addActionListener(new Gui());
    }
    return button;
  }

  

  public static void start(){
    startMenu = panel(window, windowWidth, windowLength);
    startMenu.setLayout(null);

    startMenu.setBackground(light_blue);

    JLabel title = tag(startMenu, "Blackjack", windowWidth/2-(int)(titlefontSize/0.38), 0, 200, 100);
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Serif", Font.BOLD, titlefontSize));

    JButton play = button(startMenu, "Play", windowWidth/4-50, windowLength/2, 100, 50, true);
    play.setBackground(dark_blue);
    play.setForeground(Color.WHITE);

    JButton rules = button(startMenu, "Rules", windowWidth/2-50, windowLength/2, 100, 50, true);
    rules.setBackground(dark_blue);
    rules.setForeground(Color.WHITE);

    JButton quit = button(startMenu, "Quit",(int)(windowWidth*(0.75)-50), windowLength/2, 100, 50, true);
    quit.setBackground(dark_blue);
    quit.setForeground(Color.WHITE);

    startMenu.setVisible(true);
  }

  public static void instruct(){
    instructMenu = panel(window, windowWidth, windowLength);
    instructMenu.setLayout(null);

    instructMenu.setBackground(light_blue);

    JLabel title = tag(instructMenu, "Instructions", windowWidth/2-(int)(titlefontSize/0.38), 0, 500, 100);
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Serif", Font.BOLD, titlefontSize));

    JButton back = button(instructMenu, "Back", 0, 0, 100, 50, true);
    back.setBackground(dark_blue);
    back.setForeground(Color.WHITE);

    JButton next = button(instructMenu, "Next", windowWidth/2-50, windowLength/2+75, 100, 50, false);
    next.setBackground(dark_blue);
    next.setForeground(Color.WHITE);

    JLabel txt = tag(instructMenu, "The player will get two cards face up whilst the house gets two cards as well, but one face down.", rulesX, rulesY, 600, 150);
    txt.setForeground(Color.WHITE);
    txt.setFont(new Font("Serif", Font.PLAIN, pgfontSize));
    JLabel txt2 = tag(instructMenu, "The player must reach as close to 21 without going over by adding the total of their cards. If the", rulesX, rulesY+rulesGap, 600, 150);
    txt2.setForeground(Color.WHITE);
    txt2.setFont(new Font("Serif", Font.PLAIN, pgfontSize));
    JLabel txt3 = tag(instructMenu, "player isn’t close to 21, they can receive an additional card via hit. If the player is satisfied with", rulesX, rulesY+(rulesGap*2), 600, 150);
    txt3.setForeground(Color.WHITE);
    txt3.setFont(new Font("Serif", Font.PLAIN, pgfontSize));
    JLabel txt4 = tag(instructMenu, "their total, they can stand. The winner is determined whether the player’s hand is higher than", rulesX, rulesY+(rulesGap*3), 600, 150);
    txt4.setForeground(Color.WHITE);
    txt4.setFont(new Font("Serif", Font.PLAIN, pgfontSize));
    JLabel txt5 = tag(instructMenu, "the house’s hand without going over, or busting.", windowWidth/2-150, rulesY+(rulesGap*4), 600, 150);
    txt5.setForeground(Color.WHITE);
    txt5.setFont(new Font("Serif", Font.PLAIN, pgfontSize));

    if(instructScreen == 1){
      txt.setVisible(false);
      txt2.setVisible(false);
      txt3.setVisible(false);
      txt4.setVisible(false);
      txt5.setVisible(false);
    }

    instructMenu.setVisible(true);
  }

  public static void game(){
    gameMenu = panel(window, windowWidth, windowLength);
    gameMenu.setLayout(null);

    gameMenu.setBackground(light_blue);

    JButton back = button(gameMenu, "Back", 0, 0, 100, 50, isBack);

    if(isBack){
      back.setBackground(dark_blue);
    } else {
      back.setBackground(dark_red);
    }
    back.setForeground(Color.WHITE);

    JButton hit = button(gameMenu, "Hit", windowWidth-100, 20, 100, 50, true);
    hit.setBackground(dark_blue);
    hit.setForeground(Color.WHITE);

    JButton stand = button(gameMenu, "Stand", windowWidth-100, 90, 100, 50, true);
    stand.setBackground(dark_blue);
    stand.setForeground(Color.WHITE);

    JButton forfeit = button(gameMenu, "Forfeit", windowWidth-100, 160, 100, 50, true);
    forfeit.setBackground(dark_blue);
    forfeit.setForeground(Color.WHITE);

    JButton doubleDown = button(gameMenu, "DoubleD", windowWidth-100, 230, 100, 50, true);
    doubleDown.setBackground(dark_blue);
    doubleDown.setForeground(Color.WHITE);

    JLabel cash = tag(gameMenu, "Cash: $" + Game.cash, windowWidth/2-150, 0, 200, 50);
    cash.setForeground(Color.WHITE);
    cash.setFont(new Font("Serif", Font.PLAIN, namefontSize));

    JLabel house = tag(gameMenu, "House: " + Game.houseTotal, 20, 20, 200, 100);
    house.setForeground(Color.WHITE);
    house.setFont(new Font("Serif", Font.PLAIN, namefontSize));

    JLabel user = tag(gameMenu, "User: " + Game.userTotal, 20, 150, 200, 100);
    user.setForeground(Color.WHITE);
    user.setFont(new Font("Serif", Font.PLAIN, namefontSize));

    JButton enter = button(gameMenu, "Enter", windowWidth/2+75, windowLength-62, 75, 37, true);
    enter.setBackground(dark_blue);
    enter.setForeground(Color.WHITE);

    bet.setBounds(windowWidth-150, windowLength-75, 150, 50);
    gameMenu.add(bet);

    if(Game.houseTotal > 0){
      for(int i = 0; i < Game.houseCount; i++){
        JLabel housecardNumber = new JLabel(Integer.toString(Game.houseHand[i]));
        housecardNumber.setBounds(cardX+(cardGap*i), cardY, 200, 100);
        housecardNumber.setForeground(Color.RED);
        housecardNumber.setFont(new Font("Serif", Font.PLAIN, cardfontSize));
        gameMenu.add(housecardNumber);
      }
    }

    if(Game.userTotal > 0){
      for(int i = 0; i < Game.userCount; i++){
        JLabel usercardNumber = new JLabel(Integer.toString(Game.userHand[i]));
        usercardNumber.setBounds(cardX+(cardGap*i), cardY+130, 200, 100);
        usercardNumber.setForeground(Color.RED);
        usercardNumber.setFont(new Font("Serif", Font.PLAIN, cardfontSize));
        gameMenu.add(usercardNumber);
      }
    }

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

    switch(e.getActionCommand()){
      case "Play": case "Rules":
        window.remove(startMenu);
        if(e.getActionCommand().equals("Play")){
          Game.resetVar();
          screen = 1;
        } else if(e.getActionCommand().equals("Rules")){
          screen = 2;
        }
        Main.gameplay();
        break;
      case "Back":
        window.remove(instructMenu);
        window.remove(gameMenu);
        screen = 0;
        Main.gameplay();
        break;
      case "Enter":
        window.remove(gameMenu);
        Game.resetVar();
        Game.setBet(bet.getText());
        Game.changeCash(Game.getBet());
        Game.dealCards();
        isBack = false;
        Main.gameplay();
        break;
      case "Hit":
        window.remove(gameMenu);
        if(Game.getBet() == 0){
          System.out.println("Please enter a bet first.");
          break;
        }
        Game.userHit();
        if(Game.userTotal>21 || Game.userCount==5){
          while(Game.houseTotal < 16){
            Game.houseHit();
          }
          if(Game.didWin()){
            Game.returnCash(1);
          }
        }
        Main.gameplay();
        break;
      case "Stand":
        window.remove(gameMenu);
        if(Game.getBet() == 0){
          System.out.println("Please enter a bet first.");
          break;
        }
        while(Game.houseTotal < 16){
          Game.houseHit();
        }
        if(Game.didWin()){
          Game.returnCash(1);
        }
        Main.gameplay();
        break;
      case "Forfeit":
        window.remove(gameMenu);
        if(Game.getBet() == 0){
          System.out.println("Please enter a bet first.");
          break;
        }
        Game.returnCash(3);
        Game.resetVar();
        Main.gameplay();
        break; 
      case "DoubleD":
        window.remove(gameMenu);
        Game.changeCash(Game.getBet());
        Game.userHit();
        while((Game.houseTotal < 16)){
          Game.houseHit();
        }
        if(Game.didWin()){
          Game.returnCash(2);
        }
        Main.gameplay();
        break;
      case "Next":
        window.remove(instructMenu);
        instructScreen = 1;
        Main.gameplay();
        break;
      case "Quit":
        window.dispose();
        break;
      default:
        System.out.println("Why did this happen?");
        break;
    }
  }
}