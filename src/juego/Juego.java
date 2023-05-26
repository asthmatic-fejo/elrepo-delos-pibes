package juego;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	// ...

	private List<Destructor> destructores = new ArrayList<>();
	private List<Asteroide> asteroides = new ArrayList<>();

	private boolean seguirJugando = true;

	private Nave nave;
	private int tiempo;
	Random rand;
	private Proyectil proyectil;

	private int getLimitedRandom(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo ... - v1", 800, 600);

		// Inicializar lo que haga falta para el juego
		// ...

		this.nave = new Nave(400, 500, 50, 100);

		this.proyectil = new Proyectil(0, 0, 0, 0, 0);

		destructores.add(new Destructor(this.getLimitedRandom(1, 100), 0, 50, 50));
		destructores.add(new Destructor(this.getLimitedRandom(201, 300), 0, 50, 50));
		destructores.add(new Destructor(this.getLimitedRandom(401, 500), 0, 50, 50));
		destructores.add(new Destructor(this.getLimitedRandom(601, 700), 0, 50, 50));

//		asteroides.add(new Asteroide(this.getLimitedRandom(101, 200), this.getLimitedRandom(1,300), 50, 50));
//		asteroides.add(new Asteroide(this.getLimitedRandom(301, 400), this.getLimitedRandom(1,300), 50, 50));
//		asteroides.add(new Asteroide(this.getLimitedRandom(501, 600), this.getLimitedRandom(1,300), 50, 50));
//		asteroides.add(new Asteroide(this.getLimitedRandom(701, 799), this.getLimitedRandom(1,300), 50, 50));

		// Inicia el juego!

		this.entorno.iniciar();

	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		tiempo++;
//		System.out.println(tiempo);
		// Procesamiento de un instante de tiempo
		// ...

		nave.refrescarPosicion(entorno);
		animarMovimientoNave();
		animarProyectil();
		animarMovimientoDestructores(destructores);
//		animarMovimientoAsteroides(asteroides);
//		rebotarAsteroides(asteroides);
//		rebotarAsteroidesConDestructores(asteroides, destructores);

	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}

	private void animarMovimientoNave() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
				&& this.nave.getX() + this.nave.getAncho() / 2 < this.entorno.ancho()) {
			this.nave.moverDerecha();
		}
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
				&& this.nave.getX() - this.nave.getAncho() / 2 > 0) {
			this.nave.moverIzquierda();
		}
	}

	private void animarProyectil() {
		if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && nave.getSeDisparo() == false) {
			this.proyectil = new Proyectil(nave.getX(), 500, 50, 30, 0);
		}
		if (proyectil.getY() > 0) {
			proyectil.dibujarse(entorno);
			proyectil.movermas();
			nave.setSeDisparo(true);
		} else {
			nave.setSeDisparo(false);
		}
	}

	public void animarMovimientoDestructores(List<Destructor> destructores) {

		for (Destructor destructor : destructores) {
			destructor.animarMovimientoDestructor(entorno, destructores);
		}

	}

//	public void animarMovimientoAsteroides(List lista) {
//
//		for (int i = 0; i < lista.size(); i++) {
//			Asteroide asteroide1 = (Asteroide) lista.get(i);
//			asteroide1.animarMovimiento(entorno);
//		}
//
//	}

//	public void rebotarAsteroides(List lista) {
//		for (int i = 0; i < lista.size(); i++) {
//			Asteroide asteroide1 = (Asteroide) lista.get(i);
//			for (int j = 0; j < lista.size(); j++) {
//				Asteroide asteroide2 = (Asteroide) lista.get(j);
//				if (asteroide2.getX() + asteroide2.getAncho() == asteroide1.getX() + asteroide1.getAncho()
//						|| asteroide2.getY() + asteroide2.getAlto() == asteroide1.getY() + asteroide1.getAlto()) {
//					asteroide2.invertirMovimiento();
//					asteroide1.invertirMovimiento();
//				}
//			}
//
//		}
//
//	}
//
//	
//	public void rebotarAsteroidesConDestructores(List listaDeAsteroides, List listaDeDestructores) {
//		for (int i = 0; i < listaDeAsteroides.size(); i++) {
//			Asteroide asteroide = (Asteroide) listaDeAsteroides.get(i);
//			for (int j = 0; j < listaDeDestructores.size(); j++) {
//				Destructor destructor = (Destructor) listaDeDestructores.get(j);
//				if (destructor.getX() < asteroide.getX() + asteroide.getAncho() &&
//					    destructor.getX() + destructor.getAncho() > asteroide.getX() &&
//					    destructor.getY() < asteroide.getY() + asteroide.getAlto() &&
//					    destructor.getY() + destructor.getAlto() > asteroide.getY()) {
//					    destructor.invertirMovimiento();
//					    asteroide.invertirMovimiento();
//					}
//			}
//		}
//
//	}
//	

}
