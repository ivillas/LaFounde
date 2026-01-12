package FoundeA;

public class Persona implements Runnable {
	
	private String nom;
	private int tempsCoure;
	private  Tenedors tenedors;
	
	public Persona(String nom, int tempsCoure, Tenedors tenedor) {
		this.nom = nom;
		this.tempsCoure = tempsCoure;
		this.tenedors = tenedor; 
	}
	
	@Override
	public void run() {
		
		while(true) {

			try {
				tenedors.agafarTenedor(nom);
				System.out.println(nom + " esta cuinant duran " + tempsCoure + " segons");
				Thread.sleep(tempsCoure*1000);
				
				tenedors.deixarTenedor(nom);
				
				System.out.println(nom + " esta menjant");
				Thread.sleep(2000);
								
			} catch (InterruptedException e) {
				System.out.println("Error " + e);
				break;
			}			
		}
	}

}
