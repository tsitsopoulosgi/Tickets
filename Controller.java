import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controller{
	private Model model;
	private View view;
	private ActionListener BuyListener;

	
	//erxetai to model kai to view apo tin main kai vazw ton akroati sto buyButton
	public Controller(Model model, View view){
		this.model=model;
		this.view=view;
	}
	
	//akroatis gia to koumpi buy
	public void control(){
		BuyListener = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				linkButton();
			}
			
		};
		view.addListener(BuyListener);
	}

	
	public void linkButton(){
		if(isStringAlpha(view.getName())&& isStringAlpha(view.getSurname()) && isNumber(view.getPhone()) && view.hasSelectedSeats() && isEmail(view.getEmail())){
			model.update(view.getSelectedMovie(), view.getSelectedSeats());
			int ticketcost=view.regIsSelected()?8:4;
			
			JOptionPane.showMessageDialog(null, "Στοιχεία κράτησης: "+view.getSurname()+" "+view.getName()+
					"\nΑριθμός εισιτηρίων: "+view.getSelectedSeats()+
					"\nΣυνολική αξία εισιτηρίων: "+ticketcost*view.getSelectedSeats()+"\u20ac"+
					"\nΗ αγορά σας για την ταινία "+view.getSelectedMovie()+" στις "+view.getDate() +"του μηνός πραγματοποιήθηκε με επιτυχία."+
					"\nΗ αποστολή της κράτησης θα γίνει στην διεύθυνση: "+view.getEmail()+
					"\nΥπόλοιπο διαθέσιμων θέσεων: "+model.getMovieSeats(view.getSelectedMovie())+
					"\nΚαλή διασκέδαση."
					, "Επιτυχής Κράτηση", 1);	
			Reservation r = new Reservation(view.getSurname(), view.getName(),view.getPhone(), view.getEmail(), view.regIsSelected()?"regular":"student",view.getSelectedSeats(),view.getDate(),view.getSelectedMovie());
			model.addReservation(r);
			model.printReservations();
			view.reset();	
		}else if(!isStringAlpha(view.getName())){	
			JOptionPane.showMessageDialog(null,"Λάθος όνομα","Λάθος εισαγωγή",1);
			view.reset();
		}else if(!isStringAlpha(view.getSurname())){	
			JOptionPane.showMessageDialog(null,"Λάθος επίθετο","Λάθος εισαγωγή",1);
			view.reset();
		}else if(!isNumber(view.getPhone())){	
			JOptionPane.showMessageDialog(null,"Λάθος τηλέφωνο. Δώστε 10 ψηφία.","Λάθος εισαγωγή",1);
			view.reset();
		}else if(!isEmail(view.getEmail())){
			JOptionPane.showMessageDialog(null,"Παρακαλώ ελέγξτε το email σας","Λάθος εισαγωγή",1);
			view.reset();
		}else if(!view.hasSelectedSeats()){	
			JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε θέσεις","Λάθος εισαγωγή",1);
			view.reset();
		}
	}
	
	public boolean isStringAlpha(String aString){
	    int charCount=0;
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩςΆΈΉΊΌΎΏ";
	    if(aString.length() == 0) return false;//zero length string ain't alpha
	    for(int i=0;i<aString.length();i++){
	        for(int j=0;j<alphabet.length();j++){
	            if(aString.substring(i,i+1).equals(alphabet.substring(j,j+1))
	                || aString.substring(i,i+1).equals(alphabet.substring(j,j+1).toLowerCase()))
	                charCount++;
	        }
	        if(charCount != (i+1)){
		            return false;
	        }
	    }
	        return true;
	}
	
	public boolean isNumber(String aString){
	    int charCount=0;
	    String numbers = "0123456789";
	    if(aString.length() != 10) return false;//zero length string ain't alpha
	    for(int i=0;i<aString.length();i++){
	        for(int j=0;j<numbers.length();j++){
	            if(aString.substring(i,i+1).equals(numbers.substring(j,j+1)))
	                charCount++;
	        }
	        if(charCount != (i+1)){
		            return false;
	        }
	    }
	        return true;
	}
	
	public boolean isEmail(String em)
	 {
	  if(em==null)
	  {
	   return false;
	  }
	  //Assigning the email format regular expression
	  String emailPattern="^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})";
	  return em.matches(emailPattern); 
	 }

	
}
