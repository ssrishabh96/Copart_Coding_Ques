import java.util.ArrayList;

class Lots implements Comparable{
    private int lotNumber;
    private String country;
    private ArrayList<Parties> party=new ArrayList<>();
    private double purchasePrice;
    private double salePrice;

    public void setLotNumber(int lotNumber){
        this.lotNumber=lotNumber;

    }

    public void setcountry(String country){
        this.country=country;

    }

    public void addParty(int partyID, String partyType){
        this.party.add(new Parties(partyID, partyType));
    }

    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice=purchasePrice;

    }

    public void setsalePrice(double salePrice){
        this.salePrice=salePrice;
    }

    public int getLotNumber(){
        return lotNumber;
    }

    public String getCountry(){
        return country;
    }

    public ArrayList<Parties> getParty(){
        return party;
    }

    public double getPurchasePrice(){
        return purchasePrice;
    }

    public double getSalePrice(){
        return salePrice;
    }

    public double getTax(){
        double tax=0.0;
        if(country.equalsIgnoreCase("DEU"))
            tax=19;
        else if(country.equalsIgnoreCase("ESP"))
            tax=21;

        return (tax*salePrice/100);
    }
    @Override
    public int compareTo(Object object) {
        double compareProfit=((Lots) object).getProfit();
        return (int) (this.getProfit()-compareProfit);
    }

    public class Parties{
        private String partyType="";//  : "SLR",
        private int parytID;


        public Parties(int parytID, String partyType) {
            this.partyType = partyType;
            this.parytID = parytID;
        }

        public String getPartyType() {
            return partyType;
        }

        public void setPartyType(String partyType) {
            this.partyType = partyType;
        }

        public int getParytID() {
            return parytID;
        }

        public void setParytID(int parytID) {
            this.parytID = parytID;
        }
    }

    public double getProfit(){
        return (salePrice-purchasePrice);
    }

}