package cinema;

public class Beverage extends Cater {
    private String size;
    private boolean isCabornated;

    public Beverage(String Name, double price,String size, boolean isCarbonated){
        super(Name, price);
        this.size = size;
        this.isCabornated = isCarbonated;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public boolean getIsCarbonated(){
        return isCabornated;
    }

    public void setIsCarbonated(boolean IsCarbonated){
        this.isCabornated = IsCarbonated;
    }
}
