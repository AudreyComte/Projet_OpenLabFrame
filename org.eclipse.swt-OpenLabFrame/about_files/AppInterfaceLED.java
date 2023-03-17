package about_files;

public class AppInterfaceLED {

	public static void main(String[] args) {
		// on assemble les pi�ces de la m�thode MVC, ici RVC
		View fenetreInterface = new View("Interface de contr�le d'une LED avec GPIO en Java");
		Robot raspiThermoCam = new Robot();
		ControllerCam controlActions = new ControllerCam(fenetreInterface, raspiThermoCam);
		controlActions.initControllerCam();
	}
}