package cinema;

import java.util.List;

public class Ticket {
    private static int ticketIdCounter = 1000;

    private String ticketId;
    private String movieTitle;
    private String movieGenre;
    private String showtime;
    private String seat;
    private String ticketType;
    private int quantity;
    private Food selectedFood;
    private int quantityFood;
    private Beverage selectedBeverage;
    private int quantityBeverage;

    public Ticket(String movieTitle, String movieGenre, String showtime, String seat, String ticketType, int quantity) {
        this.ticketId = "T" + ticketIdCounter++;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.showtime = showtime;
        this.seat = seat;
        this.ticketType = ticketType;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getShowtime() {
        return showtime;
    }

    public String getSeat() {
        return seat;
    }

    public String getTicketType() {
        return ticketType;
    }
    
    public Food getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(Food selectedFood) {
        this.selectedFood = selectedFood;
    }

    public int getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
    }

    public Beverage getSelectedBeverage() {
        return selectedBeverage;
    }

    public void setSelectedBeverage(Beverage selectedBeverage) {
        this.selectedBeverage = selectedBeverage;
    }

    public int getQuantityBeverage() {
        return quantityBeverage;
    }

    public void setQuantityBeverage(int quantityBeverage) {
        this.quantityBeverage = quantityBeverage;
    }

}
