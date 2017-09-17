public class Reservation {
	
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String movie;
	private int tickets;
	private int day;
	private String type;
	
	public Reservation(String surname, String name, String phone, String email, String type, int tickets, int day, String movie
			 ) {
		super();
		
		this.surname = surname;
		this.name = name;		
		this.phone = phone;
		this.email=email;
		this.type=type;
		this.tickets = tickets;
		this.day = day;
		this.movie = movie;		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	
}
