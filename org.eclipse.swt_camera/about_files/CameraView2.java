package about_files;

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
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;



import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class CameraView2 extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 650, 500);
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
		panel_Moving.setLayout(new GridLayout(7, 4, 15, 15));
		
		JPanel panel = new JPanel();
		panel_Moving.add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("GC:G0 G54 G17 G21 G90 G94 M2 M9 T0 F0 S0\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_Moving.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_Moving.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_Moving.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Set zero here //
		
		JButton btn_Origine = new JButton("Set zero here");
		btn_Origine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G10 P0 L20 X0 Y0 Z0\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_3.add(btn_Origine);
		
		JPanel panel_24 = new JPanel();
		panel_Moving.add(panel_24);
		
		JPanel panel_23 = new JPanel();
		panel_Moving.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Step = new JLabel("<html>Step (mm)<br>(coordinate relative)</html>");
		panel_23.add(lbl_Step);
		
		
		String [] message_Step = {"5", "10", "20", "30", "40", "50", "60", "70", "80","90","100","110","120"};
		JComboBox comboBox_Step = new JComboBox(message_Step);
		panel_23.add(comboBox_Step);
		
		JPanel panel_25 = new JPanel();
		panel_Moving.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_Moving.add(panel_17);
		
		JPanel panel_4 = new JPanel();
		panel_Moving.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button Z+ //
		
		JButton btn_plus_Z = new JButton("+ Z");
		btn_plus_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0z" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_4.add(btn_plus_Z);
		
		JPanel panel_12 = new JPanel();
		panel_Moving.add(panel_12);
		
		JPanel panel_15 = new JPanel();
		panel_Moving.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button +Y //
		
		JButton btn_plus_Y = new JButton("+ Y");
		btn_plus_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0y" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_15.add(btn_plus_Y);
		
		JPanel panel_14 = new JPanel();
		panel_Moving.add(panel_14);
		
		JPanel panel_13 = new JPanel();
		panel_Moving.add(panel_13);
		
		JPanel panel_5 = new JPanel();
		panel_Moving.add(panel_5);
		
		
		// Button -X //
		
		JButton btn_moins_X = new JButton("- X");
		btn_moins_X.setBackground(Color.CYAN);
		btn_moins_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0x-" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		panel_5.add(btn_moins_X);
		
		JPanel panel_8 = new JPanel();
		panel_Moving.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button Home //
		
		JButton btn_Home = new JButton("Home");
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_8.add(btn_Home);
		
		JPanel panel_7 = new JPanel();
		panel_Moving.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button +X //
		
		JButton btn_plus_x = new JButton("+ X");
		btn_plus_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0x" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_7.add(btn_plus_x);
		
		JPanel panel_9 = new JPanel();
		panel_Moving.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		// Button -Z //
		
		JButton btn_moins_Z = new JButton("- Z");
		btn_moins_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0z-" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		btn_moins_Z.setBackground(Color.CYAN);
		panel_9.add(btn_moins_Z);
		
		JPanel panel_6 = new JPanel();
		panel_Moving.add(panel_6);
		
		JPanel panel_11 = new JPanel();
		panel_Moving.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button -Y //
		
		JButton btn_moins_Y = new JButton("- Y");
		btn_moins_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G91\n");
				data_controller.add("G0y-" + comboBox_Step.getSelectedItem().toString() + "\n");
				arduino.Save_Coordinate();
				arduino.afficher_data_controller();
				try {
					arduino.Arduino();
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
		panel_11.add(btn_moins_Y);
		
		JPanel panel_19 = new JPanel();
		panel_Moving.add(panel_19);
		
		JPanel panel_26 = new JPanel();
		panel_Moving.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_Moving.add(panel_27);
		
		JPanel panel_29 = new JPanel();
		panel_Moving.add(panel_29);
		
		JPanel panel_28 = new JPanel();
		panel_Moving.add(panel_28);
		
		JPanel panel_22 = new JPanel();
		panel_Moving.add(panel_22);
		
		JPanel panel_21 = new JPanel();
		panel_Moving.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Start //
		
		JButton btnNewButton_Start = new JButton("Start preview");
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
		panel_21.add(btnNewButton_Start);
		
		JPanel panel_31 = new JPanel();
		panel_Moving.add(panel_31);
		
		JPanel panel_20 = new JPanel();
		panel_Moving.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Stop //
		
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
		btnNewButton_Stop.setForeground(new Color(255, 255, 255));
		btnNewButton_Stop.setBackground(Color.RED);
		panel_20.add(btnNewButton_Stop);
		btnNewButton_Stop.setFont(new Font("Dialog", Font.BOLD, 12));
		
		
		// Panel Picture //
		
		JPanel panel_Picture = new JPanel();
		tabbedPane.addTab("Picture", null, panel_Picture, null);
		panel_Picture.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_32 = new JPanel();
		panel_Picture.add(panel_32);
		panel_32.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_33 = new JPanel();
		panel_32.add(panel_33);
		panel_33.setLayout(new GridLayout(5, 1, 50, 15));
		
		JPanel panel_Quality = new JPanel();
		panel_33.add(panel_Quality);
		panel_Quality.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Quality //
		
		JLabel lblNewLabel_Quality = new JLabel("Quality");
		panel_Quality.add(lblNewLabel_Quality);
		
		String [] message_Quality = {"100", "75", "50"};
		JComboBox comboBox_Quality = new JComboBox(message_Quality);
		comboBox_Quality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Quality.getSelectedItem().toString());
			}
		});
		panel_Quality.add(comboBox_Quality);
		
		JPanel panel_Time = new JPanel();
		panel_33.add(panel_Time);
		panel_Time.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Time //
		
		JLabel lblTime = new JLabel("Time");
		panel_Time.add(lblTime);
		
		String [] message_Time = {"5000", "10000", "15000", "20000", "25000", "30000"};
		JComboBox comboBox_Time = new JComboBox(message_Time);
		comboBox_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Time.getSelectedItem().toString());
			}
		});
		panel_Time.add(comboBox_Time);
		
		JPanel panel_Width = new JPanel();
		panel_33.add(panel_Width);
		panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		// Button Width //
		
		JLabel lblWidth = new JLabel("Width");
		panel_Width.add(lblWidth);
		
		String [] message_Width = {"500", "1000", "5000", "10000", "20000", "30000"};
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
		
		JLabel lblHeigth = new JLabel("Heigth");
		panel_Heigth.add(lblHeigth);
		
		String [] message_Heigth = {"500", "1000", "5000", "10000", "20000", "30000"};
		JComboBox comboBox_Heigth = new JComboBox(message_Heigth);
		comboBox_Heigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox_Heigth.getSelectedItem().toString());
			}
		});
		panel_Heigth.add(comboBox_Heigth);
		
		JPanel panel_Encoding = new JPanel();
		panel_33.add(panel_Encoding);
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
		
		JPanel panel_34 = new JPanel();
		panel_32.add(panel_34);
		panel_34.setLayout(new GridLayout(3, 3, 20, 15));
		
		JPanel panel_43 = new JPanel();
		panel_34.add(panel_43);
		
		JPanel panel_Taking_picture = new JPanel();
		panel_34.add(panel_Taking_picture);
		panel_Taking_picture.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		// Button Taking a picture //
		
		JButton btnPicture = new JButton("Taking a picture");
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
		
		JPanel panel_37 = new JPanel();
		panel_34.add(panel_37);
		
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
