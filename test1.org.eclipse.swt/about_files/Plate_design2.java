package about_files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.graphics.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import arduino.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import about_files.Manip;
import about_files.Field;
import about_files.Controller;
import about_files.Head;
import about_files.Save_info;
import about_files.Coordinate_Field;
import about_files.Coordinate_Frame;
import about_files.Event;
import javax.swing.UIManager;
import javax.swing.JTextField;




public class Plate_design2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void PlateDesign2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plate_design2 frame = new Plate_design2();
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
	public Plate_design2() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/centuri/eclipse-workspace/Audrey/res/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 3));
		
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		panel_North.setLayout(new GridLayout(0, 1, 0, 50));
		
		
		// Label Plate Design //
		
		JLabel lblLabel_Plate_Design = new JLabel("Plate Design");
		panel_North.add(lblLabel_Plate_Design);
		
		
		// Panel South //
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new GridLayout(2, 1, 2, 0));
		
		JPanel panel_2 = new JPanel();
		panel_South.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_Reading_order = new JLabel("Reading order of selected wells");
		lbl_Reading_order.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Reading_order.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lbl_Reading_order);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(50);
						
		JPanel panel = new JPanel();
		panel_South.add(panel);
		panel.setLayout(new GridLayout(0, 4, 100, 0));
		
		
		// Button Back //
		
		JButton btnButton_Back = new JButton("Back");
		btnButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		panel.add(btnButton_Back);
		
		
		
		// Panel West //
		
				JPanel panel_West = new JPanel();
				contentPane.add(panel_West, BorderLayout.WEST);
				panel_West.setLayout(new GridLayout(5, 1, 0, 5));
				
				
				// Panel Type of plate //
				
				JPanel panel_Type_of_plate = new JPanel();
				panel_West.add(panel_Type_of_plate);
				panel_Type_of_plate.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lblLabel_Type_of_plate = new JLabel("Type of plate");
				panel_Type_of_plate.add(lblLabel_Type_of_plate);
				
				String [] message_type_of_well = {"6 well plate"};// ,"12 well plate", "24 well plate", "48 well plate", "96 well plate"//};
				JComboBox comboBox_Type_of_plate = new JComboBox(message_type_of_well);
				/* comboBox_Type_of_plate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if ((comboBox_Type_of_plate.getSelectedItem().toString())== "6 well plate")
						{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\6 well plate.png"));
						
						}
						if ((comboBox_Type_of_plate.getSelectedItem().toString())== "12 well plate")
						{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\12 well plate.png"));
						}
						if ((comboBox_Type_of_plate.getSelectedItem().toString())== "24 well plate")
						{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\24 well plate.png"));
						}
						if ((comboBox_Type_of_plate.getSelectedItem().toString())== "48 well plate")
						{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\48 well plate.png"));
						}
						if ((comboBox_Type_of_plate.getSelectedItem().toString())== "96 well plate")
						{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\96 well plate.png"));
						}
					}
				}); */
				
				
				panel_Type_of_plate.add(comboBox_Type_of_plate);
				
				
				ArrayList<String> well = new ArrayList<String>();
				well.add("A1");
				well.add("A2");
				well.add("A3");
				well.add("B1");
				well.add("B2");
				well.add("B3");
				
				
				// Création de la liste data //
				ArrayList<String> data = new ArrayList<String>();
				
				
				// Panel First well //
				
				JPanel panel_First_well = new JPanel();
				panel_West.add(panel_First_well);
				panel_First_well.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lblLabel_First_well = new JLabel("First well");
				panel_First_well.add(lblLabel_First_well);
				
				String [] message_First_well = {"A1", "A2", "A3", "B1", "B2", "B3"};
				JComboBox comboBox_First_well = new JComboBox(message_First_well);
				comboBox_First_well.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Valeur: " + comboBox_First_well.getSelectedItem().toString());
					}
				});
				panel_First_well.add(comboBox_First_well);
				
				
				
				// Panel Last well //
				
				JPanel panel_Last_well = new JPanel();
				panel_West.add(panel_Last_well);
				panel_Last_well.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lblLabel_Last_well = new JLabel("Last well");
				panel_Last_well.add(lblLabel_Last_well);
				
				String [] message_Last_well = {"A1", "A2", "A3", "B1", "B2", "B3"};
				JComboBox comboBox_Last_well = new JComboBox(message_Last_well);
				comboBox_Last_well.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Valeur: " + comboBox_Last_well.getSelectedItem().toString());
						textField.setText("");
						int pos = well.indexOf(comboBox_First_well.getSelectedItem().toString());
						System.out.println(pos +"  "+comboBox_First_well.getSelectedItem().toString());
						data.add(comboBox_First_well.getSelectedItem().toString());
						textField.setText(textField.getText() + comboBox_First_well.getSelectedItem().toString()+" ");
						
						int stop = well.indexOf(comboBox_Last_well.getSelectedItem().toString());
						for(int i = pos; i <= stop-1; i++) {
							pos = pos + 1;
							String wellAdd = well.get(pos);
							data.add(wellAdd);
							textField.setText(textField.getText() + wellAdd + " ");
							System.out.println(pos+"  "+ wellAdd);
							}
					}
				});
				panel_Last_well.add(comboBox_Last_well);
				
				// Panel Reading direction //
				
				JPanel panel_Reading_direction = new JPanel();
				panel_West.add(panel_Reading_direction);
				panel_Reading_direction.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lblLabel_Reading_direction = new JLabel("Reading direction");
				panel_Reading_direction.add(lblLabel_Reading_direction);
				
				String [] message_reading_direction = {"Rows by rows", "Columns by columns"};
				JComboBox comboBox_Reading_direction = new JComboBox(message_reading_direction);
				panel_Reading_direction.add(comboBox_Reading_direction);
				
				
				
			//  Création d'un objet de la classe Manip //
				Manip essaiManip = new Manip (comboBox_First_well.getSelectedItem().toString(), comboBox_Last_well.getSelectedItem().toString(), 
		                comboBox_Reading_direction.getName(),"time",data);
				
				
				
				// Panel Time //
				
				JPanel panel_Time = new JPanel();
				panel_West.add(panel_Time);
				panel_Time.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lblLabel_Time = new JLabel("Time");
				panel_Time.add(lblLabel_Time);
				
				String [] message_Time = {"2", "10"};
				JComboBox comboBox_Time = new JComboBox(message_Time);
				comboBox_Time.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(comboBox_Time.getSelectedItem().toString());
						essaiManip.Time(comboBox_Time.getSelectedItem().toString());
					}
				});
				panel_Time.add(comboBox_Time);
				
		
		
	
		// Panel Center //
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_Center.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		
		
		
		
		
		
		// Button A1 //
		JButton btnButton_A1 = new JButton("A1");
		btnButton_A1.setBackground(Color.LIGHT_GRAY);
		btnButton_A1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_A1.getBackground()== Color.LIGHT_GRAY){
					data.add(btnButton_A1.getText());
					textField.setText(textField.getText()+"A1 ");
					btnButton_A1.setBackground(Color.CYAN);
				}
				else {
					btnButton_A1.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_A1.getText());
					textField.setText((textField.getText()).replaceAll("A1 ", ""));
				}    
			}
		});
		btnButton_A1.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		btnButton_A1.setBorder(border);
		panel_1.add(btnButton_A1);
		
		
		// Button A2 //
		
		JButton btnButton_A2 = new JButton("A2");
		btnButton_A2.setBackground(Color.LIGHT_GRAY);
		btnButton_A2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_A2.getBackground()== Color.LIGHT_GRAY){
					data.add(btnButton_A2.getText());
					textField.setText(textField.getText()+"A2 ");
					btnButton_A2.setBackground(Color.CYAN);
				}
				else {
					btnButton_A2.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_A2.getText());
					textField.setText((textField.getText()).replaceAll("A2 ", ""));
				}    
			}
		});
		btnButton_A2.setHorizontalAlignment(SwingConstants.CENTER);
		btnButton_A2.setBorder(border);
		panel_1.add(btnButton_A2);
		
		
		// Button A3 //
		
		JButton btnButton_A3 = new JButton("A3");
		btnButton_A3.setBackground(Color.LIGHT_GRAY);
		btnButton_A3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_A3.getBackground()== Color.LIGHT_GRAY){
					data.add(btnButton_A3.getText());
					textField.setText(textField.getText()+"A3 ");
					btnButton_A3.setBackground(Color.CYAN);
				}
				else {
					btnButton_A3.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_A3.getText());
					textField.setText((textField.getText()).replaceAll("A3 ", ""));
				}    
			}
		});
		btnButton_A3.setHorizontalAlignment(SwingConstants.CENTER);
		btnButton_A3.setBorder(border);
		panel_1.add(btnButton_A3);
		
		
		// Button B1 //
		
		JButton btnButton_B1 = new JButton("B1");
		btnButton_B1.setBackground(Color.LIGHT_GRAY);
		btnButton_B1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_B1.getBackground()== Color.LIGHT_GRAY){
					data.add(btnButton_B1.getText());
					textField.setText(textField.getText()+"B1 ");
					btnButton_B1.setBackground(Color.CYAN);
				}
				else {
					btnButton_B1.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_B1.getText());
					textField.setText((textField.getText()).replaceAll("B1 ", ""));
				}    
			}
		});
		btnButton_B1.setHorizontalAlignment(SwingConstants.CENTER);
		btnButton_B1.setBorder(border);
		panel_1.add(btnButton_B1);
		
		
		// Button B2 //
		
		JButton btnButton_B2 = new JButton("B2");
		btnButton_B2.setBackground(Color.LIGHT_GRAY);
		btnButton_B2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_B2.getBackground()== Color.LIGHT_GRAY){
					data.add(btnButton_B2.getText());
					textField.setText(textField.getText()+"B2 ");
					btnButton_B2.setBackground(Color.CYAN);
				}
				else {
					btnButton_B2.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_B2.getText());
					textField.setText((textField.getText()).replaceAll("B2 ", ""));
				}    
			}
		});
		btnButton_B2.setHorizontalAlignment(SwingConstants.CENTER);
		btnButton_B2.setBorder(border);
		panel_1.add(btnButton_B2);
		
		
		// Button B3 //
		
		JButton btnButton_B3 = new JButton("B3");
		btnButton_B3.setBackground(Color.LIGHT_GRAY);
		btnButton_B3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnButton_B3.getBackground()== (Color.LIGHT_GRAY)){
					data.add(btnButton_B3.getText());
					textField.setText(textField.getText()+"B3 ");
					btnButton_B3.setBackground(Color.CYAN);
				}
				else {
					btnButton_B3.setBackground(Color.LIGHT_GRAY);
					data.remove(btnButton_B3.getText());
					textField.setText((textField.getText()).replaceAll("B3 ", ""));
				}    
			}
		});
		btnButton_B3.setHorizontalAlignment(SwingConstants.CENTER);
		btnButton_B3.setBorder(border);
		panel_1.add(btnButton_B3);
		
		
		// Button Save //
		
				JButton btnButton_Save = new JButton("Save");
				btnButton_Save.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for (int i=0; i<data.size(); i++) {
							System.out.println(data.get(i));
						}
					}
				});
				panel.add(btnButton_Save);
				
				
		// Button Stop //
				
				JButton btnButton_Stop = new JButton("Stop");
				btnButton_Stop.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				panel.add(btnButton_Stop);		
				
				
		// Button Go //
		
				JButton btnButton_Go = new JButton("Go");
				btnButton_Go.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Head head1 = new Head (0.0,0.0,0.0);
						Field essaiField= new Field(130.0, 90.0, 3 ,2);
						
						Coordinate_Field coordinate1 = new Coordinate_Field (essaiField);
						  
						Controller controller1 = new Controller (essaiField,coordinate1,head1,essaiManip); 
						controller1.go();
						controller1.Save_Coordinate();
						controller1.afficher_data_controller();
						try {
							controller1.Arduino();
						}
						catch (IOException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				panel.add(btnButton_Go);
				
				
                
				
	}			
	
}

