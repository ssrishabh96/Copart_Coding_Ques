
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

```java
private static void populateList(JSONObject lot)

```

```java
private static void sortByProfitAndPrint()
```

```java
private static void printLotInfo(int lotNumber)
calls the method: printLot(Lots temp)
```

```java
private static void findSellerHighLots()


```

```java
```

```java
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

