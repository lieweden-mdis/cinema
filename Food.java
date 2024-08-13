package cinema;

	public class Food extends Cater{
	    private double calories;
	    private int spicinessLevel;
	    private boolean ishot;

	    public Food(String Name, double price, double calories, int spicinessLevel, boolean ishot){
	        super(Name,price);
	        this.calories = calories;
	        this.spicinessLevel = spicinessLevel;
	        this.ishot = ishot;
	    }

	    //Getters amd Setters
	    public double getCalories(){
	        return calories;
	    }

	    public void setCalories(double calories){
	        this.calories = calories;
	    }

	    public int getSpicinessLevel(){
	        return spicinessLevel;
	    }

	    public void setSpicinessLevel(int spicinessLevel){
	        this.spicinessLevel = spicinessLevel;
	    }

	    public boolean getIsHot() {
	        return ishot;
	    }

	    public void setIsHot(boolean IsHot) {
	        this.ishot = IsHot;
	    }
	}

