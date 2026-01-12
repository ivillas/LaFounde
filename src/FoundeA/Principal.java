package FoundeA;

public class Principal {

	public static void main(String[] args) {

		final int n = 5;
		final int m = 3;
		
		Tenedors tenedor = new Tenedors(m);
		
		for (int i = 0; i < n; i++) {
            int tempsCuinar = 4 + (int) (Math.random() * 4); 
            new Thread(new Persona("persona " + (i+1), tempsCuinar, tenedor)).start();
        }
		

	}

}
