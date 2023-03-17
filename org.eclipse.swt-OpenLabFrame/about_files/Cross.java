package about_files;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Cross extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Cross() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cross frame = new Cross();
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
	public Cross() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 70));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
