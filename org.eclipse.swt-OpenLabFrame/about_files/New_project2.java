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
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JRadioButton;




public class New_project2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void New_Project2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_project2 frame = new New_project2();
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
	public New_project2() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/centuri/eclipse-workspace/Audrey/res/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 3));
				
				String [] message_type_of_well = {"6 well plate"};// ,"12 well plate", "24 well plate", "48 well plate", "96 well plate"//};
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
				
				
				ArrayList<String> well = new ArrayList<String>();
				well.add("A1");
				well.add("A2");
				well.add("A3");
				well.add("B1");
				well.add("B2");
				well.add("B3");
				
				
				// Création de la liste data //
				ArrayList<String> data = new ArrayList<String>();
				
				String [] message_First_well = {"A1", "A2", "A3", "B1", "B2", "B3"};
				
				String [] message_Last_well = {"A1", "A2", "A3", "B1", "B2", "B3"};
				
				String [] message_reading_direction = {"Rows by rows", "Columns by columns"};
				
				String [] message_Time = {"2", "10"};
				Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				
				JPanel panel_Plate_Design = new JPanel();
				tabbedPane.addTab("Plate Design", null, panel_Plate_Design, null);
				panel_Plate_Design.setLayout(new BorderLayout(0, 0));
				
				
				// Panel North //
				
				JPanel panel_North = new JPanel();
				panel_Plate_Design.add(panel_North, BorderLayout.NORTH);
				panel_North.setLayout(new GridLayout(0, 1, 0, 50));
				
				
				// Label Plate Design //
				
				JLabel lblLabel_Plate_Design = new JLabel("      ");
				lblLabel_Plate_Design.setForeground(Color.BLUE);
				panel_North.add(lblLabel_Plate_Design);
				
				
				// Panel South //
				
				JPanel panel_South = new JPanel();
				panel_Plate_Design.add(panel_South, BorderLayout.SOUTH);
				panel_South.setLayout(new GridLayout(2, 1, 2, 0));
				
				JPanel panel_2 = new JPanel();
				panel_South.add(panel_2);
				panel_2.setLayout(new GridLayout(2, 1, 0, 0));
				
				JLabel lbl_Reading_order = new JLabel("Reading order of selected wells");
				lbl_Reading_order.setVerticalAlignment(SwingConstants.BOTTOM);
				lbl_Reading_order.setForeground(Color.BLUE);
				lbl_Reading_order.setHorizontalAlignment(SwingConstants.LEFT);
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
						panel_Plate_Design.add(panel_West, BorderLayout.WEST);
						panel_West.setLayout(new GridLayout(5, 1, 0, 5));
						
						
						// Panel Type of plate //
						
						JPanel panel_Type_of_plate = new JPanel();
						panel_West.add(panel_Type_of_plate);
						panel_Type_of_plate.setLayout(new GridLayout(2, 1, 0, 0));
						
						JLabel lblLabel_Type_of_plate = new JLabel("Type of plate");
						lblLabel_Type_of_plate.setForeground(Color.BLUE);
						panel_Type_of_plate.add(lblLabel_Type_of_plate);
						JComboBox comboBox_Type_of_plate = new JComboBox(message_type_of_well);
						
						
						panel_Type_of_plate.add(comboBox_Type_of_plate);
						
						
						// Panel First well //
						
						JPanel panel_First_well = new JPanel();
						panel_West.add(panel_First_well);
						panel_First_well.setLayout(new GridLayout(2, 1, 0, 0));
						
						JLabel lblLabel_First_well = new JLabel("First well");
						lblLabel_First_well.setForeground(Color.BLUE);
						panel_First_well.add(lblLabel_First_well);
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
						lblLabel_Last_well.setForeground(Color.BLUE);
						panel_Last_well.add(lblLabel_Last_well);
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
						lblLabel_Reading_direction.setForeground(Color.BLUE);
						panel_Reading_direction.add(lblLabel_Reading_direction);
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
						lblLabel_Time.setForeground(Color.BLUE);
						panel_Time.add(lblLabel_Time);
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
		panel_Plate_Design.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_Center.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		
		
		
		
		
		
		// Button A1 //
		JButton btnButton_A1 = new JButton("A1");
		btnButton_A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
				
				JPanel panel_Camera = new JPanel();
				tabbedPane.addTab("Camera", null, panel_Camera, null);
				panel_Camera.setLayout(new BorderLayout(0, 0));
				
				JPanel panel_32 = new JPanel();
				panel_Camera.add(panel_32, BorderLayout.CENTER);
				panel_32.setLayout(new BorderLayout(0, 0));
				
				JPanel panel_33 = new JPanel();
				panel_32.add(panel_33, BorderLayout.CENTER);
				panel_33.setLayout(new GridLayout(8, 1, 50, 15));
				
				JPanel panel_45 = new JPanel();
				panel_33.add(panel_45);
				panel_45.setLayout(new GridLayout(0, 1, 0, 0));
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Picture");
				rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
				rdbtnNewRadioButton.setForeground(Color.BLUE);
				panel_45.add(rdbtnNewRadioButton);
				
				JPanel panel_Quality = new JPanel();
				panel_33.add(panel_Quality);
				panel_Quality.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lblNewLabel_3 = new JLabel("Picture setting");
				lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
				panel_Quality.add(lblNewLabel_3);
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_3.setForeground(Color.BLACK);
				lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
				
				JPanel panel_Width = new JPanel();
				panel_33.add(panel_Width);
				panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lbl_Size = new JLabel("Size (mm)");
				panel_Width.add(lbl_Size);
				
				JComboBox comboBox_Size = new JComboBox(new Object[]{});
				panel_Width.add(comboBox_Size);
				
				JPanel panel_Heigth = new JPanel();
				panel_33.add(panel_Heigth);
				panel_Heigth.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lblTime = new JLabel("Delay Time (ms)");
				panel_Heigth.add(lblTime);
				
				JComboBox comboBox_Time_1 = new JComboBox(new Object[]{});
				panel_Heigth.add(comboBox_Time_1);
				
				JPanel panel_46 = new JPanel();
				panel_33.add(panel_46);
				panel_46.setLayout(new GridLayout(1, 2, 0, 0));
				
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Video");
				rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
				rdbtnNewRadioButton_1.setForeground(Color.BLUE);
				panel_46.add(rdbtnNewRadioButton_1);
				
				JPanel panel_78 = new JPanel();
				panel_33.add(panel_78);
				panel_78.setLayout(new GridLayout(1, 2, 0, 0));
				
				JLabel lblNewLabel_3_1 = new JLabel("Video setting");
				lblNewLabel_3_1.setVerticalAlignment(SwingConstants.BOTTOM);
				panel_78.add(lblNewLabel_3_1);
				lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_3_1.setForeground(Color.BLACK);
				lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 12));
				
				JPanel panel_79 = new JPanel();
				panel_33.add(panel_79);
				panel_79.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lblRecordTimems = new JLabel("Record time (ms)");
				panel_79.add(lblRecordTimems);
				
				textField_1 = new JTextField();
				panel_79.add(textField_1);
				textField_1.setColumns(10);
				
				JPanel panel_80 = new JPanel();
				panel_33.add(panel_80);
				
				JPanel panel_22 = new JPanel();
				panel_32.add(panel_22, BorderLayout.EAST);
				panel_22.setLayout(new GridLayout(8, 1, 50, 15));
				
				JPanel panel_48 = new JPanel();
				panel_22.add(panel_48);
				
				JPanel panel_74 = new JPanel();
				panel_22.add(panel_74);
				
				JPanel panel_66 = new JPanel();
				panel_22.add(panel_66);
				
				JPanel panel_75 = new JPanel();
				panel_22.add(panel_75);
				panel_75.setLayout(new GridLayout(0, 1, 0, 0));
				
				JPanel panel_76 = new JPanel();
				panel_22.add(panel_76);
				
				JPanel panel_77 = new JPanel();
				panel_22.add(panel_77);
				
				JPanel panel_83 = new JPanel();
				panel_22.add(panel_83);
				panel_83.setLayout(new GridLayout(0, 1, 0, 0));
				
				JPanel panel_84 = new JPanel();
				panel_22.add(panel_84);
				panel_84.setLayout(new GridLayout(0, 1, 0, 0));
				
				JPanel panel_4_1 = new JPanel();
				panel_Camera.add(panel_4_1, BorderLayout.SOUTH);
				panel_4_1.setLayout(new GridLayout(0, 4, 100, 0));
				
				JButton btnButton_Back_1_1 = new JButton("Back");
				panel_4_1.add(btnButton_Back_1_1);
				
				JPanel panel_Go = new JPanel();
				tabbedPane.addTab("Go", null, panel_Go, null);
				panel_Go.setLayout(new BorderLayout(0, 15));
				
				JPanel panel_3 = new JPanel();
				panel_Go.add(panel_3, BorderLayout.CENTER);
				panel_3.setLayout(new GridLayout(5, 3, 0, 15));
				
				JLabel lblNewLabel = new JLabel("");
				panel_3.add(lblNewLabel);
				
		
				// Button Go //
				
				JButton btnButton_Go = new JButton("Go");
				btnButton_Go.setBackground(Color.GREEN);
				panel_3.add(btnButton_Go);
				btnButton_Go.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Head head1 = new Head (0.0,0.0,0.0);
						Field essaiField= new Field(130.0, 90.0, 3 ,2);
						
						Coordinate_Field coordinate1 = new Coordinate_Field (essaiField);
						  
						Controller controller1 = new Controller (essaiField,coordinate1,head1,essaiManip); 
						controller1.go();
						controller1.Save_Coordinate();
						controller1.afficher_data_controller();
						Thread t = new Thread(controller1);
						t.start();
						
						//try {
							//controller1.Arduino();
						//}
						//catch (IOException | InterruptedException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						//}
					}
				});
				
				JLabel lblNewLabel_1 = new JLabel("");
				panel_3.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("");
				panel_3.add(lblNewLabel_2);
				
				JButton btnNewButton_Start = new JButton("Start preview");
				btnNewButton_Start.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cross point = new Cross();
						ControllerCamera controller_cam = new ControllerCamera();
						Thread t = new Thread(controller_cam);
						t.start();
					}
				});
				btnNewButton_Start.setForeground(Color.BLACK);
				btnNewButton_Start.setFont(new Font("Dialog", Font.BOLD, 12));
				btnNewButton_Start.setBackground(Color.CYAN);
				panel_3.add(btnNewButton_Start);
				
				JLabel lblNewLabel_4 = new JLabel("");
				panel_3.add(lblNewLabel_4);
				
				JLabel lblNewLabel_1_1 = new JLabel("");
				panel_3.add(lblNewLabel_1_1);
				
				JButton btnNewButton_Stop = new JButton("Stop preview");
				btnNewButton_Stop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						StopCamera Stop_cam = new StopCamera();
						Thread t1 = new Thread(Stop_cam);
						t1.start();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_Stop.setForeground(Color.BLACK);
				btnNewButton_Stop.setFont(new Font("Dialog", Font.BOLD, 12));
				btnNewButton_Stop.setBackground(Color.PINK);
				panel_3.add(btnNewButton_Stop);
				
				JLabel lblNewLabel_1_1_1 = new JLabel("");
				panel_3.add(lblNewLabel_1_1_1);
				
				JLabel lblNewLabel_1_1_2 = new JLabel("");
				panel_3.add(lblNewLabel_1_1_2);
				
				JLabel lblNewLabel_1_1_3 = new JLabel("");
				panel_3.add(lblNewLabel_1_1_3);
				
				JLabel lblNewLabel_5 = new JLabel("");
				panel_3.add(lblNewLabel_5);
				
				JLabel lblNewLabel_1_1_4 = new JLabel("");
				panel_3.add(lblNewLabel_1_1_4);
				
				
		// Button Stop //
				
				JButton btnButton_Stop = new JButton("Stop");
				btnButton_Stop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnButton_Stop.setBackground(Color.RED);
				btnButton_Stop.setForeground(Color.WHITE);
				panel_3.add(btnButton_Stop);
				btnButton_Stop.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				
				JLabel lblNewLabel_5_1 = new JLabel("");
				panel_3.add(lblNewLabel_5_1);
				
				JPanel panel_4 = new JPanel();
				panel_Go.add(panel_4, BorderLayout.SOUTH);
				panel_4.setLayout(new BorderLayout(15, 0));
				
				JButton btnButton_Back_1 = new JButton("Back");
				panel_4.add(btnButton_Back_1, BorderLayout.WEST);
				
				JTextArea textArea_InPut = new JTextArea();
				textArea_InPut.setTabSize(3);
				
				
				panel_4.add(textArea_InPut);
				textArea_InPut.setRows(3);
				textArea_InPut.setColumns(1);
				JScrollPane scrollPane = new JScrollPane(textArea_InPut);
				panel_4.add(scrollPane);
				
				JButton btnButton_Save = new JButton("Save");
				btnButton_Save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int i=0; i<data.size(); i++) {
							System.out.println(data.get(i));
						}
					}
				});
				panel_4.add(btnButton_Save, BorderLayout.EAST);
				
				JPanel panel_5 = new JPanel();
				panel_Go.add(panel_5, BorderLayout.NORTH);
				
				
	}			
	
}

