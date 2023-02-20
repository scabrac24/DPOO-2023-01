package uniandes.dpoo.taller2.modelo;



public class Combo implements Producto

{
	
	private int descuento;
	
	private String nombreCombo;
	
	private int identificador;
	
	private java.util.ArrayList<ProductoEnMenu> productos;
	
	
	public Combo(String nombre, int descuento, int identificador, java.util.ArrayList<ProductoEnMenu> elementosCombo) 
	
	{
		this.nombreCombo = nombre;
		this.descuento = descuento;
		this.identificador = identificador;
		this.productos = elementosCombo;
	}
	
	
	
	
	
	public void establecerDescuento(int descuento) 
	{
		this.descuento = descuento;
	}

	public void establecerNombreCombo(String nombreCombo) 
	{
		this.nombreCombo = nombreCombo;
	}
	

	public void establecerProductos(java.util.ArrayList<ProductoEnMenu> productos)
	{
		this.productos = productos;
	}
	

	public void establecerIdentificador(int identificador) 
	{
		this.identificador = identificador;
	}
	
	
	
	
	
	
	public void agregarItemACombo(ProductoEnMenu elementoCombo)
	{
		productos.add(elementoCombo);
	}
	
	
	
	public String generarTextoEnFactura()
	{
		return ("\t" + this.obtenerNombre() + "\t\t\t" + this.obtenerPrecio());
	}
	
	

	
	
	
	
	
	
	
	public String obtenerNombre()
	{
		return nombreCombo;
	}



	public int obtenerIdentificador() 
	{
		return identificador;
	}
	
	
	public int obtenerPrecio()
	{	
		int valorFinal = 0;
		int total = 0;
		for (int i = this.productos.size() - 1; i >= 0; i--)
			
		{
			ProductoEnMenu unProducto = productos.get(i);
			total = total + unProducto.obtenerPrecio();
			
		}
		
		valorFinal = total - (total * this.descuento / 100);
		
		return valorFinal;
	}
	
	
	public double obtenerDescuento() 
	{
		return descuento;
	}
	
	
	public java.util.ArrayList<ProductoEnMenu> obtenerProductos() 
	{
		return productos;
	}
	
	



}



