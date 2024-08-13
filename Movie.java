package cinema;


public class Movie {
	private String title;
    private String genre;
    private int duration;
    private String[] showtimes;
    private int[][] seats;

    private double adultTicketPrice;
    private double childrenTicketPrice;
    private double seniorCitizenTicketPrice;
    private double studentTicketPrice;

    public Movie(String title, String genre, int duration, String[] showtimes, int numRows, int seatsPerRow,
                 double adultTicketPrice, double childrenTicketPrice, double seniorCitizenTicketPrice, double studentTicketPrice) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.showtimes = showtimes;
        this.seats = new int[numRows][seatsPerRow];
        this.adultTicketPrice = adultTicketPrice;
        this.childrenTicketPrice = childrenTicketPrice;
        this.seniorCitizenTicketPrice = seniorCitizenTicketPrice;
        this.studentTicketPrice = studentTicketPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String[] getShowtimes() {
        return showtimes;
    }

    public int[][] getSeats() {
        return seats;
    }

    public double getAdultTicketPrice() {
        return adultTicketPrice;
    }

    public double getChildrenTicketPrice() {
        return childrenTicketPrice;
    }

    public double getSeniorCitizenTicketPrice() {
        return seniorCitizenTicketPrice;
    }

    public double getStudentTicketPrice() {
        return studentTicketPrice;
    }

    public boolean isSeatAvailable(int row, int seatNumber) {
        return seats[row][seatNumber] == 0;
    }

    public void bookSeat(int row, int seatNumber) {
        seats[row][seatNumber] = 1;
    }
    
}