package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


import uniandes.dpoo.taller2.modelo.Restaurante;




public class Aplicacion {
	
	
	private Restaurante restaurante = new Restaurante();
	
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException 
	{
		System.out.println("Bienvenido al Programa del Restaurante \n");
		
		boolean pedido = false;

		boolean continuar = true;
		
		while (continuar)
			
		{
			try
			{
				System.out.println("\nOpciones de la aplicación\n");
				System.out.println("1. Mostrar el menu");
				System.out.println("2. Iniciar un nuevo pedido");
				System.out.println("3. Agregar un elemento a un pedido");
				System.out.println("4. Cerrar un pedido y guardar la factura");
				System.out.println("5. Consultar la información de un pedido dado su id");
				System.out.println("6. Salir de la aplicacion");
				
				restaurante.cargarDatosRestaurante();
				
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
				if (opcion_seleccionada == 1)
				{
					mostrarMenu();
				}
				
				else if (opcion_seleccionada == 2) 
					
				{
					String nombreCliente = input("Ingrese el nombre del cliente\n");
					String direccionCliente = input("Ingrese su direccion\n");
					restaurante.iniciarPedido(nombreCliente, direccionCliente);
					pedido = true;
					System.out.println("Pedido iniciado");
					
				}
				
				else if (opcion_seleccionada == 3 && pedido==true)
					
				{
					int identificadorProducto = Integer.parseInt(input("Ingrese el código del producto que desea agregar\n"));
					
					if (identificadorProducto > 2000 && identificadorProducto <= 2019)
						
					{
						int ajuste = Integer.parseInt(input("¿Modificar Producto?\n \t1. Sí\n\t2. No\n"));
						
						if (ajuste == 1)
						{
							boolean modificador = true;
							
							while (modificador)
								
							{
								int identificadorIngrediente = Integer.parseInt(input("Ingrese el código del ingrediente que desea modificar\n"));
								
								int tipo = Integer.parseInt(input("1. Agregar Ingrediente\n2. Eliminar Ingrediente\n"));
								
								if (tipo == 1 || tipo == 2)
								{
									restaurante.ejecutarPrepararProductoAjustado(identificadorProducto, tipo, identificadorIngrediente);
								}
								
								int continuo = Integer.parseInt(input("¿Continuar modificaciones?\n \t1. Sí\n\t2. No\n"));
								
								if (continuo != 1)
									
								{
									modificador = false;
								}
								
							}
							
							restaurante.ejecutarAgregarProductoAjustado();
						}
						else if (ajuste == 2)
						{
							restaurante.ejecutarAgregarProducto(identificadorProducto);
						}
						
						System.out.println("Producto agregado Exitosamente");
					}
				
					
					else if ((identificadorProducto > 1000 && identificadorProducto < 1016) || (identificadorProducto > 4000 && identificadorProducto < 4007))
					{
						restaurante.ejecutarAgregarProducto(identificadorProducto);
						System.out.println("Producto agregado Exitosamente");
					}
					
					else
					{
						System.out.println("Producto inválido En el rango de la Lista");
					}
				}
				
				else if (opcion_seleccionada == 3 && pedido==false) 
				{
					System.out.println("Por favor inicie un pedido antes de poder agregar un producto");
				}
		
				else if (opcion_seleccionada == 4)
				{
					restaurante.cerrarYGuardarPedido();
					System.out.println("Pedido Cerrado Exitosamente");
					pedido = false;
				}
				
				else if (opcion_seleccionada == 5)
				{
					int identificadorPedido = Integer.parseInt(input("Ingrese el ID del pedido que desea consultar\n"));
					String texto = restaurante.obtenerPedidoxID(identificadorPedido);
					System.out.println(texto);
				}
	
					
				
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				
		
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los numerales de las opciones del menu.");
			}
		}
	}
	
	
	public void mostrarMenu()
	
	{
		
		System.out.println("\n1. INGREDIENTES\n");
		System.out.println("\t Codigo = 1001 - Lechuga: 1000");
		System.out.println("\t Codigo = 1002 - Tomate: 1000");
		System.out.println("\t Codigo = 1003 - Cebolla: 1000");
		System.out.println("\t Codigo = 1004 - Queso Mozzarella: 2500");
		System.out.println("\t Codigo = 1005 - Huevo: 2500");
		System.out.println("\t Codigo = 1006 - Queso Americano: 2500");
		System.out.println("\t Codigo = 1007 - Tocineta Express: 2500");
		System.out.println("\t Codigo = 1008 - Papa Callejera: 2000");
		System.out.println("\t Codigo = 1009 - Pepinillos: 2500");
		System.out.println("\t Codigo = 1010 - Cebolla Grille: 2500");
		System.out.println("\t Codigo = 1011 - Suero Costeño: 3000");
		System.out.println("\t Codigo = 1012 - Frijol Refrito: 4500");
		System.out.println("\t Codigo = 1013 - Queso Fundido: 4500");
		System.out.println("\t Codigo = 1014 - Tocineta Picada: 6000");
		System.out.println("\t Codigo = 1015 - Piña: 2500");
		System.out.println("2. MENÚ\n");
		System.out.println("\t Codigo = 2001 - Corral: 14000");
		System.out.println("\t Codigo = 2002 - Corral Queso: 16000");
		System.out.println("\t Codigo = 2003 - Corral Pollo: 15000");
		System.out.println("\t Codigo = 2004 - Corralita: 13000");
		System.out.println("\t Codigo = 2005 - Todoterreno: 25000");
		System.out.println("\t Codigo = 2006 - 1/2 Libra: 25000");
		System.out.println("\t Codigo = 2007 - Especial: 24000");
		System.out.println("\t Codigo = 2008 - Casera: 23000");
		System.out.println("\t Codigo = 2009 - Mexicana: 22000");
		System.out.println("\t Codigo = 2010 - Criolla: 22000");
		System.out.println("\t Codigo = 2011 - Costeña: 20000");
		System.out.println("\t Codigo = 2012 - Hawaiana: 20000");
		System.out.println("\t Codigo = 2013 - Wrap de Pollo: 15000");
		System.out.println("\t Codigo = 2014 - Wrap de Lomo: 22000");
		System.out.println("\t Codigo = 2015 - Ensalada Mexicana: 20900");
		System.out.println("\t Codigo = 2016 - Papas Medianas: 5500");
		System.out.println("\t Codigo = 2017 - Papas Grandes: 6900");
		System.out.println("\t Codigo = 2018 - Papas en casco medianas: 5500");
		System.out.println("\t Codigo = 2019 - Papas en casco grandes: 6900");
		System.out.println("\n3. COMBOS\n");
		System.out.println("\t Codigo = 3001 - Combo Corral (corral, papas medianas, gaseosa): 22050");
		System.out.println("\t Codigo = 3002 - Combo Corral queso (corral queso, papas medianas, gaseosa): 23850");
		System.out.println("\t Codigo = 3003 - Combo Todoterreno (todoterreno, papas grandes, gaseosa): 34317");
		System.out.println("\n4. BEBIDAS\n");
		System.out.println("\t Codigo = 4001 - Coca Cola: 4500");
		System.out.println("\t Codigo = 4002 - Pepsi: 4000");
		System.out.println("\t Codigo = 4003 - Sprite: 3500");
		System.out.println("\t Codigo = 4004 - Seven Up: 6500");
		System.out.println("\t Codigo = 4005 - Colombiana: 4700");
		System.out.println("\t Codigo = 4006 - Agua cristal sin gas: 5000");
		System.out.println("\t Codigo = 4007 - Agua cristal con gas: 5000");
		
		
		
	}
		
		
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola . . .");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
	
	
	
	
	
	
	
	
	
}



