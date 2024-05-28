import javax.swing.JOptionPane;
import javax.swing.JFrame;

class PropertyBox extends Box{
  public Player playerOwner = null;
  public int propertyPrice;
  public static int buildPrice;
  public static int rentPrice;
  public static int houses = 0, hotels = 0;

  public PropertyBox(String boxName, int propertyPrice, int buildPrice, int rentPrice){
    super(boxName);
    this.boxName = boxName;
    this.boxType = "PropertyBox";

    this.propertyPrice = propertyPrice;
    this.buildPrice = buildPrice;
    this.rentPrice = rentPrice;
  }

  public void eventBox(Player player){

    if(player.playerTurn){
      if(playerOwner == null){
        buyProperty(player);
      } else {
        payRent(player);
      }
      endTurn(player);
    }
  }

  public void buyProperty(Player player){

    if(player.money > propertyPrice){
      int buy = JOptionPane.showConfirmDialog(null,"Wants to buy "+boxName+" for "+propertyPrice,"Buy Property",JOptionPane.YES_NO_OPTION);
      if(buy == 0){
        playerOwner = player;
        player.money -= propertyPrice;
        player.playerStuff.add(this);
      }
    }
  }

  public void payRent(Player player){

  }
}
