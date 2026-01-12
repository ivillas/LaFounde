package FoundeA;

/*
 * Clase que fara de monitor
 */

public class Tenedors {
	
	int tenedorsDisponibles;

	public Tenedors(int tenedorsDisponibles) {
		this.tenedorsDisponibles = tenedorsDisponibles;
	}
	
	public synchronized void agafarTenedor (String nom) throws InterruptedException{
		
		while( tenedorsDisponibles == 0) {
			System.out.println(nom + " Esta esperan un tenedor ");
			wait();
		}
		notifyAll();
		tenedorsDisponibles--;
		System.out.println(nom + " Ha agafat un tenedor ");

	}
	
	public synchronized void deixarTenedor (String nom){
		tenedorsDisponibles++;
		System.out.println(nom + " ha deixat un tenedor");
		notifyAll();

	}

}
