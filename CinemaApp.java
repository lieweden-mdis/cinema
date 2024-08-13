package cinema;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CinemaApp {
	
	private static Food f1 = new Food("Spicy Chicken Nuggets", 5.00, 400, 4, true);
	private static Food f2 = new Food("Hotdog", 1.50, 250, 1, true);
	private static Food f3 = new Food("Burger", 10.00, 350, 2, true);
	private static Food f4 = new Food("Caramel Popcorn", 15.00, 600, 0, false);
	private static Food f5 = new Food("Chips", 7.50, 160, 2, false);

	private static Beverage b1 = new Beverage("Cola", 7.50, "Large", true);
	private static Beverage b2 = new Beverage("100Plus", 7.50, "Large", true);
	private static Beverage b3 = new Beverage("Pepsi", 5.00, "Medium", true);
	private static Beverage b4 = new Beverage("Green Tea", 3.50, "Medium", false);
	private static Beverage b5 = new Beverage("Lemon Tea", 3.50, "Small", false);
	
	private static Map<String, Ticket> tickets = new HashMap<>();
	private static Map<String, Member> userCredentials = new HashMap<>();

	private static String username;
	
    public static void main(String[] args) {
    	
    	// User Registration
    	registerUser("amanda", "1234");
        registerUser("rani", "2468");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cinema App!");

        // User Type (member or non-member)
        System.out.print("Are you a member? (Y/N): ");
        String userTypeChoice = scanner.next().toLowerCase();

        if (userTypeChoice.equals("y")) 
        {
            // Member Login
            handleMemberLogin(scanner);
        }
        
        else if (userTypeChoice.equals("n")) 
        {
            // Non-member (No login required)
            System.out.println("Welcome! You can use the app without login as a non-member.");
            // Perform actions for non-members
            menu();

        } 
        
        else 
        {
            System.out.println("Invalid choice. Please enter 'Y' for Yes (member) or 'N' for No (non-member).");
            main(args);
            
        }

        scanner.close();
    }

    private static void handleMemberLogin(Scanner scanner) {
        // Member Login loop
        while (true) {
            System.out.println("\n|--------------- Member Login --------------|");
                    
            // Prompt for login credentials
            System.out.print("|Enter username: ");
            username = scanner.next().toLowerCase(); // Set the class-level variable

            // Check if the entered user name exists in the userCredentials1 map
            if (userCredentials.containsKey(username)) 
            {
                System.out.print("|Enter password: ");
                String password = scanner.next();

                // Check if the entered credentials are valid
                if (isValidCredentials(username, password)) 
                {
                	System.out.println("|-------------------------------------------|");
                    System.out.println("Login successful! Enjoy the cinema app!");
                    menu();
                } 
                
                else 
                {
                    System.out.println("|Invalid credentials. Please try again.");
                }
            } 
            
            else 
            {
                System.out.println("|User not found. Please register to become a member.");
                // Provide an option for the user to register
                showRegistrationOptions();
                break; // Exit the loop as the user is not registered
            }
        }
    }

    private static void showRegistrationOptions() 
    {
        try (Scanner input = new Scanner(System.in)) 
        {
			System.out.println("|-------------------------------------------|");
			System.out.println("| Enter 1 to Register to become a member    |");
			System.out.println("| Enter 0 to Use the app without login      |");
			System.out.println("|-------------------------------------------|");
			System.out.print(" Enter :");

			int num = input.nextInt();

			if (num == 1) 
			{
			    joinMember();    //registration
			} 
			
			else if (num == 0) 
			{
			    menu();
			}
		}
    }

    private static void joinMember() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n|-------------- Registration ---------------|");
        System.out.print("|Enter a new username: ");
        String newUsername = scanner.next().toLowerCase();

        // Check if the entered user name is available
        if (!userCredentials.containsKey(newUsername)) 
        {
            System.out.print("|Enter a password: ");
            String newPassword = scanner.next();

            System.out.print("|Enter your email: ");
            String newEmail = scanner.next();

            System.out.print("|Enter your phone number: ");
            String newPhoneNumber = scanner.next();

            // Create a new member and add to the members map
            Member newMember = new Member(newUsername, newPassword, newEmail, newPhoneNumber);
            userCredentials.put(newUsername, newMember);

            System.out.println("|-------------------------------------------|");
            System.out.println("Registration successful! You are now a member. Please proceed to login.");
            handleMemberLogin(scanner);
        } 
        
        else 
        {
            System.out.println("Username already taken. Please choose a different username.");
            joinMember();
        }
    }

    private static void registerUser(String username, String password) 
    {
        // Create a new member and add to the members map
        Member member = new Member(username, password, password, password);
        userCredentials.put(username.toLowerCase(), member);  // Use lower case user name as the key
    }

    private static boolean isValidCredentials(String enteredUsername, String enteredPassword) 
    {
        // Check if the entered user name exists in the userCredentials map
        if (userCredentials.containsKey(enteredUsername.toLowerCase())) 
        {  
            // Retrieve the Member object using the entered user name
            Member member = userCredentials.get(enteredUsername.toLowerCase());
            // Check if the entered password matches the stored password for the user name
            return member.getPassword().equals(enteredPassword);
        }
        return false;
    }

    private static void menu()
    {
		Scanner input=new Scanner(System.in);
		System.out.println("\n ================================== ");
		System.out.println("|              Menu                |");
		System.out.println("|----------------------------------|");
		System.out.println("| Enter 1 to Select Movie          |");
		System.out.println("| Enter 2 to Buy Food and Beverage |");
		System.out.println("| Enter 3 to Check Ticket          |");
		System.out.println("| Enter 4 to Join Member           |");
		System.out.println("| Enter 5 to Member Profile        |");
		System.out.println("| Enter 0 to EXIT                  |");
		System.out.println("|----------------------------------|");
		System.out.print("| Enter :");
		int num=input.nextInt();
		
		if (num==1) 
		{
			Ticket();
		}
		
		else if (num==2) 
		{
			FoodBeverage();
		}
		
		else if(num==3) 
		{
			CheckTicket(input);
		}
		
		else if(num==4) 
		{
			joinMember();
		}
		
		else if(num==5) 
		{
			MemberProfile(input);
		}
		
		else if(num==0) 
		{
			System.out.println("|----------------------------------|");
			System.out.println("|    Thanks for use the system!    |");
			System.out.println(" ================================== ");
			System.exit(0);
		}
		
		else 
		{
			System.out.println("|----------------------------------|");
			System.out.println("| Enter a value number             |");
			menu();
		}
	}
    
    private static void Ticket()
    {
    	Scanner scanner = new Scanner(System.in);

        // Add more movies as needed

    	// Create Movie objects
        Movie movieA = new Movie("Movie A", "Action", 120, new String[]{"10:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"}, 7, 20, 20.0, 10.0, 8.0, 15.0);
        Movie movieB = new Movie("Movie B", "Comedy", 90, new String[]{"10:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"}, 7, 20, 18.0, 12.0, 10.0, 13.0);
        Movie movieC = new Movie("Movie C", "Drama", 110, new String[]{"10:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"}, 7, 20, 22.0, 15.0, 12.0, 18.0);
        Movie movieD = new Movie("Movie D", "Thriller", 150, new String[]{"10:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"}, 7, 20, 25.0, 18.0, 15.0, 20.0);

        // Display movie list for the user to choose
        Movie selectedMovie = selectMovie(scanner, movieA, movieB, movieC, movieD);

        // Display show time options
        String selectedShowtime = selectShowtime(scanner, selectedMovie);

        // Get user's quantity selection for each ticket category
        Map<String, Integer> ticketQuantities = getTicketQuantities(scanner);

        // Display available seats
        System.out.println("\nAvailable Seats:");
        System.out.println("----------------------------------------------------------------------");
        displayAvailableSeats(selectedMovie);
        System.out.println("----------------------------------------------------------------------");

        // Get user's seat selection
        System.out.print("\nEnter the seat numbers separated by space (e.g., A1 A2 B3): ");
        scanner.nextLine(); // Consume the newline
        String seatSelection = scanner.nextLine();

        // Create Ticket objects based on quantity selection
        generateTickets(selectedMovie, selectedShowtime, ticketQuantities, seatSelection);
    
        // ask user to continue buy FoodBeverage / back to menu
        try (Scanner input = new Scanner(System.in)) 
        {
        	System.out.println("\nThanks for your purchasing!");
        	System.out.println("Do you want to buy Food and Beverage? ");
        	System.out.println("|-------------------------------------------|");
        	System.out.println("| Enter 1 to buy Food and Beverage          |");
        	System.out.println("| Enter 0 to back to menu                   |");
        	System.out.println("|-------------------------------------------|");
        	System.out.print("| Enter :");

        	int num = input.nextInt();

        	if (num == 1) 
        	{
        		FoodBeverage();

        	} 
		
	        else if (num == 0) 
			{
			System.out.print("Enjoy your movie!");
		    menu();
			}
        }
    
        scanner.close();
    }

    private static Movie selectMovie(Scanner scanner, Movie... movies) 
    {
        while (true) 
        {
            System.out.println("\n|---------- Movie List ------------|");
            for (int i = 0; i < movies.length; i++)
            {
                System.out.println("|"+(i + 1) + ". " + movies[i].getTitle()+"                        |");
            }

            // Get the user's movie selection
            System.out.println("|----------------------------------|");
            System.out.print("|Select a movie (1, 2, 3, or 4): ");
            int selectedMovieIndex = scanner.nextInt();

            if (selectedMovieIndex < 1 || selectedMovieIndex > movies.length) 
            {
                System.out.println("Invalid movie selection. Please try again.");
                continue; // Ask the user to re-enter the movie number
            }

            return movies[selectedMovieIndex - 1];
        }
    }

    private static String selectShowtime(Scanner scanner, Movie selectedMovie) 
    {
        while (true) 
        {
            System.out.println("\n|------- Showtime Options ---------|");
            String[] showtimes = selectedMovie.getShowtimes();
            for (int i = 0; i < showtimes.length; i++) 
            {
                System.out.println("|"+(i + 1) + ". " + showtimes[i]);
            }

            // Get the user's show time selection
            System.out.println("|----------------------------------|");
            System.out.print("|Select a showtime (1, 2, 3, or 4): ");
            int selectedShowtimeIndex = scanner.nextInt();

            if (selectedShowtimeIndex < 1 || selectedShowtimeIndex > showtimes.length) 
            {
                System.out.println("Invalid showtime selection. Please try again.");
                continue; // Ask the user to re-enter the show time
            }

            return showtimes[selectedShowtimeIndex - 1];
        }
    }

    private static Map<String, Integer> getTicketQuantities(Scanner scanner) 
    {
        Map<String, Integer> ticketQuantities = new HashMap<>();

        System.out.println("\n|----- Enter ticket quantities ----|");
        System.out.print("|Adult tickets: ");
        ticketQuantities.put("Adult", scanner.nextInt());

        System.out.print("|Children tickets: ");
        ticketQuantities.put("Children", scanner.nextInt());

        System.out.print("|Senior Citizen tickets: ");
        ticketQuantities.put("SeniorCitizen", scanner.nextInt());

        System.out.print("|Student tickets: ");
        ticketQuantities.put("Student", scanner.nextInt());

        return ticketQuantities;
    }

    private static void displayAvailableSeats(Movie movie) 
    {
        for (int row = 0; row < movie.getSeats().length; row++) 
        {
            for (int seatNumber = 0; seatNumber < movie.getSeats()[row].length; seatNumber++) 
            {
            	// Check if the current seat is available
                if (movie.isSeatAvailable(row, seatNumber)) 
                {
                    String seatLabel = getSeatLabel(row, seatNumber);
                    System.out.print(seatLabel + " ");
                }
            }
            
            // Move to the next line after displaying all seats in the current row
            System.out.println();
        }
    }

    private static String getSeatLabel(int row, int seatNumber) 
    {
        char rowLabel = (char) ('A' + row);
        return rowLabel + Integer.toString(seatNumber + 1);
    }

    private static void generateTickets(Movie selectedMovie, String selectedShowtime, Map<String, Integer> ticketQuantities, String seatSelection) 
    {
    	// Iterate through each ticket type and quantity
    	for (Map.Entry<String, Integer> entry : ticketQuantities.entrySet()) 
        {
    		// Extract ticket type and quantity from the map entry
            String ticketType = entry.getKey();
            int quantity = entry.getValue();
            
            // Generate the specified quantity of tickets for the current type
            for (int i = 0; i < quantity; i++) 
            {
            	// Split the seatSelection string into an array of seat identifiers
                String[] seatArray = seatSelection.split("\\s+");
                
                // Create a new Ticket object with relevant information
                Ticket ticket = new Ticket(selectedMovie.getTitle(), selectedMovie.getGenre(), selectedShowtime, String.join(", ", seatArray), ticketType, quantity);
             
                // Set initial values
                ticket.setSelectedFood(null);
                ticket.setQuantityFood(0);
                ticket.setSelectedBeverage(null);
                ticket.setQuantityBeverage(0);
                
                // Generate a unique ticket ID
                String ticketId = ticket.getTicketId();
                
                // Display ticket info
                System.out.print("\n-------------------------------");
                System.out.print("\nTicket Information:");
                displayTicketInfo(ticket);

                // Calculate and display total ticket price
                double totalTicketPrice = calculateTotalTicketPrice(ticket, selectedMovie);
                System.out.println("Total Price of Ticket: RM " + totalTicketPrice);
                System.out.print("-------------------------------");
                
                // Store the ticket in the tickets map with its ID as the key
                tickets.put(ticketId, ticket);
            }
        }
    }

    private static void displayTicketInfo(Ticket ticket) 
    {
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Movie Name: " + ticket.getMovieTitle());
        System.out.println("Movie Genre: " + ticket.getMovieGenre());
        System.out.println("Showtime: " + ticket.getShowtime());
        System.out.println("Selected Seat(s): " + ticket.getSeat());
        System.out.println("Ticket Type: " + ticket.getTicketType());
    }

    private static double calculateTotalTicketPrice(Ticket ticket, Movie selectedMovie) 
    {
        double totalPrice = 0;
        switch (ticket.getTicketType()) 
        {
            case "Adult":
                totalPrice = ticket.getQuantity() * selectedMovie.getAdultTicketPrice();
                break;
                
            case "Children":
                totalPrice = ticket.getQuantity() * selectedMovie.getChildrenTicketPrice();
                break;
                
            case "SeniorCitizen":
                totalPrice = ticket.getQuantity() * selectedMovie.getSeniorCitizenTicketPrice();
                break;
                
            case "Student":
                totalPrice = ticket.getQuantity() * selectedMovie.getStudentTicketPrice();
                break;
                
            default:
                break;
        }
        
        return totalPrice;
    }

    	
    private static void FoodBeverage() 
    {
        Scanner scanner = new Scanner(System.in);
        boolean reorder;
        
        // ask user to enter ticket ID
        System.out.print("Please enter your ticket ID: ");
        String ticketId = scanner.next();
        
        // Check if the ticket ID exists in the tickets map
        if (tickets.containsKey(ticketId)) 
        {
            Ticket ticket = tickets.get(ticketId);

            do 
            {
                System.out.println("\n|--------------- Cater List -----------------|");
                displayFoodMenu();
                displayBeverageMenu();

                Food selectedFood = selectFood(scanner);
                int quantityFood = (selectedFood != null) ? selectQuantity(scanner) : 0;

                Beverage selectedBeverage = selectBeverage(scanner);
                int quantityBeverage = (selectedBeverage != null) ? selectQuantity(scanner) : 0;

                // Set food and beverage information for the ticket
                ticket.setSelectedFood(selectedFood);
                ticket.setQuantityFood(quantityFood);
                ticket.setSelectedBeverage(selectedBeverage);
                ticket.setQuantityBeverage(quantityBeverage);

                displayFoodDetails(selectedFood, quantityFood);
                displayBeverageDetails(selectedBeverage, quantityBeverage);

                double totalAmount = calculateTotalAmount(selectedFood, selectedBeverage, quantityFood, quantityBeverage);
                System.out.println("Total Amount: RM " + totalAmount);

                // Ask the user if they want to reorder
                System.out.print("Do you want to reorder? (Y= Yes / N= No): ");
                String reorderInput = scanner.next().toLowerCase();
                reorder = reorderInput.equals("yes") || reorderInput.equals("y");

                // Store the ticket in the tickets map with its ID as the key
                tickets.put(ticketId, ticket);
            } 
            
            while (reorder);

            System.out.println("Thanks for your purchasing! Enjoy your movie!");
            menu();
        } 
        
        else 
        {
            System.out.println("Ticket not found. Please check your ticket ID.");
            menu(); // Return to the main menu
        }

        scanner.close();
    }

    private static int selectQuantity(Scanner scanner) 
    {
    	int quantity = 0;
    	
    	try 
    	{
    		System.out.print("|Enter quantity: ");
    		quantity = scanner.nextInt();
    		if (quantity <= 0) 
    		{
    			System.out.println("|Invalid quantity. Please enter a positive number.");
    		}
    	} 
    
    	catch (InputMismatchException e) 
    	{
    		System.out.println("|Invalid input. Please enter a valid number.");
    		scanner.nextLine(); // If invalid input
    	}
    	
    	return quantity;
    }

    private static Food selectFood(Scanner scanner) 
    {
    	// Display food menu to user
    	System.out.println("\nFood Menu:");
    	displayFoodMenu();

    	try 
    	{
    		// Prompt the user to enter the number corresponding to the desired food
    		System.out.print("|Enter food number: ");
    		String userInput = scanner.next();

    		switch (userInput) 
    		{
    			case "1":
    				return f1;
                
    			case "2":
    				return f2;
                
    			case "3":
    				return f3;
                
    			case "4":
    				return f4;
                
    			case "5":
    				return f5;
                
    			default:
    				System.out.println("|Invalid food number. No food selected.");
    				return null;
    		}
        
    	} 
    
    	catch (InputMismatchException e) 
    
    	{
    		System.out.println("|Invalid input. Please enter a valid number.");
    		scanner.nextLine(); // if invalid input
    		return null;
    	}
    }

	private static Beverage selectBeverage(Scanner scanner) 
	{
		// Display Beverage menu to user
	    System.out.println("\nBeverage Menu:");
	    displayBeverageMenu();
	
	    try 
	    {
	        System.out.print("|Enter beverage number: ");
	        String userInput = scanner.next();
	
	        switch (userInput) 
	        {
	            case "1":
	                return b1;
	                
	            case "2":
	                return b2;
	                
	            case "3":
	                return b3;
	                
	            case "4":
	                return b4;
	                
	            case "5":
	                return b5;
	                
	            default:
	                System.out.println("|Invalid beverage number. No beverage selected.");
	                return null;
	        }    
	    } 
    
	    catch (InputMismatchException e) 
	    {
	        System.out.println("|Invalid input. Please enter a valid number.");
	        scanner.nextLine(); // if invalid input
	        return null;
	    }
	}

	private static void displayFoodMenu() 
	{
	    System.out.println("|------------------- Food -------------------|");
	    System.out.println("|1. Spicy Chicken Nuggets - RM 5.00          |");
	    System.out.println("|2. Hotdog - RM 1.50                         |");
	    System.out.println("|3. Burger - RM 10.00                        |");
	    System.out.println("|4. Caramel Popcorn - RM 15.00               |");
	    System.out.println("|5. Chips - RM 7.50                          |");
	    System.out.println("|--------------------------------------------|");
	}
	
	private static void displayBeverageMenu() 
	{
	    System.out.println("|------------------ Beverage ----------------|");
	    System.out.println("|1. Cola - RM 7.50                           |");
	    System.out.println("|2. 100Plus - RM 7.50                        |");
	    System.out.println("|3. Pepsi - RM 5.00                          |");
	    System.out.println("|4. Green Tea - RM 5.00                      |");
	    System.out.println("|5. Lemon Tea - RM 3.50                      |");
	    System.out.println("|--------------------------------------------|");
	}
	
	private static void displayFoodDetails(Food food, int quantity) 
	{
	    if (food != null) 
	    {
	        System.out.println("\n--------------- Selected Food --------------");
	        System.out.println("Food Name: " + food.getName());
	        System.out.println("Price per unit: RM " + food.getPrice());
	        System.out.println("Calories: " + food.getCalories());
	        System.out.println("Spiciness Level: " + food.getSpicinessLevel());
	        System.out.println("Food Is Hot: " + (food.getIsHot() ? "Yes" : "No"));
	        System.out.println("Quantity: " + quantity);
	        System.out.println("Total Price: RM " + food.getPrice() * quantity);
	        System.out.println("--------------------------------------------");
	    }
	}
	
	private static void displayBeverageDetails(Beverage beverage, int quantity) 
	{
	    if (beverage != null) 
	    {
	        System.out.println("\n----------- Selected Beverage --------------");
	        System.out.println("Beverage Name: " + beverage.getName());
	        System.out.println("Price per unit: RM " + beverage.getPrice());
	        System.out.println("Size: " + beverage.getSize());
	        System.out.println("Beverage Is Carbonated: " + (beverage.getIsCarbonated() ? "Yes" : "No"));
	        System.out.println("Quantity: " + quantity);
	        System.out.println("Total Price: RM " + beverage.getPrice() * quantity);
	        System.out.println("--------------------------------------------");
	    }
	}

	private static double calculateTotalAmount(Food food, Beverage beverage, int quantityFood, int quantityBeverage) 
	{
	    double totalAmount = 0;
	    
	    if (food != null) 
	    {
	        totalAmount += food.getPrice() * quantityFood;
	    }
	    
	    if (beverage != null) 
	    {
	        totalAmount += beverage.getPrice() * quantityBeverage;
	    }
	    
	    return totalAmount;
	}
	
	public static void CheckTicket(Scanner scanner) 
	{
	    System.out.print("Enter your ticket ID: ");
	    String ticketId = scanner.next();
	
	    // Check if the ticket ID exists in the tickets map
	    if (tickets.containsKey(ticketId)) {
	        Ticket ticket = tickets.get(ticketId);
	
	        // Display ticket information
	        System.out.println("\nTicket Information:");
	        displayTicketInfo(ticket);
	        
	        // Display selected food and beverage information
	        displayFoodDetails(ticket.getSelectedFood(), ticket.getQuantityFood());
	        displayBeverageDetails(ticket.getSelectedBeverage(), ticket.getQuantityBeverage());
	        
	        Scanner input = new Scanner(System.in);
	        System.out.println("\n Do you want to check again or back to menu?");
	        System.out.println("|-------------------------------------------|");
	        System.out.println("| Enter 1 to check again                    |");
	        System.out.println("| Enter 0 to back to menu                   |");
	        System.out.println("|-------------------------------------------|");
	        System.out.print("| Enter :");
	
	        int num = input.nextInt();
	
	        	if (num == 1) 
	        	{
	        	CheckTicket(input);
	        	} 
	        	
	        	else if (num == 0) 
	        	{
	        	System.out.print("\nThank you.");
	        	menu();
	        	}
	        
	        scanner.close();
	        
	    } 
	    
	    else 
	    {
	        System.out.println("Ticket not found. Please check your ticket ID.");
	    }
	
	    menu(); // Return to the main menu
	}
	
	
	public static void MemberProfile(Scanner scanner) 
	{
		System.out.println("|------- Member Profile -----------|");
		System.out.print("Enter your username: ");
	    String username = scanner.next().toLowerCase();
	
	    // Check if the user name exists in the userCredentials map
	    if (userCredentials.containsKey(username)) 
	    {
	        // Retrieve the Member object using the user name
	        Member member = userCredentials.get(username);
	
	        // Prompt for password verification
	        System.out.print("Enter your password: ");
	        String password = scanner.next();
	
	        // Check if the entered password is correct
	        if (isValidCredentials(username, password)) 
	        {
	            // Display member information
	            member.displayProfile();
	        } 
	        
	        else 
	        {
	            System.out.println("Incorrect password. Access denied.");
	        }
	        
	    } 
	    
	    else 
	    {
	        System.out.println("Username not found. Please check your username.");
	    }
	
	    menu(); // Return to the main menu
	}

}


