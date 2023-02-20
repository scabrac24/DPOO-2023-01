package uniandes.dpoo.taller2.modelo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class Restaurante{
	
	
	private Pedido pedidoActivo;
	private ProductoAjustado productoActivo;
	private int contadorPedidos;
	
	private ArrayList<Ingrediente> ingredientesLista;
	private ArrayList<ProductoEnMenu> productosLista;
	private ArrayList<Combo> combosLista;
	private ArrayList<Bebida> bebidasLista;
	
	private Map<Integer, Pedido> pedidos;
	
	
	public Restaurante() 
	
	{
		this.contadorPedidos = 0;
		ProductoEnMenu temp = new ProductoEnMenu(null, 0, 0);
		this.productoActivo = new ProductoAjustado(temp);
		this.pedidos = new HashMap<>();
	}
	
	
	

	public void iniciarPedido(String nombreCliente, String direccionCliente) 
	
    {
		contadorPedidos = contadorPedidos + 1;
		Pedido pedidoActivo = new Pedido(nombreCliente, direccionCliente, contadorPedidos);
		establecerPedidoActivo(pedidoActivo);
    }

	 public void cerrarYGuardarPedido() throws IOException 
	 
    {
    	pedidoActivo.guardarFactura();
    	this.pedidos.put(pedidoActivo.obtenerIdentificadorPedido(), pedidoActivo);
    	pedidoActivo = null;
    }
	
	
	public void cargarDatosRestaurante() throws FileNotFoundException 
	
	{
		String archivoMenu = "data/menu.txt";
		
		String archivoCombos = "data/combos.txt";
    	
    	String archivoIngredientes = "data/ingredientes.txt";
    	
    	String archivoBebidas = "data/bebidas.txt";
    	
    	
		loaderIngredientes(archivoIngredientes);    	
    	loaderMenu(archivoMenu);
		loaderCombos(archivoCombos, productosLista);
		loaderBebidas(archivoBebidas);
		
		
    }

	
	
	
	public void loaderIngredientes(String archivoIngredientes) throws FileNotFoundException 
	{
		
		InputStream ins = new FileInputStream(archivoIngredientes);
		Scanner obj = new Scanner(ins);
		int identificador = 1000;
		java.util.ArrayList<Ingrediente> ingredientes = new java.util.ArrayList<>();
		while (obj.hasNextLine())
		{
			
    		String[] secciones = obj.nextLine().split(";");
    		String nombreIngrediente = secciones[0]; 
    		int precio = Integer.parseInt(secciones[1]);
    		
    		Ingrediente elIngrediente = obtenerIngredientes(ingredientes, nombreIngrediente);
    		
    		if (elIngrediente == null)
    		{
    			identificador = identificador + 1;
    			elIngrediente = new Ingrediente(nombreIngrediente, precio, identificador);
    			
    			ingredientes.add(elIngrediente);
    			
    		}
    		
    	
		}
    	
    	establecerIngredientesEnLista(ingredientes); 
    	
    }
	
	
	
	private void loaderMenu(String archivoMenu) throws FileNotFoundException 
	
	{
		
		InputStream ins = new FileInputStream(archivoMenu);
		Scanner obj = new Scanner(ins);
		int identificador = 2000;
		java.util.ArrayList<ProductoEnMenu> productos = new java.util.ArrayList<>();
		
		while (obj.hasNextLine())
    	{
    		String[] secciones = obj.nextLine().split(";");
    		String nombreProducto = secciones[0]; 
    		int precioBase = Integer.parseInt(secciones[1]);
    		
    		ProductoEnMenu elProducto = ObtenerMenuBase(productos, nombreProducto);
    		
    		if (elProducto == null)
    		{
    			identificador = identificador + 1;
    			elProducto = new ProductoEnMenu(nombreProducto, precioBase, identificador);
    			productos.add(elProducto);
    		}
    		
    		
    	}
    	
		establecerProductosEnLista(productos);    	
    }
	
	
	
	
	
	
	
	private void loaderCombos(String archivoCombos, ArrayList<ProductoEnMenu> productos) throws FileNotFoundException
    {
		InputStream ins = new FileInputStream(archivoCombos);
		Scanner obj = new Scanner(ins);
		int identificador = 3000;
		java.util.ArrayList<Combo> combos = new java.util.ArrayList<>();
    	
    	while(obj.hasNextLine())
    	{
    		String[] secciones = obj.nextLine().split(";");
    		String nombreCombo = secciones[0]; 
    		String descuento1 = secciones[1];
    		descuento1 = descuento1.replace("%", "");
    		int descuento = Integer.parseInt(descuento1);
    		
    		Combo ElCombo = obtenerCombos(combos, nombreCombo);
    		
    		if (ElCombo == null)
    		{
    			ArrayList<ProductoEnMenu> elementosCombo = new ArrayList<>();
        		String nombreHamburguesa = secciones[2];
        		String nombrePapas = secciones[3];
        		String nombreBebida = secciones[4];
        		ProductoEnMenu hamburguesa = null;
        		ProductoEnMenu papas = null;
        		ProductoEnMenu bebida = null;
        		
        		
        		for (int i = productos.size() - 1; i >= 0 && (hamburguesa == null || papas == null || bebida == null); i--)
        		{
        			ProductoEnMenu unProducto = productos.get(i);
        			if (unProducto.obtenerNombre().equals(nombreHamburguesa))
        			{
        				hamburguesa = unProducto;
        			}
        			else if (unProducto.obtenerNombre().equals(nombrePapas))
        	    	{
        	    		papas = unProducto;
        	   		}
        			else if (unProducto.obtenerNombre().equals(nombreBebida))
        	    	{
        	    		bebida = unProducto;
        	   		}
        		} 
        		
        		
    			identificador = identificador + 1;
    			ElCombo = new Combo(nombreCombo, descuento, identificador, elementosCombo);
    			
    			combos.add(ElCombo);
    			ElCombo.agregarItemACombo(hamburguesa);
        		ElCombo.agregarItemACombo(papas);
        		ElCombo.agregarItemACombo(bebida);
    		}
    		
    		
    	}
    	
		establecerCombosEnLista(combos);
    }
	
	
	
	private void loaderBebidas(String archivoBebidas) throws FileNotFoundException 
	
	{
		
		InputStream ins = new FileInputStream(archivoBebidas);
		Scanner obj = new Scanner(ins);
		int identificador = 4000;
		java.util.ArrayList<Bebida> bebidas = new java.util.ArrayList<>();
		
		while (obj.hasNextLine())
		{
			
    		String[] secciones = obj.nextLine().split(";");
    		String nombreBebida = secciones[0]; 
    		int precio = Integer.parseInt(secciones[1]);
    		
    		Bebida laBebida = obtenerBebidas(bebidas, nombreBebida);
    		
    		if (laBebida == null)
    		{
    			identificador = identificador + 1;
    			laBebida = new Bebida(nombreBebida, precio, identificador);
    			
    			bebidas.add(laBebida);
    			
    		}
    		
    	
		}
    	
    	establecerBebidasEnLista(bebidas); 
    	
    }
	
	
	// Metodos de establecimiento 
	
	
	
	public void establecerIngredientesEnLista(java.util.ArrayList<Ingrediente> ingredientesLista) 
	{
		this.ingredientesLista = ingredientesLista;
	}
	
	public void establecerProductosEnLista(java.util.ArrayList<ProductoEnMenu> productosLista)
	{
		this.productosLista = productosLista;
	}
	
	public void establecerCombosEnLista(java.util.ArrayList<Combo> combosLista)
	{
		this.combosLista = combosLista;
	}
	
	public void establecerBebidasEnLista(java.util.ArrayList<Bebida> bebidasLista)
	{
		this.bebidasLista = bebidasLista;
	}
	
	
	
	
	// Metodos de obtencion en Lista
	
	
	
	public ArrayList<Ingrediente> obtenerIngredientesLista()
	
	{
		return ingredientesLista;
	}
	
	public ArrayList<ProductoEnMenu> obtenerProductosLista() 
	
	{
		return productosLista;
	}
	
	public ArrayList<Combo> obtenerCombosLista() 
	
	{
		return combosLista;
	}
	
	public ArrayList<Bebida> obtenerBebidasLista()
	
	{
		return bebidasLista;
	}
	
	
	// Recorridos sobre lista de tipo Array_List
	
	
	
	public static Ingrediente obtenerIngredientes(java.util.ArrayList<Ingrediente> ingredientes, String nombreIngrediente)
    {
    	Ingrediente elIngrediente = null;
    	
    	for (int e = ingredientes.size()-1; e>= 0 && elIngrediente == null; e--)
    	{	
	    	 Ingrediente unIngrediente = ingredientes.get(e);
	    	 if (unIngrediente.obtenerNombre() == nombreIngrediente)
	    	 {
	    		 elIngrediente = unIngrediente;
    	     }		
    	}

    	 return elIngrediente;
    	 
    }
	
	
    	 
    public static Bebida obtenerBebidas(java.util.ArrayList<Bebida> bebidas, String nombreBebida)
    {
    	
    	Bebida laBebida = null;
    	    	
    	for (int e = bebidas.size()-1; e>= 0 && laBebida == null; e--)
    		
    	{	
    	    Bebida unaBebida = bebidas.get(e);
    	    
    		if (unaBebida.obtenerNombre() == nombreBebida)
    			
    		{
    		    laBebida = unaBebida;
    	    }		
    		
    	}

    	 return laBebida;
    	 
	}
    
    
	
	public static ProductoEnMenu ObtenerMenuBase(java.util.ArrayList<ProductoEnMenu> productos, String nombreProducto)
    {
    	ProductoEnMenu elProducto = null;
    	
    	for (int e = productos.size()-1; e>= 0 && elProducto == null; e--)
    	{
	    	 ProductoEnMenu unProducto = productos.get(e);
	    	 if (unProducto.obtenerNombre() == nombreProducto)
	    	 {
	    		 elProducto = unProducto;
    	     }
    	 
    	}
    	 return elProducto;
	}
	
	
	
	
	
	 public static Combo obtenerCombos(ArrayList<Combo> combos, String nombreCombo)
	    {
	    	Combo elCombo = null;
	    	
	    	for (int e = combos.size()-1; e>= 0 && elCombo == null; e--)
	    	{
		    	 Combo unCombo = combos.get(e);
		    	 if (unCombo.obtenerNombre() == nombreCombo)
		    	 {
		    		 elCombo = unCombo;
	    	     }
	    	 
	    	}
	    	 return elCombo;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	public Pedido obtenerPedidoEnCurso()
		{
			return pedidoActivo;
		}
		
	

	public void establecerPedidoActivo(Pedido pedidoActivo) {
			this.pedidoActivo = pedidoActivo;
		}
		
	public void ejecutarAgregarProducto(int identificadorProducto)
		{
			
			Producto producto = obtenerProducto(identificadorProducto);
			pedidoActivo.agregarProducto(producto);
		}
		
	
	public void ejecutarAgregarProductoAjustado()
	
		{
			pedidoActivo.agregarProducto(productoActivo);
			ProductoEnMenu temp = new ProductoEnMenu(null, 0, 0);
			this.productoActivo = new ProductoAjustado(temp);
		}
		
	
	
	
	
	public Producto obtenerProducto(int idProducto)
	
		{
			Producto producto = null;
			
			if (idProducto > 2000 && idProducto < 2023)
			{
				producto = obtenerProductoMenuxID(idProducto);
			}
			else if (idProducto > 3000 && idProducto < 3004)
			{
				producto = obtenerComboxID(idProducto);
			}
			else if (idProducto > 4000 && idProducto < 4005)
			{
				producto = obtenerBebidaxID(idProducto);
			}
			return producto;
			
		}
	
	
	// Metodos de obtencion por ID
	
		
	public ProductoEnMenu obtenerProductoMenuxID(int identificadorProducto)
	
		{
			ProductoEnMenu producto = null;

			for (int i = this.productosLista.size() - 1; i >= 0 && producto == null; i--)
	    	{
	   			ProductoEnMenu unProducto = productosLista.get(i);
	   			
	   			if (unProducto.obtenerIdentificador() == identificadorProducto)
	   				
	   			{
	   				producto = unProducto;
	   			}
	    	}
			
			return producto;
		}
	

		
	public Combo obtenerComboxID(int identificadorProducto)
	
		{
			Combo producto = null;

			for (int i = this.combosLista.size() - 1; i >= 0 && producto == null; i--)
	    	{
	   			Combo unCombo = combosLista.get(i);
	   			
	   			if (unCombo.obtenerIdentificador() == identificadorProducto)
	   			{
	   				producto = unCombo;
	   			}
	    	}

			return producto;
		}
	
	
		
	public Ingrediente obtenerIngredientexID(int identificadorProducto)
	
		{
			Ingrediente producto = null;
			if (identificadorProducto > 1000 && identificadorProducto < 1016)
			{
				for (int i = this.ingredientesLista.size() - 1; i >= 0 && producto == null; i--)
	    		{
	    			Ingrediente unIngrediente = ingredientesLista.get(i);
	    			if (unIngrediente.obtenerIdentificador() == identificadorProducto)
	    			{
	    				producto = unIngrediente;
	    			}
	    		}
			}
			return producto;
		}
	
	
	
	public Bebida obtenerBebidaxID(int identificadorProducto)
	
	{
		Bebida producto = null;
		for (int i = this.bebidasLista.size() - 1; i >= 0 && producto == null; i--)
    	{
   			Bebida unaBebida = bebidasLista.get(i);
   			
   			if (unaBebida.obtenerIdentificador() == identificadorProducto)
   			{
   				producto = unaBebida;
   			}
    	}

		return producto;
		
	}
		
	
	public String obtenerPedidoxID(int identificadorPedido)
	{
		Pedido consulta = this.pedidos.get(identificadorPedido);
		String info = consulta.generarTextoEnFactura();
		return info;
	}
	
	
	
	public void ejecutarPrepararProductoAjustado(int identificadorProducto, int x4bool, int identificadorIngrediente)
		{
			if (productoActivo.obtenerIdentificador() != identificadorProducto)
			{
				ProductoEnMenu productoBase = obtenerProductoMenuxID(identificadorProducto);
				productoActivo = new ProductoAjustado(productoBase);
			}
			Ingrediente ingrediente = obtenerIngredientexID(identificadorIngrediente);
			
			if (x4bool == 1)
			{
				ArrayList<Ingrediente> agregadosLista = productoActivo.obtenerIngredientesAgregados();
				agregadosLista.add(ingrediente);
			}
			else if (x4bool == 2)
			{
				ArrayList<Ingrediente> eliminadosLista = productoActivo.obtenerIngredientesEliminados();
				eliminadosLista.add(ingrediente);
			}
			
		}
		
	 
	 
	 
	 
	 
	 
	 

	
}
