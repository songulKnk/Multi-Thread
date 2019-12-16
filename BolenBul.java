
import java.io.FileWriter;
import java.io.IOException;

class Bolen extends Thread {
		
		int altLimit, ustLimit;

	public Bolen(int altLimit, int ustLimit) {
			super();
			this.altLimit = altLimit;
			this.ustLimit = ustLimit;
		}



	public void run() {
		int bolenSayisi = 0;
		int maxBolenSayisi = 0;
		int maxSayi = 0;

		long startTime = System.nanoTime();
		for (int i =altLimit; i < ustLimit; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					bolenSayisi++;
				}
			}
			if (bolenSayisi > maxBolenSayisi) {
				maxBolenSayisi = bolenSayisi;
				maxSayi = i;
			}
			bolenSayisi = 0;

		}
		System.out.println("\nSayi: " + maxSayi + " Bölen Sayýsý: " + maxBolenSayisi);
		long endTime = System.nanoTime();
		long estimatedTime = endTime - startTime;
		double seconds = (double) estimatedTime / 1000000000;
		System.out.println("süre: " + seconds);

		
		try {
			FileWriter dosya = new FileWriter (this.getName());
			dosya.write(maxSayi + maxBolenSayisi);
			dosya.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	}
	
	
	
	
	
	public class BolenBul extends Thread{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bolen thread1 = new Bolen(1, 25000);
		thread1.setName("1.txt");
		thread1.start();
		
		Bolen thread2 = new Bolen(25001,50000);
		thread2.setName("2.txt");
		thread2.start();
		
		Bolen thread3 = new Bolen(50001, 75000);
		thread3.setName("3.txt");
		thread3.start();
		
		Bolen thread4 = new Bolen(75001, 100000); 
		thread4.setName("4.txt");
		thread4.start();
		

	
	}

}
