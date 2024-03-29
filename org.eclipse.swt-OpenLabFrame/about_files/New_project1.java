package about_files;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class New_project1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewProject1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_project1 frame = new New_project1();
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
	public New_project1() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/centuri/eclipse-workspace/Audrey/res/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		FlowLayout fl_panel_North = (FlowLayout) panel_North.getLayout();
		fl_panel_North.setVgap(20);
		fl_panel_North.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_North, BorderLayout.NORTH);
		
		
		// Panel Center //
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(0, 1, 0, 20));
		
		
		// Panel West //
		
		JPanel panel_West = new JPanel();
		FlowLayout fl_panel_West = (FlowLayout) panel_West.getLayout();
		fl_panel_West.setHgap(80);
		contentPane.add(panel_West, BorderLayout.WEST);
				
				
		// Panel East //
				
		JPanel panel_East = new JPanel();
		FlowLayout fl_panel_East = (FlowLayout) panel_East.getLayout();
		fl_panel_East.setHgap(80);
		contentPane.add(panel_East, BorderLayout.EAST);
				
				
		// Panel South //
				
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
				
		JPanel panel = new JPanel();
		panel_South.add(panel);
		panel.setLayout(new GridLayout(0, 2, 275, 0));
		
		
		// Label New Project //
		
		JLabel lblLabel_Project = new JLabel("New Project");
		panel_North.add(lblLabel_Project);
		
		
		// Button Plate Design //
		
		JButton btnButton_Plate_Design = new JButton("Plate design");
		btnButton_Plate_Design.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_project2 nw = new New_project2();
				nw.New_Project2();
			}
		});
		panel_Center.add(btnButton_Plate_Design);
		
		
		// Button Syringe //
		
		JButton btnButton_Syringe = new JButton("Syringe");
		btnButton_Syringe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Syringe nw = new Syringe();
				nw.Syringe1();
			}
		});
		panel_Center.add(btnButton_Syringe);
		
		
		// Button Camera //
		
		JButton btnButton_Camera = new JButton("Camera");
		btnButton_Camera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cam2 nw = new Cam2();
				nw.Cam2();
			}
		});
		panel_Center.add(btnButton_Camera);
		
		
		// Button Back //
		
		JButton btnButton_Back = new JButton("Back");
		btnButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		panel.add(btnButton_Back);
		
		
		// Button Start //
		
		JButton btnButton_Start = new JButton("Start");
		btnButton_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnButton_Start);
		
	}

}
