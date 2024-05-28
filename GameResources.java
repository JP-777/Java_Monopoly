import java.util.*;
import java.lang.Math;

class GameResources{

  public ArrayList<Box> gameBoxes = new ArrayList<>();
  public ArrayList<String> gameCards = new ArrayList<String>();
  public int randomCB, randomPB;
  //ServiceBox Position List
  public int[] sbPositions = {15,22,33};
  //Each Game Cards Amount List
  int[] gcAmountList = {200,100,10,50,150,200,100,25,20,100,50, //Collect Mount Cards
                        15,25,50,100,50,150,40};                //Pay Mount Cards
      
    public GameResources(){

    //Every box of the board are here

      gameBoxes.add(new Box("Start"));
      gameBoxes.add(new PropertyBox("Salvador",60,50,2));
      gameBoxes.add(new CardBox("Treasure",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Rio",60,50,4));
      gameBoxes.add(new TaxBox("Income Tax"));
      gameBoxes.add(new PropertyBox("Tel Aviv",100,50,6));
      gameBoxes.add(new PropertyBox("Eliat Port",200,50,6));
      gameBoxes.add(new PropertyBox("Haifa",100,50,8));
      gameBoxes.add(new PropertyBox("Jerusalem",110,50,8));
      gameBoxes.add(new CardBox("Surprise",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Mumbai",120,100,8));
      gameBoxes.add(new PropertyBox("New Delhi",130,100,10));

      gameBoxes.add(new Box("Visit Prison"));
      gameBoxes.add(new PropertyBox("Venice",140,100,10));
      gameBoxes.add(new PropertyBox("Bologna",140,100,10));
      gameBoxes.add(new PropertyBox("Electric Company",150,50,8));
      gameBoxes.add(new PropertyBox("Milan",160,100,12));
      gameBoxes.add(new PropertyBox("Roma",160,100,12));
      gameBoxes.add(new PropertyBox("Genova Port",200,50,6));
      gameBoxes.add(new PropertyBox("Frankfurt",180,100,14));
      gameBoxes.add(new CardBox("Treasure",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Munich",180,100,14));
      gameBoxes.add(new PropertyBox("Gas Company",150,50,16));
      gameBoxes.add(new PropertyBox("Berlin",200,100,16));

      gameBoxes.add(new Box("Vacation"));
      gameBoxes.add(new PropertyBox("Shenzen",220,150,18));
      gameBoxes.add(new CardBox("Surprise",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Beijing",220,150,18));
      gameBoxes.add(new CardBox("Treasure",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Shanghai",240,150,20));
      gameBoxes.add(new PropertyBox("Centuri Port",200,50,6));
      gameBoxes.add(new PropertyBox("Toulouse",260,150,22));
      gameBoxes.add(new PropertyBox("Paris",260,150,22));
      gameBoxes.add(new PropertyBox("Water Company",150,50,6));
      gameBoxes.add(new PropertyBox("Yokohama",280,150,24));
      gameBoxes.add(new PropertyBox("Tokyo",280,150,24));

      gameBoxes.add(new Box("Go to prison"));
      gameBoxes.add(new PropertyBox("Liverpool",300,200,26));
      gameBoxes.add(new PropertyBox("Manchester",300,200,26));
      gameBoxes.add(new CardBox("Treasure",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("Birmingham",320,200,28));
      gameBoxes.add(new PropertyBox("London",240,200,28));
      gameBoxes.add(new PropertyBox("Long Beach Port",200,50,6));
      gameBoxes.add(new PropertyBox("Los Angeles",350,200,35));
      gameBoxes.add(new CardBox("Susprise",gameCards,gcAmountList));
      gameBoxes.add(new PropertyBox("San Francisco",360,200,40));
      gameBoxes.add(new TaxBox("Luxury Tax"));
      gameBoxes.add(new PropertyBox("New York",400,200,50));

    //Cards list elements
      
      //Random CityBox Position
      randomCB = (int)(Math.random()*44+1);
      for(;;){
        if(gameBoxes.get(randomCB).boxType.equals("PropertyBox")){
          break;
        }
        randomCB++;
      }

      //Random PortBox Position
      randomPB = 6*(((int)(Math.random()*4+1))*2-1);
      
      //Game Cards COLLECT Section
      gameCards.add("Go to START, collect 200$");
      gameCards.add("Life insure MATURES collect 100$");
      gameCards.add("You have won SECOND PRIZE in a beauty contest collect 10$");
      gameCards.add("Bank PAYS you dividends of 50$");
      gameCards.add("Building loan MATURES collect 150$");
      gameCards.add("Bank ERROR in your FAVOR collect 200$");
      gameCards.add("Happy Xmas COLLECT 100$");
      gameCards.add("RECEIVE 25$ for services");
      gameCards.add("Income tax REFUND collect 20$");
      gameCards.add("INHERIT 100$");
      gameCards.add("Grand Opera opening COLLECT 50$ of EVERY player");

      //Game Cards PAY Section
      gameCards.add("Pay POOR tax of 15$");
      gameCards.add("Make repairs on all your PROPERTIES, 25$ for each house, 100$ for each hotel");
      gameCards.add("You have been elected CHAIRMAN, pay each PLAYER 50$");
      gameCards.add("PAY hospital 100$");
      gameCards.add("Doctor's fee PAY 50$");
      gameCards.add("PAY school TAX of 150$");
      gameCards.add("Make street repairs on all your PROPERTIES, 35$ for each house, 140$ for each hotel");

      //Game Cards OTHER Section
      gameCards.add("Go to " + gameBoxes.get(randomCB).boxName);
      gameCards.add("Go to " + gameBoxes.get(randomCB).boxName);
      gameCards.add("Go to " + gameBoxes.get(randomCB).boxName);
      gameCards.add("Cross the sea in the " + gameBoxes.get(randomPB).boxName);
      gameCards.add("Cross the sea in the " + gameBoxes.get(randomPB).boxName);
      gameCards.add("Cross the sea in the " + gameBoxes.get(randomPB).boxName);
      gameCards.add("Go to the nearest SERVICE, if UNOWNED you may BUY IT, if OWNED throw dices and pay TEN TIMES the dices");
      gameCards.add("Go to the nearest SERVICE, if UNOWNED you may BUY IT, if OWNED throw dices and pay TEN TIMES the dices");
      gameCards.add("Go directly TO JAIL");
      gameCards.add("Go directly TO JAIL");
      gameCards.add("Go BACK 3 spaces");
      gameCards.add("GET OUT of jail FREE");
      gameCards.add("GET OUT of jail FREE");
  }
}
