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

public class CameraView extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Time;
	private JTextField textField_Height;
	private JTextField textField_Width;
	private JTextField textField_Quality;
	private JTextField textField_encoding;
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
		
		JPanel panel_West = new JPanel();
		contentPane.add(panel_West, BorderLayout.WEST);
		panel_West.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lbl_Parametres = new JLabel("");
		panel_West.add(lbl_Parametres);
		
		
		/* Panel Quality */
		JPanel panel_Quality = new JPanel();
		panel_West.add(panel_Quality);
		panel_Quality.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Quality = new JLabel("Quality");
		panel_Quality.add(lbl_Quality);
		
		textField_Quality = new JTextField();
		textField_Quality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_Quality.getText());
			}
		});
		textField_Quality.setColumns(10);
		panel_Quality.add(textField_Quality);
		
		
		/* Panel Time */
		JPanel panel_Time = new JPanel();
		panel_West.add(panel_Time);
		panel_Time.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Time = new JLabel("Time");
		panel_Time.add(lbl_Time);
		
		textField_Time = new JTextField();
		textField_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_Time.getText());
			}
		});
		panel_Time.add(textField_Time);
		textField_Time.setColumns(10);
		
		
		/* Panel Width */
		
		JPanel panel_Width = new JPanel();
		panel_West.add(panel_Width);
		panel_Width.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Width = new JLabel("Width");
		panel_Width.add(lbl_Width);
		
		textField_Width = new JTextField();
		textField_Width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_Width.getText());
			}
		});
		panel_Width.add(textField_Width);
		textField_Width.setColumns(10);
		
		
		/* Panel Height */
		
		JPanel panel_Height = new JPanel();
		panel_West.add(panel_Height);
		panel_Height.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Height = new JLabel("Height");
		panel_Height.add(lbl_Height);
		
		textField_Height = new JTextField();
		textField_Height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_Height.getText());
			}
		});
		panel_Height.add(textField_Height);
		textField_Height.setColumns(10);
		
		
		/* Panel Encoding */
		
		JPanel panel_Encoding = new JPanel();
		panel_West.add(panel_Encoding);
		panel_Encoding.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_Encoding = new JLabel("Encoding");
		panel_Encoding.add(lbl_Encoding);
		
		textField_encoding = new JTextField();
		textField_encoding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_encoding.getText());
			}
		});
		textField_encoding.setColumns(10);
		panel_Encoding.add(textField_encoding);
		
		JLabel lblNewLabel = new JLabel("");
		panel_West.add(lblNewLabel);
		
		
		
		// Panel South //
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new GridLayout(2, 1, 25, 10));
		
		JPanel panel = new JPanel();
		panel_South.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtn_Absolute = new JRadioButton("Absolute coordinate");
		JRadioButton rdbtn_Relative = new JRadioButton("Relative coordinate");
		
		rdbtn_Absolute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_Absolute.isSelected()){
					rdbtn_Relative.setSelected(false);
				}
			}
		});
		rdbtn_Absolute.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtn_Absolute);
		
		
		rdbtn_Relative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_Relative.isSelected()){
					rdbtn_Absolute.setSelected(false);
				}
			}
		});
		rdbtn_Relative.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtn_Relative);
		
		JPanel panel_coordinate = new JPanel();
		panel_South.add(panel_coordinate);
		panel_coordinate.setLayout(new GridLayout(0, 3, 25, 15));
		
		ArrayList data_controller= new ArrayList();
		Arduino arduino = new Arduino(data_controller);
		
		/* Panel coordinate x */
		
		JPanel panel_coordinate_x = new JPanel();
		panel_coordinate.add(panel_coordinate_x);
		panel_coordinate_x.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		textField_coordinate_x = new JTextField();
		textField_coordinate_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_coordinate_x.setColumns(10);
		panel_coordinate_x.add(textField_coordinate_x);
		
		JButton btn_coordinate_x = new JButton("x");
		btn_coordinate_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn_Absolute.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G90\n");
					data_controller.add("G0x" + textField_coordinate_x.getText() + "\n");
					arduino.Save_Coordinate();
					arduino.afficher_data_controller();
					try {
						arduino.Arduino();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					data_controller.clear();
				}
				if (rdbtn_Relative.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G91\n");
					data_controller.add("G0x" + textField_coordinate_x.getText() + "\n");
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
				
			
			}
		});
		panel_coordinate_x.add(btn_coordinate_x);
		
		
		/* Panel coordinate y */
		
		JPanel panel_coordinate_y = new JPanel();
		panel_coordinate.add(panel_coordinate_y);
		panel_coordinate_y.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		textField_coordinate_y = new JTextField();
		textField_coordinate_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_coordinate_y.setColumns(10);
		panel_coordinate_y.add(textField_coordinate_y);
		
		JButton btn_coordinate_y = new JButton("y");
		btn_coordinate_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn_Absolute.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G90\n");
					data_controller.add("G0y" + textField_coordinate_y.getText() + "\n");
					arduino.Save_Coordinate();
					arduino.afficher_data_controller();
					try {
						arduino.Arduino();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					data_controller.clear();
				}
				if (rdbtn_Relative.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G91\n");
					data_controller.add("G0y" + textField_coordinate_y.getText() + "\n");
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
				
			}
		});
		panel_coordinate_y.add(btn_coordinate_y);
		
		
		/* Panel coordinate z */
		
		JPanel panel_coordinate_z = new JPanel();
		panel_coordinate.add(panel_coordinate_z);
		panel_coordinate_z.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		textField_coordinate_z = new JTextField();
		textField_coordinate_z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_coordinate_z.setColumns(10);
		panel_coordinate_z.add(textField_coordinate_z);
		
		JButton btn_coordinate_z = new JButton("z");
		btn_coordinate_z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn_Absolute.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G90\n");
					data_controller.add("G0z" + textField_coordinate_z.getText() + "\n");
					arduino.Save_Coordinate();
					arduino.afficher_data_controller();
					try {
						arduino.Arduino();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					data_controller.clear();
				}
				if (rdbtn_Relative.isSelected()) {
					data_controller.add("$H\n");
					data_controller.add("G91\n");
					data_controller.add("G0z" + textField_coordinate_z.getText() + "\n");
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
				
				}
		});
		panel_coordinate_z.add(btn_coordinate_z);
		
		
		ControllerCamera controller_cam = new ControllerCamera();

		Thread t = new Thread(controller_cam);
		
		// Panel Center //
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(null);
		
		JButton btn_Preview = new JButton("Preview");
		btn_Preview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.start();
			}
		});
		btn_Preview.setBounds(47, 26, 173, 52);
		panel_Center.add(btn_Preview);
		
		JButton btn_Stop = new JButton("Stop");
		btn_Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StopCamera Stop_cam = new StopCamera();
				Thread t1 = new Thread(Stop_cam);
				t1.start();
				Stop stop = new Stop();
				Thread t2 = new Thread(stop);
				dispose();
			}
		});
		btn_Stop.setBounds(47, 103, 173, 52);
		panel_Center.add(btn_Stop);
		
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		panel_North.setLayout(new GridLayout(1, 2, 150, 0));
				
		JLabel lbl_Camera = new JLabel("Camera");
		lbl_Camera.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Camera.setHorizontalAlignment(SwingConstants.CENTER);
		panel_North.add(lbl_Camera);
				
		JButton btn_Taking_a_picture = new JButton("Taking a picture");
		btn_Taking_a_picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Camera camera = new Camera();

				var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
						.delay(Integer.parseInt(textField_Time.getText()))
						.disablePreview(true)
						.encoding(Camera.PicEncoding.PNG)
						.useDate(true)
						.quality(Integer.parseInt(textField_Quality.getText()))
						.width(Integer.parseInt(textField_Width.getText()))
						.height(Integer.parseInt(textField_Height.getText()))
						.build();
				
				camera.takeStill(config);
				
			}
		});
		panel_North.add(btn_Taking_a_picture);
		
	}

	
}
