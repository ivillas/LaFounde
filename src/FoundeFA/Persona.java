package FoundeFA;

import java.util.Random;

public class Persona implements Runnable {
	
	private String nom;
	private int tempsCoure;
	private  Tenedors carn;
	private  Tenedors formatge;
	private Random rand = new Random();
	private boolean menjaCarn = false;
	private boolean menjaFormatge = false;
	public boolean disponibleCarn = true;
	public boolean disponibleFormatge = true;
		
	public Persona(String nom, int tempsCoure,Boolean menjacarn,Boolean menjaformatje, Tenedors carn, Tenedors formatge) {
		this.nom = nom;
		this.tempsCoure = tempsCoure;
		this.menjaCarn = menjacarn;
		this.menjaFormatge = menjaformatje;
		this.carn = carn; 
		this.formatge = formatge;
	}
	
	public boolean isDisponibleCarn() {
		return disponibleCarn;
	}

	public void setDisponibleCarn(boolean disponibleCarn) {
		this.disponibleCarn = disponibleCarn;
	}

	public boolean isDisponibleFormatge() {
		return disponibleFormatge;
	}

	public void setDisponibleFormatge(boolean disponibleFormatge) {
		this.disponibleFormatge = disponibleFormatge;
	}

	@Override
	public void run() {
		
		while(disponibleCarn || disponibleFormatge) {			
			if(!disponibleCarn && !disponibleFormatge) {
				System.out.println("No queden unitats de menjar, tancant aplicacio...");
				System.exit(0);
			}	
			try {
				boolean deCarn = rand.nextBoolean();
				/*
				if(menjaCarn && menjaFormatge) {
					System.out.println(nom + " Probara amb la carn i so no amb el formatge ja que menja de tot");
					}else if(!menjaCarn && menjaFormatge) {
						System.out.println(nom + " Probara amb el formatge ja que no menja carn");
					}else if(menjaCarn && !menjaFormatge) {
						System.out.println(nom + " Probara amb la carn ja que no menja formatge");
					}
					*/
				
				if(deCarn && menjaCarn && disponibleCarn) {
					if(carn.intentaagafarTenedor(nom)) {
						cuinanCarn();
					} else if (menjaFormatge) {
						System.out.println(nom + " volia carn pero esta ocupada, probara formatge ");
						if(formatge.intentaagafarTenedor(nom)) {
							cuinantFormatge();
						}else esperantTotesOcupades();
					}
				}else if(!deCarn && menjaFormatge && disponibleFormatge) {
					if(formatge.intentaagafarTenedor(nom)) {
						cuinantFormatge();
					}else if(menjaCarn){
						System.out.println(nom + " volia formatge pero esta ocupada, probara carn ");
						if(carn.intentaagafarTenedor(nom)) {
							cuinanCarn();
						}else esperantTotesOcupades();
					}
					}
						
					
			}catch (Exception e) {}
		}
		
		if(!disponibleCarn && !disponibleFormatge) {
			System.out.println("No queden unitats de menjar, tancant aplicacio...");
			System.exit(0);
		}		
	}
	
	private void esperantTotesOcupades() throws InterruptedException{
		boolean deCarn = false;
		if(menjaCarn && menjaFormatge) {
		deCarn = rand.nextBoolean();
		}else if(!menjaCarn && menjaFormatge) {
			deCarn=false;
		}else if(menjaCarn && !menjaFormatge) {
			deCarn=true;
		}
		if(deCarn && disponibleCarn) {
			System.out.println(nom + " No ha trobat cap tenedor lliure, esperant a la founde de carn ");
			carn.esperaTenedors(nom);
		} else if(disponibleFormatge){
			System.out.println(nom + " No ha trobat cap tenedor lliure, esperant a la founde de formatge ");
			formatge.esperaTenedors(nom);
		}		
	}
	
	private void cuinanCarn() throws InterruptedException{
        System.out.println(nom + " està cuinant carn durant " + tempsCoure + " segons.");
        Thread.sleep(tempsCoure * 1000);

        carn.deixarTenedor(nom);
		if(!carn.disponibilitat()) {
			System.out.println("Ja no queden mes unitats de carn");
			disponibleCarn = false;
			System.out.println(disponibleCarn);;
		}
        System.out.println(nom + " està menjant carn.");
        Thread.sleep(2000);
	}
	
	
	private void cuinantFormatge() throws InterruptedException{
		System.out.println(nom + " està cuinant formatge durant " + tempsCoure + " segons.");
		Thread.sleep(tempsCoure*1000);
		
		formatge.deixarTenedor(nom);
		if(!formatge.disponibilitat()) {
			System.out.println("Ja no queden mes unitats de Formatge");
			disponibleFormatge = false;
			System.out.println(disponibleFormatge);
		}
		System.out.println(nom + " està menjant formatge.");
		Thread.sleep(2000);

	}
	
}
