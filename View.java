import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import com.toedter.calendar.JDayChooser;

import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;


public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField phone;
	private JButton buyBtn;
	private JList<String> moviesList;
	private JSpinner numOfTickets;
	private JRadioButton regular;
	private JRadioButton student;
	private long n = System.currentTimeMillis()+ 86400 * 14 * 1000;
	private Date next2Weeks=new Date(n);
	private ButtonGroup group;
	private JDayChooser dayChooser;
	
	public View(String[] m, int numOfMovies) {
		
		super("Village Cinemas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("\u03A6\u03CC\u03C1\u03BC\u03B1 \u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7\u03C2 \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 13, 414, 14);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setBounds(10, 38, 46, 14);
		contentPane.add(nameLabel);
		
		name = new JTextField();
		name.setBounds(10, 59, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel surnameLbl = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		surnameLbl.setBounds(151, 38, 46, 14);
		contentPane.add(surnameLbl);
		
		surname = new JTextField();
		surname.setBounds(151, 59, 86, 20);
		contentPane.add(surname);
		surname.setColumns(10);
		
		JLabel catLbl = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		catLbl.setBounds(10, 131, 79, 14);
		contentPane.add(catLbl);
		
		regular = new JRadioButton("\u039A\u03B1\u03BD\u03BF\u03BD\u03B9\u03BA\u03CC - 8\u20AC");
		regular.setSelected(true);
		regular.setBounds(10, 161, 109, 23);	
		contentPane.add(regular);
		
		student = new JRadioButton("\u03A6\u03BF\u03B9\u03C4\u03B7\u03C4\u03B9\u03BA\u03CC - 4\u20AC");
		student.setBounds(10, 187, 109, 23);
		contentPane.add(student);
		
		group = new ButtonGroup();
		group.add(regular);
		group.add(student);
		
		
		moviesList = new JList<String>();
		moviesList.setVisibleRowCount(3);
		moviesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		moviesList.setBounds(10, 345, 142, 66);
		moviesList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return numOfMovies;
			}
			public String getElementAt(int index) {
				return m[index];
			}
		});
		moviesList.setSelectedIndex(0);
		contentPane.add(moviesList);
		
		JLabel dateLbl = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1");
		dateLbl.setBounds(151, 131, 86, 14);
		contentPane.add(dateLbl);
		
		JLabel movieLbl = new JLabel("\u03A4\u03B1\u03B9\u03BD\u03AF\u03B1");
		movieLbl.setBounds(10, 320, 46, 14);
		contentPane.add(movieLbl);
		
		buyBtn = new JButton("\u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		buyBtn.setBounds(314, 448, 89, 23);
		contentPane.add(buyBtn);
		
		dayChooser = new JDayChooser();
		dayChooser.setBounds(151, 154, 161, 133);
		dayChooser.setMinSelectableDate(new Date());
		dayChooser.setMaxSelectableDate(next2Weeks);
		contentPane.add(dayChooser);
		
		JLabel numberLabel = new JLabel("\u0391\u03C1. \u03B5\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03C9\u03BD");
		numberLabel.setBounds(335, 131, 89, 14);
		contentPane.add(numberLabel);
		
		numOfTickets = new JSpinner();
		numOfTickets.setBounds(345, 162, 45, 20);
		contentPane.add(numOfTickets);
		
		JLabel phoneLbl = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		phoneLbl.setBounds(294, 38, 79, 14);
		contentPane.add(phoneLbl);
		
		phone = new JTextField(10);
		phone.setBounds(294, 59, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(moviesList);
		scrollPane.setBounds(10, 345, 187, 74);
		
		contentPane.add(scrollPane);
	}

	public int getDate(){
		return dayChooser.getDay();
	}
	
	public String getName() {
		return name.getText();
	}


	public String getSurname() {
		return surname.getText();
	}


	public String getPhone() {
		return phone.getText();
	}
	
	public String getSelectedMovie(){
		return moviesList.getSelectedValue();	
	}
	
	public int getSelectedSeats(){
		return (Integer)numOfTickets.getValue();
	}
	
	public boolean regIsSelected(){
		return regular.isSelected();
	}
	
	public boolean hasSelectedSeats(){
		return (Integer)numOfTickets.getValue()>0;
	}
	
	public void reset(){
		name.setText("");
		surname.setText("");
		phone.setText("");
		numOfTickets.setValue(0);
		moviesList.setSelectedIndex(0);
	}
	
	//vazw akroati sto koumpi buy auton poy stelnei o controller
	public void addListener(ActionListener con){
		buyBtn.addActionListener(con);
	}
}
