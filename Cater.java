package cinema;

public class Cater {
    protected String Name;
    protected double price;

    public Cater(String Name, double price) {
        this.Name = Name;
        this.price = price;
    }

    //Getters and Setters
    @Override
    public String toString() {
        return "Name: " + Name + "\nPrice: RM " + price ;
    }
    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
