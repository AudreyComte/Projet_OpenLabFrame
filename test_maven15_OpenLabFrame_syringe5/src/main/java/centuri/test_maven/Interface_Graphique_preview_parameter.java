package centuri.test_maven;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import centuri.test_maven.ControllerCamera;
//import centuri.test_maven.StopCamera;

import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.print.DocFlavor.URL;
import javax.sql.rowset.serial.SerialException;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.event.ChangeEvent;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import centuri.test_maven.Cross;

public class Interface_Graphique_preview_parameter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_coordinate_x;
	private JTextField textField_coordinate_y;
	private JTextField textField_coordinate_z;
	private JTextField textField_Time_Video;
	private JTextField textField_Syringue_i;
	private JTextField textField_Syringue_a;
	private JTextField textField_rep;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Graphique_preview_parameter frame = new Interface_Graphique_preview_parameter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws SerialException 
	 */
	 
	public Interface_Graphique_preview_parameter() throws SerialException, IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		setBounds(0, 0, 800, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(1, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_Center.add(tabbedPane);
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Dimension de de la plaque avec le nombre de colonne et de ligne
				Field field = new Field(12.0, 8.0, 3, 2);

				// Calcul des coordonnées de chaque puits de la plaque
				Coordinate_Field coordinate = new Coordinate_Field(field);
				
				Arduino arduino = new Arduino("ttyACM0");
				
				arduino.start();
			

				// Arduino arduino2 = new Arduino("ttyAMA0");
				// arduino2.Start();
				
				
		        // Liste d'objet Event qui sert à stocker les différents évenements (Mouvement, Pause, Picture, Video, Syringe, Home)
				ArrayList<Event> data = new ArrayList<Event>();
				
				
		        // Instanciation d'un objet initialization de la classe Inialisation
				Initialization initialization = new Initialization(arduino);

				// Ajout de l'objet initialization dans le liste d'Event pour permettre d'effectuer le Homing à chaque répétition de la liste 
				data.add(initialization);

				// Instanciation d'un objet camera de la classe Camera
				Camera camera = new Camera();
				
				// Instanciation d'un objet protocol de la classe Loading_protocol
				Loading_Protocol protocol = new Loading_Protocol();
				
				ArrayList <Double> tx = new ArrayList();
				tx.add(0.0);
				ArrayList <Double> ty = new ArrayList();
				ty.add(0.0);
				ArrayList <Double> tz = new ArrayList();
				tz.add(0.0);
				
				JComboBox comboBox_1 = new JComboBox<>();
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				
		//Panel Moving//
				
		
		Counter counter_x =new Counter(0.0);
		Counter counter_y =new Counter(0.0);
		Counter counter_z =new Counter(0.0);
		
		Counter counter2_x =new Counter(0.0);
		Counter counter2_y =new Counter(0.0);
		Counter counter2_z =new Counter(0.0);
		
		JPanel panel_Moving = new JPanel();
		tabbedPane.addTab("Preview", null, panel_Moving, null);
		panel_Moving.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_Moving.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_44 = new JPanel();
		panel_44.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel_44);
		panel_44.setBorder(new LineBorder(Color.GRAY));
		panel_44.setLayout(new GridLayout(4, 3, 50, 0));
		
		JPanel panel_55 = new JPanel();
		panel_55.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_55);
		panel_55.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_56 = new JPanel();
		panel_56.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_56);
		panel_56.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_57 = new JPanel();
		panel_57.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_57);
		
		JPanel panel_58 = new JPanel();
		panel_58.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_58);
		panel_58.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Coordinate X Y Z");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		panel_58.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel panel_59 = new JPanel();
		panel_59.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_59);
		panel_59.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_60 = new JPanel();
		panel_60.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_60);
		panel_60.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_62 = new JPanel();
		panel_62.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_62);
		panel_62.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("X");
		panel_62.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_61 = new JPanel();
		panel_61.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_61);
		panel_61.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5_1 = new JLabel("Y");
		panel_61.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_63 = new JPanel();
		panel_63.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_63);
		panel_63.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5_2 = new JLabel("Z");
		panel_63.add(lblNewLabel_5_2);
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_70 = new JPanel();
		panel_70.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_70);
		panel_70.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel textArea_x = new JLabel();
		textArea_x.setHorizontalAlignment(SwingConstants.CENTER);
		panel_70.add(textArea_x);
		
		textArea_x.setText((counter_x.get_Counter())+"");
		
		JPanel panel_64 = new JPanel();
		panel_64.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_64);
		panel_64.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel textArea_y = new JLabel();
		textArea_y.setHorizontalAlignment(SwingConstants.CENTER);
		panel_64.add(textArea_y);
		textArea_y.setText((counter_y.get_Counter())+"");
		
		JPanel panel_65 = new JPanel();
		panel_65.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_65);
		panel_65.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel textArea_z = new JLabel();
		textArea_z.setHorizontalAlignment(SwingConstants.CENTER);
		panel_65.add(textArea_z);
		textArea_z.setText((counter_z.get_Counter())+"");
		
		JPanel panel = new JPanel();
		panel_Moving.add(panel, BorderLayout.CENTER);
				panel.setLayout(new BorderLayout(0, 0));
				
				JPanel panel_71 = new JPanel();
				panel.add(panel_71, BorderLayout.CENTER);
				panel_71.setLayout(new GridLayout(5, 4, 15, 15));
				
				JPanel panel_18_1 = new JPanel();
				panel_71.add(panel_18_1);
				panel_18_1.setLayout(new GridLayout(1, 1, 0, 0));
				
				JLabel lblNewLabel_1_2 = new JLabel("Relative");
				lblNewLabel_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
				lblNewLabel_1_2.setForeground(Color.BLUE);
				lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
				panel_18_1.add(lblNewLabel_1_2);
				
				JPanel panel_2 = new JPanel();
				panel_71.add(panel_2);
				panel_2.setLayout(new GridLayout(0, 1, 0, 0));
				
				JButton btnNewButton_6 = new JButton("Set as A1");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						coordinate.set_A1_x(counter_x.get_Counter());
						System.out.println("A1 X = " + counter_x.get_Counter());
						coordinate.set_A1_y(counter_y.get_Counter());
						System.out.println("A1 Y = " + counter_y.get_Counter());
						coordinate.set_A1_z(counter_z.get_Counter());
						System.out.println("A1 Z = " + counter_z.get_Counter());
					}
				});
				btnNewButton_6.setForeground(Color.WHITE);
				btnNewButton_6.setBackground(Color.MAGENTA);
				panel_2.add(btnNewButton_6);
				
				
				JPanel panel_3 = new JPanel();
				panel_71.add(panel_3);
				panel_3.setLayout(new GridLayout(0, 1, 0, 0));
				
				JButton btnNewButton_7 = new JButton("Set position");
				
				btnNewButton_7.setBackground(Color.ORANGE);
				panel_3.add(btnNewButton_7);
				
				JPanel panel_24 = new JPanel();
				panel_71.add(panel_24);
				panel_24.setLayout(new GridLayout(0, 1, 0, 0));
				
				// Button Set zero here //
				
				JButton btn_Origine = new JButton("Set zero here");
				panel_24.add(btn_Origine);
				btn_Origine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						arduino.go(("G10 P0 L20 X0 Y0 Z0\n"));
						                        
						counter_x.set_Counter(0.0);
						counter_y.set_Counter(0.0);
						counter_z.set_Counter(0.0);
						textArea_x.setText((counter_x.get_Counter())+"");
						textArea_y.setText((counter_y.get_Counter())+"");
						textArea_z.setText((counter_z.get_Counter())+"");
						
						arduino.input();
						
					}
				});
				btn_Origine.setBackground(Color.YELLOW);
				btn_Origine.setFont(new Font("Dialog", Font.BOLD, 11));
				
				JPanel panel_23 = new JPanel();
				panel_71.add(panel_23);
				panel_23.setLayout(new GridLayout(1, 1, 0, 0));
				
				
				ArrayList valeur = new ArrayList();
				
				
				JButton btnNewButton = new JButton("Step 0.1 mm");
				btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
				JButton btnNewButton_4 = new JButton("Step 1 mm");
				btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 12));
				JButton btnNewButton_5 = new JButton("Step 10 mm");
				btnNewButton_5.setFont(new Font("Dialog", Font.BOLD, 12));
				
				
			
				panel_23.add(btnNewButton);
				
				JPanel panel_25 = new JPanel();
				panel_71.add(panel_25);
				panel_25.setLayout(new GridLayout(0, 1, 0, 0));
				
				
				
				
				panel_25.add(btnNewButton_4);
				
						
						JPanel panel_17 = new JPanel();
						panel_71.add(panel_17);
						panel_17.setLayout(new GridLayout(1, 1, 0, 0));
						
						
						
						panel_17.add(btnNewButton_5);
						
						JPanel panel_15 = new JPanel();
						panel_71.add(panel_15);
						panel_15.setLayout(new GridLayout(1, 1, 0, 0));
						
						JPanel panel_14 = new JPanel();
						panel_71.add(panel_14);
						panel_14.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_13 = new JPanel();
						panel_71.add(panel_13);
						panel_13.setLayout(new GridLayout(0, 1, 0, 0));
						
						
						// Button +Y //
						
						JButton btn_plus_Y = new JButton("+ Y");
						panel_13.add(btn_plus_Y);
						btn_plus_Y.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
									btn_plus_Y.setText("Select a step");
								}
								
								if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
								
								System.out.println(counter_y.get_Counter()+"");
									counter_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									if (counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0 & 
											(counter2_y.get_Counter() < 90 & counter2_y.get_Counter() >= 0 )) {
										
								arduino.go(("G91G0y" + (Double.parseDouble(valeur.get(0).toString())) + "\n"));
								
								textArea_y.setText((counter_y.get_Counter())+"");
								}
									else {
										counter_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
										counter2_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									}
									
									arduino.input();
									
							}
							}
						});
						btn_plus_Y.setBackground(Color.CYAN);
						
						JPanel panel_5 = new JPanel();
						panel_71.add(panel_5);
						panel_5.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_8 = new JPanel();
						panel_71.add(panel_8);
						panel_8.setLayout(new GridLayout(1, 1, 0, 0));
						
						
						// Button Z+ //
						
						JButton btn_plus_Z = new JButton("+ Z");
						panel_8.add(btn_plus_Z);
						btn_plus_Z.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
									btn_plus_Z.setText("Select a step");
								}
								
								if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
									
								System.out.println(counter_z.get_Counter()+"");
									counter_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									if ((counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0) & 
											(counter2_z.get_Counter() > -50 & counter2_z.get_Counter() <= 0)) {
										
										arduino.go(("G91G0z" + (Double.parseDouble(valeur.get(0).toString())) + "\n"));
										
										textArea_z.setText((counter_z.get_Counter())+"");
									}	
									else {
										counter_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
										counter2_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									}
									
									arduino.input();
										
						 }
						}		
						});
						btn_plus_Z.setBackground(Color.CYAN);
						
						JPanel panel_7 = new JPanel();
						panel_71.add(panel_7);
						panel_7.setLayout(new GridLayout(1, 1, 0, 0));
						
						
						// Button -X //
						
						JButton btn_moins_X = new JButton("- X");
						panel_7.add(btn_moins_X);
						btn_moins_X.setBackground(Color.CYAN);
						
						JPanel panel_9 = new JPanel();
						panel_71.add(panel_9);
						panel_9.setLayout(new GridLayout(1, 1, 0, 0));
						
						
						// Button Home //
						
						JButton btn_Home = new JButton("Home");
						panel_9.add(btn_Home);
						btn_Home.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								arduino.go("$H");
								
								counter_x.set_Counter(0.0);
								counter_y.set_Counter(0.0);
								counter_z.set_Counter(0.0);
								counter2_x.set_Counter(0.0);
								counter2_y.set_Counter(0.0);
								counter2_z.set_Counter(0.0);
								textArea_x.setText((counter_x.get_Counter())+"");
								textArea_y.setText((counter_y.get_Counter())+"");
								textArea_z.setText((counter_z.get_Counter())+"");
								
								arduino.input();							
							}
						});
						btn_Home.setForeground(new Color(255, 255, 255));
						btn_Home.setBackground(Color.BLUE);
						
						JPanel panel_6 = new JPanel();
						panel_71.add(panel_6);
						panel_6.setLayout(new GridLayout(1, 1, 0, 0));
						
						
						// Button +X //
						
						JButton btn_plus_x = new JButton("+ X");
						panel_6.add(btn_plus_x);
						btn_plus_x.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
									btn_plus_x.setText("Select a step");
								}
								
								if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
								System.out.println(counter_x.get_Counter()+"");
								counter_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
								counter2_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
								if ((counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0)&
										(counter2_x.get_Counter() < 130 & counter2_x.get_Counter() >= 0)) {
								
								arduino.go("G91G0x" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
								
								textArea_x.setText((counter_x.get_Counter())+"");
								}
								else {
									counter_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
								}
								
								
								arduino.input();	
								
								
							}
							}
						});
						btn_plus_x.setBackground(Color.CYAN);
						
						JPanel panel_11 = new JPanel();
						panel_71.add(panel_11);
						panel_11.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_26 = new JPanel();
						panel_71.add(panel_26);
						panel_26.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_21 = new JPanel();
						panel_71.add(panel_21);
						panel_21.setLayout(new GridLayout(0, 1, 0, 0));
						
						
						// Button -Y //
						
						JButton btn_moins_Y = new JButton("- Y");
						panel_21.add(btn_moins_Y);
						btn_moins_Y.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
									btn_moins_Y.setText("Select a step");
								}
								
								if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
								System.out.println(counter_y.get_Counter()+"");
									counter_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									if ((counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0)&
											(counter2_y.get_Counter() < 90 & counter2_y.get_Counter() >= 0)) {
								
										arduino.go("G91G0y-" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
								
								textArea_y.setText((counter_y.get_Counter())+"");
								}
									else {
										counter_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
										counter2_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									}
									
									arduino.input();	
									
							}
							}
						});
						btn_moins_Y.setBackground(Color.CYAN);
						
						JPanel panel_31 = new JPanel();
						panel_71.add(panel_31);
						panel_31.setLayout(new GridLayout(1, 1, 0, 0));
						
						JPanel panel_20 = new JPanel();
						panel_71.add(panel_20);
						panel_20.setLayout(new GridLayout(0, 1, 0, 0));
						
						
						// Button -Z //
						
						JButton btn_moins_Z = new JButton("- Z");
						panel_20.add(btn_moins_Z);
						btn_moins_Z.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
									btn_moins_Z.setText("Select a step");
								}
								
								if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
								System.out.println(counter_z.get_Counter()+"");
									counter_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
									if ((counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0)&
											(counter2_z.get_Counter() > -50 & counter2_z.get_Counter() <= 0)) {
										
								arduino.go(("G91G0z-" + (Double.parseDouble(valeur.get(0).toString())) + "\n"));
								
								textArea_z.setText((counter_z.get_Counter())+"");
								}
									else {counter_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									     counter2_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									     }
									
									arduino.input();	
										
							}
							}
						});
						btn_moins_Z.setBackground(Color.CYAN);
						
						JPanel panel_18 = new JPanel();
						panel.add(panel_18, BorderLayout.EAST);
						panel_18.setLayout(new GridLayout(0, 1, 0, 0));
						
						JLabel lblNewLabel = new JLabel("                                                              ");
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						panel_18.add(lblNewLabel);
						
						DefaultListModel<String> listData_1 = new DefaultListModel();
						
						JLabel label = new JLabel("");
						panel_18.add(label);
						
						JList list_1 = new JList(listData_1);
						panel_18.add(list_1, BorderLayout.SOUTH);
						
						JScrollPane scrollPane_list_1 = new JScrollPane(list_1);
						panel_18.add(scrollPane_list_1);
									
						
						btnNewButton_7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								listData_1.addElement("position " + (listData_1.size()+1)+ " (x = "+ counter_x.get_Counter()+ "; y = "+ counter_y.get_Counter() +"; z = "+ counter_z.get_Counter() +" ) \n");
								tx.add(counter_x.get_Counter());
								ty.add(counter_y.get_Counter());
								tz.add(counter_z.get_Counter());
								comboBox_1.addItem((listData_1.size())+"");
							}
						});
						
						
						btn_moins_X.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(btnNewButton.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_4.getBackground( )!=(Color.LIGHT_GRAY) && btnNewButton_5.getBackground( )!=(Color.LIGHT_GRAY)) {
								btn_moins_X.setText("Select a step");
							}
							
							if(btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
								System.out.println(counter_x.get_Counter()+"");
								counter_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
								counter2_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
								if ((counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0)&
										(counter2_x.get_Counter() < 130 & counter2_x.get_Counter() >= 0)) {
								
								arduino.go("G91G0x-" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
								
								textArea_x.setText((counter_x.get_Counter())+"");
								}
								else {
									counter_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
									counter2_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
								}
								
								
								arduino.input();
								
							}
							}
						});
						
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btn_plus_Y.setText("+ Y");
								btn_moins_Y.setText("- Y");
								btn_plus_Z.setText("+ Z");
								btn_moins_Z.setText("- Z");
								btn_plus_x.setText("+ X");
								btn_moins_X.setText("- X");
								valeur.clear();
								valeur.add(0.1);
								btnNewButton.setBackground(Color.LIGHT_GRAY);
								if (btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
									btnNewButton_4.setBackground(UIManager.getColor("Button.background"));
									btnNewButton_5.setBackground(UIManager.getColor("Button.background"));
								}
								
							}
						});
						
						btnNewButton_4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btn_plus_Y.setText("+ Y");
								btn_moins_Y.setText("- Y");
								btn_plus_Z.setText("+ Z");
								btn_moins_Z.setText("- Z");
								btn_plus_x.setText("+ X");
								btn_moins_X.setText("- X");
								valeur.clear();
								valeur.add(1);
								btnNewButton_4.setBackground(Color.LIGHT_GRAY);
								if (btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_5.getBackground( )==(Color.LIGHT_GRAY)) {
									btnNewButton.setBackground(UIManager.getColor("Button.background"));	
									btnNewButton_5.setBackground(UIManager.getColor("Button.background"));
							}
							}
						});
						
						btnNewButton_5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btn_plus_Y.setText("+ Y");
								btn_moins_Y.setText("- Y");
								btn_plus_Z.setText("+ Z");
								btn_moins_Z.setText("- Z");
								btn_plus_x.setText("+ X");
								btn_moins_X.setText("- X");
								valeur.clear();
								valeur.add(10);
								btnNewButton_5.setBackground(Color.LIGHT_GRAY);
								if (btnNewButton.getBackground( )==(Color.LIGHT_GRAY) || btnNewButton_4.getBackground( )==(Color.LIGHT_GRAY)) {
									btnNewButton.setBackground(UIManager.getColor("Button.background"));	
									btnNewButton_4.setBackground(UIManager.getColor("Button.background"));
							}
							}
						});
							
			
		
		JPanel panel_4 = new JPanel();
		panel_Moving.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_4.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(3, 3, 30, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Absolute");
		panel_19.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.BLUE);
		
		JPanel panel_1 = new JPanel();
		panel_19.add(panel_1);
		
		JPanel panel_16 = new JPanel();
		panel_19.add(panel_16);
		
		JPanel panel_30 = new JPanel();
		panel_19.add(panel_30);
		panel_30.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("coordinate x (mm)");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_30.add(lblNewLabel_2);
		
		JPanel panel_28 = new JPanel();
		panel_19.add(panel_28);
		panel_28.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("coordinate y (mm)");
		panel_28.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_29 = new JPanel();
		panel_19.add(panel_29);
		panel_29.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("coordinate z (mm)");
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_29.add(lblNewLabel_2_1_1);
		
		JPanel panel_35 = new JPanel();
		panel_19.add(panel_35);
		panel_35.setLayout(new GridLayout(1, 2, 0, 0));
		
		textField_coordinate_x = new JTextField();
		textField_coordinate_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_35.add(textField_coordinate_x);
		textField_coordinate_x.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt((textField_coordinate_x.getText())) < 130 & Integer.parseInt((textField_coordinate_x.getText())) >= 0) {
				
				arduino.go("G90G0x" + textField_coordinate_x.getText() + "\n");
					
				counter_x.set_Counter(Double.parseDouble((textField_coordinate_x.getText())));
				textArea_x.setText((counter_x.get_Counter())+"");
				
				arduino.input();
			
			}}
		});
		panel_35.add(btnNewButton_1);
		
		JPanel panel_36 = new JPanel();
		panel_19.add(panel_36);
		panel_36.setLayout(new GridLayout(1, 2, 0, 0));
		
		textField_coordinate_y = new JTextField();
		textField_coordinate_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_36.add(textField_coordinate_y);
		textField_coordinate_y.setColumns(10);
		
		
		JButton btnNewButton_2 = new JButton("Y");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt((textField_coordinate_y.getText())) < 90 & Integer.parseInt((textField_coordinate_y.getText())) >= 0) {
					
					arduino.go("G90G0y" + textField_coordinate_y.getText() + "\n");
				
				counter_y.set_Counter(Double.parseDouble((textField_coordinate_y.getText())));
				textArea_y.setText((counter_y.get_Counter())+"");
				
				arduino.input();
			
			}}
		});
		panel_36.add(btnNewButton_2);
		
		JPanel panel_38 = new JPanel();
		panel_19.add(panel_38);
		panel_38.setLayout(new GridLayout(1, 2, 0, 0));
		
		textField_coordinate_z = new JTextField();
		textField_coordinate_z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_38.add(textField_coordinate_z);
		textField_coordinate_z.setColumns(10);
		
		
		JButton btnNewButton_3 = new JButton("Z");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt((textField_coordinate_z.getText())) > -50 & Integer.parseInt((textField_coordinate_z.getText())) <= 0) {
				
				arduino.go("G90G0z" + textField_coordinate_z.getText() + "\n");
				
				counter_z.set_Counter(Double.parseDouble((textField_coordinate_z.getText())));
				textArea_z.setText((counter_z.get_Counter())+"");
				
				arduino.input();
			
			}}
		});
		panel_38.add(btnNewButton_3);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_42 = new JPanel();
		panel_12.add(panel_42);
		panel_42.setLayout(new GridLayout(2, 2, 50, 0));
		
		JPanel panel_51 = new JPanel();
		panel_42.add(panel_51);
		
		JPanel panel_52 = new JPanel();
		panel_42.add(panel_52);
		
		
		// Button Stop //
		
		JButton btnNewButton_Stop = new JButton("Stop preview");
		panel_42.add(btnNewButton_Stop);
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
		btnNewButton_Stop.setForeground(new Color(255, 255, 255));
		btnNewButton_Stop.setBackground(Color.RED);
		btnNewButton_Stop.setFont(new Font("Dialog", Font.BOLD, 12));
		
		
		// Button Start //
		
		JButton btnNewButton_Start = new JButton("Start preview");
		panel_42.add(btnNewButton_Start);
		btnNewButton_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cross point = new Cross();
				ControllerCamera controller_cam = new ControllerCamera();
				Thread t = new Thread(controller_cam);
				t.start();
			}
		});
		btnNewButton_Start.setForeground(new Color(0, 0, 0));
		btnNewButton_Start.setBackground(Color.GREEN);
		btnNewButton_Start.setFont(new Font("Dialog", Font.BOLD, 12));
		
		
	
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panel_parameter2 = new JPanel();
		tabbedPane.addTab("Parameter", null, panel_parameter2, null);
		panel_parameter2.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel_List = new JPanel();
		panel_List.setPreferredSize(new Dimension(200, 300));
		panel_parameter2.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));

		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(1, 1, 0, 0));

		
		// List
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_List = new JLabel("List of events");
		panel_List_titre.add(lblNewLabel_List);
		lblNewLabel_List.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_list_scrollPane = new JPanel();
		panel_List.add(panel_list_scrollPane, BorderLayout.CENTER);
		panel_list_scrollPane.setLayout(new BorderLayout(0, 0));

		// listData est une instance de la classe DefaultListModel qui stocke des
		// éléments sous forme de chaînes de caractères.
		DefaultListModel<String> listData = new DefaultListModel();

		// Instanciation d'une liste de string de la classe JList qui prend en argument
		// l'object listData
		JList<String> list = new JList(listData);

		panel_list_scrollPane.add(list);

		JScrollPane scrollPane_list = new JScrollPane(list);
		panel_list_scrollPane.add(scrollPane_list, BorderLayout.CENTER);

		JPanel panel_list2 = new JPanel();
		panel_List.add(panel_list2, BorderLayout.SOUTH);
		panel_list2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_list3 = new JPanel();
		panel_list2.add(panel_list3);
		panel_list3.setLayout(new GridLayout(2, 1, 0, 10));

		JPanel panel_remove_apply = new JPanel();
		panel_list3.add(panel_remove_apply);

		
		// Bouton "Remouve"
		JButton btnNewButton_remove = new JButton("Remove");
		btnNewButton_remove.setBackground(Color.ORANGE);
		btnNewButton_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				listData.remove(selectedIndex);
				data.remove(selectedIndex + 1);
			}
		});

		
		// Button "Apply to all well"
		JButton btnNewButton_applyAll = new JButton("Apply to all well"); 
		btnNewButton_applyAll.setForeground(Color.WHITE);
		btnNewButton_applyAll.setBackground(Color.MAGENTA);
		btnNewButton_applyAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinate.apply_all(listData, data, arduino);
			}
		});
		panel_remove_apply.setLayout(new GridLayout(0, 1, 0, 5));
		panel_remove_apply.add(btnNewButton_applyAll);
		panel_remove_apply.add(btnNewButton_remove);

		JPanel panel_timeTotal = new JPanel();
		panel_list3.add(panel_timeTotal);
		panel_timeTotal.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_timeTotal = new JLabel("Total time : ");
		lblNewLabel_timeTotal.setHorizontalAlignment(SwingConstants.LEFT);

		panel_timeTotal.add(lblNewLabel_timeTotal);

		
		
		// Parameter
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_parameter = new JPanel();
		panel_parameter2.add(panel_parameter, BorderLayout.CENTER);
		panel_parameter.setLayout(new BorderLayout(0, 0));

		JPanel panel_Parameter_titre = new JPanel();
		panel_parameter.add(panel_Parameter_titre, BorderLayout.NORTH);
		panel_Parameter_titre.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_parameter = new JLabel("Parameter");
		lblNewLabel_parameter.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Parameter_titre.add(lblNewLabel_parameter);

		JPanel panel_Parameter_contenu = new JPanel();
		panel_parameter.add(panel_Parameter_contenu, BorderLayout.CENTER);
		panel_Parameter_contenu.setLayout(new GridLayout(4, 2, 15, 15));

		JPanel panel_Mouvement = new JPanel();
		panel_Mouvement.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Mouvement);
		panel_Mouvement.setLayout(new GridLayout(2, 1, 5, 5));

		
		
		// Mouvement
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_Mouvement = new JLabel("6 well plate");
		lblNewLabel_Mouvement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement.add(lblNewLabel_Mouvement);

		JPanel panel1 = new JPanel();
		panel_Mouvement.add(panel1);
		panel1.setLayout(new GridLayout(1, 3, 10, 0));

		JLabel lblNewLabel_well = new JLabel("Well");
		lblNewLabel_well.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_well.setFont(new Font("Dialog", Font.BOLD, 12));
		panel1.add(lblNewLabel_well);

		String[] well = { "A1", "A2", "A3", "B1", "B2", "B3" };
		JComboBox comboBox = new JComboBox(well);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getSelectedItem().toString();
			}
		});
		panel1.add(comboBox);

		JButton btnNewButton_add_well = new JButton("Add");
		btnNewButton_add_well.setBackground(Color.CYAN);
		panel1.add(btnNewButton_add_well);
		btnNewButton_add_well.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement((comboBox.getSelectedItem().toString() + "\n"));
				double coordinate_x = (coordinate
						.get_x_coordinate(coordinate.get_c(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_y = (coordinate
						.get_y_coordinate(coordinate.get_r(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_z = coordinate.get_A1_z();
				Mouvement well = new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino);
				data.add(well);
			}
		});
		
		JPanel panel_Mouvement2 = new JPanel();
		panel_Parameter_contenu.add(panel_Mouvement2);
		panel_Mouvement2.setLayout(new GridLayout(2, 1, 0, 5));
		
		JLabel lblNewLabel_Mouvement_1 = new JLabel("Mouvement ");
		lblNewLabel_Mouvement_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Mouvement2.add(lblNewLabel_Mouvement_1);
		
		JPanel panel1_1 = new JPanel();
		panel_Mouvement2.add(panel1_1);
		panel1_1.setLayout(new GridLayout(1, 3, 10, 0));
		
		JLabel lblNewLabel_well_1 = new JLabel("Position");
		lblNewLabel_well_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_well_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel1_1.add(lblNewLabel_well_1);
		
		
		
		
		panel1_1.add(comboBox_1);
		
		JButton btnNewButton_add_well_1 = new JButton("Add");
		btnNewButton_add_well_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("position " + (comboBox_1.getSelectedItem().toString() + "\n"));
				double coordinate_x = (tx.get(Integer.parseInt(comboBox_1.getSelectedItem().toString())));
				double coordinate_y = (ty.get(Integer.parseInt(comboBox_1.getSelectedItem().toString())));
				double coordinate_z = (tz.get(Integer.parseInt(comboBox_1.getSelectedItem().toString())));
				Mouvement position = new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino);
				data.add(position);
			}
		});
		btnNewButton_add_well_1.setBackground(Color.CYAN);
		panel1_1.add(btnNewButton_add_well_1);

		
		
		// Picture
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Picture = new JPanel();
		panel_Picture.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Picture);
		panel_Picture.setLayout(new GridLayout(2, 1, 5, 5));
		JLabel lblNewLabel_picture = new JLabel("Picture");

		lblNewLabel_picture.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Picture.add(lblNewLabel_picture);

		JPanel panel_picture2 = new JPanel();
		panel_Picture.add(panel_picture2);
		panel_picture2.setLayout(new GridLayout(1, 3, 15, 0));

		JLabel lblNewLabel_vide3 = new JLabel("");
		panel_picture2.add(lblNewLabel_vide3);

		JLabel lblNewLabel_vide4 = new JLabel("");
		panel_picture2.add(lblNewLabel_vide4);

		JButton btnNewButton_addPicture = new JButton("Add");
		btnNewButton_addPicture.setBackground(Color.CYAN);
		panel_picture2.add(btnNewButton_addPicture);
		btnNewButton_addPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Picture" + "\n");
				Picture picture = new Picture(camera);
				data.add(picture);
			}
		});

		// Video
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Video = new JPanel();
		panel_Video.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Video);
		panel_Video.setLayout(new GridLayout(2, 1, 5, 5));

		JLabel lblNewLabel_Video = new JLabel("Video");
		lblNewLabel_Video.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Video.add(lblNewLabel_Video);

		JPanel panel_video2 = new JPanel();
		panel_Video.add(panel_video2);
		panel_video2.setLayout(new GridLayout(1, 3, 10, 0));

		JLabel lblNewLabel_Time_Video = new JLabel("Time (sec.)");
		lblNewLabel_Time_Video.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Time_Video.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_video2.add(lblNewLabel_Time_Video);

		textField_Time_Video = new JTextField();
		textField_Time_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Time_Video.setColumns(10);
		panel_video2.add(textField_Time_Video);

		JButton btnNewButton_add_Video = new JButton("Add");
		btnNewButton_add_Video.setBackground(Color.CYAN);
		panel_video2.add(btnNewButton_add_Video);
		btnNewButton_add_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Time_Video.getText().isEmpty() == false) {
					listData.addElement("Video " + textField_Time_Video.getText() + " sec. record time" + "\n");
					Video video = new Video((Integer.parseInt(textField_Time_Video.getText().toString()) * 1000),
							camera);
					data.add(video);
				} else {
					btnNewButton_add_Video.setEnabled(true);
				}
			}
		});

		// Syringe injection
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Syringe_injected = new JPanel();
		panel_Syringe_injected.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Syringe_injected);
		panel_Syringe_injected.setLayout(new GridLayout(2, 1, 5, 5));

		JLabel lblNewLabel_Syringue_i = new JLabel("Syringe injection");
		lblNewLabel_Syringue_i.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Syringe_injected.add(lblNewLabel_Syringue_i);

		JPanel panel_Syringe2 = new JPanel();
		panel_Syringe_injected.add(panel_Syringe2);
		panel_Syringe2.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lblNewLabel_volume_i = new JLabel("Volum (ml.)");
		lblNewLabel_volume_i.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_volume_i.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_Syringe2.add(lblNewLabel_volume_i);

		textField_Syringue_i = new JTextField();
		textField_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_i.setColumns(10);
		panel_Syringe2.add(textField_Syringue_i);

		JButton btnNewButton_Syringue_i = new JButton("Add");
		btnNewButton_Syringue_i.setBackground(Color.CYAN);
		panel_Syringe2.add(btnNewButton_Syringue_i);
		btnNewButton_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_i.getText().isEmpty() == false) {
					listData.addElement("Syringe : " + textField_Syringue_i.getText() + " ml injected " + "\n");
					Syringe injection = new Syringe((Integer.parseInt(textField_Syringue_i.getText().toString())),
							arduino);
					data.add(injection);
				} else {
					btnNewButton_Syringue_i.setEnabled(true);
				}
			}
		});

		// Syringe aspiration
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Syringe_aspirated = new JPanel();
		panel_Syringe_aspirated.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Syringe_aspirated);
		panel_Syringe_aspirated.setLayout(new GridLayout(2, 1, 5, 5));

		JLabel lblNewLabel_Syringue_a = new JLabel("Syringe aspiration");
		lblNewLabel_Syringue_a.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Syringe_aspirated.add(lblNewLabel_Syringue_a);

		JPanel panel_Syringe3 = new JPanel();
		panel_Syringe_aspirated.add(panel_Syringe3);
		panel_Syringe3.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lblNewLabel_volume_a = new JLabel("Volum (ml.)");
		lblNewLabel_volume_a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_volume_a.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_Syringe3.add(lblNewLabel_volume_a);

		textField_Syringue_a = new JTextField();
		textField_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_a.setColumns(10);
		panel_Syringe3.add(textField_Syringue_a);

		JButton btnNewButton_Syringue_a = new JButton("Add");
		btnNewButton_Syringue_a.setBackground(Color.CYAN);
		panel_Syringe3.add(btnNewButton_Syringue_a);
		btnNewButton_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_a.getText().isEmpty() == false) {
					listData.addElement("Syringe : " + textField_Syringue_a.getText() + " ml aspirated" + "\n");
					Syringe aspiration = new Syringe((Integer.parseInt(textField_Syringue_a.getText().toString())),
							arduino);
					data.add(aspiration);
				} else {
					btnNewButton_Syringue_a.setEnabled(true);
				}
			}
		});

		// Home
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Home = new JPanel();
		panel_Home.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Home);
		panel_Home.setLayout(new GridLayout(2, 1, 5, 5));

		JLabel lblNewLabel_Home = new JLabel("Home");
		lblNewLabel_Home.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Home.add(lblNewLabel_Home);

		JPanel panel_home2 = new JPanel();
		panel_Home.add(panel_home2);
		panel_home2.setLayout(new GridLayout(0, 3, 10, 15));

		JButton btnNewButton_add_Home = new JButton("Add");
		btnNewButton_add_Home.setBackground(Color.CYAN);
		btnNewButton_add_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Home" + "\n");
				Initialization home = new Initialization(arduino);
				data.add(home);
			}
		});

		JLabel lblNewLabel_vide5 = new JLabel("");
		panel_home2.add(lblNewLabel_vide5);

		JLabel lblNewLabel_vide6 = new JLabel("");
		panel_home2.add(lblNewLabel_vide6);
		panel_home2.add(btnNewButton_add_Home);
		
		JPanel panel_Break = new JPanel();
		panel_Break.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Break);
		panel_Break.setLayout(new GridLayout(2, 1, 5, 5));
		
		JLabel lblNewLabel_Break = new JLabel("Break");
		lblNewLabel_Break.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Break.add(lblNewLabel_Break);
		
		JPanel panel_break2 = new JPanel();
		panel_Break.add(panel_break2);
		panel_break2.setLayout(new GridLayout(1, 3, 10, 0));
		
		JLabel lblNewLabel_Time_break = new JLabel("Time (sec.)");
		lblNewLabel_Time_break.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Time_break.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_break2.add(lblNewLabel_Time_break);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_break2.add(textField);
		
		JButton btnNewButton_Add_Break = new JButton("Add");
		btnNewButton_Add_Break.setBackground(Color.CYAN);
		panel_break2.add(btnNewButton_Add_Break);

		JPanel panel_south = new JPanel();
		panel_parameter2.add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new BorderLayout(15, 0));

		JPanel panel_repetition = new JPanel();
		panel_repetition.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_south.add(panel_repetition, BorderLayout.CENTER);
		panel_repetition.setLayout(new GridLayout(0, 3, 10, 0));

		JLabel lblNewLabel_rep_1 = new JLabel("Repetition");
		panel_repetition.add(lblNewLabel_rep_1);
		lblNewLabel_rep_1.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_vide = new JLabel("");
		panel_repetition.add(lblNewLabel_vide);

		JLabel lblNewLabel_vide2 = new JLabel("");
		panel_repetition.add(lblNewLabel_vide2);

		JPanel panel_timeBetween = new JPanel();
		panel_repetition.add(panel_timeBetween);
		panel_timeBetween.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_Time_Rep_1 = new JLabel("Time between 2 rep (min)");
		lblNewLabel_Time_Rep_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Time_Rep_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_timeBetween.add(lblNewLabel_Time_Rep_1, BorderLayout.NORTH);

		textField_rep = new JTextField();
		textField_rep.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_rep.setColumns(10);
		panel_timeBetween.add(textField_rep, BorderLayout.SOUTH);

		JPanel panel_number_rep = new JPanel();
		panel_repetition.add(panel_number_rep);
		panel_number_rep.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_nub_rep_1 = new JLabel("Number of repetition");
		lblNewLabel_nub_rep_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nub_rep_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_number_rep.add(lblNewLabel_nub_rep_1, BorderLayout.NORTH);

		String[] rep = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JComboBox comboBox_rep = new JComboBox(rep);
		panel_number_rep.add(comboBox_rep, BorderLayout.SOUTH);

		JPanel panel_validate = new JPanel();
		panel_repetition.add(panel_validate);
		panel_validate.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton_validate = new JButton("Validate");
		btnNewButton_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_rep.getText().isEmpty()) {
					lblNewLabel_timeTotal
							.setText("Total time : "
									+ (Long.parseLong(textField_rep.getText().toString())
											* Integer.parseInt(comboBox_rep.getSelectedItem().toString()))
									+ " minutes");
				} else {
					lblNewLabel_timeTotal.setText("Total time : "
							+ (1 * Integer.parseInt(comboBox_rep.getSelectedItem().toString())) + " minutes");
				}
			}
		});
		btnNewButton_validate.setBackground(new Color(135, 206, 250));
		panel_validate.add(btnNewButton_validate);

		JPanel panel_Start_Stop = new JPanel();
		panel_south.add(panel_Start_Stop, BorderLayout.EAST);
		panel_Start_Stop.setLayout(new GridLayout(2, 2, 10, 10));

		// Button start
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		JButton btnNewButton_Start1 = new JButton("                Start                ");
		btnNewButton_Start1.setBackground(Color.GREEN);
		panel_Start_Stop.add(btnNewButton_Start1);

		btnNewButton_Start1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_rep.getText().isEmpty()) {
					textField_rep.setText("1");
				}

				Thread t1 = new Thread(protocol);

				protocol.set_number_repetition(Integer.parseInt(comboBox_rep.getSelectedItem().toString()));
				protocol.set_time(Long.parseLong(textField_rep.getText().toString()));
				protocol.set_data(data);

				t1.start();

			}
		});

		// Stop
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JButton btnNewButton_Stop1 = new JButton("Stop");
		btnNewButton_Stop1.setForeground(Color.BLACK);
		btnNewButton_Stop1.setBackground(Color.PINK);
		panel_Start_Stop.add(btnNewButton_Stop1);

		btnNewButton_Stop1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				protocol.stop();
			}
		});
	}
}
