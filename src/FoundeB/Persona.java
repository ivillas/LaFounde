package FoundeB;

import java.util.Random;

public class Persona implements Runnable {
	
	private String nom;
	private int tempsCoure;
	private  Tenedors carn;
	private  Tenedors formatge;
	private Random rand = new Random();
		
	public Persona(String nom, int tempsCoure, Tenedors carn, Tenedors formatge) {
		this.nom = nom;
		this.tempsCoure = tempsCoure;
		this.carn = carn; 
		this.formatge = formatge;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				boolean deCarn = rand.nextBoolean();
				Tenedors tenedorActual;
				//if (deCarn) tenedorActual = carn; else tenedorActual = formatge;
				
				if(deCarn) {
					carn.agafarTenedor(nom, "carn");
					System.out.println(nom + " esta cuinant carn duran " + tempsCoure + " segons");
					Thread.sleep(tempsCoure*1000);
					
					carn.deixarTenedor(nom, "carn");
					
					System.out.println(nom + " esta menjant carn");
					Thread.sleep(2000);
			
				}else{
					formatge.agafarTenedor(nom, "Formatge");
					System.out.println(nom + " esta cuinant formatge duran  " + tempsCoure + " segons");
					Thread.sleep(tempsCoure*1000);
					
					formatge.deixarTenedor(nom, "formatge");
					
					System.out.println(nom + " esta menjant formatge");
					Thread.sleep(2000);
								
				}	
			} catch (InterruptedException e) {
				System.out.println("Error " + e);
				break;
			}
			
		}
			
	}
	
}
