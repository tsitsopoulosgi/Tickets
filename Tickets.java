public class Tickets {

	public static void main(String[] args) {
		Model model = new Model();
		
		
		//pernaw ta orismata stin model
		model.addMovie("Spectre-ΑΙΘ5");
		model.addMovie("Superman-ΑΙΘ6");
		model.addMovie("Worlds apart-ΑΙΘ7");
		model.addMovie("Star Wars-ΑΙΘ8");
		model.addMovie("The big short-ΑΙΘ9");
		model.addMovie("The Hateful Eight-VMAX");
		model.addMovie("Secret in their eyes-ΑΙΘ11");
		
		model.addSeats(60);
		model.addSeats(70);
		model.addSeats(80);
		model.addSeats(80);
		model.addSeats(80);
		model.addSeats(100);
		model.addSeats(60);
		
		View view = new View(model.moviesArray(),model.numberOfMovies());
		
		//stelnw to model kai to view poy dimiourgisa ston Controller
		Controller controller = new Controller(model, view);
		controller.control();
		
		//kanw orato to view stin othoni
		view.setVisible(true);
	}

}
