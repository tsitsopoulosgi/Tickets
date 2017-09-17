import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Controller{
	private Model model;
	private View view;
	
	//erxetai to model kai to view apo tin main kai vazw ton akroati sto buyButton
	public Controller(Model model, View view){
		this.model=model;
		this.view=view;
		view.addListener(new BuyListener());
	}
	
	
	
	//akroatis gia to koumpi buy
	class BuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(isStringAlpha(view.getNameField())&& isStringAlpha(view.getSurnameField()) && isNumeric(view.getPhoneField()) && view.hasSelectedSeats() ){
				model.update(view.getSelectedMovie(), view.getSeats());
				int ticketcost=view.regIsSelected()?9:6;
				
				JOptionPane.showMessageDialog(null, "Στοιχεία κράτησης: "+view.getSurnameField()+" "+view.getNameField()+
						"\nΑριθμός εισιτηρίων: "+view.getSeats()+
						"\nΣυνολική αξία εισιτηρίων: "+ticketcost*view.getSeats()+"\u20ac"+
						"\nΗ αγορά σας για την ταινία "+view.getSelectedMovie()+" στις "+view.getDate() +" πραγματοποιήθηκε με επιτυχία."+
						"\nΥπόλοιπο διαθέσιμων θέσεων:"+model.getNumOfSeats(view.getSelectedMovie())+
						"\nΚαλή διασκέδαση."
						, "Επιτυχής Αγορά", 1);		
				view.reset();	
			}else if(!isStringAlpha(view.getNameField())){
				view.reset();	
				JOptionPane.showMessageDialog(null,"Λάθος όνομα","Λάθος εισαγωγή",1);
			}else if(!isStringAlpha(view.getSurnameField())){
				view.reset();	
				JOptionPane.showMessageDialog(null,"Λάθος επίθετο","Λάθος εισαγωγή",1);
			}else if(!isNumeric(view.getPhoneField())){
				view.reset();	
				JOptionPane.showMessageDialog(null,"Λάθος τηλέφωνο","Λάθος εισαγωγή",1);
			}else if(!view.hasSelectedSeats()){
				view.reset();	
				JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε θέσεις","Λάθος εισαγωγή",1);
			}
				
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
	
	public boolean isNumeric(String aString){
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
}
