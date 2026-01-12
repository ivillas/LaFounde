package FoundeE;

import java.util.Random;



public class Principal {

	public static void main(String[] args) {

		final int n = 7;
		final int m = 3;
		final int p = 2;
		Random random = new Random();
		
		Tenedors carn = new Tenedors(m,"carn");
		Tenedors formatge = new Tenedors(p,"formatge");
		for (int i = 0; i < n; i++) {
            int tempsCuinar = 4 + (int) (Math.random() * 4); 
            boolean menjaCarn = random.nextBoolean();
            boolean menjaFormatge = random.nextBoolean(); 
            while(!menjaCarn && !menjaFormatge) {
                menjaCarn = random.nextBoolean();
                menjaFormatge = random.nextBoolean(); 
            }
            System.out.println("persona " + (i+1) + " Menja Formatge: " + menjaFormatge + " , Menja Carn: " + menjaCarn);
            new Thread(new Persona("persona "+ (i+1), tempsCuinar,menjaCarn,menjaFormatge, carn,formatge)).start();
        }
		

	}

}
