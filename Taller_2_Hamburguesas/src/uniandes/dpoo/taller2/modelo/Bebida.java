package uniandes.dpoo.taller2.modelo;

public class Bebida implements Producto
{
	private String nombre;
	private int identificador;
	private int precioBase;
	
	
	
	
	public Bebida(String nombre, int precioBase, int identificador)
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.establecerIdentificador(identificador);
	}
		
	
	
	public int obtenerPrecio() 
	{
		
		return precioBase;
	}

	
	public String obtenerNombre() 
	{
		
		return nombre;
	}
	
	
	public int obtenerIdentificador() 
	{
		
		return identificador;
	}
	


	public String generarTextoEnFactura() 
	{
	
		return ("\t" + this.obtenerNombre() + "\t\t" + this.obtenerPrecio());
	}

	
	public void establecerNombre(String nombre) 
	{
		this.nombre = nombre;
	}
		
	public void establecerPrecioBase(int precioBase) 
	{
		this.precioBase = precioBase;
	}
		
	public void establecerIdentificador(int identificador) 
	{
		this.identificador = identificador;
	}

}
