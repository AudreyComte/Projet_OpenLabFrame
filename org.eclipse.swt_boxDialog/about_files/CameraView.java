package about_files;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class CameraView extends JFrame {
	private JPanel contentPane;
	private JTextField textField_encoding;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CameraView frame = new CameraView();
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
	
	public CameraView() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/centuri/eclipse-workspace/Audrey/res/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
			
		
		
		// Panel West //
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(3, 2, 0, 10));
		
		
		/* Panel Quality */
		JPanel panel_Quality = new JPanel();
		panel_Center.add(panel_Quality);
		panel_Quality.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Quality = new JLabel("Quality");
		panel_Quality.add(lbl_Quality);
		
		String [] message_Quality = {"100", "75", "50"};
		JComboBox comboBox_Quality = new JComboBox(message_Quality);
		panel_Quality.add(comboBox_Quality);
		
		
		/* Panel Time */
		JPanel panel_Time = new JPanel();
		panel_Center.add(panel_Time);
		panel_Time.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Time = new JLabel("Time");
		panel_Time.add(lbl_Time);
		
		String [] message_Time = {"5000", "10000", "15000", "20000", "25000", "30000"};
		JComboBox comboBox_Time = new JComboBox(message_Time);
		panel_Time.add(comboBox_Time);
		
		
		/* Panel Width */
		
		JPanel panel_Width = new JPanel();
		panel_Center.add(panel_Width);
		panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Width = new JLabel("Width");
		panel_Width.add(lbl_Width);
		
		String [] message_Width = {"500", "1000", "5000", "10000", "20000", "30000"};
		JComboBox comboBox_Width = new JComboBox(message_Width);
		panel_Width.add(comboBox_Width);
		
		
		/* Panel Height */
		
		JPanel panel_Height = new JPanel();
		panel_Center.add(panel_Height);
		panel_Height.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Height = new JLabel("Height");
		panel_Height.add(lbl_Height);
		
		String [] message_Height = {"500", "1000", "5000", "10000", "20000", "30000"};
		JComboBox comboBox_Height = new JComboBox(message_Height);
		panel_Height.add(comboBox_Height);
		
		
		/* Panel Encoding */
		
		JPanel panel_Encoding = new JPanel();
		panel_Center.add(panel_Encoding);
		panel_Encoding.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Encoding = new JLabel("Encoding");
		panel_Encoding.add(lbl_Encoding);
		
		String [] message_encoding = {"JPG","PNG","RGB","BMP","YUV420"};
		JComboBox comboBox_encoding = new JComboBox(message_encoding);
		comboBox_encoding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel_Encoding.add(comboBox_encoding);
		panel_Encoding.add(textField_encoding);
		
		JPanel panel_1 = new JPanel();
		panel_Center.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 50, 10));
		
		JButton btn_Taking_a_picture = new JButton("Tacking a picture");
		panel_1.add(btn_Taking_a_picture);
		btn_Taking_a_picture.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_Taking_a_picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				class Picture implements Runnable {
					@Override
					public void run() {
						
						Camera camera = new Camera();
						
						var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
								.delay(Integer.parseInt(comboBox_Time.getSelectedItem().toString()))
								.disablePreview(true)
								.encoding(Camera.PicEncoding.valueOf(textField_encoding.getText()))
								.useDate(true)
								.quality(Integer.parseInt(comboBox_Quality.getSelectedItem().toString()))
								.width(Integer.parseInt(comboBox_Width.getSelectedItem().toString()))
								.height(Integer.parseInt(comboBox_Height.getSelectedItem().toString()))
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
		
		
		
		// Panel South //
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new GridLayout(1, 1, 25, 10));
		
		JPanel panel_4 = new JPanel();
		panel_South.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_coordinate = new JPanel();
		panel_4.add(panel_coordinate, BorderLayout.NORTH);
		panel_coordinate.setLayout(new GridLayout(4, 4, 25, 15));
		
		JPanel panel_11 = new JPanel();
		panel_coordinate.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_11.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel_coordinate.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Step");
		panel.add(lblNewLabel);
		
		JComboBox comboBox_Step = new JComboBox();
		panel.add(comboBox_Step);
		
		JPanel panel_12 = new JPanel();
		panel_coordinate.add(panel_12);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		panel_12.add(lblNewLabel_1_1);
		
		JPanel panel_coordinate_z_plus = new JPanel();
		panel_coordinate.add(panel_coordinate_z_plus);
		panel_coordinate_z_plus.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_Origine = new JButton("Origine");
		btn_coordinate_Origine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_coordinate_z_plus.add(btn_coordinate_Origine);
		
		JPanel panel_coordinate_y_plus = new JPanel();
		panel_coordinate.add(panel_coordinate_y_plus);
		panel_coordinate_y_plus.setLayout(new GridLayout(0, 1, 0, 0));
		
		ArrayList data_controller= new ArrayList();
		Arduino arduino = new Arduino(data_controller);
		
		JButton btn_coordinate_z = new JButton("z +");
		panel_coordinate_y_plus.add(btn_coordinate_z);
		btn_coordinate_z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					data_controller.add("$H\n");
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
		
		JPanel panel_6 = new JPanel();
		panel_coordinate.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		panel_6.add(lblNewLabel_1_1_1);
		
		JPanel panel_7 = new JPanel();
		panel_coordinate.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_y_plus = new JButton("y +");
		panel_7.add(btn_coordinate_y_plus);
		btn_coordinate_y_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
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
		
		JPanel panel_5 = new JPanel();
		panel_coordinate.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		panel_5.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_coordinate_x_plus = new JPanel();
		panel_coordinate.add(panel_coordinate_x_plus);
		panel_coordinate_x_plus.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		panel_coordinate_x_plus.add(lblNewLabel_1_1_1_1_1);
		
		JPanel panel_9 = new JPanel();
		panel_coordinate.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_x_moins = new JButton("x -");
		btn_coordinate_x_moins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
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
		panel_9.add(btn_coordinate_x_moins);
		
		JPanel panel_13 = new JPanel();
		panel_coordinate.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_Home = new JButton("Home");
		panel_13.add(btn_coordinate_Home);
		
		JPanel panel_8 = new JPanel();
		panel_coordinate.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_x_plus = new JButton("x +");
		panel_8.add(btn_coordinate_x_plus);
		btn_coordinate_x_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
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
		
		JPanel panel_10 = new JPanel();
		panel_coordinate.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_z_moins = new JButton("z -");
		btn_coordinate_z_moins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
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
		panel_10.add(btn_coordinate_z_moins);
		
		JPanel panel_14 = new JPanel();
		panel_coordinate.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("");
		panel_14.add(lblNewLabel_1_1_1_1_2);
		
		JPanel panel_15 = new JPanel();
		panel_coordinate.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btn_coordinate_y_moins = new JButton("y -");
		btn_coordinate_y_moins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
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
		panel_15.add(btn_coordinate_y_moins);
		
		JPanel panel_16 = new JPanel();
		panel_coordinate.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("");
		panel_16.add(lblNewLabel_1_1_1_1_3);
		
		JPanel panel_17 = new JPanel();
		panel_4.add(panel_17, BorderLayout.SOUTH);
		panel_17.setLayout(new GridLayout(1, 3, 15, 20));
		
		JButton btn_Preview = new JButton("Preview");
		panel_17.add(btn_Preview);
		btn_Preview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCamera controller_cam = new ControllerCamera();
				Thread t = new Thread(controller_cam);
				t.start();
			}
		});
		
		JButton btn_Stop = new JButton("Stop preview");
		panel_17.add(btn_Stop);
		
		
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		panel_North.setLayout(new GridLayout(1, 2, 150, 0));
				
		JLabel lbl_Camera = new JLabel("Camera");
		lbl_Camera.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Camera.setHorizontalAlignment(SwingConstants.CENTER);
		panel_North.add(lbl_Camera);
		
	}
}
