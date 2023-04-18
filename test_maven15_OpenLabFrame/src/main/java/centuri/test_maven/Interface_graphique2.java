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
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
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

public class Interface_graphique2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_break;
	private JTextField textField_Time_Video;
	private JTextField textField;
	private JTextField textField_Syringue_i;
	private JTextField textField_Syringue_a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_graphique2 frame = new Interface_graphique2();
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
	public Interface_graphique2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Field field = new Field(12.0, 8.0, 3, 2);

		Coordinate_Field coordinate = new Coordinate_Field(field);

		Arduino arduino = new Arduino();

		Arduino2 arduino2 = new Arduino2();

		ArrayList<Event> initilization_homing = new ArrayList<Event>();

		Initialisation initialization = new Initialisation(arduino);

		initilization_homing.add(initialization);

		ArrayList<Event> data = new ArrayList<Event>();

		Camera camera = new Camera();
		
		Motor2 motor2 = new Motor2();

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_List = new JPanel();
		contentPane.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));

		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(0, 1, 0, 0));

		// List
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_List = new JLabel("List of events");
		panel_List_titre.add(lblNewLabel_List);
		lblNewLabel_List.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_List.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		DefaultListModel<String> listData = new DefaultListModel();

		JList<String> list = new JList(listData);

		panel_1.add(list);

		JScrollPane scrollPane = new JScrollPane(list);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_List.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(4, 1, 0, 10));

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		panel_3.add(panel_5);

		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				listData.remove(selectedIndex);
				data.remove(selectedIndex);
				// }
				/*
				 * String text = listData.lastElement().toString(); if (!text.isEmpty()) { text
				 * = text.replaceFirst("(?s)[^\n]*\n?$", "");
				 * listData.removeElementAt(listData.getSize() - 1); } data.remove((data.size())
				 * - 1);
				 */
			}
		});

		ArrayList wellName = new ArrayList();
		wellName.add("A1");
		wellName.add("A2");
		wellName.add("A3");
		wellName.add("B1");
		wellName.add("B2");
		wellName.add("B3");

		JButton btnNewButton_4 = new JButton("Apply to all well");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 5;
				int size = listData.getSize();
				for (int i = 0; i < count; i++) {
					for (int j = 0; j < size; j++) {
						listData.addElement(listData.getElementAt(j));
						data.add(data.get(j));
					}
				}
				int l = 0;
				for (int k = 0; k < listData.getSize(); k++) {
					if (listData.getElementAt(k).toString().contains("A1") == true) {
						listData.remove(k);
						listData.add(k, wellName.get(l).toString());
						double coordinate_x = (coordinate.get_x_coordinate(coordinate.get_c(wellName.get(l).toString()))
								* 10);
						double coordinate_y = (coordinate.get_y_coordinate(coordinate.get_r(wellName.get(l).toString()))
								* 10);
						double coordinate_z = 35.0;
						double AB = Math.sqrt((coordinate_x * coordinate_x) + (coordinate_y * coordinate_y));
						double d1 = 70.91;
						double time;
						if (AB <= d1) {
							time = 532;
						} else {
							time = (0.532 + ((AB - 70.91) / 133.3)) * 1000;
						}
						data.set(k, new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino));
						l++;
					}
				}
			}
		});
		panel_5.add(btnNewButton_4);
		panel_5.add(btnNewButton_1);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Total time : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		String[] rep = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		panel_9.add(lblNewLabel_3);

		// Start
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JButton btnNewButton = new JButton("Start");
		panel_3.add(btnNewButton);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		panel_3.add(panel_8);

		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable stop = new Runnable() {
					@Override
					public void run() {
						arduino.Close();
						Camera camera = new Camera();
						ProcessBuilder processBuilder = new ProcessBuilder();
						processBuilder.command("bash", "-c", "kill -9 $(pidof raspistill raspivid)");
						try {
							camera.callBash(processBuilder);
						} catch (Exception f) {
							System.out.println("Camera: Error : " + f.getMessage());
							// logError("Camera: Error while taking picture: " + e.getMessage());
						}
					}

				};

				Thread t1 = new Thread(stop);
				t1.start();
			}
		});

		panel_8.add(btnNewButton_2);

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
		panel_Parameter_contenu.setLayout(new GridLayout(0, 2, 15, 15));

		JPanel panel_Mouvement = new JPanel();
		panel_Mouvement.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Mouvement);
		panel_Mouvement.setLayout(new GridLayout(3, 1, 15, 15));

		// Mouvement
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel_Mouvement = new JLabel("Mouvement");
		lblNewLabel_Mouvement.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Mouvement.add(lblNewLabel_Mouvement);

		JPanel panel = new JPanel();
		panel_Mouvement.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Well");
		panel.add(lblNewLabel_1);

		String[] well = { "A1", "A2", "A3", "B1", "B2", "B3" };
		JComboBox comboBox = new JComboBox(well);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getSelectedItem().toString();
			}
		});
		panel.add(comboBox);

		JPanel panel_7_1_1_1 = new JPanel();
		panel_Mouvement.add(panel_7_1_1_1);
		panel_7_1_1_1.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement((comboBox.getSelectedItem().toString() + "\n"));
				double coordinate_x = (coordinate
						.get_x_coordinate(coordinate.get_c(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_y = (coordinate
						.get_y_coordinate(coordinate.get_r(comboBox.getSelectedItem().toString())) * 10);
				double coordinate_z = 35.0;
				double AB = Math.sqrt((coordinate_x * coordinate_x) + (coordinate_y * coordinate_y));
				double d1 = 70.91;
				double time;
				if (AB <= d1) {
					time = 532;
				} else {
					time = (0.532 + ((AB - 70.91) / 133.3)) * 1000;
				}
				Mouvement well = new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino);
				data.add(well);
			}
		});
		panel_7_1_1_1.add(btnNewButton_1_1_1_1);

		// Break
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		JButton btnNewButton_Add_Break = new JButton("Add");
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
		panel_7.add(btnNewButton_Add_Break);

		// Picture
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		JPanel panel_7_1_1 = new JPanel();
		panel_Picture.add(panel_7_1_1);
		panel_7_1_1.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Picture" + "\n");
				Picture picture = new Picture(camera);
				data.add(picture);
			}
		});
		panel_7_1_1.add(btnNewButton_1_1_1);

		// Video
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		JButton btnNewButton_1_1 = new JButton("Add");
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

		panel_7_1.add(btnNewButton_1_1);

		JPanel panel_Syringe_injected = new JPanel();
		panel_Syringe_injected.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Syringe_injected);
		panel_Syringe_injected.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Syringue_i = new JLabel("Syringue injection");
		lblNewLabel_Syringue_i.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Syringe_injected.add(lblNewLabel_Syringue_i);

		JPanel panel_6_1_2 = new JPanel();
		panel_Syringe_injected.add(panel_6_1_2);
		panel_6_1_2.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblNewLabel_volume_i = new JLabel("Volume (ml.)");
		panel_6_1_2.add(lblNewLabel_volume_i);

		textField_Syringue_i = new JTextField();
		textField_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_i.setColumns(10);
		panel_6_1_2.add(textField_Syringue_i);

		JPanel panel_7_1_2 = new JPanel();
		panel_Syringe_injected.add(panel_7_1_2);
		panel_7_1_2.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_Syringue_i = new JButton("Add");
		btnNewButton_Syringue_i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_i.getText().isEmpty() == false) {
					listData.addElement("Syringue : " + textField_Syringue_i.getText() + " ml injected" + "\n");
					listData.addElement("Pause : injection" + "\n");
					Syringue_Injection injection = new Syringue_Injection(
							(Integer.parseInt(textField_Syringue_i.getText().toString())), arduino2);
					data.add(injection);
					Pause pause = new Pause((motor2.time(Double.valueOf(textField_Syringue_i.getText().toString()))));
					data.add(pause);
				} else {
					btnNewButton_Syringue_i.setEnabled(true);
				}
			}
		});
		panel_7_1_2.add(btnNewButton_Syringue_i);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);

		JComboBox comboBox_1 = new JComboBox(rep);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		

		JPanel panel_Syringe_aspirated = new JPanel();
		panel_Syringe_aspirated.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Syringe_aspirated);
		panel_Syringe_aspirated.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Syringue_a = new JLabel("Syringue aspiration");
		lblNewLabel_Syringue_a.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Syringe_aspirated.add(lblNewLabel_Syringue_a);

		JPanel panel_6_1_2_1 = new JPanel();
		panel_Syringe_aspirated.add(panel_6_1_2_1);
		panel_6_1_2_1.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblNewLabel_volume_a = new JLabel("Volume (ml.)");
		panel_6_1_2_1.add(lblNewLabel_volume_a);

		textField_Syringue_a = new JTextField();
		textField_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Syringue_a.setColumns(10);
		panel_6_1_2_1.add(textField_Syringue_a);

		JPanel panel_7_1_2_1 = new JPanel();
		panel_Syringe_aspirated.add(panel_7_1_2_1);
		panel_7_1_2_1.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_Syringue_a = new JButton("Add");
		btnNewButton_Syringue_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Syringue_a.getText().isEmpty() == false) {
					listData.addElement("Syringue : " + textField_Syringue_a.getText() + " ml aspirated" + "\n");
					listData.addElement("Pause : aspiration" + "\n");
					Syringue_Aspiration aspiration = new Syringue_Aspiration(
							(Integer.parseInt(textField_Syringue_a.getText().toString())), arduino2);
					data.add(aspiration);
					Pause pause = new Pause((motor2.time(Double.valueOf(textField_Syringue_a.getText().toString()))));
					data.add(pause);
				} else {
					btnNewButton_Syringue_a.setEnabled(true);
				}
			}
		});
		panel_7_1_2_1.add(btnNewButton_Syringue_a);
		
		
		// Home
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Home = new JPanel();
		panel_Home.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Home);
		panel_Home.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Home = new JLabel("Home");
		lblNewLabel_Home.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Home.add(lblNewLabel_Home);

		JPanel panel_6_1_1_1 = new JPanel();
		panel_Home.add(panel_6_1_1_1);
		panel_6_1_1_1.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_7_1_1_2 = new JPanel();
		panel_Home.add(panel_7_1_1_2);
		panel_7_1_1_2.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_1_1_1_2 = new JButton("Add");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Home" + "\n");
				Initialisation home = new Initialisation(arduino);
				data.add(home);
			}
		});
		panel_7_1_1_2.add(btnNewButton_1_1_1_2);

		// Repetitions
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Timer = new JPanel();
		panel_Parameter_contenu.add(panel_Timer);
		panel_Timer.setBorder(new LineBorder(Color.GRAY));
		panel_Timer.setLayout(new GridLayout(4, 1, 10, 10));

		JLabel lblNewLabel_3_1_1 = new JLabel("Repetition");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Timer.add(lblNewLabel_3_1_1);

		JPanel panel_4 = new JPanel();
		panel_Timer.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("<html>Number of repetition of the list</html>");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblNewLabel_2);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(comboBox_1, BorderLayout.EAST);

		JPanel panel_6_1_1_2 = new JPanel();
		panel_Timer.add(panel_6_1_1_2);
		panel_6_1_1_2.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_Time_Video_1 = new JLabel("<html>Time between repetitions(min)</html>");
		lblNewLabel_Time_Video_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_Time_Video_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6_1_1_2.add(lblNewLabel_Time_Video_1);

		textField.setColumns(10);
		panel_6_1_1_2.add(textField);

		JPanel panel_10 = new JPanel();
		panel_Timer.add(panel_10);

		JButton btnNewButton_3 = new JButton("Validate");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().toString().isEmpty()) {
					lblNewLabel_3
							.setText(
									"Total time (approximate) : "
											+ (Integer.parseInt(textField.getText().toString())
													* Integer.parseInt(comboBox_1.getSelectedItem().toString()))
											+ " min.");
				} else {
					lblNewLabel_3.setText("Total time : less than 1 min.");
				}
			}
		});
		panel_10.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("                  ");
		panel_10.add(label, BorderLayout.EAST);
		panel_10.add(btnNewButton_3);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				arduino.Start();
				arduino2.Start();
				arduino.event_go(initilization_homing);

				Timer timer = new Timer();

				TimerTask task = new TimerTask() {
					int n = 0;

					public void run() {

						n++;
						Start start = new Start();
						start.event_go(data);

						if (n == Integer.parseInt(comboBox_1.getSelectedItem().toString())) {
							timer.cancel();
							arduino.Close();
							arduino2.Close();
						}

					}
				};
				if (!textField.getText().toString().isEmpty()) {
					timer.scheduleAtFixedRate(task, 0, Integer.parseInt(textField.getText().toString()) * 60000);
				} else {
					timer.scheduleAtFixedRate(task, 0, 1);
				}

			}
		});
	}
}