package centuri.test_maven;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;



import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class Interface_graphique extends JFrame {

	private JPanel contentPane;
	private JTextField textField_break;
	private JTextField textField_Time_Video;
	private JTextField textField_Picture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_graphique frame = new Interface_graphique();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface_graphique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		
		Field field= new Field(12.0, 8.0, 3 ,2);
		
		Coordinate_Field coordinate = new Coordinate_Field (field);		
		
		Arduino arduino = new Arduino();
		
		ArrayList<Event> initilization_homing = new ArrayList<Event>();
		
		Initialisation initialization = new Initialisation(arduino);
		
		initilization_homing.add(initialization);
		
		ArrayList<Event> data = new ArrayList<Event>();
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JPanel panel_List = new JPanel();
		contentPane.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		// List ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_List = new JLabel("             List of events             ");
		panel_List_titre.add(lblNewLabel_List);
		lblNewLabel_List.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_List.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(1);
		textArea.setColumns(1);
		panel_1.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel_1.add(scrollPane);
		
		
		JPanel panel_2 = new JPanel();
		panel_List.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 10));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("<html> Number of <br/> repetition of  <br/> the list </html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblNewLabel_2);
		
		String [] rep = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox comboBox_1 = new JComboBox(rep);
		panel_4.add(comboBox_1);
		
		int n = Integer.parseInt(comboBox_1.getSelectedItem().toString());
		
		// Start ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnNewButton = new JButton("Start");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arduino.Start();
				arduino.event_go(initilization_homing);
				for (int i = 1; i <= n; i ++) {
					arduino.event_go(data);
				}
				arduino.Close();
			}
		});
		
		JPanel panel_parameter = new JPanel();
		contentPane.add(panel_parameter, BorderLayout.CENTER);
		panel_parameter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Parameter_titre = new JPanel();
		panel_parameter.add(panel_Parameter_titre, BorderLayout.NORTH);
		panel_Parameter_titre.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Parameter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Parameter_titre.add(lblNewLabel);
		
		JPanel panel_Parameter_contenu = new JPanel();
		panel_parameter.add(panel_Parameter_contenu, BorderLayout.CENTER);
		panel_Parameter_contenu.setLayout(new GridLayout(0, 2, 15, 15));
		
		JPanel panel_Mouvement = new JPanel();
		panel_Mouvement.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Mouvement);
		panel_Mouvement.setLayout(new GridLayout(3, 1, 15, 15));
		
		
		
		
		// Mouvement ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_Mouvement = new JLabel("Mouvement");
		lblNewLabel_Mouvement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement.add(lblNewLabel_Mouvement);
		
		JPanel panel = new JPanel();
		panel_Mouvement.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Well");
		panel.add(lblNewLabel_1);
		
		String [] well = {"A1", "A2", "A3", "B1", "B2", "B3"};
		JComboBox comboBox = new JComboBox(well);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getSelectedItem().toString();
			}
		});
		panel.add(comboBox);
		
		JPanel panel_7_1_1_1 = new JPanel();
		panel_Mouvement.add(panel_7_1_1_1);
		panel_7_1_1_1.setLayout(new GridLayout(0, 2, 15, 15));
		
			
		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(comboBox.getSelectedItem().toString() + "\n");
				double coordinate_x = coordinate.get_x_coordinate(coordinate.get_c (comboBox.getSelectedItem().toString())) * 10;
				double coordinate_y = coordinate.get_y_coordinate(coordinate.get_r (comboBox.getSelectedItem().toString())) * 10;
				Mouvement well = new Mouvement( coordinate_x, coordinate_y, arduino);
				data.add(well);
			}	
		});
		panel_7_1_1_1.add(btnNewButton_1_1_1_1);
		
		
		
		
		// Break ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panel_Break = new JPanel();
		panel_Break.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Break);
		panel_Break.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_Break = new JLabel("Break");
		lblNewLabel_Break.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Break.add(lblNewLabel_Break);
		
		JPanel panel_6 = new JPanel();
		panel_Break.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_break = new JLabel("Time (sec.)");
		panel_6.add(lblNewLabel_Time_break);
		
		textField_break = new JTextField();
		textField_break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(textField_break);
		textField_break.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_Break.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_Add_Break = new JButton("Add");
		btnNewButton_Add_Break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Break "+ textField_break.getText() + " sec." + "\n");
				Pause pause = new Pause((Integer.parseInt(textField_break.getText().toString()))*1000);
				data.add(pause);
			}
		});
		panel_7.add(btnNewButton_Add_Break);
		
		
		
		
		// Picture ////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panel_Picture = new JPanel();
		panel_Picture.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Picture);
		panel_Picture.setLayout(new GridLayout(3, 1, 15, 15));
		JLabel lblNewLabel_3_1 = new JLabel("Picture");
		
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Picture.add(lblNewLabel_3_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_Picture.add(panel_6_1_1);
		panel_6_1_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_Video_1 = new JLabel("Delay (sec.)");
		panel_6_1_1.add(lblNewLabel_Time_Video_1);
		
		textField_Picture = new JTextField();
		textField_Picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Picture.setColumns(10);
		panel_6_1_1.add(textField_Picture);
		
		JPanel panel_7_1_1 = new JPanel();
		panel_Picture.add(panel_7_1_1);
		panel_7_1_1.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Picture "+ textField_Picture.getText() + " sec. delay" + "\n");
				Picture picture = new Picture((Integer.parseInt(textField_Picture.getText().toString()))*1000);
				data.add(picture);
			}
		});
		panel_7_1_1.add(btnNewButton_1_1_1);
		
		
		
		
		// Video /////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panel_Video = new JPanel();
		panel_Video.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Video);
		panel_Video.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_Video = new JLabel("Video");
		lblNewLabel_Video.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Video.add(lblNewLabel_Video);
		
		JPanel panel_6_1 = new JPanel();
		panel_Video.add(panel_6_1);
		panel_6_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_Video = new JLabel("Time (sec.)");
		panel_6_1.add(lblNewLabel_Time_Video);
		
		textField_Time_Video = new JTextField();
		textField_Time_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Time_Video.setColumns(10);
		panel_6_1.add(textField_Time_Video);
		
		JPanel panel_7_1 = new JPanel();
		panel_Video.add(panel_7_1);
		panel_7_1.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Video "+ textField_Time_Video.getText() + " sec. record time" + "\n");
				Video video = new Video((Integer.parseInt(textField_Time_Video.getText().toString()))*1000);
				data.add(video);
			}
		});
		
		panel_7_1.add(btnNewButton_1_1);
	}
}
