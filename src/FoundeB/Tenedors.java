package FoundeB;

/*
 * Clase que fara de monitor
 */

public class Tenedors {
	
	int tenedorsDisponibles;

	public Tenedors(int tenedorsDisponibles) {
		this.tenedorsDisponibles = tenedorsDisponibles;
	}
	
	public synchronized void agafarTenedor (String nom, String tipus) throws InterruptedException{
		
		while( tenedorsDisponibles == 0) {
			System.out.println(nom + " Esta esperan un tenedor per coure " + tipus );
			wait();
		}
		
		tenedorsDisponibles--;
		System.out.println(nom + " Ha agafat un tenedor per coure " + tipus);
		notifyAll();
	}
	
	public synchronized void deixarTenedor (String nom, String tipus){
		tenedorsDisponibles++;
		System.out.println(nom + " ha deixat un tenedor per coure " + tipus);
		notifyAll();

	}

}
