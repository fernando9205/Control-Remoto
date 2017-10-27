package test;

import java.util.Scanner;

import logic.Superficie;
import logic.Vehiculo;

public class PintarMatriz {


	public PintarMatriz() {



	}


	public void Matriztablero(String [][]tablero,Vehiculo matriz[][]){
		for ( int i = 0; i<matriz.length ; i++) { 
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]==null) {
					tablero[i][j]=" ";
				}else {
					tablero[i][j]="X";
				}

			}
		}
	


		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print("["+tablero[i][j]+"]"+"\t");
			}

			System.out.println();
		}







}

}


