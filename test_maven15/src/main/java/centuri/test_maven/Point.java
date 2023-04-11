package centuri.test_maven;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

public class Point extends JPanel {

	/**
	 * Create the panel.
	 */
	public Point() {
		setBackground(Color.WHITE);
		setForeground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		add(lblNewLabel);

	}

}
