package graph;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Elements.Equipe;
import contr�le.Jcontr�le;
import jeux.Etat;



public class Screen extends JFrame {

	JPanel pan = new JPanel();
	public static double dt=0.001;
	Jcontr�le jc;
	int joueurcontrol�e=0;
	Equipe equipe;
	public Screen(Equipe equipe)
	{
	    //D�finit un titre pour notre fen�tre
	    this.setTitle("Screen");
	    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(1018,640);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Et enfin, la rendre visible        
	    this.setVisible(true);
       //couleur du fond 
	    pan.setBackground(Color.DARK_GRAY);
	   //on applique � notre �cran
	    jc=new Jcontr�le(equipe);
	    this.addKeyListener(jc);
	    this.equipe=equipe;
	    }
	
	public Screen(Etat etat)
	{
	    //D�finit un titre pour notre fen�tre
	    this.setTitle("Screen");
	    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(1018,640);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Et enfin, la rendre visible        
	    this.setVisible(true);
       //couleur du fond 
	    pan.setBackground(Color.DARK_GRAY);
	   //on applique � notre �cran
	    jc=new Jcontr�le(etat.getequipe1());
	    this.addKeyListener(jc);
	    
	    }

	
	public void modifPan(Pan pan){
		
		this.pan=pan;
		this.setContentPane(pan);
	   
	}
	
	public JPanel getPan(){
		
		return pan;
		
	}
	
	
	 public void refresh(){
		    
		      pan.repaint();  
		      try {
		        Thread.sleep(10);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		     
		}
	 
	public Jcontr�le getjccontr�le()
	 {
		 return jc;
	 }
	
	public void updatejoueurcontrol�e()
	{  
		
		jc.setJoueur();
		jc.accelJoueur();
		this.joueurcontrol�e=jc.getjoueur();
		((Pan) this.pan).updatejoueurcontrol�e(joueurcontrol�e);
	}
	
	public void updatepuissancej(){
		((Pan) this.pan).updatepuissancej(jc.getpuissance());
	}
	 
	public void update(){
		this.updatejoueurcontrol�e();
		this.updatepuissancej();
	}
	 
	
	 
}



