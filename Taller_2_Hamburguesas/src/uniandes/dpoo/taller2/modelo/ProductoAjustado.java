package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto

{
	
	
	private ProductoEnMenu productoBase; 
	
	private ArrayList<Ingrediente> ingredientesEliminados;
	
	private ArrayList<Ingrediente> ingredientesAgregados;
		
	
	
	public ProductoAjustado(ProductoEnMenu productoBase)
	{
		this.productoBase = productoBase;
		this.ingredientesAgregados = new ArrayList<>();
		this.ingredientesEliminados = new ArrayList<>();
	}

	
	
	public String obtenerNombre() 
	{
		return productoBase.obtenerNombre();
	}


	public int obtenerPrecio() 
	{
		int total = productoBase.obtenerPrecio();
		for (int i = this.ingredientesAgregados.size() - 1; i >= 0; i--)
		{
			Ingrediente unIngrediente = ingredientesAgregados.get(i);
			total += unIngrediente.obtenerCostoAgregado();
		}
		return total;
	}


	public String generarTextoEnFactura() 
	{
		String texto = "\t";
		texto = texto + productoBase.obtenerNombre() + "\t\t\t" + productoBase.obtenerPrecio() + "\n";
		
		for (int i = this.ingredientesAgregados.size() - 1; i >= 0; i--)
		{
			Ingrediente unIngrediente = ingredientesAgregados.get(i);
			texto += "\t\t+ " + unIngrediente.obtenerNombre() + "\t" + unIngrediente.obtenerCostoAgregado()+ "\n";
		}
		
		for (int i = this.ingredientesEliminados.size() - 1; i >= 0; i--)
		{
			Ingrediente unIngrediente = ingredientesEliminados.get(i);
			texto += "\t\t- " + unIngrediente.obtenerNombre() + "\n";
		}
		return texto;
	}
	
	
	
	public ArrayList<Ingrediente> obtenerIngredientesEliminados() {
		return ingredientesEliminados;
	}


	public void estabblecerIngredientesEliminados(ArrayList<Ingrediente> ingredientesEliminados) {
		this.ingredientesEliminados = ingredientesEliminados;
	}


	public ArrayList<Ingrediente> obtenerIngredientesAgregados() {
		return ingredientesAgregados;
	}


	public void establecerIngredientesAgregados(ArrayList<Ingrediente> ingredientesAgregados) {
		this.ingredientesAgregados = ingredientesAgregados;
	}
	
	
	public int obtenerIdentificador() 
	{
		return productoBase.obtenerIdentificador();
	}


	


}
