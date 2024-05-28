import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

class Lobby extends JPanel{

  public Lobby(JButton startButton){
    this.add(startButton);
  }

  @Override
  public void paint(Graphics g){
    super.paint(g);
    ImageIcon backGround = new ImageIcon(getClass().getResource("./images/fondo.jpg"));
    g.drawImage(backGround.getImage(),0,0,getWidth(),getHeight(),this);

    g.dispose();
  }

}
