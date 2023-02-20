package uniandes.dpoo.taller2.modelo;


public class ProductoEnMenu implements Producto

{
	
	private String nombre;
	
	private int precioBase;
	
	private int identificador;
	
	
		
	public ProductoEnMenu(String nombre, int precioBase, int identificador)
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.establecerIdentificador(identificador);
	}
		
	
	public String obtenerNombre() 
	{
		return nombre;
	}
		
	public int obtenerPrecio() 
	{
		return precioBase;
	}
		
	public int obtenerIdentificador() 
	{
		return identificador;
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
		
		
	public String generarTextoEnFactura()
	{
		return ("\t" + this.obtenerNombre() + "\t\t\t" + this.obtenerPrecio());
	}


		
	
}
	


