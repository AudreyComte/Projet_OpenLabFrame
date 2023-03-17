package about_files;

public class ControllerCam {
	// attributs
	private View Cam2;
	private Robot robot;

	// constructeur
	public ControllerCam(View v, Robot r) {
		Cam2 = v;
		robot = r;
	}

	// methodes
	// action des boutons
	public void initControllerCam() {		
		Cam2.getBtnResetGPIO().addActionListener(event -> robot.resetGPIO());
		Cam2.getBtnAllumerLed().addActionListener(event -> robot.allumerLed(robot.getLed18()));
		Cam2.getBtnEteindreLed().addActionListener(event -> robot.eteindreLed(robot.getLed18()));
	}
	
	// evenements lors d'un appui sur bouton
	
}
