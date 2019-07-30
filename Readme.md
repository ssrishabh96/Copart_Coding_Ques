
# Data Structure Used:
Map where key is the lotNumber and the value is the POJO class Lots.java, implemented as:
```java
	private static Map<Integer, Lots> dataItems= new HashMap<>();
```

#### JSONArray Data Format:
```javascript
    "lotNumber" : "500671",
    "country" : "DEU",
    "party" : [{
      "partyType" : "SLR",
      "partyId" : 100
    },
      {
        "partyType" : "MBR",
        "partyId" : 700
      }],
    "purchasePrice" : 100000,
    "salePrice" : 15000
```  
#### POJO class Lots.java:

Class member variables:
```java
private int lotNumber;
private String country;
private ArrayList<Parties> party=new ArrayList<>();
private double purchasePrice;
private double salePrice;

... Usual getter and setter methods
... Inner Pojo Class: Parties with th following class members:
... public class Parties{
        private String partyType="";//  : "SLR",
        private int parytID;
	... usual getter and setter methods.
```

# METHODS:

-> Reading the json file and for each item in the JSONArray call the method populateList(JSONObject object) passing in the current JSONObject as the parameter.
```java
JSONParser jsonParser = new JSONParser();

try (FileReader reader = new FileReader("src/input.json")){
	//Read JSON file
        Object obj = jsonParser.parse(reader);
	// Typecast the object as the JSONArray
        JSONArray parties = (JSONArray) obj;
        //Iterate over employee array using Lambda
        parties.forEach( emp -> populateList( (JSONObject) emp ) );
}
```



```java
private static void populateList(JSONObject lot)

```
->This method receives the JSONObject and we start by extracting each of the attributes for the current element and being pushing the data to the POJO object temp. Using POJO class setter method to set the attributes.


```java
private static void sortByProfitAndPrint()

// Using Java Collections to sort the ArrayList of the items.

Collections.sort(lotsList);

// This requires that the POJO class implements the Comparable interface 
// and implement the compareTo() method as follows:
    @Override
    public int compareTo(Object object) {
        double compareProfit=((Lots) object).getProfit();
        return (int) (this.getProfit()-compareProfit);
    }
```
-> This method sorts the list of lots as per the profit earned in ascending order. The profit is calculated by (salePrice - purchasePrice).

```java
private static void printLotInfo(int lotNumber)
// First it check if the map has the key. If it does, it calls the method pasing in hte key: as
 printLot(Lots temp)
 Else, it prints appropriate error message in the console.
```

```java
private static void findSellerHighLots()
// This method computes the seller thathas the highest numebr of lots.
   In this, it is assumed that a seller is identified by the partyName attribute.
   Idea is to extract a List of all the lots we have. And then, create a map of as follows:
   Map<String, Integer> count=new HashMap<>();
   where key is the seller name and value is the integer count of the lots they have.

```

# OUTPUT
Following is the Terminal output for the program:

```java
/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=59880:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Users/rishabh/Documents/JSONInterview/out/production/JSONInterview:/Users/rishabh/Library/Mobile Documents/com~apple~CloudDocs/Downloads/json-simple-1.1.1.jar" JsonQuestion
------------
Lot Number: 500675
Country: DEU
 Parties:
	1 Party Id: 100, Party Type: SLR
	2 Party Id: 701, Party Type: MBR
Purchase Price: 3000.0
Sale Price: 2900.0
Profit: -100.0
Taxes: 551.0
------------
------------
Lot Number: 500671
Country: DEU
 Parties:
	1 Party Id: 100, Party Type: SLR
	2 Party Id: 700, Party Type: MBR
Purchase Price: 100000.0
Sale Price: 15000.0
Profit: -85000.0
Taxes: 2850.0
------------
------------
Lot Number: 500674
Country: ESP
 Parties:
	1 Party Id: 101, Party Type: SLR
	2 Party Id: 701, Party Type: MBR
Purchase Price: 10000.0
Sale Price: 7000.0
Profit: -3000.0
Taxes: 1470.0
------------
------------
Lot Number: 500675
Country: DEU
 Parties:
	1 Party Id: 100, Party Type: SLR
	2 Party Id: 701, Party Type: MBR
Purchase Price: 3000.0
Sale Price: 2900.0
Profit: -100.0
Taxes: 551.0
------------
------------
Lot Number: 500672
Country: ESP
 Parties:
	1 Party Id: 100, Party Type: SLR
	2 Party Id: 700, Party Type: MBR
Purchase Price: 100.0
Sale Price: 2000.0
Profit: 1900.0
Taxes: 420.0
------------
------------
Lot Number: 500673
Country: DEU
 Parties:
	1 Party Id: 101, Party Type: SLR
	2 Party Id: 701, Party Type: MBR
Purchase Price: 10000.0
Sale Price: 15000.0
Profit: 5000.0
Taxes: 2850.0
------------
Seller: SLR has +5vehicle lots:

Process finished with exit code 0

```

