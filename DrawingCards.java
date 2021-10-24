import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingCards extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(new Color(31, 21, 1));
    g2d.fillRect(250, 195, 90, 60);

  }

  public static void drawUserCards()
  {
    DrawingCards userCards = new DrawingCards();
    frame.add(userCards);
  }
}