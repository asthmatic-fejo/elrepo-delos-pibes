package juego;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import entorno.Entorno;

public class Destructor {

	private int ancho;
	private int alto;
	private int velocidad;
	private int movimiento;
	private boolean seDisparo;
	Random random = new Random();
	private int x;
	private int y;

	Destructor(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 1;
		this.movimiento = random.nextInt(2) == 0 ? 1 : -1;
		this.seDisparo = false;
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

	public boolean getSeDisparo() {
		return seDisparo;
	}

	public void setSeDisparo(boolean seDisparo) {
		this.seDisparo = seDisparo;
	}

	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.RED);
	}

	void moverDiagonalDerecha() {
		this.y += this.velocidad;
		this.x += this.velocidad * this.movimiento;
	}

	void moverDiagonalIzquierda() {
		this.y += this.velocidad;
		this.x += this.velocidad * this.movimiento;
	}

	public void invertirMovimiento() {
		this.movimiento = -1 * movimiento;
	}

	public boolean setocaDestructor(Destructor otroDestructor) {
		int otroX = otroDestructor.getX();
		int otroY = otroDestructor.getY();
		int otroAncho = otroDestructor.getAncho();
		int otroAlto = otroDestructor.getAlto();
		boolean tocanHorizontalmente = false;
		boolean tocanVerticalmente = false;
		if (this.x <= otroX + otroAncho && this.x + this.ancho >= otroX) {
			tocanHorizontalmente = true;
		}
		if (this.y <= otroY + otroAlto && this.y + this.alto >= otroY) {
			tocanVerticalmente = true;
		}
		if (tocanHorizontalmente == true && tocanVerticalmente == true) {
			return true;
		} else
			return false;
	}

	public boolean setocaConNave(Nave nave) {
		int otroX = nave.getX();
		int otroY = nave.getY();
		int otroAncho = nave.getAncho();
		int otroAlto = nave.getAlto();
		boolean tocanHorizontalmente = false;
		boolean tocanVerticalmente = false;
		if (this.x <= otroX + otroAncho && this.x + this.ancho >= otroX) {
			tocanHorizontalmente = true;
		}
		if (this.y <= otroY + otroAlto && this.y + this.alto >= otroY) {
			tocanVerticalmente = true;
		}
		if (tocanHorizontalmente == true && tocanVerticalmente == true) {
			return true;
		} else
			return false;
	}

	public boolean setocaConAsteroide(Asteroide asteroide) {
		int otroX = asteroide.getX();
		int otroY = asteroide.getY();
		int otroAncho = asteroide.getAncho();
		int otroAlto = asteroide.getAlto();
		boolean tocanHorizontalmente = false;
		boolean tocanVerticalmente = false;
		if (this.x <= otroX + otroAncho && this.x + this.ancho >= otroX) {
			tocanHorizontalmente = true;
		}
		if (this.y <= otroY + otroAlto && this.y + this.alto >= otroY) {
			tocanVerticalmente = true;
		}
		if (tocanHorizontalmente == true && tocanVerticalmente == true) {
			return true;
		} else
			return false;
	}

	void animarMovimientoDestructor(Entorno entorno, List<Destructor> destructores) {
		this.dibujarse(entorno);
		int cont = 0;

		if (tocaParedes(entorno) || tocaOtroDestructor(destructores)) {
			this.invertirMovimiento();
		}

		if (cont == 0 || cont == 2) {
			this.moverDiagonalDerecha();
			cont++;
		} else {
			this.moverDiagonalIzquierda();
			cont = 0;
		}

	}

	private boolean tocaOtroDestructor(List<Destructor> destructores) {
		for (Destructor destructor : destructores) {
			if (this.getLimiteLadoDerecho() >= destructor.getLimiteLadoIzq()
					|| this.getLimiteLadoIzq() <= destructor.getLimiteLadoDerecho())
				return true;
		}
		return false;
	}

	private boolean tocaParedes(Entorno entorno) {
		return this.getLimiteLadoIzq() <= 0 || this.getLimiteLadoDerecho() >= entorno.ancho();
	}

	private int getLimiteLadoIzq() {
		return this.getX() - this.ancho / 2;
	}

	private int getLimiteLadoDerecho() {
		return this.getX() + this.ancho / 2;
	}

}
