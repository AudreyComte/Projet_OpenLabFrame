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
import javax.sql.rowset.serial.SerialException;
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
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTabbedPane;

public class Interface_graphique2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_break;
	private JTextField textField_Time_Video;
	private JTextField textField_time_repetition;
	private JPanel panel_Preview;
	private JPanel panel_Parameter1;
	private JTextField textField_coordinate_x;
	private JTextField textField_coordinate_y;
	private JTextField textField_coordinate_z;
	private JPanel panel_well1;
	private JLabel lblNewLabel_111;
	private JPanel panel_time_break;
	private JPanel panel_add_break;
	private JPanel panel_number_repetition;
	private JLabel lblNewLabel_number_repetition;
	private JPanel panel_validate;
	private JButton btnNewButton_validate;
	private JPanel panel_list_contenu;
	private JPanel panel_parameter_list;
	private JPanel panel_parameter_list_2;
	private JPanel panel_add_remouve_list;
	private JButton btnNewButton_all_well;
	private JButton btnNewButton_remouve_list;
	private JPanel panel_total_time;
	private JButton btnNewButton_start_list;
	private JPanel panel_8_stop_list;
	private JButton btnNewButton_stop_list;

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
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SerialException
	 */
	public Interface_graphique2() throws SerialException, IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		Field field = new Field(12.0, 8.0, 3, 2);

		Coordinate_Field coordinate = new Coordinate_Field(field);

		// Panel Preview
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////

		ArrayList data_controller = new ArrayList();

		Arduino2 arduino2 = new Arduino2(data_controller);

		arduino2.arduino_openPort();

		Counter counter_x = new Counter(0.0);
		Counter counter_y = new Counter(0.0);
		Counter counter_z = new Counter(0.0);

		Counter counter2_x = new Counter(0.0);
		Counter counter2_y = new Counter(0.0);
		Counter counter2_z = new Counter(0.0);

		JPanel panel_Preview1 = new JPanel();
		tabbedPane.addTab("Preview", null, panel_Preview1, null);
		panel_Preview1.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_Preview1.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_44 = new JPanel();
		panel_44.setBackground(Color.LIGHT_GRAY);
		panel_10.add(panel_44);
		panel_44.setBorder(new LineBorder(Color.GRAY));
		panel_44.setLayout(new GridLayout(4, 3, 50, 0));

		JPanel panel_55 = new JPanel();
		panel_55.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_55);
		panel_55.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_56 = new JPanel();
		panel_56.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_56);
		panel_56.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_57 = new JPanel();
		panel_57.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_57);

		JPanel panel_58 = new JPanel();
		panel_58.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_58);
		panel_58.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_1_1 = new JLabel("Coordinate X Y Z");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		panel_58.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));

		JPanel panel_59 = new JPanel();
		panel_59.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_59);
		panel_59.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_60 = new JPanel();
		panel_60.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_60);
		panel_60.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_62 = new JPanel();
		panel_62.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_62);
		panel_62.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("X");
		panel_62.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_61 = new JPanel();
		panel_61.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_61);
		panel_61.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_5_1 = new JLabel("Y");
		panel_61.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_63 = new JPanel();
		panel_63.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_63);
		panel_63.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_5_2 = new JLabel("Z");
		panel_63.add(lblNewLabel_5_2);
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_70 = new JPanel();
		panel_70.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_70);
		panel_70.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel textArea_x = new JLabel();
		textArea_x.setHorizontalAlignment(SwingConstants.CENTER);
		panel_70.add(textArea_x);

		textArea_x.setText((counter_x.get_Counter()) + "");

		JPanel panel_64 = new JPanel();
		panel_64.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_64);
		panel_64.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel textArea_y = new JLabel();
		textArea_y.setHorizontalAlignment(SwingConstants.CENTER);
		panel_64.add(textArea_y);
		textArea_y.setText((counter_y.get_Counter()) + "");

		JPanel panel_65 = new JPanel();
		panel_65.setBackground(Color.LIGHT_GRAY);
		panel_44.add(panel_65);
		panel_65.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel textArea_z = new JLabel();
		textArea_z.setHorizontalAlignment(SwingConstants.CENTER);
		panel_65.add(textArea_z);
		textArea_z.setText((counter_z.get_Counter()) + "");

		JPanel panel_18_1 = new JPanel();
		panel_10.add(panel_18_1);
		panel_18_1.setLayout(new GridLayout(1, 1, 0, 0));

		JLabel lblNewLabel_1_2 = new JLabel("Relative coordinate");
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_18_1.add(lblNewLabel_1_2);

		JPanel panel = new JPanel();
		panel_Preview1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_71 = new JPanel();
		panel.add(panel_71);
		panel_71.setLayout(new GridLayout(5, 4, 15, 15));

		JPanel panel_1 = new JPanel();
		panel_71.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textArea_InPut = new JTextArea();
		// Button Set zero here //

		JButton btn_Origine = new JButton("Set zero here");
		panel_1.add(btn_Origine);
		btn_Origine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("G10 P0 L20 X0 Y0 Z0\n");
				arduino2.Save_Coordinate();
				arduino2.afficher_data_controller();
				/*
				 * try { try { arduino2.arduino_start(); } catch (SerialException e1) {
				 * e1.printStackTrace(); } } catch (IOException e1) { // TODO Auto-generated
				 * catch block e1.printStackTrace(); } catch (InterruptedException e1) { // TODO
				 * Auto-generated catch block e1.printStackTrace(); }
				 */
				data_controller.clear();
				counter_x.set_Counter(0.0);
				counter_y.set_Counter(0.0);
				counter_z.set_Counter(0.0);
				textArea_x.setText((counter_x.get_Counter()) + "");
				textArea_y.setText((counter_y.get_Counter()) + "");
				textArea_z.setText((counter_z.get_Counter()) + "");

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btn_Origine.setBackground(Color.YELLOW);
		btn_Origine.setFont(new Font("Dialog", Font.BOLD, 12));

		JPanel panel_2 = new JPanel();
		panel_71.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_71.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_24 = new JPanel();
		panel_71.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton_A1 = new JButton("Save as A1");
		btnNewButton_A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinate.setA1_x(Double.parseDouble(textArea_x.getText()));
				coordinate.setA1_y(Double.parseDouble(textArea_y.getText()));
				coordinate.setA1_z(Double.parseDouble(textArea_z.getText()));
			}
		});
		btnNewButton_A1.setForeground(Color.WHITE);
		btnNewButton_A1.setBackground(Color.MAGENTA);
		panel_24.add(btnNewButton_A1);

		JPanel panel_23 = new JPanel();
		panel_71.add(panel_23);
		panel_23.setLayout(new GridLayout(1, 1, 0, 0));

		ArrayList valeur = new ArrayList();

		JButton btnNewButton = new JButton("Step of 0.1 mm");
		JButton btnNewButton_4 = new JButton("Step of 1 mm");
		JButton btnNewButton_5 = new JButton("Step of 10 mm");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valeur.clear();
				valeur.add(0.1);
				btnNewButton.setBackground(Color.LIGHT_GRAY);
				if (btnNewButton_4.getBackground() == (Color.LIGHT_GRAY)
						|| btnNewButton_5.getBackground() == (Color.LIGHT_GRAY)) {
					btnNewButton_4.setBackground(UIManager.getColor("Button.background"));
					btnNewButton_5.setBackground(UIManager.getColor("Button.background"));
				}
			}
		});
		panel_23.add(btnNewButton);

		JPanel panel_25 = new JPanel();
		panel_71.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valeur.clear();
				valeur.add(1);
				btnNewButton_4.setBackground(Color.LIGHT_GRAY);
				if (btnNewButton.getBackground() == (Color.LIGHT_GRAY)
						|| btnNewButton_5.getBackground() == (Color.LIGHT_GRAY)) {
					btnNewButton.setBackground(UIManager.getColor("Button.background"));
					btnNewButton_5.setBackground(UIManager.getColor("Button.background"));
				}
			}
		});
		panel_25.add(btnNewButton_4);

		JPanel panel_17 = new JPanel();
		panel_71.add(panel_17);
		panel_17.setLayout(new GridLayout(1, 1, 0, 0));

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valeur.clear();
				valeur.add(10);
				btnNewButton_5.setBackground(Color.LIGHT_GRAY);
				if (btnNewButton.getBackground() == (Color.LIGHT_GRAY)
						|| btnNewButton_4.getBackground() == (Color.LIGHT_GRAY)) {
					btnNewButton.setBackground(UIManager.getColor("Button.background"));
					btnNewButton_4.setBackground(UIManager.getColor("Button.background"));
				}
			}
		});
		panel_17.add(btnNewButton_5);

		JPanel panel_15 = new JPanel();
		panel_71.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_71.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_71.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));

		// Button +Y //

		JButton btn_plus_Y = new JButton("+ Y");
		panel_13.add(btn_plus_Y);
		btn_plus_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_y.get_Counter() + "");
				counter_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				if (counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0
						& (counter2_y.get_Counter() < 90 & counter2_y.get_Counter() >= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0y" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) {
					 * 
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();
					textArea_y.setText((counter_y.get_Counter()) + "");
				} else {
					counter_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_plus_Y.setBackground(Color.CYAN);

		JPanel panel_5 = new JPanel();
		panel_71.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_71.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 1, 0, 0));

		// Button Z+ //

		JButton btn_plus_Z = new JButton("+ Z");
		panel_8.add(btn_plus_Z);
		btn_plus_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_z.get_Counter() + "");
				counter_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				if ((counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0)
						& (counter2_z.get_Counter() > -50 & counter2_z.get_Counter() <= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0z" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();
					textArea_z.setText((counter_z.get_Counter()) + "");
				} else {
					counter_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					// Thread.sleep(100);
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});
		btn_plus_Z.setBackground(Color.CYAN);

		JPanel panel_7 = new JPanel();
		panel_71.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 1, 0, 0));

		// Button -X //

		JButton btn_moins_X = new JButton("- X");
		panel_7.add(btn_moins_X);
		btn_moins_X.setBackground(Color.CYAN);

		JPanel panel_9 = new JPanel();
		panel_71.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 1, 0, 0));

		// Button Home //

		JButton btn_Home = new JButton("Home");
		panel_9.add(btn_Home);
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_controller.add("$H\n");
				arduino2.Save_Coordinate();
				arduino2.afficher_data_controller();
				/*
				 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
				 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
				 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
				 * (InterruptedException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
				data_controller.clear();
				counter_x.set_Counter(0.0);
				counter_y.set_Counter(0.0);
				counter_z.set_Counter(0.0);
				counter2_x.set_Counter(0.0);
				counter2_y.set_Counter(0.0);
				counter2_z.set_Counter(0.0);
				textArea_x.setText((counter_x.get_Counter()) + "");
				textArea_y.setText((counter_y.get_Counter()) + "");
				textArea_z.setText((counter_z.get_Counter()) + "");

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_Home.setForeground(new Color(255, 255, 255));
		btn_Home.setBackground(Color.BLUE);

		JPanel panel_6 = new JPanel();
		panel_71.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 1, 0, 0));

		// Button +X //

		JButton btn_plus_x = new JButton("+ X");
		panel_6.add(btn_plus_x);
		btn_plus_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_x.get_Counter() + "");
				counter_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				if ((counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0)
						& (counter2_x.get_Counter() < 130 & counter2_x.get_Counter() >= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0x" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();

					textArea_x.setText((counter_x.get_Counter()) + "");
				} else {
					counter_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_plus_x.setBackground(Color.CYAN);

		JPanel panel_11 = new JPanel();
		panel_71.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_26 = new JPanel();
		panel_71.add(panel_26);
		panel_26.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_21 = new JPanel();
		panel_71.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));

		// Button -Y //

		JButton btn_moins_Y = new JButton("- Y");
		panel_21.add(btn_moins_Y);
		btn_moins_Y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_y.get_Counter() + "");
				counter_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_y.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				if ((counter_y.get_Counter() < 90 & counter_y.get_Counter() >= 0)
						& (counter2_y.get_Counter() < 90 & counter2_y.get_Counter() >= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0y-" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();

					textArea_y.setText((counter_y.get_Counter()) + "");
				} else {
					counter_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_y.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_moins_Y.setBackground(Color.CYAN);

		JPanel panel_31 = new JPanel();
		panel_71.add(panel_31);
		panel_31.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_20 = new JPanel();
		panel_71.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 1, 0, 0));

		// Button -Z //

		JButton btn_moins_Z = new JButton("- Z");
		panel_20.add(btn_moins_Z);
		btn_moins_Z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_z.get_Counter() + "");
				counter_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_z.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				if ((counter_z.get_Counter() > -50 & counter_z.get_Counter() <= 0)
						& (counter2_z.get_Counter() > -50 & counter2_z.get_Counter() <= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0z-" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();

					textArea_z.setText((counter_z.get_Counter()) + "");
				} else {
					counter_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_z.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btn_moins_Z.setBackground(Color.CYAN);

		btn_moins_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(counter_x.get_Counter() + "");
				counter_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				counter2_x.less_Counter(Double.parseDouble(valeur.get(0).toString()));
				if ((counter_x.get_Counter() < 130 & counter_x.get_Counter() >= 0)
						& (counter2_x.get_Counter() < 130 & counter2_x.get_Counter() >= 0)) {
					data_controller.add("G91\n");
					data_controller.add("G0x-" + (Double.parseDouble(valeur.get(0).toString())) + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();

					textArea_x.setText((counter_x.get_Counter()) + "");
				} else {
					counter_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
					counter2_x.add_Counter(Double.parseDouble(valeur.get(0).toString()));
				}

				InputStream input_stream = arduino2.getInput();
				while (true) {
					char msg;
					try {
						if (input_stream.available() == 0) {
							break;
						}
						msg = (char) input_stream.read();
						textArea_InPut.append(msg + "");
						System.out.print(msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});

		JPanel panel_4 = new JPanel();
		panel_Preview1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_19 = new JPanel();
		panel_4.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(4, 3, 30, 0));

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
				if (Integer.parseInt((textField_coordinate_x.getText())) < 130
						& Integer.parseInt((textField_coordinate_x.getText())) >= 0) {
					data_controller.add("G90\n");
					data_controller.add("G0x" + textField_coordinate_x.getText() + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();
					counter_x.set_Counter(Double.parseDouble((textField_coordinate_x.getText())));
					textArea_x.setText((counter_x.get_Counter()) + "");

					InputStream input_stream = arduino2.getInput();
					while (true) {
						// Thread.sleep(100);
						char msg;
						try {
							if (input_stream.available() == 0) {
								break;
							}
							msg = (char) input_stream.read();
							textArea_InPut.append(msg + "");
							System.out.print(msg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
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
				if (Integer.parseInt((textField_coordinate_y.getText())) < 90
						& Integer.parseInt((textField_coordinate_y.getText())) >= 0) {
					data_controller.add("G90\n");
					data_controller.add("G0y" + textField_coordinate_y.getText() + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();
					counter_y.set_Counter(Double.parseDouble((textField_coordinate_y.getText())));
					textArea_y.setText((counter_y.get_Counter()) + "");

					InputStream input_stream = arduino2.getInput();
					while (true) {
						char msg;
						try {
							if (input_stream.available() == 0) {
								break;
							}
							msg = (char) input_stream.read();
							textArea_InPut.append(msg + "");
							System.out.print(msg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
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
				if (Integer.parseInt((textField_coordinate_z.getText())) > -50
						& Integer.parseInt((textField_coordinate_z.getText())) <= 0) {
					data_controller.add("G90\n");
					data_controller.add("G0z" + textField_coordinate_z.getText() + "\n");
					arduino2.Save_Coordinate();
					arduino2.afficher_data_controller();
					/*
					 * try { try { arduino2.arduino_start(); } catch (SerialException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); } } catch (IOException e1) {
					 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
					 * (InterruptedException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					data_controller.clear();
					counter_z.set_Counter(Double.parseDouble((textField_coordinate_z.getText())));
					textArea_z.setText((counter_z.get_Counter()) + "");

					InputStream input_stream = arduino2.getInput();
					while (true) {
						char msg;
						try {
							if (input_stream.available() == 0) {
								break;
							}
							msg = (char) input_stream.read();
							textArea_InPut.append(msg + "");
							System.out.print(msg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}
		});

		panel_38.add(btnNewButton_3);

		JPanel panel_39 = new JPanel();
		panel_19.add(panel_39);

		JPanel panel_40 = new JPanel();
		panel_19.add(panel_40);

		JPanel panel_41 = new JPanel();
		panel_19.add(panel_41);

		JPanel panel_67 = new JPanel();
		panel_19.add(panel_67);

		JPanel panel_68 = new JPanel();
		panel_19.add(panel_68);

		JPanel panel_69 = new JPanel();
		panel_19.add(panel_69);

		JPanel panel_18 = new JPanel();
		panel_4.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel panel_49 = new JPanel();
		panel_18.add(panel_49);

		JPanel panel_72 = new JPanel();
		panel_18.add(panel_72);

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
		panel_12.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_42 = new JPanel();
		panel_12.add(panel_42);
		panel_42.setLayout(new GridLayout(3, 2, 50, 0));

		JPanel panel_51 = new JPanel();
		panel_42.add(panel_51);

		JPanel panel_52 = new JPanel();
		panel_42.add(panel_52);

		// Button Stop //

		JButton btnNewButton_Stop = new JButton("Stop preview");
		panel_42.add(btnNewButton_Stop);
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
		panel_42.add(btnNewButton_Start);
		btnNewButton_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cross point = new Cross();
				ControllerCamera controller_cam = new ControllerCamera();
				Thread t = new Thread(controller_cam);
				t.start();
			}
		});
		btnNewButton_Start.setForeground(new Color(0, 0, 0));
		btnNewButton_Start.setBackground(Color.GREEN);
		btnNewButton_Start.setFont(new Font("Dialog", Font.BOLD, 12));

		JPanel panel_53 = new JPanel();
		panel_42.add(panel_53);

		JPanel panel_54 = new JPanel();
		panel_42.add(panel_54);

		// Parameter
		// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		panel_Parameter1 = new JPanel();
		tabbedPane.addTab("Parameter", null, panel_Parameter1, null);
		panel_Parameter1.setLayout(new BorderLayout(0, 0));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Arduino arduino = new Arduino();

		ArrayList<Event> initilization_homing = new ArrayList<Event>();

		Initialisation initialization = new Initialisation(arduino);

		initilization_homing.add(initialization);

		ArrayList<Event> data = new ArrayList<Event>();

		Camera camera = new Camera();

		// List
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_List = new JPanel();
		panel_Parameter1.add(panel_List, BorderLayout.EAST);
		panel_List.setLayout(new BorderLayout(0, 0));

		JPanel panel_List_titre = new JPanel();
		panel_List.add(panel_List_titre, BorderLayout.NORTH);
		panel_List_titre.setLayout(new GridLayout(0, 1, 0, 0));

		DefaultListModel listData = new DefaultListModel();

		ArrayList wellName = new ArrayList();
		wellName.add("A1");
		wellName.add("A2");
		wellName.add("A3");
		wellName.add("B1");
		wellName.add("B2");
		wellName.add("B3");

		JLabel lblNewLabel_List = new JLabel("List of events");
		panel_List_titre.add(lblNewLabel_List);
		lblNewLabel_List.setHorizontalAlignment(SwingConstants.CENTER);

		panel_list_contenu = new JPanel();
		panel_List.add(panel_list_contenu, BorderLayout.CENTER);
		panel_list_contenu.setLayout(new BorderLayout(0, 0));

		JList list = new JList(listData);

		panel_list_contenu.add(list);

		JScrollPane scrollPane_list = new JScrollPane(list);
		panel_list_contenu.add(scrollPane_list, BorderLayout.CENTER);

		panel_parameter_list = new JPanel();
		panel_List.add(panel_parameter_list, BorderLayout.SOUTH);
		panel_parameter_list.setLayout(new GridLayout(0, 1, 0, 0));

		panel_parameter_list_2 = new JPanel();
		panel_parameter_list.add(panel_parameter_list_2);
		panel_parameter_list_2.setLayout(new GridLayout(4, 1, 0, 10));

		panel_add_remouve_list = new JPanel();
		FlowLayout fl_panel_add_remouve_list = (FlowLayout) panel_add_remouve_list.getLayout();
		panel_parameter_list_2.add(panel_add_remouve_list);

		btnNewButton_remouve_list = new JButton("Remove");
		btnNewButton_remouve_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = listData.lastElement().toString();
				if (!text.isEmpty()) {
					text = text.replaceFirst("(?s)[^\n]*\n?$", "");
					listData.removeElementAt(listData.getSize() - 1);
				}
				data.remove((data.size()) - 1);
			}
		});

		btnNewButton_all_well = new JButton("Apply to all wells");
		btnNewButton_all_well.addActionListener(new ActionListener() {
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
						listData.add(k, wellName.get(l));
						double coordinate_x = (coordinate
								.get_x_coordinate(coordinate.get_c(wellName.get(l).toString())) * 10);
						double coordinate_y = (coordinate
								.get_y_coordinate(coordinate.get_r(wellName.get(l).toString())) * 10);
						double coordinate_z = coordinate.A1_z;
						data.set(k, new Mouvement(coordinate_x, coordinate_y,coordinate_z,arduino));
						l++;
					}
				}	
			}
		});
		panel_add_remouve_list.add(btnNewButton_all_well);
		panel_add_remouve_list.add(btnNewButton_remouve_list);

		panel_total_time = new JPanel();
		panel_parameter_list_2.add(panel_total_time);
		panel_total_time.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Total time : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);

		panel_total_time.add(lblNewLabel_3);

		// Start
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		btnNewButton_start_list = new JButton("Start");
		panel_parameter_list_2.add(btnNewButton_start_list);

		panel_8_stop_list = new JPanel();
		FlowLayout fl_panel_8_stop_list = (FlowLayout) panel_8_stop_list.getLayout();
		panel_parameter_list_2.add(panel_8_stop_list);

		btnNewButton_stop_list = new JButton("Stop");
		btnNewButton_stop_list.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_stop_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable stop = new Runnable() {
					@Override
					public void run() {
						arduino.Close();
					}
				};

				Thread t1 = new Thread(stop);
				t1.start();
			}
		});

		panel_8_stop_list.add(btnNewButton_stop_list);

		textField_time_repetition = new JTextField();
		textField_time_repetition.setHorizontalAlignment(SwingConstants.CENTER);

		String[] rep = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JComboBox comboBox_number_repetition = new JComboBox(rep);

		textField_time_repetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JPanel panel_parameter = new JPanel();
		panel_Parameter1.add(panel_parameter);
		panel_parameter.setLayout(new BorderLayout(0, 0));

		JPanel panel_Parameter_titre = new JPanel();
		panel_parameter.add(panel_Parameter_titre, BorderLayout.NORTH);
		panel_Parameter_titre.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel1 = new JLabel("Parameter");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Parameter_titre.add(lblNewLabel1);

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

		panel_well1 = new JPanel();
		panel_Mouvement.add(panel_well1);
		panel_well1.setLayout(new GridLayout(0, 2, 0, 0));

		String[] well = { "A1", "A2", "A3", "B1", "B2", "B3" };

		JComboBox comboBox_well1 = new JComboBox(well);
		comboBox_well1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_well1.getSelectedItem().toString();
			}
		});
		lblNewLabel_111 = new JLabel("Well");
		panel_well1.add(lblNewLabel_111);
		panel_well1.add(comboBox_well1);

		JPanel panel_add_well = new JPanel();
		panel_Mouvement.add(panel_add_well);
		panel_add_well.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_add_well1 = new JButton("Add");
		btnNewButton_add_well1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement((comboBox_well1.getSelectedItem().toString() + "\n"));
				double coordinate_x = (coordinate
						.get_x_coordinate(coordinate.get_c(comboBox_well1.getSelectedItem().toString())) * 10);
				double coordinate_y = (coordinate
						.get_y_coordinate(coordinate.get_r(comboBox_well1.getSelectedItem().toString())) * 10);
				double coordinate_z = coordinate.A1_z;

				Mouvement well = new Mouvement(coordinate_x, coordinate_y, coordinate_z, arduino);
				data.add(well);
			}
		});
		panel_add_well.add(btnNewButton_add_well1);

		// Break
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Break = new JPanel();
		panel_Break.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Break);
		panel_Break.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Break = new JLabel("Break");
		lblNewLabel_Break.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Break.add(lblNewLabel_Break);

		panel_time_break = new JPanel();
		panel_Break.add(panel_time_break);
		panel_time_break.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblNewLabel_Time_break = new JLabel("Time (sec.)");
		panel_time_break.add(lblNewLabel_Time_break);

		textField_break = new JTextField();
		textField_break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_time_break.add(textField_break);
		textField_break.setColumns(10);

		panel_add_break = new JPanel();
		panel_Break.add(panel_add_break);
		panel_add_break.setLayout(new GridLayout(0, 2, 15, 15));

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
		panel_add_break.add(btnNewButton_Add_Break);

		// Picture
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Picture = new JPanel();
		panel_Picture.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Picture);
		panel_Picture.setLayout(new GridLayout(3, 1, 15, 15));
		JLabel lblNewLabel_Picture11 = new JLabel("Picture");

		lblNewLabel_Picture11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Picture.add(lblNewLabel_Picture11);

		JPanel panel_vide1 = new JPanel();
		panel_Picture.add(panel_vide1);
		panel_vide1.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_add_picture = new JPanel();
		panel_Picture.add(panel_add_picture);
		panel_add_picture.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_add_picture = new JButton("Add");
		btnNewButton_add_picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Picture" + "\n");
				Picture picture = new Picture(camera);
				data.add(picture);
			}
		});
		panel_add_picture.add(btnNewButton_add_picture);

		// Video
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Video = new JPanel();
		panel_Video.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Video);
		panel_Video.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Video = new JLabel("Video");
		lblNewLabel_Video.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Video.add(lblNewLabel_Video);

		JPanel panel_time_video = new JPanel();
		panel_Video.add(panel_time_video);
		panel_time_video.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblNewLabel_Time_Video = new JLabel("Time (sec.)");
		panel_time_video.add(lblNewLabel_Time_Video);

		textField_Time_Video = new JTextField();
		textField_Time_Video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_Time_Video.setColumns(10);
		panel_time_video.add(textField_Time_Video);

		JPanel panel_add_video = new JPanel();
		panel_Video.add(panel_add_video);
		panel_add_video.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_add_video = new JButton("Add");
		btnNewButton_add_video.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_Time_Video.getText().isEmpty() == false) {
					listData.addElement("Video " + textField_Time_Video.getText() + " sec. record time" + "\n");
					Video video = new Video(camera,
							(Integer.parseInt(textField_Time_Video.getText().toString())) * 1000);
					data.add(video);
				} else {
					btnNewButton_add_video.setEnabled(true);
				}
			}
		});

		panel_add_video.add(btnNewButton_add_video);

		// Home
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Home = new JPanel();
		panel_Home.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Home);
		panel_Home.setLayout(new GridLayout(3, 1, 15, 15));

		JLabel lblNewLabel_Home = new JLabel("Home");
		lblNewLabel_Home.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Home.add(lblNewLabel_Home);

		JPanel panel_vide2 = new JPanel();
		panel_Home.add(panel_vide2);
		panel_vide2.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_add_home = new JPanel();
		panel_Home.add(panel_add_home);
		panel_add_home.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_add_home = new JButton("Add");
		btnNewButton_add_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listData.addElement("Home" + "\n");
				Initialisation home = new Initialisation(arduino);
				data.add(home);
			}
		});
		panel_add_home.add(btnNewButton_add_home);

		// Repetitions
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel panel_Timer = new JPanel();
		panel_Timer.setBorder(new LineBorder(Color.GRAY));
		panel_Parameter_contenu.add(panel_Timer);
		panel_Timer.setLayout(new GridLayout(4, 1, 10, 10));

		JLabel lblNewLabel_Repetition = new JLabel("Repetition");
		lblNewLabel_Repetition.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Timer.add(lblNewLabel_Repetition);

		panel_number_repetition = new JPanel();
		panel_Timer.add(panel_number_repetition);
		panel_number_repetition.setLayout(new BorderLayout(0, 0));

		lblNewLabel_number_repetition = new JLabel("<html>Number of repetition of the list</html>");
		lblNewLabel_number_repetition.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel_number_repetition.setHorizontalAlignment(SwingConstants.LEFT);
		panel_number_repetition.add(lblNewLabel_number_repetition);

		comboBox_number_repetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_number_repetition.add(comboBox_number_repetition, BorderLayout.EAST);

		JPanel panel_time_repetition = new JPanel();
		panel_Timer.add(panel_time_repetition);
		panel_time_repetition.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_Time_repetition = new JLabel("<html>Time between repetitions(min)</html>");
		lblNewLabel_Time_repetition.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_Time_repetition.setHorizontalAlignment(SwingConstants.CENTER);
		panel_time_repetition.add(lblNewLabel_Time_repetition);

		textField_time_repetition.setColumns(10);
		panel_time_repetition.add(textField_time_repetition);

		panel_validate = new JPanel();
		panel_Timer.add(panel_validate);

		btnNewButton_validate = new JButton("Validate");
		btnNewButton_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_time_repetition.getText().toString().isEmpty()) {
					lblNewLabel_3.setText("Total time (approximate) : "
							+ (Integer.parseInt(textField_time_repetition.getText().toString())
									* (Integer.parseInt(comboBox_number_repetition.getSelectedItem().toString())))
							+ " minutes");
				}
			}
		});
		panel_validate.setLayout(new BorderLayout(0, 0));

		JLabel label_vide3 = new JLabel("                  ");
		panel_validate.add(label_vide3, BorderLayout.EAST);
		panel_validate.add(btnNewButton_validate);

		JPanel panel_16 = new JPanel();
		contentPane.add(panel_16, BorderLayout.SOUTH);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));

		panel_16.add(textArea_InPut);

		JScrollPane scrollPane = new JScrollPane(textArea_InPut);
		panel_16.add(scrollPane);

		// Button Start
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		btnNewButton_start_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arduino2.arduino_closePort();
				} catch (SerialException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				arduino.Start();
				arduino.event_go(initilization_homing);

				Timer timer = new Timer();

				TimerTask task = new TimerTask() {
					int n = 0;

					public void run() {

						n++;
						arduino.event_go(data);

						if (n == Integer.parseInt(comboBox_number_repetition.getSelectedItem().toString())) {
							timer.cancel();
							arduino.Close();
						}
					}
				};

				timer.scheduleAtFixedRate(task, 0,
						Integer.parseInt(textField_time_repetition.getText().toString()) * 60000);

			}
		});

	}
}