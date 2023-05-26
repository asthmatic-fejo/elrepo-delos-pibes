package juego;
import java.awt.Color;
import entorno.Entorno;


public class Proyectil {
	
	private	int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private int angulo;
	

	public Proyectil (int x, int y, int alto, int ancho, int angulo ) {
		
		this.alto=alto;
		this.ancho=ancho;
		this.x=x;
		this.y=y;
		this.angulo=angulo;
		this.velocidad=4;
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 ,Color.yellow);
	}
		
	public void movermas()
	{
		this.y -= this.velocidad;
	}
	
	public void invertir()
	{
		this.y +=this.velocidad;
	}
	
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	public int getancho()
	{
		return ancho;
	}

	public int getaalto()
	{
		return alto;
	}

	public int getangulo()
	{
		return angulo;
	}


}
