package logic;

import java.util.ArrayList;

public class Superficie {

	public Vehiculo matriz[][];
	public int n;
	public int m;


	public Superficie(int n,int m) {
		this.n=n;
		this.m=m;
		matriz= new Vehiculo[n][m];
		int filaIni=0;
		int columnaIni=0;
		Vehiculo vehiculo= new Vehiculo();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				filaIni=i;
			}
		}
		
		matriz[filaIni][columnaIni]=vehiculo;
	
	}
	
	

	public Vehiculo[][] getMatriz() {
		return matriz;
		
	}




	public Vehiculo[][] MoverVehiculo(String listaComandos,Vehiculo [][] matrizAux) throws Exception {
    
		
		
		
		Vehiculo vehiculo= new Vehiculo();
		Movimiento movimiento= new Movimiento();
	
		ArrayList<Movimiento> movimientos=vehiculo.obtenerMovimientos(listaComandos);
		int desplazamiento=0;
		String direccion="";
		int filaAnt=0;
		int columAnt=0;
		
		//---ver ultima posicion
		for (int i = 0; i < matrizAux.length; i++) {
			for (int j = 0; j < matrizAux[i].length; j++) {
				if(matrizAux[i][j]!=null) {
					filaAnt=i;
					columAnt=j;
				}
			}
		}
		
		

		for (int a = 0; a < movimientos.size(); a++) {
	
			movimiento=movimientos.get(a);
			desplazamiento=movimiento.getDesplazamiento();
			direccion=movimiento.getDireccion();
			
			if(direccion.equals("N")) {
				if(filaAnt-desplazamiento<0) {
					throw new Exception("Fuera de límite");
				}
               int aux=filaAnt-desplazamiento;
               matrizAux[filaAnt][columAnt]=null;
               filaAnt=aux;            
               matrizAux[aux][columAnt]=vehiculo;

			}else if(direccion.equals("S")) {
				int aux=filaAnt+desplazamiento;
				if(filaAnt+desplazamiento>matrizAux.length-1) {
					throw new Exception("Fuera de límite");
				}

				matrizAux[filaAnt][columAnt]=null;
				filaAnt=aux;		
				matrizAux[aux][columAnt]=vehiculo; 
				
			}else if(direccion.equals("E")) {
				int aux=columAnt+desplazamiento;
				if(columAnt+desplazamiento>matrizAux[0].length-1) {
					throw new Exception("Fuera de límite");
				}
				matrizAux[filaAnt][columAnt]=null;
				columAnt=aux;		
				matrizAux[filaAnt][aux]=vehiculo;
				
			}else if(direccion.equals("O")) {
				int aux=columAnt-desplazamiento;
				if(columAnt-desplazamiento<0) {
					throw new Exception("Fuera de límite");
				}
				matrizAux[filaAnt][columAnt]=null;
				columAnt=aux;		
				matrizAux[filaAnt][aux]=vehiculo;
				
			}

		

		}
   
		return matrizAux;



	}

}
