package uniandes.dpoo.taller2.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Pedido 

{
	private String nombreCliente;
	
	private String direccionCliente;
	
	private int numeroPedidos;
	
	private int identificadorPedido;
	
	private java.util.ArrayList<Producto> productos;
	    
	
	
	   
	public Pedido(String nombreCliente, String direccionCliente, int contadorPedidos) 
	
	{
	    Random rand = new Random();
		this.identificadorPedido = rand.nextInt(99999);
		this.numeroPedidos = contadorPedidos;
		this.productos = new ArrayList<>();
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	
	
	
	
	public void agregarProducto(Producto nuevoElemento)
	
	{
	    	
	    productos.add(nuevoElemento);
	    
	}
	
	
	
	
	private int obtenerPrecioTotalPedido() 
	
    {
        int precioTotal = this.obtenerPrecioNetoPedido() +  this.obtenerPrecioIVAPedido();

        return precioTotal;
    }
	    
	    

	public int obtenerIdentificadorPedido() 
	
	    {
	        return identificadorPedido;
	    }

	private int obtenerPrecioNetoPedido() 
	
	    {
	    	int neto = 0;
	    	for (int i = this.productos.size() - 1; i >= 0; i--)
			{
				Producto unProducto = productos.get(i);
				neto = neto + unProducto.obtenerPrecio();
			}
	    	return neto;
	    }
	
	
	    
	private int obtenerPrecioIVAPedido() 
	
	    {
	        int precioRegular = this.obtenerPrecioNetoPedido();
	        int precioIVA = precioRegular * 19 / 100;

	        return precioIVA;
	    }
	    
	
	    
	protected String generarTextoEnFactura() 
	
	    {
	    	String textoProductos = "";
	    	
	    	for (int i = this.productos.size() - 1; i >= 0; i--)
	    		
			{
				Producto unProducto = productos.get(i);
				
				textoProductos = textoProductos + unProducto.generarTextoEnFactura() + "\n";
			}
	    	
	        String TextoFactura = "HAMBURGUESAS EL CORRAL\n\nCliente: " + this.nombreCliente + 
	        					  "\nDirección cliente: " +  this.direccionCliente +
	        					  "\nID Pedido: " + this.identificadorPedido +
	        					  "\nNumero Pedido: " + this.numeroPedidos +
	        					  "\n\nPRODUCTOS\n" + textoProductos +
	        					  "\n\nValor Neto: " + this.obtenerPrecioNetoPedido() + 
	        					  "\nValor IVA (19%): " + this.obtenerPrecioIVAPedido() + 
	        					  "\nTOTAL: " + this.obtenerPrecioTotalPedido();
	        
	        

	        return TextoFactura;
	    
	   }
	
	
	    
	public void guardarFactura() throws IOException 
	    {
	        String ruta = "data/facturas/" + this.identificadorPedido + ".txt";
	        String contenido = this.generarTextoEnFactura();
	        File file = new File(ruta);
	           
	        if (!file.exists()) 
	        	
	        {
	           file.createNewFile();
	        }
	        FileWriter fw = new FileWriter(file);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(contenido);
	        bw.close();
	    }

	}



