import java.util.Scanner;

public class movie {
		//1)get name
		//2)select Movie
		//3)select seats 
		//4)print out
	
	static Scanner scan=new Scanner(System.in);
	static String name;
	static String[] movielist={"1) The Avangeger","2) SAW","3) Lucy","4) Lion King"};
	static int number;
	
	
	public static void main(String[] args) {
	/*	System.out.println("Please input name");
		String name=scan.nextLine();
		System.out.println(name);*/
		getName();
		getMovie();
		getSeats();	
	}

	public static void getName() {
		System.out.println("Please input your Name");
		name=scan.nextLine();
		System.out.println("Hello "+name);
		//getMovie();
	}

	public static void getMovie() {
		System.out.println("Please select a Movie");
		for(int i=0;i<movielist.length;i++){
			System.out.println(movielist[i]);
		}
		number=scan.nextInt();
		System.out.println("You selected the movie "+movielist[number-1].substring(3, movielist[number-1].length()));
		//getSeats();
	}
	
	public static void getSeats() {
		System.out.println("Please select how many seats you would like");
		String seats=scan.next();
		System.out.println("Thanks you,\nYou selected seats "+seats+" for the movie "+movielist[number-1].substring(3, movielist[number-1].length()));
		}

}
