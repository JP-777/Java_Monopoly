import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.util.*;

public class Game extends JPanel{

    public static Player player = new Player();
    public static GameResources gameResources = new GameResources();  

    public Game(){

      addKeyListener(new KeyListener(){

      @Override
      public void keyTyped(KeyEvent e){
      }
      @Override
      public void keyPressed(KeyEvent e){
        player.keyPressed(e);  
      }
      @Override
      public void keyReleased(KeyEvent e){
      }

      });

      setFocusable(true);

  }
  
  @Override
  public void paint(Graphics g){
    super.paint(g);
    ImageIcon board = new ImageIcon(getClass().getResource("./images/board_v1.png"));
    g.drawImage(board.getImage(),0,0,getWidth(),getHeight(),this);

    Font dataPlayer = new Font("Arial",Font.BOLD,20);
    g.setFont(dataPlayer);
    g.setColor(Color.blue);


    g.drawString("<--| PLAYER 1 |-->",0,20);
    g.drawString("Cash: " + player.money,0,40);
    g.drawString("Properties: ",0,60);

    for(int i = 0; i < player.playerStuff.size(); i++){
      g.drawString(player.playerStuffNameElements()[i],20,80+(i*20));
    }

    player.paint(g);
    g.dispose();
  }


  public static void main(String[] args){ 

    JFrame lobbyWindow = new JFrame("Monopoly by JP777");
    JButton startButton = new JButton("Start Game!");
    JFrame gameWindow = new JFrame("Monopoly");

    Game game = new Game();
    Lobby lobby = new Lobby(startButton);

    lobbyWindow.add(lobby);
    lobbyWindow.setSize(500,500);
    lobbyWindow.setVisible(true);
    lobbyWindow.setResizable(false);
    lobbyWindow.setLocationRelativeTo(null);

    startButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){

        gameWindow.add(game);
        gameWindow.setSize(1300,1000);
        gameWindow.setVisible(true);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      }
    });

    while(true){
      
      gameResources.gameBoxes.get(player.position).eventBox(player);

      try{

        Thread.sleep(10);

      } catch (InterruptedException ex){

        System.out.print(ex.toString());

      }

     game.repaint();

    }

  }
}
