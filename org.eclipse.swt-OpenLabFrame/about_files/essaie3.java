package about_files;



import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
	 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
	 
public class essaie3 {
	 
	  public essaie3(){
		  
		  	JTextArea textArea = new JTextArea(10, 20);
		  	final JProgressBar progressBar = new JProgressBar(0, 10);
	 
		  	final TacheParallele tâche = new TacheParallele();
		  	tâche.addPropertyChangeListener(new PropertyChangeListener(){  
		  		public void propertyChange(PropertyChangeEvent evt) {
		  			if ("progress".equals(evt.getPropertyName())) {
		  				progressBar.setValue((Integer) evt.getNewValue());
		  			}
		  		}
		      });
		  
		      JButton boutonLancer = new JButton("Lancer l'opération");
		      boutonLancer.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		          tâche.execute();
		        }
		      });
	 
		      JButton boutonAnnuler = new JButton("Annuler");
		      boutonAnnuler.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		          tâche.cancel(true);
		        }
		      });
	 
		      JPanel panelBoutons = new JPanel();
		      panelBoutons.add(boutonLancer);
		      panelBoutons.add(boutonAnnuler);
	 
		      JPanel cp = new JPanel();
		      LayoutManager layout = new BoxLayout(cp, BoxLayout.Y_AXIS);
		      cp.setLayout(layout);
		      cp.add(panelBoutons);
		      cp.add(new JScrollPane(textArea));
		      cp.add(progressBar);
	 
		      JFrame frame = new JFrame("Exemple SwingWorker");
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.setContentPane(cp);
		      frame.pack();
			  frame.setVisible(true);
	 
	  }
	 
	  public static void main(String[] args){
	    new essaie3();
	  }
	}
	 
	class TacheParallele extends SwingWorker<Integer, Integer> {
	  private static final int DELAY = 1000;
	 
	  public TacheParallele() {
	  }
	 
	 // A exécuter en arrière plan
	  protected Integer doInBackground() throws Exception {
	    int i = 0;
	    int count = 10;
	    while (!isCancelled() & i < count) {
	      i++;
	      publish(new Integer[] { i });
	      setProgress(count * i / count);
	      Thread.sleep(DELAY);
	    }
	 
	    return count;
	  }
	 
	  protected void processus(List<Integer> chunks) {
	    for (int i : chunks)
	      System.out.println(i);
	  }
	 
	  protected void arret() {
	    if (isCancelled())
	      System.out.println("Annuler");
	    else
	      System.out.println("Terminer");
	  }
	}	
