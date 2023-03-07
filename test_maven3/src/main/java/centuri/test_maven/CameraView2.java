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



import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class CameraView2 extends JFrame {

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
					CameraView2 frame = new CameraView2();
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
	public CameraView2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
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
		
		JButton btnNewButton = new JButton("Reset");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$G\n");
				data_controller.add("$H\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_24 = new JPanel();
		panel.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Set zero here //
		
		JButton btn_Origine = new JButton("Set zero here");
		panel_24.add(btn_Origine);
		btn_Origine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G10 P0 L20 X0 Y0 Z0\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
			}
		});
		btn_Origine.setBackground(Color.YELLOW);
		btn_Origine.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JPanel panel_23 = new JPanel();
		panel.add(panel_23);
		panel_23.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_25 = new JPanel();
		panel.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Step = new JLabel("Step (mm)");
		panel_25.add(lbl_Step);
		String [] message_Step = {"5", "10", "20", "30", "40", "50", "60", "70", "80","90","100","110","120"};
		JComboBox comboBox_Step = new JComboBox(message_Step);
		panel_25.add(comboBox_Step);
		
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
				data_controller.add("G91\n");
				data_controller.add("G0z" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
			}
		});
		btn_plus_Z.setBackground(Color.CYAN);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button +Y //
		
		JButton btn_plus_Y = new JButton("+ Y");
		panel_5.add(btn_plus_Y);
		btn_plus_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0y" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
			}
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
				data_controller.add("G91\n");
				data_controller.add("G0x-" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
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
				data_controller.add("H\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
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
				data_controller.add("G91\n");
				data_controller.add("G0x" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
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
				if (Integer.parseInt((comboBox_Step.getSelectedItem().toString())) < 50) {
				data_controller.add("G91\n");
				data_controller.add("G0z-" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
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
				data_controller.add("G91\n");
				data_controller.add("G0y-" + comboBox_Step.getSelectedItem().toString() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data_controller.clear();
			}
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
		panel_19.setLayout(new GridLayout(3, 3, 30, 0));
		
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
				data_controller.add("G90\n");
				data_controller.add("G0x" + textField_coordinate_x.getText() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				data_controller.clear();
			}
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
				data_controller.add("G90\n");
				data_controller.add("G0y" + textField_coordinate_y.getText() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				data_controller.clear();
			}
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
				data_controller.add("G90\n");
				data_controller.add("G0z" + textField_coordinate_z.getText() + "\n");
				//arduino.Save_Coordinate();
				//arduino.afficher_data_controller();
				try {
					try {
						arduino.arduino();
					} catch (SerialException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				data_controller.clear();
			}
		});
		panel_38.add(btnNewButton_3);
		
		JPanel panel_39 = new JPanel();
		panel_19.add(panel_39);
		
		JPanel panel_40 = new JPanel();
		panel_19.add(panel_40);
		
		JPanel panel_41 = new JPanel();
		panel_19.add(panel_41);
		
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
		panel_12.setLayout(new GridLayout(3, 2, 50, 0));
		
		JPanel panel_42 = new JPanel();
		panel_12.add(panel_42);
		
		JPanel panel_44 = new JPanel();
		panel_12.add(panel_44);
		
		
		// Button Stop //
		
		JButton btnNewButton_Stop = new JButton("Stop preview");
		panel_12.add(btnNewButton_Stop);
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
		panel_12.add(btnNewButton_Start);
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
		
		
		// Button Quality //
		
		JLabel lblNewLabel_Quality = new JLabel("Quality (%)");
		panel_Quality.add(lblNewLabel_Quality);
		
		String [] message_Quality = {"50", "75", "100"};
		JComboBox comboBox_Quality = new JComboBox(message_Quality);
		comboBox_Quality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Quality.getSelectedItem().toString());
			}
		});
		panel_Quality.add(comboBox_Quality);
		
		
		
		JPanel panel_Width = new JPanel();
		panel_33.add(panel_Width);
		panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Width //
		
		JLabel lblWidth = new JLabel("Width (mm)");
		panel_Width.add(lblWidth);
		
		String [] message_Width = {"500", "1000", "5000", "10000"};
		JComboBox comboBox_Width = new JComboBox(message_Width);
		comboBox_Width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Width.getSelectedItem().toString());
			}
		});
		panel_Width.add(comboBox_Width);
		
		JPanel panel_Heigth = new JPanel();
		panel_33.add(panel_Heigth);
		panel_Heigth.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Heigth //
		
		JLabel lblHeigth = new JLabel("Heigth (mm)");
		panel_Heigth.add(lblHeigth);
		String [] message_Heigth = {"500", "1000", "5000", "10000"};
		JComboBox comboBox_Heigth = new JComboBox(message_Heigth);
		comboBox_Heigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Heigth.getSelectedItem().toString());
			}
		});
		panel_Heigth.add(comboBox_Heigth);
		
		
		JPanel panel_46 = new JPanel();
		panel_33.add(panel_46);
		panel_46.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Save in");
		panel_46.add(lblNewLabel_4);
		
	      
		JButton btnNewButton_4 = new JButton("Choose a file");
		final JLabel label = new JLabel();
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showOpenDialog(panel_46);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               label.setText("File Selected: " + file.getName());
	            }else{
	               label.setText("Open command canceled");
	            }
			}
		});
		panel_46.add(btnNewButton_4);
		panel_46.add(label);
		
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
		
		
		JPanel panel_Encoding = new JPanel();
		panel_34.add(panel_Encoding);
		panel_Encoding.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Encording//
		
		JLabel lblEncoding = new JLabel("Encoding");
		panel_Encoding.add(lblEncoding);
		String [] message_encoding = {"JPG","PNG","RGB","BMP","YUV420"};
		JComboBox comboBox_Encoding= new JComboBox(message_encoding);
		comboBox_Encoding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Encoding.getSelectedItem().toString());
			}
		});
		panel_Encoding.add(comboBox_Encoding);
		
		JPanel panel_50 = new JPanel();
		panel_34.add(panel_50);
		
		JPanel panel_37 = new JPanel();
		panel_34.add(panel_37);
		
		JPanel panel_Taking_picture = new JPanel();
		panel_34.add(panel_Taking_picture);
		panel_Taking_picture.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button Taking a picture //
		
		JButton btnPicture = new JButton("Taking a picture");
		btnPicture.setBackground(Color.GREEN);
		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				class Picture implements Runnable {
					@Override
					public void run() {
						
						Camera camera = new Camera();
						
						var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
								.delay(Integer.parseInt(comboBox_Time.getSelectedItem().toString()))
								.disablePreview(true)
								.encoding(Camera.PicEncoding.valueOf(comboBox_Encoding.getSelectedItem().toString()))
								.useDate(true)
								.quality(Integer.parseInt(comboBox_Quality.getSelectedItem().toString()))
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
		
		panel_Taking_picture.add(btnPicture);
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new GridLayout(0, 1, 50, 0));
		
		JPanel panel_Console = new JPanel();
		panel_South.add(panel_Console);
		panel_Console.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_Console.add(textArea);
			
		
	}
}
