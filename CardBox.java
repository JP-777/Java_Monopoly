import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.lang.Math;
import java.util.*;

class CardBox extends Box{

  private ArrayList<String> gameCards = new ArrayList<>();
  private int[] gcAmountList = new int[31];

  public CardBox(String boxName, ArrayList<String> gameCards, int[] gcAmountList){
    super(boxName);
    this.boxName = boxName;
    this.boxType = "CardBox";
    this.gameCards = gameCards;
    this.gcAmountList = gcAmountList;
  }
  
  public void eventBox(Player player){
    if(player.playerTurn){
      //Random Card Generator
      int randomCard = (int)(Math.random()*31);

      //Collect Cards Action
      if(randomCard < 11){
        JOptionPane.showMessageDialog(null,gameCards.get(randomCard),boxName,JOptionPane.DEFAULT_OPTION);
        player.money += gcAmountList[randomCard];

      //Pay Cards Action
      }else if(randomCard < 18){
        JOptionPane.showMessageDialog(null,gameCards.get(randomCard),boxName,JOptionPane.DEFAULT_OPTION);

        // Houses and Hotels Pay Action Exception
        if(randomCard == 17 || randomCard == 12){
          int nHouses=0, nHotels=0;
          for(int i = 0; i < player.playerStuff.size(); i++){
            nHouses += player.playerStuff.get(i).houses;
            nHotels += player.playerStuff.get(i).hotels;
          }
          player.money -= (gcAmountList[randomCard]*nHouses) + (gcAmountList[randomCard]*nHotels*4);

        //Pay Each Player Action Exception
        }else if(randomCard == 13){
          
        //Normal Pay Action
        }else{
          player.money -= gcAmountList[randomCard];
        }
      
      //Move Cards Action
      }else if(randomCard < 31){
        JOptionPane.showMessageDialog(null,gameCards.get(randomCard),boxName,JOptionPane.DEFAULT_OPTION);
        if(randomCard < 21){
          for(int i = 0; i < 44; i++){
            player.playerMovement(1);
            if(player.gameResources.randomCB == player.position)
              break;
          }
        }else if(randomCard < 24){
          for(int i = 0; i < 44; i++){
            player.playerMovement(1);
            if(player.gameResources.randomPB == player.position)
              break;
          }
        }else if(randomCard < 26){
          for(int i = 0; i < 44; i++){
            player.playerMovement(1);
            for(int j = 0; j < 3; j++){
              if(player.gameResources.sbPositions[j] == player.position){
                break;
              }
            }
          }
        }else if(randomCard < 28){
          for(int i = 0; i < 44; i++){
            player.playerMovement(1);
            if(player.position == 12)
              break;
          }
        }else if(randomCard == 28){
          player.position -= 3;
        }

      }
      endTurn(player);
    }
  }

  public static void Pay(Player player){
  }
  
}
