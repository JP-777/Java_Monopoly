import javax.swing.JOptionPane;
import javax.swing.JFrame;

class TaxBox extends Box{

  public TaxBox(String boxName){
    super(boxName);
    this.boxName = boxName;
    boxType = "CardBox";
  }

  public void eventBox(Player player){
    if(player.playerTurn){
      if(player.position == 2){
        JOptionPane.showMessageDialog(null,"Income Tax 10%",boxName,JOptionPane.DEFAULT_OPTION);
        player.money -= (int)(player.money*0.1);
      }
      if(player.position == 46){
        JOptionPane.showMessageDialog(null,"Luxury Tax 75$",boxName,JOptionPane.DEFAULT_OPTION);
        player.money -= 75;
      }
      endTurn(player);
    }
  }
}
