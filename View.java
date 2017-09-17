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
import javax.swing.JSeparator;
import java.awt.Font;


public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField phone;
	private JTextField email;
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
		setBounds(100, 100, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("\u03A6\u03CC\u03C1\u03BC\u03B1 \u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7\u03C2 \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 13, 414, 14);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setBounds(10, 57, 46, 14);
		contentPane.add(nameLabel);
		
		name = new JTextField();
		name.setBounds(10, 82, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel surnameLbl = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		surnameLbl.setBounds(151, 57, 46, 14);
		contentPane.add(surnameLbl);
		
		surname = new JTextField();
		surname.setBounds(151, 82, 86, 20);
		contentPane.add(surname);
		surname.setColumns(10);
		
		JLabel catLbl = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		catLbl.setHorizontalAlignment(SwingConstants.CENTER);
		catLbl.setBounds(10, 205, 109, 14);
		contentPane.add(catLbl);
		
		regular = new JRadioButton("\u039A\u03B1\u03BD\u03BF\u03BD\u03B9\u03BA\u03CC - 8\u20AC");
		regular.setSelected(true);
		regular.setBounds(10, 226, 109, 23);	
		contentPane.add(regular);
		
		student = new JRadioButton("\u03A6\u03BF\u03B9\u03C4\u03B7\u03C4\u03B9\u03BA\u03CC - 4\u20AC");
		student.setBounds(10, 252, 109, 23);
		contentPane.add(student);
		
		group = new ButtonGroup();
		group.add(regular);
		group.add(student);
		
		
		moviesList = new JList<String>();
		moviesList.setVisibleRowCount(3);
		moviesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		moviesList.setBounds(12, 391, 185, 70);
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
		
		
		JLabel dateLbl = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1");
		dateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateLbl.setBounds(263, 205, 161, 14);
		contentPane.add(dateLbl);
		
		JLabel movieLbl = new JLabel("\u03A4\u03B1\u03B9\u03BD\u03AF\u03B1");
		movieLbl.setBounds(10, 370, 46, 14);
		contentPane.add(movieLbl);
		
		buyBtn = new JButton("\u039A\u03C1\u03AC\u03C4\u03B7\u03C3\u03B7");
		buyBtn.setBounds(335, 495, 89, 23);
		contentPane.add(buyBtn);
		
		JLabel numberLabel = new JLabel("\u0391\u03C1. \u03B5\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03C9\u03BD");
		numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberLabel.setBounds(133, 205, 104, 14);
		contentPane.add(numberLabel);
		
		numOfTickets = new JSpinner();
		numOfTickets.setBounds(163, 227, 45, 20);
		contentPane.add(numOfTickets);
		
		JLabel phoneLbl = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		phoneLbl.setBounds(294, 57, 79, 14);
		contentPane.add(phoneLbl);
		
		phone = new JTextField(10);
		phone.setBounds(294, 82, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(moviesList);
		scrollPane.setBounds(10, 395, 187, 74);
		
		contentPane.add(scrollPane);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setBounds(10, 113, 46, 14);
		contentPane.add(emailLbl);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(10, 138, 161, 20);
		contentPane.add(email);
		
		dayChooser = new JDayChooser();
		dayChooser.setBounds(263, 226, 161, 133);
		dayChooser.setMinSelectableDate(new Date());
		dayChooser.setMaxSelectableDate(next2Weeks);
		contentPane.add(dayChooser);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 187, 434, 7);
		contentPane.add(separator_1);
		
		
		
	
	}
	
	public String getEmail(){
		return email.getText();
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
		email.setText("");
		numOfTickets.setValue(0);
		moviesList.setSelectedIndex(0);
	}
	
	//vazw akroati sto koumpi buy auton poy stelnei o controller
	public void addListener(ActionListener con){
		buyBtn.addActionListener(con);
	}
}
