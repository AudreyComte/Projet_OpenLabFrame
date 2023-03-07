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
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
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

public class CameraView3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_coordinate_x;
	private JTextField textField_coordinate_y;
	private JTextField textField_coordinate_z;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CameraView3 frame = new CameraView3();
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
	 
	public CameraView3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 650, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		panel_North.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_North.add(panel_16);
		
		
		// Titer Camera //
		
		JLabel lblCamera = new JLabel("Camera");
		lblCamera.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCamera.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(lblCamera);
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(1, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_Center.add(tabbedPane);
		
		
		//Panel Moving//
		
		ArrayList data_controller= new ArrayList();
		Arduino arduino = new Arduino(data_controller);
		
		JPanel panel_Moving = new JPanel();
		tabbedPane.addTab("Moving", null, panel_Moving, null);
		panel_Moving.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_Moving.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_48 = new JPanel();
		panel_10.add(panel_48);
		
		JLabel lblNewLabel = new JLabel("Relative coordinate");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_10.add(lblNewLabel);
		
		JPanel panel_22 = new JPanel();
		panel_10.add(panel_22);
		panel_22.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_Moving.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 4, 15, 15));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSlider slider = new JSlider();
		panel_2.add(slider);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setFont(new Font("Dialog", Font.BOLD, 10));
		slider.setMajorTickSpacing(2);
		slider.setMaximum(12);
		slider.setPaintLabels(true);
		slider.setValue(0);
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_24 = new JPanel();
		panel.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 1, 0, 0));
		
		Counter counter_x =new Counter(0);
		Counter counter_y =new Counter(0);
		Counter counter_z =new Counter(0);
		
		JTextArea textArea_x = new JTextArea();
		JTextArea textArea_y = new JTextArea();
		JTextArea textArea_z = new JTextArea();
		
		textArea_x.setText((counter_x.get_Counter())+"");
		textArea_y.setText((counter_y.get_Counter())+"");
		textArea_z.setText((counter_z.get_Counter())+"");
		
		// Button Set zero here //
		
		JButton btn_Origine = new JButton("Set zero here");
		panel_24.add(btn_Origine);
		btn_Origine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G10 P0 L20 X0 Y0 Z0\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				counter_x.set_Counter(0);
				counter_y.set_Counter(0);
				counter_z.set_Counter(0);
				textArea_x.setText((counter_x.get_Counter())+"");
				textArea_y.setText((counter_y.get_Counter())+"");
				textArea_z.setText((counter_z.get_Counter())+"");
			}
		});
		btn_Origine.setBackground(Color.YELLOW);
		btn_Origine.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JPanel panel_23 = new JPanel();
		panel.add(panel_23);
		panel_23.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Step (cm) : "+ slider.getValue());
		panel_25.add(lblNewLabel_4);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblNewLabel_4 .setText("Step (cm) : "+ slider.getValue()); 
			}
		});
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);

		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		panel_17.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Z+ //
		
		JButton btn_plus_Z = new JButton("+ Z");
		panel_14.add(btn_plus_Z);
		btn_plus_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_z.get_Counter()+"");
				if ((slider.getValue()*10) < 50) {
					counter_z.add_Counter(slider.getValue()*10);
					if (counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0) {
						data_controller.add("G91\n");
						data_controller.add("G0z" + (slider.getValue()*10) + "\n");
						arduino.Save_Coordinate();
						arduino.afficher_data_controller();
						/*try {
							arduino.arduino();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						data_controller.clear();
						textArea_z.setText((counter_z.get_Counter())+"");
					}	
					else {
						counter_z.less_Counter(slider.getValue()*10);
						
			}}}
				
		});
		btn_plus_Z.setBackground(Color.CYAN);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button +Y //
		
		JButton btn_plus_Y = new JButton("+ Y");
		panel_5.add(btn_plus_Y);
		btn_plus_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_y.get_Counter()+"");
				if (slider.getValue()*10 < 90) {
					counter_y.add_Counter(slider.getValue()*10);
					if (counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0) {
				data_controller.add("G91\n");
				data_controller.add("G0y" + (slider.getValue()*10) + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				textArea_y.setText((counter_y.get_Counter())+"");
				}
					else {
						counter_y.less_Counter(slider.getValue()*10);
					}
			}}
		});
		btn_plus_Y.setBackground(Color.CYAN);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button -X //
		
		JButton btn_moins_X = new JButton("- X");
		panel_9.add(btn_moins_X);
		btn_moins_X.setBackground(Color.CYAN);
		btn_moins_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_x.get_Counter()+"");
				counter_x.less_Counter(slider.getValue()*10);
				if (counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0) {
				data_controller.add("G91\n");
				data_controller.add("G0x-" + (slider.getValue()*10) + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				
				textArea_x.setText((counter_x.get_Counter())+"");
				}
				else {
					counter_x.add_Counter(slider.getValue()*10);
				}
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button Home //
		
		JButton btn_Home = new JButton("Home");
		panel_6.add(btn_Home);
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				counter_x.set_Counter(0);
				counter_y.set_Counter(0);
				counter_z.set_Counter(0);
				textArea_x.setText((counter_x.get_Counter())+"");
				textArea_y.setText((counter_y.get_Counter())+"");
				textArea_z.setText((counter_z.get_Counter())+"");
			}
		});
		btn_Home.setForeground(new Color(255, 255, 255));
		btn_Home.setBackground(Color.BLUE);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button +X //
		
		JButton btn_plus_x = new JButton("+ X");
		panel_11.add(btn_plus_x);
		btn_plus_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_x.get_Counter()+"");
				counter_x.add_Counter(slider.getValue()*10);
				if (counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0) {
				data_controller.add("G91\n");
				data_controller.add("G0x" + (slider.getValue()*10) + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				
				textArea_x.setText((counter_x.get_Counter())+"");
				}
				else {
					counter_x.less_Counter(slider.getValue()*10);
				}
			}
		});
		btn_plus_x.setBackground(Color.CYAN);
		
		JPanel panel_26 = new JPanel();
		panel.add(panel_26);
		panel_26.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button -Z //
		
		JButton btn_moins_Z = new JButton("- Z");
		panel_26.add(btn_moins_Z);
		btn_moins_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_z.get_Counter()+"");
				if ((slider.getValue()*10) < 50) {
					counter_z.less_Counter(slider.getValue()*10);
					if (counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0) {
				data_controller.add("G91\n");
				data_controller.add("G0z-" + (slider.getValue()*10) + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				
				textArea_z.setText((counter_z.get_Counter())+"");
				}
					else counter_z.add_Counter(slider.getValue()*10);
			}}
		});
		btn_moins_Z.setBackground(Color.CYAN);
		
		JPanel panel_21 = new JPanel();
		panel.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_31 = new JPanel();
		panel.add(panel_31);
		panel_31.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button -Y //
		
		JButton btn_moins_Y = new JButton("- Y");
		panel_31.add(btn_moins_Y);
		btn_moins_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_y.get_Counter()+"");
				if ((slider.getValue()*10) < 90) {
					counter_y.less_Counter(slider.getValue()*10);
					if (counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0) {
				data_controller.add("G91\n");
				data_controller.add("G0y-" + (slider.getValue()*10) + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				data_controller.clear();
				
				textArea_y.setText((counter_y.get_Counter())+"");
				}
					else {
						counter_y.add_Counter(slider.getValue()*10);
					}
			}}
		});
		btn_moins_Y.setBackground(Color.CYAN);
		
		JPanel panel_20 = new JPanel();
		panel.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_Moving.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_4.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(4, 3, 30, 0));
		
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
				if (Integer.parseInt((textField_coordinate_x.getText())) < 130 && Integer.parseInt((textField_coordinate_x.getText())) >= 0) {
				data_controller.add("G90\n");
				data_controller.add("G0x" + textField_coordinate_x.getText() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				data_controller.clear();
				counter_x.set_Counter(Integer.parseInt((textField_coordinate_x.getText())));
				textArea_x.setText((counter_x.get_Counter())+"");
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
				if (Integer.parseInt((textField_coordinate_y.getText())) < 90 && Integer.parseInt((textField_coordinate_y.getText())) >= 0) {
				data_controller.add("G90\n");
				data_controller.add("G0y" + textField_coordinate_y.getText() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				data_controller.clear();
				counter_y.set_Counter(Integer.parseInt((textField_coordinate_y.getText())));
				textArea_y.setText((counter_y.get_Counter())+"");
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
				if (Integer.parseInt((textField_coordinate_z.getText())) > -50 && Integer.parseInt((textField_coordinate_z.getText())) <= 0) {
				data_controller.add("G90\n");
				data_controller.add("G0z" + textField_coordinate_z.getText() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				/*try {
					arduino.arduino();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				data_controller.clear();
				counter_z.set_Counter(Integer.parseInt((textField_coordinate_z.getText())));
				textArea_z.setText((counter_z.get_Counter())+"");
			}}
		});
		panel_38.add(btnNewButton_3);
		
		JPanel panel_39 = new JPanel();
		panel_19.add(panel_39);
		
		JPanel panel_40 = new JPanel();
		panel_19.add(panel_40);
		
		JPanel panel_41 = new JPanel();
		panel_19.add(panel_41);
		
		JPanel panel_67 = new JPanel();
		panel_19.add(panel_67);
		
		JPanel panel_68 = new JPanel();
		panel_19.add(panel_68);
		
		JPanel panel_69 = new JPanel();
		panel_19.add(panel_69);
		
		JPanel panel_18 = new JPanel();
		panel_4.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_49 = new JPanel();
		panel_18.add(panel_49);
		
		JPanel panel_47 = new JPanel();
		panel_18.add(panel_47);
		
		JPanel panel_27 = new JPanel();
		panel_18.add(panel_27);
		panel_27.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Absolute coordinate");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.BLUE);
		panel_18.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_44 = new JPanel();
		panel_44.setBorder(new LineBorder(Color.GRAY));
		panel_12.add(panel_44);
		panel_44.setLayout(new GridLayout(4, 3, 50, 0));
		
		JPanel panel_55 = new JPanel();
		panel_44.add(panel_55);
		panel_55.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Coordinate X Y Z");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_55.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel panel_56 = new JPanel();
		panel_44.add(panel_56);
		panel_56.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_57 = new JPanel();
		panel_44.add(panel_57);
		
		JPanel panel_58 = new JPanel();
		panel_44.add(panel_58);
		panel_58.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("X");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_58.add(lblNewLabel_5);
		
		JPanel panel_59 = new JPanel();
		panel_44.add(panel_59);
		panel_59.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5_1 = new JLabel("Y");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_59.add(lblNewLabel_5_1);
		
		JPanel panel_60 = new JPanel();
		panel_44.add(panel_60);
		panel_60.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5_2 = new JLabel("Z");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_60.add(lblNewLabel_5_2);
		
		JPanel panel_62 = new JPanel();
		panel_44.add(panel_62);
		panel_62.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_62.add(textArea_x);
		
		JPanel panel_61 = new JPanel();
		panel_44.add(panel_61);
		panel_61.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_61.add(textArea_y);
		
		JPanel panel_63 = new JPanel();
		panel_44.add(panel_63);
		panel_63.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_63.add(textArea_z);
		
		JPanel panel_64 = new JPanel();
		panel_44.add(panel_64);
		
		JPanel panel_65 = new JPanel();
		panel_44.add(panel_65);
		
		JPanel panel_66 = new JPanel();
		panel_44.add(panel_66);
		
		JPanel panel_42 = new JPanel();
		panel_12.add(panel_42);
		panel_42.setLayout(new GridLayout(3, 2, 50, 0));
		
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
				ControllerCamera controller_cam = new ControllerCamera();
				Thread t = new Thread(controller_cam);
				t.start();
			}
		});
		btnNewButton_Start.setForeground(new Color(0, 0, 0));
		btnNewButton_Start.setBackground(Color.GREEN);
		btnNewButton_Start.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JPanel panel_53 = new JPanel();
		panel_42.add(panel_53);
		
		JPanel panel_54 = new JPanel();
		panel_42.add(panel_54);
		
		
		
		
		
		// Panel Picture //
		
		JPanel panel_Picture = new JPanel();
		tabbedPane.addTab("Picture", null, panel_Picture, null);
		panel_Picture.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_32 = new JPanel();
		panel_Picture.add(panel_32);
		panel_32.setLayout(new GridLayout(1, 2, 50, 0));
		
		JPanel panel_33 = new JPanel();
		panel_32.add(panel_33);
		panel_33.setLayout(new GridLayout(6, 1, 50, 15));
		
		JPanel panel_45 = new JPanel();
		panel_33.add(panel_45);
		panel_45.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Picture setting");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_45.add(lblNewLabel_3);
		
		JPanel panel_Quality = new JPanel();
		panel_33.add(panel_Quality);
		panel_Quality.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Width //
		
		JLabel lblWidth = new JLabel("Width (mm)");
		panel_Quality.add(lblWidth);
		String [] message_Width = {"500", "1000", "5000", "10000"};
		JComboBox comboBox_Width = new JComboBox(message_Width);
		panel_Quality.add(comboBox_Width);
		comboBox_Width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Width.getSelectedItem().toString());
			}
		});
		
	
		
		JPanel panel_Width = new JPanel();
		panel_33.add(panel_Width);
		panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Heigth //
		
		JLabel lblHeigth = new JLabel("Heigth (mm)");
		panel_Width.add(lblHeigth);
		String [] message_Heigth = {"500", "1000", "5000", "10000"};
		JComboBox comboBox_Heigth = new JComboBox(message_Heigth);
		panel_Width.add(comboBox_Heigth);
		comboBox_Heigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Heigth.getSelectedItem().toString());
			}
		});
		
		
		
		JPanel panel_Heigth = new JPanel();
		panel_33.add(panel_Heigth);
		panel_Heigth.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		JPanel panel_46 = new JPanel();
		panel_33.add(panel_46);
		panel_46.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_34 = new JPanel();
		panel_32.add(panel_34);
		panel_34.setLayout(new GridLayout(6, 1, 50, 15));
		
		JPanel panel_43 = new JPanel();
		panel_34.add(panel_43);
		
		JPanel panel_Time = new JPanel();
		panel_34.add(panel_Time);
		panel_Time.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Time //
		
		JLabel lblTime = new JLabel("Time (ms)");
		panel_Time.add(lblTime);
		String [] message_Time = {"5000", "10000", "15000", "20000", "25000", "30000"};
		JComboBox comboBox_Time = new JComboBox(message_Time);
		comboBox_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Time.getSelectedItem().toString());
			}
		});
		panel_Time.add(comboBox_Time);
		
		
		
		JPanel panel_50 = new JPanel();
		panel_34.add(panel_50);
		
		JPanel panel_37 = new JPanel();
		panel_34.add(panel_37);
		panel_37.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_Taking_picture = new JPanel();
		panel_34.add(panel_Taking_picture);
		panel_Taking_picture.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button Taking a picture //
		
		JButton btnPicture = new JButton("Taking a picture");
		panel_Taking_picture.add(btnPicture);
		btnPicture.setBackground(Color.GREEN);
		
		JPanel panel_70 = new JPanel();
		contentPane.add(panel_70, BorderLayout.SOUTH);
		panel_70.setLayout(new GridLayout(1, 1, 0, 0));
		
		SerialPort serial_port;

	    	
			SerialPort[] get_port = SerialPort.getCommPorts();
					
			for(SerialPort port : get_port) {
				System.out.println(port.getSystemPortName());
				serial_port = SerialPort.getCommPort(port.getSystemPortName());
						
				if(serial_port.openPort()) {
					System.out.println("Successfully open port!");
				}else {
					System.out.println("Failed to open port");
				}
			}
			
			
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
		
		serial_port.setBaudRate(115200);
		
		Thread thread = new Thread(){
			@Override public void run() {
				System.out.println("Arduino : ");
				Scanner scanner = new Scanner(serial_port.getInputStream());
				
				while(scanner.hasNextLine()) {
					try {
						String line = scanner.nextLine();
						JTextArea textArea = new JTextArea();
						textArea.setText(line);
						panel_70.add(textArea);
						
						System.out.println(line);								
					} catch(Exception e) {}
				}							
				scanner.close();
			}
		};
		Thread.sleep(1000);
		thread.start();
		Thread.sleep(1000);
		
		
		serial_port.closePort();
		System.out.println("Successfully close port!");
		
		
		
		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				class Picture implements Runnable {
					@Override
					public void run() {
						
						Camera camera = new Camera();
						
						var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
								.delay(Integer.parseInt(comboBox_Time.getSelectedItem().toString()))
								.disablePreview(true)
								.encoding(Camera.PicEncoding.valueOf("JPG"))
								.useDate(true)
								.quality(Integer.parseInt("100"))
								.width(Integer.parseInt(comboBox_Width.getSelectedItem().toString()))
								.height(Integer.parseInt(comboBox_Heigth.getSelectedItem().toString()))
								.build();
						
						camera.takeStill(config);
				 }
			}
				
				StopCamera Stop_cam = new StopCamera();
				Thread t1 = new Thread(Stop_cam);
				t1.start();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
				Picture picture = new Picture();
				Thread t3 = new Thread(picture);
				t3.start();
			}
		});
			
		
	}
}

