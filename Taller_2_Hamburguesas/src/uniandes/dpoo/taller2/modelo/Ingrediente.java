package uniandes.dpoo.taller2.modelo;



public class Ingrediente {
	
	private String nombre;
	
	private int costoAgregado;
	
	private int identificador;
	
	
	public Ingrediente(String nombre, int costoAgregado, int identificador) 
	{
		this.nombre = nombre;
		this.costoAgregado = costoAgregado;
		this.establecerIdentificador(identificador);
	}
	
	public String obtenerNombre() 
	{
		return nombre;
	}

	
	
	public int obtenerCostoAgregado() 
	{
		return costoAgregado;
	}


	public int obtenerIdentificador() 
	{
		return identificador;
	}


	public void establecerIdentificador(int identificador)
	{
		this.identificador = identificador;
	}

}

	

