package FoundeC;

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

				if(deCarn) {
					
					if(carn.intentaagafarTenedor(nom)) {
						cuinanCarn();
					} else {
						System.out.println(nom + " volia carn pero esta ocupada, probara formatge ");
						if(formatge.intentaagafarTenedor(nom)) {
							cuinantFormatge();
						}else esperantTotesOcupades();
					}
				}else{
					if(formatge.intentaagafarTenedor(nom)) {
						cuinantFormatge();
					}else {
						System.out.println(nom + " volia formatge pero esta ocupada, probara carn ");
						if(carn.intentaagafarTenedor(nom)) {
							cuinanCarn();
						}else esperantTotesOcupades();
					}
					}
						
					
			}catch (Exception e) {}
		}
		
	}
	
	private void esperantTotesOcupades() throws InterruptedException{
		
		boolean deCarn = rand.nextBoolean();
		if(deCarn) {
			System.out.println(nom + " No ha trobat cap tenedor lliure, esperant a la founde de carn ");
			carn.esperaTenedors(nom);
		} else {
			System.out.println(nom + " No ha trobat cap tenedor lliure, esperant a la founde de formatge ");
			formatge.esperaTenedors(nom);
		}
		
	}
	
	private void cuinanCarn() throws InterruptedException{
        System.out.println(nom + " està cuinant carn durant " + tempsCoure + " segons.");
        Thread.sleep(tempsCoure * 1000);
        
        carn.deixarTenedor(nom);

        System.out.println(nom + " està menjant carn.");
        Thread.sleep(2000);
		
	}
	
	
	private void cuinantFormatge() throws InterruptedException{
		System.out.println(nom + " està cuinant formatge durant " + tempsCoure + " segons.");
		Thread.sleep(tempsCoure*1000);
		
		formatge.deixarTenedor(nom);
		
		System.out.println(nom + " està menjant formatge.");
		Thread.sleep(2000);
	}

}
