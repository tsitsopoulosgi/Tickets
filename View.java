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


public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField phoneField;
	private JButton buyButton;
	private JList<String> list;
	private JSpinner numberOfTickets;
	private JRadioButton regButton;
	private JRadioButton studentButton;
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
		
		JLabel titleLabel = new JLabel("\u0391\u03B3\u03BF\u03C1\u03AC \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		titleLabel.setBounds(180, 11, 121, 14);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLabel.setBounds(10, 38, 46, 14);
		contentPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(10, 59, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel surnameLabel = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		surnameLabel.setBounds(151, 38, 46, 14);
		contentPane.add(surnameLabel);
		
		surnameField = new JTextField();
		surnameField.setBounds(151, 59, 86, 20);
		contentPane.add(surnameField);
		surnameField.setColumns(10);
		
		JLabel catLabel = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u0395\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		catLabel.setBounds(10, 131, 79, 14);
		contentPane.add(catLabel);
		
		regButton = new JRadioButton("\u039A\u03B1\u03BD\u03BF\u03BD\u03B9\u03BA\u03CC - 9\u20AC");
		regButton.setSelected(true);
		regButton.setBounds(10, 161, 109, 23);	
		contentPane.add(regButton);
		
		studentButton = new JRadioButton("\u03A6\u03BF\u03B9\u03C4\u03B7\u03C4\u03B9\u03BA\u03CC - 6\u20AC");
		studentButton.setBounds(10, 187, 109, 23);
		contentPane.add(studentButton);
		
		group = new ButtonGroup();
		group.add(regButton);
		group.add(studentButton);
		
		
		list = new JList<String>();
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setBounds(10, 345, 142, 66);
		list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return numOfMovies;
			}
			public String getElementAt(int index) {
				return m[index];
			}
		});
		list.setSelectedIndex(0);
		contentPane.add(list);
		
		JLabel dateLabel = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1");
		dateLabel.setBounds(151, 131, 86, 14);
		contentPane.add(dateLabel);
		
		JLabel movieLabel = new JLabel("\u03A4\u03B1\u03B9\u03BD\u03AF\u03B1");
		movieLabel.setBounds(10, 320, 46, 14);
		contentPane.add(movieLabel);
		
		buyButton = new JButton("\u0391\u03B3\u03BF\u03C1\u03AC");
		buyButton.setBounds(314, 448, 89, 23);
		contentPane.add(buyButton);
		
		dayChooser = new JDayChooser();
		dayChooser.setBounds(151, 154, 161, 133);
		dayChooser.setMinSelectableDate(new Date());
		dayChooser.setMaxSelectableDate(next2Weeks);
		contentPane.add(dayChooser);
		
		JLabel numberLabel = new JLabel("\u0391\u03C1. \u03B5\u03B9\u03C3\u03B9\u03C4\u03B7\u03C1\u03AF\u03C9\u03BD");
		numberLabel.setBounds(335, 131, 89, 14);
		contentPane.add(numberLabel);
		
		numberOfTickets = new JSpinner();
		numberOfTickets.setBounds(345, 162, 45, 20);
		contentPane.add(numberOfTickets);
		
		JLabel phoneLabel = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		phoneLabel.setBounds(294, 38, 79, 14);
		contentPane.add(phoneLabel);
		
		phoneField = new JTextField(10);
		phoneField.setBounds(294, 59, 86, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 345, 187, 74);
		
		contentPane.add(scrollPane);
		
		
	
	
		}

	public int getDate(){
		return dayChooser.getDay();
	}
	public String getNameField() {
		
		return nameField.getText();
	}


	public String getSurnameField() {
		return surnameField.getText();
	}


	public String getPhoneField() {
		return phoneField.getText();
	}
	
	public String getSelectedMovie(){
		return list.getSelectedValue();	
	}
	
	public int getSeats(){
		return (Integer)numberOfTickets.getValue();
	}
	
	public boolean regIsSelected(){
		return regButton.isSelected();
	}
	
	public boolean hasSelectedSeats(){
		return (Integer)numberOfTickets.getValue()>0;
	}
	
	public void reset(){
		nameField.setText("");
		surnameField.setText("");
		phoneField.setText("");
		numberOfTickets.setValue(0);
		list.setSelectedIndex(0);
	}
	
	//vazw akroati sto koumpi buy auton poy stelnei o controller
	public void addListener(ActionListener con){
		buyButton.addActionListener(con);
	}
}
