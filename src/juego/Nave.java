package juego;

import java.awt.Color;

import entorno.Entorno;

public class Nave {
	
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private boolean conVida;
	private boolean seDisparo;
	

	Nave (int x, int y, int alto, int ancho)
	{
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;

		this.velocidad=3;
		this.conVida= true;
		this.seDisparo= false;
		
	}
	
	void refrescarPosicion(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.green);
	}
	

	void moverIzquierda() {
		this.x-= this.velocidad;
	}
	
	void moverDerecha() {
		this.x+= this.velocidad;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}
	
	
	public int getVelocidad() {
		return velocidad;
	}	
	
	public boolean getconVida() {
		return conVida;
	}
	
	public void setConVida(boolean conVida) {
		this.conVida = conVida;
	}
	
	public boolean getSeDisparo() {
		return seDisparo;
	}

	public void setSeDisparo(boolean seDisparo) {
		this.seDisparo = seDisparo;
	}


}
