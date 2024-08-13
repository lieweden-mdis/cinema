package cinema;

public class Member {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    
    // Constructor
    public Member(String username) {
        this.username = username;
    }
    
    public Member(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    
    public void displayProfile() {
        System.out.println("\nMember Information:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}