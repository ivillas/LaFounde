package FoundeC;

public class Principal {

	public static void main(String[] args) {

		final int n = 7;
		final int m = 3;
		final int p = 2;
		
		Tenedors carn = new Tenedors(m,"carn");
		Tenedors formatge = new Tenedors(p,"formatge");
		for (int i = 0; i < n; i++) {
            int tempsCuinar = 4 + (int) (Math.random() * 4); 
            new Thread(new Persona("persona "+ (i+1), tempsCuinar, carn,formatge)).start();
        }
		

	}

}
