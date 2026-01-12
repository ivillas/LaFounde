package FoundeD;

import java.util.Random;

public class Persona implements Runnable {
	
	private String nom;
	private int tempsCoure;
	private  Tenedors carn;
	private  Tenedors formatge;
	private Random rand = new Random();
	private boolean menjaCarn = false;
	private boolean menjaFormatge = false;
	
	
	
	public Persona(String nom, int tempsCoure,Boolean menjacarn,Boolean menjaformatje, Tenedors carn, Tenedors formatge) {
		this.nom = nom;
		this.tempsCoure = tempsCoure;
		this.menjaCarn = menjacarn;
		this.menjaFormatge = menjaformatje;
		this.carn = carn; 
		this.formatge = formatge;
		
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			try {
				boolean deCarn = rand.nextBoolean();
				/*
				if(menjaCarn && menjaFormatge) {
					System.out.println(nom + " probara en qualsevol fondue ja que menja de tot");
				}else if(menjaCarn && !menjaFormatge){
					System.out.println(nom + " probara fondue de carn ja que no menja formatge");
				}else if(!menjaCarn && menjaFormatge){
					System.out.println(nom + " probara fondue de formatge ja que no menja carn");
				}
				*/
				if(deCarn && menjaCarn) {
					carn.agafarTenedor(nom);
				System.out.println(nom + " esta cuinant carn duran " + tempsCoure + " segons");
				Thread.sleep(tempsCoure*1000);
				
				carn.deixarTenedor(nom);
				
				System.out.println(nom + " esta menjant carn");
				Thread.sleep(2000);
				
				}else if (!deCarn && menjaFormatge) {
					formatge.agafarTenedor(nom);
				System.out.println(nom + " esta cuinant formatge duran  " + tempsCoure + " segons");
				Thread.sleep(tempsCoure*1000);
				
				formatge.deixarTenedor(nom);
				
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
