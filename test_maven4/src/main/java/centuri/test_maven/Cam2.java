package centuri.test_maven;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import centuri.test_maven.Camera.PicConfig.Builder;

import java.awt.CardLayout;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.SystemColor;

import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import com.hopding.jrpicam.enums.AWB;
import com.hopding.jrpicam.enums.DRC;
import com.hopding.jrpicam.enums.Encoding;
import com.hopding.jrpicam.enums.Exposure;
import com.hopding.jrpicam.enums.ImageEffect;
import com.hopding.jrpicam.enums.MeteringMode;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
import javax.swing.JTextField;
import javax.swing.JRadioButton;


public class Cam2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Delay_time;
	private JTextField textField_Width;
	private JTextField textField_Height;
	private JTextField textField_delay_time1;
	private JTextField textField_Width1;
	private JTextField textField_Height1;
	private JTextField textField_number_of_pictues;
	private JTextField textField_Number_of_picture1;

	/**
	 * Launch the application.
	 */
	public void Cam2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cam2 frame = new Cam2();
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
	public Cam2() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/centuri/eclipse-workspace/Audrey/res/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		panel_North.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
				
		JLabel lblLabel_Camera = new JLabel("Camera");
		lblLabel_Camera.setToolTipText("");
		panel_North.add(lblLabel_Camera);
				
				
		
		
		JPanel panel_Center = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Center.getLayout();
		flowLayout.setVgap(1);
		flowLayout.setHgap(70);
		contentPane.add(panel_Center, BorderLayout.CENTER);
		
		ArrayList<String> data_picture= new ArrayList<String>();
		
		// Panel West //
		
		JPanel panel_Image = new JPanel();
		panel_Center.add(panel_Image);
		panel_Image.setLayout(new GridLayout(5, 1, 0, 5));
		
		
		// Panel Image //
		
		JPanel panel_Image1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_Image1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_Image.add(panel_Image1);
		
		JRadioButton rdbtn_Image = new JRadioButton("Picture");
		rdbtn_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_Image.isSelected()){
					data_picture.add("Picture");
				}
				if(rdbtn_Image.isSelected()==false){ {
					data_picture.clear();
					textField_Delay_time.setText("");
					textField_Width.setText("");
					textField_Height.setText(" ");
					textField_number_of_pictues.setText("");
				}
			}
			}
		});
		panel_Image1.add(rdbtn_Image);
		
		
		// Panel Delay time //
		
		JPanel panel_Delay_time = new JPanel();
		panel_Image.add(panel_Delay_time);
		panel_Delay_time.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_delay_time = new JLabel("Delay time");
		panel_Delay_time.add(lblLabel_delay_time);
		
		textField_Delay_time = new JTextField();
		textField_Delay_time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_picture.add(" -t " + textField_Delay_time.getText());
				}
		});
		panel_Delay_time.add(textField_Delay_time);
		textField_Delay_time.setColumns(10);
		
		
		// Panel Width //
		
		JPanel panel_Width = new JPanel();
		panel_Image.add(panel_Width);
		panel_Width.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Width = new JLabel("Width");
		panel_Width.add(lblLabel_Width);
		
		textField_Width = new JTextField();
		textField_Width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_picture.add(" -w " + textField_Width.getText());
			}
		});
		panel_Width.add(textField_Width);
		textField_Width.setColumns(10);
		
		
		// Panel Height //
		
		JPanel panel_Height = new JPanel();
		panel_Image.add(panel_Height);
		panel_Height.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Height = new JLabel("Height");
		panel_Height.add(lblLabel_Height);
		
		textField_Height = new JTextField();
		textField_Height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_picture.add(" -w " + textField_Height.getText());
			}
		});
		panel_Height.add(textField_Height);
		textField_Height.setColumns(10);
		
		
		// Panel Number of picture //
		
		JPanel panel_Number_of_pictures = new JPanel();
		panel_Image.add(panel_Number_of_pictures);
		panel_Number_of_pictures.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Number_of_pictures = new JLabel("Number of pictures");
		panel_Number_of_pictures.add(lblLabel_Number_of_pictures);
		
		textField_number_of_pictues = new JTextField();
		textField_number_of_pictues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_picture.add("nb " + textField_number_of_pictues.getText());
			}
		});
		textField_number_of_pictues.setColumns(10);
		panel_Number_of_pictures.add(textField_number_of_pictues);
		
		
		// Panel Video //
		
		ArrayList<String> data_video= new ArrayList<String>();
		
		JPanel panel_Video = new JPanel();
		panel_Center.add(panel_Video);
		panel_Video.setLayout(new GridLayout(5, 1, 0, 5));
		
		JPanel panel_Video1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_Video1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_Video.add(panel_Video1);
		
		JRadioButton rdbtn_Video = new JRadioButton("Video");
		rdbtn_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_Video.isSelected()){
					data_video.add("Video");
				}
				if(rdbtn_Video.isSelected()==false) {
					data_video.clear();
					textField_delay_time1.setText("");
					textField_Width1.setText("");
					textField_Height1.setText(" ");
					textField_Number_of_picture1.setText("");
				}
			}
		});
		panel_Video1.add(rdbtn_Video);
		
		
		// Panel Delay time //
		
		JPanel panel_Delay_time_1 = new JPanel();
		panel_Video.add(panel_Delay_time_1);
		panel_Delay_time_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_delay_time_1 = new JLabel("Delay time");
		panel_Delay_time_1.add(lblLabel_delay_time_1);
		
		textField_delay_time1 = new JTextField();
		textField_delay_time1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_video.add(" -t " + textField_delay_time1.getText());
			}
		});
		textField_delay_time1.setColumns(10);
		panel_Delay_time_1.add(textField_delay_time1);
		
		
		// Panel Width //
		
		JPanel panel_Width_1 = new JPanel();
		panel_Video.add(panel_Width_1);
		panel_Width_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Width_1 = new JLabel("Width");
		panel_Width_1.add(lblLabel_Width_1);
		
		textField_Width1 = new JTextField();
		textField_Width1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_video.add(" -w " + textField_Width1.getText());
			}
		});
		textField_Width1.setColumns(10);
		panel_Width_1.add(textField_Width1);
		
		
		// Panel Height //
		
		JPanel panel_Height_1 = new JPanel();
		panel_Video.add(panel_Height_1);
		panel_Height_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Height_1 = new JLabel("Height");
		panel_Height_1.add(lblLabel_Height_1);
		
		textField_Height1 = new JTextField();
		textField_Height1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_picture.add(" -h " + textField_Height1.getText());
			}
		});
		textField_Height1.setColumns(10);
		panel_Height_1.add(textField_Height1);
		
		
		// Panel Time //
		
		JPanel panel_Time = new JPanel();
		panel_Video.add(panel_Time);
		panel_Time.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_panel_Time= new JLabel("Time");
		panel_Time.add(lblLabel_panel_Time);
		
		JTextField textField_Time = new JTextField();
		textField_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_video.add(textField_Time.getText());
			}
		});
		textField_Time.setColumns(10);
		panel_Time.add(textField_Time);
		
		
		// Panel South //
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
		JPanel panel = new JPanel();
		panel_South.add(panel);
		panel.setLayout(new GridLayout(0, 2, 150, 0));
								
								
		// Button Back //
								
		JButton btnButton_Back = new JButton("Back");
		btnButton_Back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		panel.add(btnButton_Back);
		
		
						
		// Button Save //
								
		JButton btnButton_Save = new JButton("Save");
		btnButton_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter file = new FileWriter("Data_picture.txt");
					BufferedWriter output = new BufferedWriter(file);
					for (int i = 0; i < data_picture.size(); i ++) {
						String Info = (String) data_picture.get(i);
						output.write(Info);
					}
				    output.close();
				    
				} catch (IOException o) {
					// TODO Auto-generated catch block
					o.printStackTrace();
				}
				
				try {
					FileWriter file = new FileWriter("Data_video.txt");
					BufferedWriter output = new BufferedWriter(file);
					for (int i = 0; i < data_video.size(); i ++) {
						String Info = (String) data_video.get(i);
						output.write(Info);
					}
				    output.close();
				    
				} catch (IOException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		panel.add(btnButton_Save);
					
	
	}
}
