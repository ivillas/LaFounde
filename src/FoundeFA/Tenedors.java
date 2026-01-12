package FoundeFA;



/*
 * Clase que fara de monitor
 */

public class Tenedors {
	
	int tenedorsDisponibles;
	String tipus;
	int unitats;

	public Tenedors(int tenedorsDisponibles,  String tipus, int unitats) {
		this.tenedorsDisponibles = tenedorsDisponibles;
		this.tipus = tipus;
		this.unitats = unitats;
	}
		
	public int getTenedorsDisponibles() {
		return tenedorsDisponibles;
	}

	public void setTenedorsDisponibles(int tenedorsDisponibles) {
		this.tenedorsDisponibles = tenedorsDisponibles;
	}

	public synchronized boolean intentaagafarTenedor (String nom) throws InterruptedException{
		
		if( tenedorsDisponibles > 0 && unitats > 0) {
			tenedorsDisponibles--;
			System.out.println(nom + " ha agafat un tenedor de " + tipus );
			unitats--;
			if(unitats == 0) {
				System.out.println("Ja no queden mes unitats de " + tipus );
				return false;
			} else	System.out.println("Queden " + unitats + " de " + tipus);
			return true;
		}

		return false;
	}
	
	public synchronized void esperaTenedors (String nom) throws InterruptedException{
		if(tenedorsDisponibles==0) {
		System.out.println(nom + " espera per coure " + tipus + " ja que estan tots els tenedors ocupats");
		wait();
		}
	}
	
	public synchronized void deixarTenedor (String nom){
		tenedorsDisponibles++;
		System.out.println(nom + " ha deixat un tenedor per coure " + tipus);
		if (unitats >0) notifyAll();
	}
	
	public boolean disponibilitat () {
		return (unitats >0);
		
	}

}
