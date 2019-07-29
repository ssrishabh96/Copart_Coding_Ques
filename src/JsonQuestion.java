import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/*

Here are the coding exercises. Read the provided JSON into your JAVA program and

1.	Be able to read the JSON data and store it a java collection or a data structure
2.	Query the above collection :Given a lot number, retrieve all the information regarding the lot.
3.	Sort the lots based on profit
4.	Determine the seller who has the highest lots
5.	Determine tax based on country code

Given a JSON with the following structure of information:
{
  Lot id (Vehicle ID)
  Seller and Buyer ID
  Purchase price
  Sale price
  Country code
}
Below is the JSON which provides the tax rates for different countries.

{
	DEU: 19  //( % of sale price)
	ESP: 21   //( % of sale price)
}

explanation:
•	Each vehicle we sell is called a LOT
•	The price that we pay to our seller for buying the lot from them will be termed as Sale price
•	Purchase price would be the price at which a buyer purchases the lot from us
•	Country code determines the country where the transaction is occurring
•	Tax rate differs based on country
•	Party – defines the buyer and the seller
*/

public class JsonQuestion{

    private static Map<Integer, Lots> dataItems= new HashMap<>();

    public static void main(String[] args) {
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("src/input.json"))
            {
                //Read JSON file
                Object obj = jsonParser.parse(reader);
                JSONArray parties = (JSONArray) obj;
                //Iterate over employee array
                parties.forEach( emp -> populateList( (JSONObject) emp ) );

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // 2. Method to print details by any lot number
            printLotInfo(500675);

            // 3. Sorting the Profits in Ascending order and print
            sortByProfitAndPrint();

            // 4. Determine the seller who has the highest lots
            // Assuming the seller is identified by the seller Type
            findSellerHighLots();

            // 5. Tax info incoporated in the POJO class and the tax price prints with the regular info of the lot (can be changed).
    }

    private static void sortByProfitAndPrint() {
        List<Lots> lotsList= new ArrayList<>(dataItems.values());

        Collections.sort(lotsList);

        for(Lots lot: lotsList){
            printLotInfo(lot.getLotNumber());
        }
    }

    private static void populateList(JSONObject lot){
            //Get employee object within list

            Lots temp = new Lots();

            //Get employee first name
            temp.setLotNumber(Integer.parseInt(lot.get("lotNumber").toString()));
            temp.setcountry(lot.get("country").toString());

            JSONArray partyArray= (JSONArray) lot.get("party");
            int len = partyArray.size();
            for(int i = 0; i < len; ++i) {
                JSONObject obj = (JSONObject) partyArray.get(i);
                int party_id = Integer.parseInt(obj.get("partyId").toString());
                String partyType= obj.get("partyType").toString();
                temp.addParty(party_id, partyType);
            }
            //Get employee last name
            Double pur_Price= Double.parseDouble( lot.get("purchasePrice").toString());
            Double sal_Price= Double.parseDouble(lot.get("salePrice").toString());

            temp.setPurchasePrice(pur_Price);
            temp.setsalePrice(sal_Price);
            dataItems.put(temp.getLotNumber(), temp);
//            System.out.println("Size: "+dataItems.size());
//            System.out.println(temp);
        }

    private static void printLotInfo(int lotNumber){

        if(dataItems.containsKey(lotNumber)){

            Lots temp=dataItems.get(lotNumber);

            if(temp!=null){
                printLot(temp);
            }else{
                System.out.println("Problem reading system components.");
            }

        }else{
            System.out.println("No lot found with this lotnumber !!");
        }

    }

    private static void printLot(Lots temp) {
        //Get employee first name
        System.out.println("------------");
        int lnumber= temp.getLotNumber();
        String country= temp.getCountry();
        System.out.println("Lot Number: "+lnumber);
        System.out.println("Country: "+country+"\n Parties:");
        ArrayList<Lots.Parties> party=temp.getParty();

        for(int i = 0; i < party.size(); ++i) {

            int party_id = party.get(i).getParytID();
            String partyType= party.get(i).getPartyType();
            System.out.println("\t"+(i+1)+ " Party Id: " +party_id+", Party Type: "+ partyType);
        }
        //Get employee last name
        System.out.println("Purchase Price: " + temp.getPurchasePrice());
        System.out.println("Sale Price: " + temp.getSalePrice());
        System.out.println("Profit: " + temp.getProfit());
        System.out.println("Taxes: " + temp.getTax());
        System.out.println("------------");

    }

    private static void findSellerHighLots(){

        List<Lots> lotsList= new ArrayList<>(dataItems.values());
        Map<String, Integer> count=new HashMap<>();

        // Populate the count in the hashmap for each of the seller type
        for(Lots lot: lotsList) {

            ArrayList<Lots.Parties> party = lot.getParty();

            for (int i = 0; i < party.size(); ++i) {

                String partyType = party.get(i).getPartyType();

                if (count.containsKey(partyType)) {
                    count.put(partyType, count.get(partyType) + 1);
                } else {
                    count.put(partyType, 1);
                }
            }

        }
         int max=0;
         String seller="";
         // looping over keys
         for (String name : count.keySet()) {
                // search  for value
                int tempCount= count.get(name);
                if(tempCount>max) {
                    max = tempCount;
                    seller = name;
                }
         }
        System.out.println("Seller: " +seller+" has "+max +"vehicle lots:");


    }


}

