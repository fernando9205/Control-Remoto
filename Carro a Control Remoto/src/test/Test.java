package test;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import logic.Movimiento;
import logic.Superficie;
import logic.Vehiculo;

public class Test {

	public static void main(String[] args) {
	
		PintarMatriz pintarMatriz= new PintarMatriz();
		Scanner fila= new Scanner(System.in);
		System.out.println("---VEHICULO A CONTROL REMOTO---");
		System.out.println("Digite el tamaño del tablero MAXIMO 9X9");
		System.out.print("Numero Filas: ");
		int n=fila.nextInt();
		Scanner columna= new Scanner(System.in);
		System.out.print("Numero Columnas: ");
		int m=columna.nextInt();
		Superficie superficie= new Superficie(n,m);
		Vehiculo vehiculo= new Vehiculo();
		Vehiculo matrizInicial[][]=superficie.getMatriz();
		//String tableroInicial[][]=new String[matrizInicial.length][matrizInicial[0].length];
		int[] ultimaPosicion=new int[2];
		
		int ultimaFila=matrizInicial.length-1;
		int ultimaColumna=0;
	
		
		String respuesta="si";
		while(respuesta.equals("si")) {
		
			//__			
			Vehiculo matrizAux[][]=new Vehiculo[matrizInicial.length][matrizInicial[0].length];
			Vehiculo vehiculoaux= new Vehiculo();
			matrizAux[ultimaFila][ultimaColumna]=vehiculoaux;
			String tableroAux[][]= new String[matrizAux.length][matrizAux[0].length];
			pintarMatriz.Matriztablero(tableroAux, matrizAux);
			
			Scanner scanner= new Scanner(System.in);
			System.out.print("Comandos ejem(2,N;3,E;2,S): ");
			String listaComandos= scanner.nextLine();
		
			
				boolean mensaje=vehiculo.validarFormatoComandos(listaComandos);
				if (mensaje==true) {
					try {
						Vehiculo matriz[][] = superficie.MoverVehiculo(listaComandos,matrizAux);
						//pintarMatriz.Matriztablero(tableroInicial, matriz);
						pintarMatriz.Matriztablero(tableroAux, matriz);
					
							
						// ver ultima posicion
						for (int i = 0; i < matriz.length; i++) {
							for (int j = 0; j < matriz[i].length; j++) {
								if(matriz[i][j]!=null) {
									ultimaPosicion[0]=matriz.length-i-1;
									ultimaPosicion[1]=j;
									ultimaFila=i;
									ultimaColumna=j;
									
								}
							}
						}
						//ver poss
						/*for (int i =0; i>matriz.length; i++) {
							for (int j =matriz[i].length; j>0; j--) {
								if(matriz[i][j]!=null) {
									
									ultimaPosicion=String.valueOf(i)+String.valueOf(j);
									
									
								}
							}
						}*/
						
						
						System.out.println("Posicion Final: "+ultimaPosicion[0]+","+ultimaPosicion[1]);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					
				}else {		
					System.out.println("Error en formato de comando");			
				}
		
			
				
			
			
		
			
			Scanner entrada= new Scanner(System.in);
			System.out.print("Continuar si/no: ");
			respuesta=entrada.nextLine().toLowerCase();
			
		}
		
		System.out.println("Adios");
		

}
	
}



