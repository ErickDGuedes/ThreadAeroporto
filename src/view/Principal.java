package view;
import java.util.concurrent.Semaphore;
import controller.ThreadAeroporto;


public class Principal {

	public static void main(String[] args) {
		int permissoes = 2;
		Semaphore semaforo = new Semaphore(permissoes);
		//Pista Norte
		for(int i=1; i<13 ; i++) {
		ThreadAeroporto aero = new ThreadAeroporto(semaforo, "Norte", i);
		aero.start();			
		}
		//Pista Sul
		for(int i=1; i<13 ; i++) {
			ThreadAeroporto aero = new ThreadAeroporto(semaforo, "Sul", i);
			aero.start();			
		}
	}

}
