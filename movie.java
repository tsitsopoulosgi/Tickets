import java.util.Scanner;

public class movie {
		//1)get name
		//2)select Movie
		//3)select seats 
		//4)print out
	
	static Scanner scan=new Scanner(System.in);
	static String name;
	static String[] movielist={"1)The Avangeger 2)SAW 3)Lucy 4)Lion King"};
	static String seats;
	static int number;
	
	public static void main(String[] args) {
		/*System.out.println("Please input name");
		String name=scan.nextLine();
		System.out.println(name);*/
		getName();
		getMovie();
		getSeats();	
	}

	public static Scanner getName() {
		System.out.println("Please input your Name");
		return scan;
	}

	public static Scanner getMovie() {
		System.out.println("Please select a Movie");
		return scan;
	}
	
	public static Scanner getSeats() {
		System.out.println("Please select how many seats you would like");
		return scan;
	}

}
