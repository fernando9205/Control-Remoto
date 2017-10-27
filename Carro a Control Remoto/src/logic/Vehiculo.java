package logic;

import java.util.ArrayList;

public class Vehiculo {
	
	public int idVehiculo;
	public int posicionN;
	public int posicionM;
	public ArrayList<Movimiento> comandos;
	
	
	public Vehiculo() {
		idVehiculo=1;
		posicionN=0;
		posicionM=0;
		comandos= new ArrayList<Movimiento>();
		
	}
	
	
	
	public boolean validarFormatoComandos(String listaComandos) {
		
	 
	 boolean mensaje=true;
	  
	 //validar comas(,)
	for(int i=1;i<listaComandos.length();i=i+4) {
		 String coma=listaComandos.substring(i,i+1);
		// System.out.println("coma"+i+coma);
		 if(coma.equals(",")) {
			 mensaje=true;
		 }else {
			 mensaje=false;
			 break;
		 }		
		 
	 }
	 //validar punto y comas
	if(mensaje==true) {
		for(int i=3;i<listaComandos.length();i=i+4) {
			String puntoComa=listaComandos.substring(i,i+1);
			
			if (puntoComa.equals(";")) {
				mensaje=true;
			}else {
				mensaje=false;
				break;
			}		
		}
		
	}


	
	//validar direcciones
	if(mensaje==true) {
		for (int i = 2; i <listaComandos.length(); i=i+4) {
			String direccion=listaComandos.substring(i,i+1);
			//System.out.println("direccion"+i+direccion);
			if(direccion.equals("N")||direccion.equals("S")||direccion.equals("O")||direccion.equals("E")) {
				mensaje=true;
				
			}else {
				mensaje=false;
				break;
				
			}
		}
		
	}
	//validar desplazamientos
	if(mensaje==true) {
		
		
		for (int i = 0; i < listaComandos.length(); i=i+4) {
			String desplazamiento=listaComandos.substring(i,i+1);
			//System.out.println("desplazamiento"+i+desplazamiento);
			if(isNumeric(desplazamiento)==true) {
				
				mensaje=true;
			}else {
				
				mensaje=false;
				break;
			}
			
		}
		
		
		}
	return mensaje;
	}
	
	
	
	
	//valida si un dato es nuerico
    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }

    
    
	public ArrayList<Movimiento> obtenerMovimientos(String listaComandos) {
		
	 ArrayList<String> desplazamientos=new ArrayList<String>();
	 ArrayList<String> direcciones=new ArrayList<String>();
	  
	  //Guardar Desplazamientos
	  
	  for (int i = 0; i < listaComandos.length(); i=i+4) {
		  String desplazamiento=listaComandos.substring(i,i+1);
		  desplazamientos.add(desplazamiento);
		
	}
	  //Guardar Direcciones
	  
	  for (int i = 2; i <listaComandos.length(); i=i+4) {
		  String direccion=listaComandos.substring(i,i+1);
		  direcciones.add(direccion);
	}
	  
	 //Guardar Movimientos
	  for (int i = 0; i <desplazamientos.size(); i++) {
		  Movimiento nuevoMoviento=new Movimiento();
		  nuevoMoviento.setDesplazamiento(Integer.parseInt(desplazamientos.get(i)));
		  nuevoMoviento.setDireccion(direcciones.get(i));
		  comandos.add(nuevoMoviento);
		  		
	}
	  return comandos;
	  
		
		
	}
}