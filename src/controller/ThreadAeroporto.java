package controller;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {
	
	Semaphore semaforo;
	String pista;
	int numAviao;
	//Construtor
	public ThreadAeroporto(Semaphore semaforo, String pista, int numAviao) {
		this.semaforo = semaforo;
		this.pista = pista;
		this.numAviao = numAviao;
		
	}
	//Método Run()
	public void run() {
		Manobrar();
		Taxiar();
		try {
			semaforo.acquire();
			Decolagem();
			Afastamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	//Manobrar Avião
	public void Manobrar() {
		Random random = new Random();
		int manobrar = random.nextInt(3, 8);
		System.out.println("Aviao num. "+numAviao+" //Pista "+pista+" manobrou por ==> "+manobrar+"s.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Taxiar Avião
	public void Taxiar() {
		Random random = new Random();
		int taxiar = random.nextInt(5, 11);
		System.out.println("Aviao num. "+numAviao+" //Pista "+pista+" taxiou por ==> "+taxiar+"s.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Decolar Avião
	public void Decolagem() {
		Random random = new Random();
		int decolou = random.nextInt(1, 5);
		System.out.println("Aviao num. "+numAviao+" //Pista "+pista+" entrou em fase de decolagem por ==>"+decolou+"s.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Decolagem e afastamento do Avião
	public void Afastamento() {
		Random random = new Random();
		int afastou = random.nextInt(3, 9);
		System.out.println("Aviao num. "+numAviao+" //Pista "+pista+" se afastou em ==> "+afastou+"s.");
		System.out.println("Aviao num. "+numAviao+" //Pista "+pista+" Decolou");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
