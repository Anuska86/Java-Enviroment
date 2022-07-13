package actividad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		  /**
	     * @param args the command line arguments
	     */

	     String[][] asr_arrNotas = {{"M01","M02","M03","M04"}
	     						,{"8","3","9","10"}
	     						,{"5","8","7","4"}
	     						,{"10","9","6","9"}};
	     
	     int asr_seleccion = 0;
	        
	      do {  
	        System.out.println("Introduzca la operación a realizar del siguiente menú de opciones: \n"
	        		+ "1-Mostrar el nombre de todas las asignaturas. \n"
	        		+ "2-Mostrar la puntuacion mayor de cada una de las asignaturas. \n"
	        		+ "3-Modificar la puntuación de una asignatura. \n"
	        		+ "4-Mostrar todos los valores del array multidimensional. \n"
	        		+ "0- Salir");
	        try{
	        	Scanner asr_decision = new Scanner(System.in);
	        	asr_seleccion = Integer.parseInt(asr_decision.nextLine());
	            System.out.println("Has seleccionado la  opción número: "+asr_seleccion); 
	            if(asr_seleccion>4 || asr_seleccion<0) {
	            	System.out.println("Solo se aceptan números entre 0 y 4 "); 
	            }
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("Introduzca únicamente valores entre 0 y 4"); 
	            ex.printStackTrace();
	        }
	       
	    	switch(asr_seleccion)
	    	{

	    	   case 1 : 
	    		   System.out.println("Los nombres de las asignaturas son:");
	    		   for (int i = 0; i < asr_arrNotas[0].length; i++) {
	    					   System.out.println(asr_arrNotas[0][i]);
	    		   }
	    		   break; 
	    	   
	    	   case 2:
	    		   for (int i = 0; i < asr_arrNotas[0].length; i++) {
	    			   Double asr_notaMayor = devolverMayorPuntuacion(asr_arrNotas,i);
	    			   System.out.println("La mayor nota de la asignatura "+ asr_arrNotas[0][i] + " es "+asr_notaMayor);  
	    			   
	    		   }
	    	      break; 
	    	      
	    	   case 3:
	    		   int asr_asignatura = recogerValorAsignatura();
	    		   int asr_posicion = recogerValorPosicion();
	    		   double nota = recogerValorNota();
	    		   asr_arrNotas[asr_posicion][asr_asignatura] = String.valueOf(nota);
	     	      break; 
	    	   case 4:
	    		  System.out.println("El array es: ");
	    		  for (int i = 0; i < asr_arrNotas[0].length; i++) {
	    			  System.out.println(Arrays.toString(asr_arrNotas[i]));
	    		  }
	     	      break; 
	    	}
	    	System.out.println("\n");
	      }
	    while (asr_seleccion !=0);
	    
	    System.out.println("Adios"); 
	    System.exit(0);
	    }
	    
	    public static int recogerValorAsignatura() {
	    	boolean asr_Bandera=true;
	    	int asr_seleccionAsignatura = 0;
	    	while(asr_Bandera) {
	        System.out.println("Indica el número de la asignatura (0 a 3):");
	        try{
	        	Scanner asr_decisionAsignatura = new Scanner(System.in);
	            asr_seleccionAsignatura = Integer.parseInt(asr_decisionAsignatura.nextLine());
	        	if(asr_seleccionAsignatura<3 && asr_seleccionAsignatura>=0 ) {
		            asr_Bandera = false;
	        	}
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("Introduzca únicamente valores entre 0 y 3. Prueba de nuevo"); 
	        }
	    	}
	        return asr_seleccionAsignatura;
	    }
	    
	    public static int recogerValorPosicion() {
	    	boolean asr_Bandera=true;
	    	int asr_seleccionPosicion = 0;
	    	while(asr_Bandera) {
	        System.out.println("Indica la posición a cambiar  (0 a 2):");
	        try{
	        	Scanner decisionPosicion = new Scanner(System.in);
	            asr_seleccionPosicion = Integer.parseInt(decisionPosicion.nextLine());
	        	if(asr_seleccionPosicion<2 && asr_seleccionPosicion>=0  ) {
		            asr_Bandera = false;
	        	}
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("Introduzca únicamente valores entre 0 y 2. Prueba de nuevo"); 
	        }
	    	}
	        return asr_seleccionPosicion+1;
	    }
	    
	    public static double recogerValorNota() {
	    	boolean asr_Bandera=true;
	    	double asr_seleccionNota = 0.0;
	    	while(asr_Bandera) {
	            System.out.println("Indica la nota (entre 0 y 10):");
	            try{ 
	            	Scanner asr_decisionNota = new Scanner(System.in);
	            	asr_seleccionNota = Double.parseDouble(asr_decisionNota.nextLine());
		        	if(asr_seleccionNota>=0.0 && asr_seleccionNota<10.01) {
		                System.out.println("La nueva nota es de: "+asr_seleccionNota);
		                asr_Bandera = false;
		        	}
	            }
	            catch (NumberFormatException ex){
	            	System.out.println("Introduzca únicamente valores numéricos. Prueba de nuevo"); 
	                ex.printStackTrace();
	            }
	    	}
	        return asr_seleccionNota;
	    }
	    
	    public static Double devolverMayorPuntuacion(String[][] asr_notas,int asr_posicion) {
			   double asr_mayorNota = 0.0;
			   for (int i = 1; i < asr_notas.length; i++) {
				   if(Double.parseDouble(asr_notas[i][asr_posicion])>asr_mayorNota) {
					   asr_mayorNota = Double.parseDouble(asr_notas[i][asr_posicion]);
				   }
				 }
			   return asr_mayorNota;
	    	
	    }

	}
