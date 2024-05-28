import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.lang.Math;
import java.awt.geom.Ellipse2D;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;

public class Player{
  GameResources gameResources = new GameResources();
  
  public static int x = 255, y = 50, dice1 = 1, dice2 = 6;
  public static int position = 0;
  public static int movement = 0;
  public static int money = 2000;
  public static boolean playerTurn = false;
  
  public ArrayList<PropertyBox> playerStuff = new ArrayList<>();

  public String[] playerStuffNameElements(){
    String[] playerStuffNameElements = new String[playerStuff.size()];
    for(int i = 0; i < playerStuff.size(); i++){
      playerStuffNameElements[i] = playerStuff.get(i).boxName;
    }
    return playerStuffNameElements;
  }

  // Dices Results Images List
  public static String[] dices = {"./images/dice1.png","./images/dice2.png","./images/dice3.png","./images/dice4.png","./images/dice5.png","./images/dice6.png"};

  public void paint(Graphics g){
    
    // Draw Player Skin
    ImageIcon player = new ImageIcon(getClass().getResource("./images/player.png"));
    g.drawImage(player.getImage(),x,y,50,50,null);
    
    // Draw Dice1 Roll Result
    ImageIcon drawDice1 = new ImageIcon(getClass().getResource(dices[dice1 - 1]));
    g.drawImage(drawDice1.getImage(),450,300,100,100,null);
  
    // Draw Dice2 Roll Result
    ImageIcon drawDice2 = new ImageIcon(getClass().getResource(dices[dice2 - 1]));
    g.drawImage(drawDice2.getImage(),750,300,100,100,null);

  }

  public int rollDices(){

    this.dice1 = (int)(Math.random()*6+1);
    this.dice2 = (int)(Math.random()*6+1);
    
    playerTurn = true;

    return dice1 + dice2;

  }

  public void corner(){
    
    //Start Corner Area
    if(x < 300 && 200 < x){
      if(y < 100 && 0 < y){
        x = 255;
        y = 50;
      }
    }
    
    //Jail Visit Area
    if(x < 1000 && 898 < x){
      if(y < 100 && 0 < y){
        x = 1020;
        y = 0;
      }
    }

    //Vacation Area
    if(x < 1000 && 898 < x){
      if(y < 830 && 672 < y){
        x = 950;
        y = 729; 
      }
    }

    //Go to Prison Area
    if(x < 300 && 200 < x){
      if(y < 830 && 672 < y){
        x = 254;
        y = 750;
      }
    }

  }
  public void playerMovement(int movement){

      for(int i = 0; i < movement; i++){

        position++;

        if(position == 48){
          position = 0;
          money += 200;
        }

        //UpSide Movement
        if(x < 1010  && y <= 50){
          if(x == 255){
            x += 83;
            y -= 30;
          }
          else{
            x += 56;
          }
          if(x > 898){
            y -= 5;
          }
        }

        //RigthSide Movement
        else if(x > 1000){
          if(x == 1020){
            y += 122;
            x -= 10;
          }
          else{
            y += 55;
          }
        }
  
        //DownSide Movement
        if(y > 705 && x > 255){
          if(x == 950){
            x -= 53;
            y += 55;
          }
          else{
            x -= 56;
          }
        }

        //LeftSide Movement
        else if(x < 255){
          if(x == 254){
            x -= 30;
            y -= 79;
          }
          else{
            y -= 55;
          }
        }
        
        //Check CornerBox
        corner();
      }
  }
  

  public void keyPressed(KeyEvent e){

    if(e.getKeyCode() == 32){

      playerMovement(rollDices());

    }

    if(e.getKeyCode() == 90){
      x = 255;
      y = 50;
    }

  }
  public void sellProperty(){
    int propertyToSell = JOptionPane.showOptionDialog(null,"Choose a Property","Sell Property",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,playerStuffNameElements(),null);
    int sell = JOptionPane.showConfirmDialog(null,"Wants to sell "+playerStuff.get(propertyToSell).boxName+" for "+(playerStuff.get(propertyToSell).propertyPrice/2),"Sell Property",JOptionPane.YES_NO_OPTION);
    if(sell == 0){
      playerStuff.remove(propertyToSell);
    }
  }

  public void buildHouse(){
    /*
    int buy = JOptionPane.showConfirmDialog(null,"Wants to build a house in "+boxName,"Build House/Hotel",JOptionPane.YES_NO_OPTION);
    if(buy == 0){
      house++;
      money -= buildPrice;
    }
    */
  }
  public void makeDeal(){

  }
}
