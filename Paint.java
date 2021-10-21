import javax.swing.*;
import java.awt.*;

public class Paint extends Gui{

  public void drawing(){
    repaint();
  }

  public void draw(Graphics g){
    super.draw(g);

    g.setColor(Color.BLUE);
    g.fillRect(200, 0, 100, 50);

  }
}