package FoundeD;

/*
 * Clase que fara de monitor
 */

public class Tenedors {
	
	int tenedorsDisponibles;
	String tipus;

	public Tenedors(int tenedorsDisponibles, String tipus) {
		this.tenedorsDisponibles = tenedorsDisponibles;
		this.tipus = tipus;
	}
	
	public synchronized void agafarTenedor (String nom) throws InterruptedException{
		
		while( tenedorsDisponibles == 0) {
			System.out.println(nom + " Esta esperan un tenedor per coure " + tipus );
			wait();
		}
		
		tenedorsDisponibles--;
		System.out.println(nom + " Ha agafat un tenedor per coure " + tipus);
	}
	
	public synchronized void deixarTenedor (String nom){
		tenedorsDisponibles++;
		System.out.println(nom + " ha deixat un tenedor per coure " + tipus);
		notifyAll();

	}

}

