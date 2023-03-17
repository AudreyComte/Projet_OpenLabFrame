package about_files;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class View {
	
	// View utilise Swing pour afficher interface utilisateur	
	
	// d�finit les attributs : les composants de l'inteface
	private JFrame frame; // fenetre
	private JPanel contentPane; // panneau
	private JButton btnAllumerLed; // bouton
	private JButton btnEteindreLed; // bouton
	private JButton btnResetGPIO; // bouton
	private JLabel lblTexteTitre; // Champ de texte
		
	// Instanciation : constructeur de View
	public View(String title) {
			
		// param�trage de la fenetre
		frame = new JFrame(title);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1000, 350, 350, 300);
		frame.setVisible(true);
		
		// param�trage du panneau
		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ajout des elements au panneau
		btnAllumerLed = new JButton("Allumer");
		btnEteindreLed = new JButton("Eteindre");
		btnResetGPIO = new JButton("Reset des ports GPIO");
		lblTexteTitre = new JLabel("Branchez une LED sur le port #18 du GPIO");
		lblTexteTitre.setPreferredSize(new Dimension(384, 50));
		lblTexteTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(btnAllumerLed, BorderLayout.WEST);
		contentPane.add(btnEteindreLed, BorderLayout.EAST);
		contentPane.add(btnResetGPIO, BorderLayout.SOUTH);
		contentPane.add(lblTexteTitre, BorderLayout.NORTH);
	}
	
	// methodes
	// on g�n�re les getters et les setters pour chaque �l�ment
	// getter permet de recuperer un element private avec une methode publique
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JButton getBtnAllumerLed() {
		return btnAllumerLed;
	}

	public JButton getBtnEteindreLed() {
		return btnEteindreLed;
	}

	public JButton getBtnResetGPIO() {
		return btnResetGPIO;
	}

	public JLabel getLblTexteTitre() {
		return lblTexteTitre;
	}
}
