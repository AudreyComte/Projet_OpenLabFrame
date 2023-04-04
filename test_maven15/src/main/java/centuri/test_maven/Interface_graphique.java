package centuri.test_maven;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Interface_graphique extends JFrame {

	private JPanel contentPane;
	private JTextField textField_break;
	private JTextField textField_Time_Video;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_graphique frame = new Interface_graphique();
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
	public Interface_graphique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));
		
		JPanel panel_List = new JPanel();
		contentPane.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("List");
		panel_List_titre.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_List.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(20, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_Initialization = new JLabel("   Initialization   ");
		lblNewLabel_Initialization.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_Initialization);
		
		JPanel panel_2 = new JPanel();
		panel_List.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_List.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("     ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_parameter = new JPanel();
		contentPane.add(panel_parameter, BorderLayout.CENTER);
		panel_parameter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Parameter_titre = new JPanel();
		panel_parameter.add(panel_Parameter_titre, BorderLayout.NORTH);
		panel_Parameter_titre.setLayout(new BoxLayout(panel_Parameter_titre, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Parameter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Parameter_titre.add(lblNewLabel);
		
		JPanel panel_Parameter_contenu = new JPanel();
		panel_parameter.add(panel_Parameter_contenu, BorderLayout.CENTER);
		panel_Parameter_contenu.setLayout(new GridLayout(0, 2, 15, 15));
		
		JPanel panel_Mouvement = new JPanel();
		panel_Mouvement.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Mouvement);
		panel_Mouvement.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_Mouvement = new JLabel("Mouvement");
		lblNewLabel_Mouvement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement.add(lblNewLabel_Mouvement);
		
		JPanel panel = new JPanel();
		panel_Mouvement.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Well");
		panel.add(lblNewLabel_1);
		
		String [] well = {"A1", "A2", "A3", "B1", "B2", "B3"};
		JComboBox comboBox = new JComboBox(well);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(comboBox);
		
		JPanel panel_7_1_1_1 = new JPanel();
		panel_Mouvement.add(panel_7_1_1_1);
		panel_7_1_1_1.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_2_1_1 = new JButton("Remove");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1_1_1.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1_1_1.add(btnNewButton_1_1_1_1);
		
		JPanel panel_Break = new JPanel();
		panel_Break.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Break);
		panel_Break.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_Break = new JLabel("Break");
		lblNewLabel_Break.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Break.add(lblNewLabel_Break);
		
		JPanel panel_6 = new JPanel();
		panel_Break.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_break = new JLabel("Time (sec.)");
		panel_6.add(lblNewLabel_Time_break);
		
		textField_break = new JTextField();
		textField_break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(textField_break);
		textField_break.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_Break.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_Remouve_Break = new JButton("Remove");
		btnNewButton_Remouve_Break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7.add(btnNewButton_Remouve_Break);
		
		JButton btnNewButton_Add_Break = new JButton("Add");
		btnNewButton_Add_Break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lblNewLabel_Break = new JLabel("Break "+ textField_break.getText() + " sec.");
				panel_1.add(lblNewLabel_Break);
			}
		});
		panel_7.add(btnNewButton_Add_Break);
		
		JPanel panel_Picture = new JPanel();
		panel_Picture.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Picture);
		panel_Picture.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_3_1 = new JLabel("Picture");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Picture.add(lblNewLabel_3_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_Picture.add(panel_6_1_1);
		panel_6_1_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_Video_1 = new JLabel("Delay (sec.)");
		panel_6_1_1.add(lblNewLabel_Time_Video_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		panel_6_1_1.add(textField);
		
		JPanel panel_7_1_1 = new JPanel();
		panel_Picture.add(panel_7_1_1);
		panel_7_1_1.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_2_1 = new JButton("Remove");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1_1.add(btnNewButton_1_1_1);
		
		JPanel panel_Video = new JPanel();
		panel_Video.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Video);
		panel_Video.setLayout(new GridLayout(3, 1, 15, 15));
		
		JLabel lblNewLabel_Video = new JLabel("Video");
		lblNewLabel_Video.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Video.add(lblNewLabel_Video);
		
		JPanel panel_6_1 = new JPanel();
		panel_Video.add(panel_6_1);
		panel_6_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNewLabel_Time_Video = new JLabel("Time (sec.)");
		panel_6_1.add(lblNewLabel_Time_Video);
		
		textField_Time_Video = new JTextField();
		textField_Time_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Time_Video.setColumns(10);
		panel_6_1.add(textField_Time_Video);
		
		JPanel panel_7_1 = new JPanel();
		panel_Video.add(panel_7_1);
		panel_7_1.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7_1.add(btnNewButton_1_1);
	}
}
