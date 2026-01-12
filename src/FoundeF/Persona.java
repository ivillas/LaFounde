package FoundeF;

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
		
		while(!noMesUnitats()) {
			
			try {
				boolean deCarn = rand.nextBoolean();
			
				if(deCarn && menjaCarn && carn.unitats >0) {
					if(carn.intentaagafarTenedor(nom)) {
						cuinanCarn();
					} else if (menjaFormatge) {
						System.out.println(nom + " volia carn pero esta ocupada, probara formatge ");
						if(formatge.intentaagafarTenedor(nom)) {
							cuinantFormatge();
						}else esperantTotesOcupades();
					}
				}else if(!deCarn && menjaFormatge && formatge.unitats >0) {
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
		
		if(noMesUnitats()) {
			System.out.println("no queden mes unitats per cuinar, tancant aplicacio...");
			System.exit(1);
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
	
	private synchronized boolean noMesUnitats(){
		if(carn.unitats==0 && formatge.unitats==0) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else return false;
	}
}
