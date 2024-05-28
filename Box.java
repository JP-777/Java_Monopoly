import javax.swing.JFrame;
import javax.swing.JOptionPane;
  
class Box{
  public String boxName;
  public String boxType;

  public Box(String boxName){

    this.boxName = boxName;

  }

  public void eventBox(Player player){

    return;

  }

  public void endTurn(Player player){
    String[] playerActions = {"Sell Property","Build Houses","Make Deal"};
    for(;;){
      int endTurn = JOptionPane.showConfirmDialog(null,"End Turn","End Turn?",JOptionPane.YES_NO_OPTION);
      if(endTurn == 0){
        player.playerTurn = false;
        return;
      }
      int chosenAction = JOptionPane.showOptionDialog(null,"Choose an Action","Player",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,playerActions,null);

      switch(chosenAction){
        case 0:
          player.sellProperty();
          break;
        case 1:
          player.buildHouse();
          break;
        case 2:
          player.makeDeal();
          break;
      }
    }
  }
}
