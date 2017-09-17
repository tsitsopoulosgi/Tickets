import java.util.ArrayList;
import java.util.Date;


public class Model {
	
	//2 arraylist gia tis tainies kai tis antistoixes theseis
	private ArrayList<String> movieList;
	private ArrayList<Integer> seats ;
	private Integer[] s = new Integer[100];
	private String[] m = new String[100];

	
			
	public Model(){
		movieList = new ArrayList<String>();
		seats = new ArrayList<Integer>();
	}
	
	public int numberOfMovies(){
		return	movieList.size();
	}
	
	//methodos gia tin meiwsi twn thesewn stin thesi i kata x
	public void decrease(int i, int x){
		seats.set(i, seats.get(i)-x);
	}
	
	public boolean hasFreeSeats(int i){
		return seats.get(i)==0?false:true;
	}
	
	//prosthiki tainiwn
	public void addMovie(String aMovie){
		movieList.add(aMovie);
	}
	
	//prosthiki thesewn gia tin antistoixi tainia
	public void addSeats(int numOfSeats){
		seats.add(numOfSeats);
	}
	
	//onoma tainias
	public String getMovie(int i){
		return movieList.get(i);
	}
	
	public int getNumOfSeats(String theMovie){
		int pos=0;
		for (int i = 0; i < movieList.size(); i++)
	      {
	         if(movieList.get(i)==theMovie)
	        	 pos=i;
	      }
	      
		return seats.get(pos);	
	}
	//epistrefei oli tin lista
	public ArrayList<String> getMovieList() {
		return movieList;
	}
	
	public String[] moviesArray(){
		return ArrayFromList(m, movieList);
	}
	
	public Integer[] seatsArray(){
		return ArrayFromList(s, seats);
	}
	
	private <T> T[] ArrayFromList(T[] arr, ArrayList<T> arrayList)
	   {
	      for (int i = 0; i < arrayList.size(); i++)
	      {
	         arr[i] = arrayList.get(i);
	      }
	      return arr;
	}
	
	public void update(String selMovie,int numOfSeats){
		for(int x=0;x<movieList.size();x++){
			if(selMovie==movieList.get(x)&& hasFreeSeats(x)){
				decrease(x,numOfSeats);
			}
		}
	}
}
