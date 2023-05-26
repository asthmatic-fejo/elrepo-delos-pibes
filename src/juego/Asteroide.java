package juego;


import java.awt.Color;
import java.util.Random;

import entorno.Entorno;

public class Asteroide {

	private int ancho;
	private int alto;
	private int velocidad;
	private int movimiento;
	Random random = new Random();
	private int x;
	private int y;

	public Asteroide(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 1;
		this.movimiento = random.nextInt(3);

	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.blue);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	
	void moverDiagonalDerecha() {
		this.y += this.velocidad;
		this.x += this.velocidad * this.movimiento;
	}
	
	void moverDiagonalIzquierda() {
		this.y += this.velocidad;
		this.x += this.velocidad * this.movimiento;
	}
	
	void moverHaciaAbajo() {
		this.y += this.velocidad;
	}
	
	public void invertirMovimiento() {
		this.movimiento = (-movimiento);
	}
	
	
	void animarMovimiento(Entorno entorno) {
		this.dibujarse(entorno);
		if(this.movimiento ==1) {
			moverDiagonalDerecha();
		} else
			
		{if (this.movimiento==2) {
			moverDiagonalIzquierda();
			}
		else {
			moverHaciaAbajo();
		}
		}
		
	}
}
