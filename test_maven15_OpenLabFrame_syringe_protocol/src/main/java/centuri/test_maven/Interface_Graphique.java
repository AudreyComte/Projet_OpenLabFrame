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
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;

public class Interface_Graphique extends JFrame {

	private JPanel contentPane;
	private JTextField textField_break;
	private JTextField textField_Time_Video;
	private JTextField textField_Syringue_i;
	private JTextField textField_Syringue_a;
	private JTextField textField_rep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Graphique frame = new Interface_Graphique();
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
	public Interface_Graphique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		// Dimension de de la plaque avec le nombre de colonne et de ligne
		Field field = new Field(12.0, 8.0, 3, 2);

		// Calcul des coordonnées de chaque puits de la plaque
		Coordinate_Field coordinate = new Coordinate_Field(field);

		Arduino arduino1 = new Arduino("ttyACM0"); // "ttyAMA1"
		arduino1.start();

		// Arduino arduino2 = new Arduino("ttyAMA0");
		// arduino2.Start();
		
		
        // Liste d'objet Event qui sert à stocker les différents évenements (Mouvement, Pause, Picture, Video, Syringe, Home)
		ArrayList<Event> data = new ArrayList<Event>();
		
		// Instanciation d'un objet protocol de la classe Protocol qui prend en argument la liste d'Event data
		Protocol protocol = new Protocol(data);
		
        // Instanciation d'un objet initialization de la classe Inialisation
		Initialization initialization = new Initialization(arduino1);

		// Ajout de l'objet initialization dans le liste d'Event pour permettre d'effectuer le Homing à chaque répétition de la liste 
		data.add(initialization);

		// Instanciation d'un objet camera de la classe Camera
		Camera camera = new Camera();
		
		// Instanciation d'un objet protocol de la classe Loading_protocol qui prend en argument l'objet protocol
		Loading_Protocol loading_protocol = new Loading_Protocol(protocol);

		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		JPanel panel_List = new JPanel();
		panel_List.setPreferredSize(new Dimension(200, 300));
		contentPane.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));

		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(1, 1, 0, 0));

		
		// List
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_List = new JLabel("List of events");
		panel_List_titre.add(lblNewLabel_List);
		lblNewLabel_List.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_List.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		// listData est une instance de la classe DefaultListModel qui stocke des
		// éléments sous forme de chaînes de caractères.
		DefaultListModel<String> listData = new DefaultListModel();

		// Instanciation d'une liste de string de la classe JList qui prend en argument
		// l'object listData
		JList<String> list = new JList(listData);

		panel_1.add(list);

		JScrollPane scrollPane = new JScrollPane(list);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_List.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 10));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);

		
		// Bouton "Remouve"
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				listData.remove(selectedIndex);
				data.remove(selectedIndex + 1);
			}
		});

		
		// Button "Apply to all well"
		JButton btnNewButton_4 = new JButton("Apply to all well"); 
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.MAGENTA);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinate.apply_all(listData, data, arduino1);
			}
		});
		panel_5.setLayout(new GridLayout(0, 1, 0, 5));
		panel_5.add(btnNewButton_4);
		panel_5.add(btnNewButton_1);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Total time : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);

		panel_9.add(lblNewLabel_3);

		
		
		// Parameter
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_parameter = new JPanel();
		contentPane.add(panel_parameter, BorderLayout.CENTER);
		panel_parameter.setLayout(new BorderLayout(0, 0));

		JPanel panel_Parameter_titre = new JPanel();
		panel_parameter.add(panel_Parameter_titre, BorderLayout.NORTH);
		panel_Parameter_titre.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Parameter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Parameter_titre.add(lblNewLabel);

		JPanel panel_Parameter_contenu = new JPanel();
		panel_parameter.add(panel_Parameter_contenu, BorderLayout.CENTER);
		panel_Parameter_contenu.setLayout(new GridLayout(4, 2, 15, 15));

		JPanel panel_Mouvement = new JPanel();
		panel_Mouvement.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Mouvement);
		panel_Mouvement.setLayout(new GridLayout(2, 1, 5, 5));

		// Mouvement
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_Mouvement = new JLabel("Mouvement");
		lblNewLabel_Mouvement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement.add(lblNewLabel_Mouvement);

		JPanel panel = new JPanel();
		panel_Mouvement.add(panel);
		panel.setLayout(new GridLayout(1, 3, 10, 0));

		JLabel lblNewLabel_1 = new JLabel("Well");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblNewLabel_1);

		String[] well = { "A1", "A2", "A3", "B1", "B2", "B3" };
		JComboBox comboBox = new JComboBox(well);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getSelectedItem().toString();
			}
		});
		panel.add(comboBox);

		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.setBackground(Color.CYAN);
		panel.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement((comboBox.getSelectedItem().toString() + "\n"));
				double coordinate_x = (coordinate
						.get_x_coordinate(coordinate.get_c(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_y = (coordinate
						.get_y_coordinate(coordinate.get_r(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_z = 35.0;
				Mouvement well = new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino1);
				data.add(well);
			}
		});

		// Break
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Break = new JPanel();
		panel_Break.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Break);
		panel_Break.setLayout(new GridLayout(2, 1, 5, 5));

		JLabel lblNewLabel_Break = new JLabel("Break");
		lblNewLabel_Break.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Break.add(lblNewLabel_Break);

		JPanel panel_6 = new JPanel();
		panel_Break.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 3, 10, 0));

		JLabel lblNewLabel_Time_break = new JLabel("Time (sec.)");
		lblNewLabel_Time_break.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Time_break.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_6.add(lblNewLabel_Time_break);

		textField_break = new JTextField();
		textField_break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(textField_break);
		textField_break.setColumns(10);

		JButton btnNewButton_Add_Break = new JButton("Add");
		btnNewButton_Add_Break.setBackground(Color.CYAN);
		panel_6.add(btnNewButton_Add_Break);
		btnNewButton_Add_Break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_break.getText().isEmpty() == false) {
					listData.addElement("Break " + textField_break.getText() + " sec." + "\n");
					Pause pause = new Pause((Integer.parseInt(textField_break.getText().toString())) * 1000);
					data.add(pause);
				} else {
					btnNewButton_Add_Break.setEnabled(true);
				}
			}
		});

		// Picture
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Picture = new JPanel();
		panel_Picture.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_Parameter_contenu.add(panel_Picture);
		panel_Picture.setLayout(new GridLayout(2, 1, 5, 5));
		JLabel lblNewLabel_3_1 = new JLabel("Picture");

		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Picture.add(lblNewLabel_3_1);

		JPanel panel_6_1_1 = new JPanel();
		panel_Picture.add(panel_6_1_1);
		panel_6_1_1.setLayout(new GridLayout(1, 3, 15, 0));

		JLabel lblNewLabel_4 = new JLabel("");
		panel_6_1_1.add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("");
		panel_6_1_1.add(lblNewLabel_2);

		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.setBackground(Color.CYAN);
		panel_6_1_1.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
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

		JPanel panel_6_1 = new JPanel();
		panel_Video.add(panel_6_1);
		panel_6_1.setLayout(new GridLayout(1, 3, 10, 0));

		JLabel lblNewLabel_Time_Video = new JLabel("Time (sec.)");
		lblNewLabel_Time_Video.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Time_Video.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_6_1.add(lblNewLabel_Time_Video);

		textField_Time_Video = new JTextField();
		textField_Time_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Time_Video.setColumns(10);
		panel_6_1.add(textField_Time_Video);

		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.setBackground(Color.CYAN);
		panel_6_1.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Time_Video.getText().isEmpty() == false) {
					listData.addElement("Video " + textField_Time_Video.getText() + " sec. record time" + "\n");
					Video video = new Video((Integer.parseInt(textField_Time_Video.getText().toString()) * 1000),
							camera);
					data.add(video);
				} else {
					btnNewButton_1_1.setEnabled(true);
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

		JPanel panel_6_1_2 = new JPanel();
		panel_Syringe_injected.add(panel_6_1_2);
		panel_6_1_2.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lblNewLabel_volume_i = new JLabel("Volum (ml.)");
		lblNewLabel_volume_i.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_volume_i.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_6_1_2.add(lblNewLabel_volume_i);

		textField_Syringue_i = new JTextField();
		textField_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_i.setColumns(10);
		panel_6_1_2.add(textField_Syringue_i);

		JButton btnNewButton_Syringue_i = new JButton("Add");
		btnNewButton_Syringue_i.setBackground(Color.CYAN);
		panel_6_1_2.add(btnNewButton_Syringue_i);
		btnNewButton_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_i.getText().isEmpty() == false) {
					listData.addElement("Syringe : " + textField_Syringue_i.getText() + " ml injected " + "\n");
					Syringe injection = new Syringe((Integer.parseInt(textField_Syringue_i.getText().toString())),
							arduino1);
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

		JPanel panel_6_1_2_1 = new JPanel();
		panel_Syringe_aspirated.add(panel_6_1_2_1);
		panel_6_1_2_1.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lblNewLabel_volume_a = new JLabel("Volum (ml.)");
		lblNewLabel_volume_a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_volume_a.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_6_1_2_1.add(lblNewLabel_volume_a);

		textField_Syringue_a = new JTextField();
		textField_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_a.setColumns(10);
		panel_6_1_2_1.add(textField_Syringue_a);

		JButton btnNewButton_Syringue_a = new JButton("Add");
		btnNewButton_Syringue_a.setBackground(Color.CYAN);
		panel_6_1_2_1.add(btnNewButton_Syringue_a);
		btnNewButton_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_a.getText().isEmpty() == false) {
					listData.addElement("Syringe : " + textField_Syringue_a.getText() + " ml aspirated" + "\n");
					Syringe aspiration = new Syringe((Integer.parseInt(textField_Syringue_a.getText().toString())),
							arduino1);
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

		JPanel panel_7_1_1_2 = new JPanel();
		panel_Home.add(panel_7_1_1_2);
		panel_7_1_1_2.setLayout(new GridLayout(0, 3, 10, 15));

		JButton btnNewButton_1_1_1_2 = new JButton("Add");
		btnNewButton_1_1_1_2.setBackground(Color.CYAN);
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Home" + "\n");
				Initialization home = new Initialization(arduino1);
				data.add(home);
			}
		});

		JLabel lblNewLabel_5 = new JLabel("");
		panel_7_1_1_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		panel_7_1_1_2.add(lblNewLabel_6);
		panel_7_1_1_2.add(btnNewButton_1_1_1_2);

		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(15, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_7.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 3, 10, 0));

		JLabel lblNewLabel_rep_1 = new JLabel("Repetition");
		panel_4.add(lblNewLabel_rep_1);
		lblNewLabel_rep_1.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_10 = new JLabel("");
		panel_4.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("");
		panel_4.add(lblNewLabel_11);

		JPanel panel_6_1_1_2_1 = new JPanel();
		panel_4.add(panel_6_1_1_2_1);
		panel_6_1_1_2_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_Time_Rep_1 = new JLabel("Time between 2 rep (min)");
		lblNewLabel_Time_Rep_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Time_Rep_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_6_1_1_2_1.add(lblNewLabel_Time_Rep_1, BorderLayout.NORTH);

		textField_rep = new JTextField();
		textField_rep.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_rep.setColumns(10);
		panel_6_1_1_2_1.add(textField_rep, BorderLayout.SOUTH);

		JPanel panel_4_1 = new JPanel();
		panel_4.add(panel_4_1);
		panel_4_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_nub_rep_1 = new JLabel("Number of repetition");
		lblNewLabel_nub_rep_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_nub_rep_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_4_1.add(lblNewLabel_nub_rep_1, BorderLayout.NORTH);

		String[] rep = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JComboBox comboBox_rep = new JComboBox(rep);
		panel_4_1.add(comboBox_rep, BorderLayout.SOUTH);

		JPanel panel_10_1 = new JPanel();
		panel_4.add(panel_10_1);
		panel_10_1.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton_3_1 = new JButton("Validate");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_rep.getText().isEmpty()) {
					lblNewLabel_3
							.setText("Total time : "
									+ (Long.parseLong(textField_rep.getText().toString())
											* Integer.parseInt(comboBox_rep.getSelectedItem().toString()))
									+ " minutes");
				} else {
					lblNewLabel_3.setText("Total time : "
							+ (1 * Integer.parseInt(comboBox_rep.getSelectedItem().toString())) + " minutes");
				}
			}
		});
		btnNewButton_3_1.setBackground(new Color(135, 206, 250));
		panel_10_1.add(btnNewButton_3_1);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10, BorderLayout.EAST);
		panel_10.setLayout(new GridLayout(2, 2, 10, 10));

		// Button start
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		JButton btnNewButton = new JButton("                Start                ");
		btnNewButton.setBackground(Color.GREEN);
		panel_10.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_rep.getText().isEmpty()) {
					textField_rep.setText("1");
				}

				Thread t1 = new Thread(loading_protocol);

				loading_protocol.set_number_repetition(Integer.parseInt(comboBox_rep.getSelectedItem().toString()));
				loading_protocol.set_time(Long.parseLong(textField_rep.getText().toString()));
				loading_protocol.set_protocol(protocol);

				t1.start();

			}
		});

		// Stop
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.PINK);
		panel_10.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loading_protocol.stop();
			}
		});
	}
}