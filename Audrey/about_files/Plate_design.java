package about_files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Plate_design extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void PlateDesign() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plate_design frame = new Plate_design();
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
	public Plate_design() {
		setBackground(new Color(0, 0, 0));
		setTitle("OpenLabFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 3));
		
		
		// Panel North //
		
		JPanel panel_North = new JPanel();
		FlowLayout fl_panel_North = (FlowLayout) panel_North.getLayout();
		fl_panel_North.setVgap(15);
		fl_panel_North.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_North, BorderLayout.NORTH);
		
		
		// Label Plate Design //
		
		JLabel lblLabel_Plate_Design = new JLabel("Plate Design");
		panel_North.add(lblLabel_Plate_Design);
		
		
		// Panel South //
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
						
		JPanel panel = new JPanel();
		panel_South.add(panel);
		panel.setLayout(new GridLayout(0, 2, 275, 0));
		
		
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
		panel.add(btnButton_Save);
		
		
		// Panel Center //
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLabel_Plate_plan = new JLabel("");
		lblLabel_Plate_plan.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Center.add(lblLabel_Plate_plan, BorderLayout.CENTER);
		
		
		// Panel West //
		
		JPanel panel_West = new JPanel();
		contentPane.add(panel_West, BorderLayout.WEST);
		panel_West.setLayout(new GridLayout(3, 1, 0, 15));
		
		
		// Panel Type of plate //
		
		JPanel panel_Type_of_plate = new JPanel();
		panel_West.add(panel_Type_of_plate);
		panel_Type_of_plate.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JLabel lblLabel_Type_of_plate = new JLabel("Type of plate");
		panel_Type_of_plate.add(lblLabel_Type_of_plate);
		
		String [] message_type_of_well = {"6 well plate", "12 well plate", "24 well plate", "48 well plate", "96 well plate"};
		JComboBox comboBox_Type_of_plate = new JComboBox(message_type_of_well);
		comboBox_Type_of_plate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBox_Type_of_plate.getSelectedItem().toString())== "6 well plate")
				{lblLabel_Plate_plan.setIcon(new ImageIcon("C:\\Users\\Audrey\\eclipse-workspace\\Audrey\\res\\6 well plate.png"));
				}
			}
		});
		
		panel_Type_of_plate.add(comboBox_Type_of_plate);
	
		
		// Panel Type of bottom //
		
		JPanel panel_Type_of_buttom = new JPanel();
		panel_West.add(panel_Type_of_buttom);
		panel_Type_of_buttom.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Type_of_bottom = new JLabel("Type of bottom");
		panel_Type_of_buttom.add(lblLabel_Type_of_bottom);
		
		String [] message_type_of_bottom = {"Round bottom", "Flat bottom"};
		JComboBox comboBox_Type_of_bottom = new JComboBox(message_type_of_bottom);
		panel_Type_of_buttom.add(comboBox_Type_of_bottom);
		
		
		// Panel Reading direction //
		
		JPanel panel_Reading_direction = new JPanel();
		panel_West.add(panel_Reading_direction);
		panel_Reading_direction.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblLabel_Reading_direction = new JLabel("Reading direction");
		panel_Reading_direction.add(lblLabel_Reading_direction);
		
		String [] message_reading_direction = {"Rows by rows", "Columns by columns"};
		JComboBox comboBox_Reading_direction = new JComboBox(message_reading_direction);
		panel_Reading_direction.add(comboBox_Reading_direction);
		
		
		
		
			
	}

}

