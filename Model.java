import java.util.ArrayList;


public class Model {
	
	//2 arraylist gia tis tainies kai tis antistoixes theseis
	private ArrayList<String> moviesList;
	private ArrayList<Integer> seatsList ;
	private Integer[] s = new Integer[100];
	private String[] m = new String[100];
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
			
	public Model(){
		moviesList = new ArrayList<String>();
		seatsList = new ArrayList<Integer>();
	}
	
	public int numberOfMovies(){
		return	moviesList.size();
	}
	
	//methodos gia tin meiwsi twn thesewn stin thesi i kata x
	public void decrease(int i, int x){
		seatsList.set(i, seatsList.get(i)-x);
	}
	
	public boolean hasFreeSeats(int i){
		return seatsList.get(i)==0?false:true;
	}
	
	//prosthiki tainiwn
	public void addMovie(String aMovie){
		moviesList.add(aMovie);
	}
	
	//prosthiki thesewn gia tin antistoixi tainia
	public void addSeats(int numOfSeats){
		seatsList.add(numOfSeats);
	}
	
	//onoma tainias
	public String getMovie(int i){
		return moviesList.get(i);
	}
	
	public int getMovieSeats(String theMovie){
		int pos=0;
		for (int i = 0; i < moviesList.size(); i++)
	      {
	         if(moviesList.get(i)==theMovie)
	        	 pos=i;
	      }
	      
		return seatsList.get(pos);	
	}
	//epistrefei oli tin lista
	public ArrayList<String> getMoviesList() {
		return moviesList;
	}
	
	public String[] moviesArray(){
		return ArrayFromList(m, moviesList);
	}
	
	public Integer[] seatsArray(){
		return ArrayFromList(s, seatsList);
	}
	
	private <T> T[] ArrayFromList(T[] array, ArrayList<T> arrayList)
	   {
	      for (int i = 0; i < arrayList.size(); i++)
	      {
	    	  array[i] = arrayList.get(i);
	      }
	      return array;
	}
	
	public void update(String selectedMovie,int numOfSeats){
		for(int x=0;x<moviesList.size();x++){
			if(selectedMovie==moviesList.get(x)&& hasFreeSeats(x)){
				decrease(x,numOfSeats);
			}
		}
	}
	
	public void addReservation(Reservation r){
		reservations.add(r);
	}
	
	public void printReservations(){
		for(int i = 0; i < reservations.size(); i++) {   
			
		    System.out.print(reservations.get(i).getSurname()+"|"+reservations.get(i).getName()+"|"+reservations.get(i).getPhone()+"|"+reservations.get(i).getEmail()+"|"+reservations.get(i).getType()+"|"+reservations.get(i).getTickets()+"|"+reservations.get(i).getDay()+"|"+reservations.get(i).getMovie());
		}  
	}
}
