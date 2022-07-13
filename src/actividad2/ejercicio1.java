package actividad2;

import java.util.Arrays;
import java.util.Scanner;

public class ejercicio1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double[] asr_arrRecipientes = new double[5];
        int asr_seleccion = 0;
        double asr_litros = 0.0;
        int asr_numRecipiente= 0;
        double asr_nuevoEstado = 0;
        
      do {  
        System.out.println("Introduzca la operación a realizar del siguiente menú de opciones: \n"
        		+ "1- Añadir refresco a un recipiente. \n"
        		+ "2- Quitar refresco de un recipiente. \n"
        		+ "3- Calcular el total de refresco. \n"
        		+ "0- Finalizar");
        try{
        	Scanner decision = new Scanner(System.in);
            asr_seleccion = Integer.parseInt(decision.nextLine());
            System.out.println("Has seleccionado la  opción número: "+asr_seleccion); 
        }
        catch (NumberFormatException ex){
        	System.out.println("Introduzca únicamente valores entre 0 y 3"); 
            ex.printStackTrace();
        }
       
    	switch(asr_seleccion)
    	{

    	   case 1 : 
    		   asr_numRecipiente = recogerValorRecipiente();
    		   asr_litros = recogerValorLitros();
    		   asr_arrRecipientes[asr_numRecipiente] = modificarRecipientes("sumar",asr_arrRecipientes,asr_numRecipiente,asr_litros);   		   
    		   System.out.println("Añadiendo "+asr_litros+" de refresco al recipiente "+ asr_numRecipiente); 
    	      break; 
    	   
    	   case 2:
    		   asr_numRecipiente = recogerValorRecipiente();
    		   asr_litros = recogerValorLitros();
    		   asr_arrRecipientes[asr_numRecipiente] = modificarRecipientes("restar",asr_arrRecipientes,asr_numRecipiente,asr_litros);
    		   System.out.println("Eliminando "+asr_litros+" de refresco al recipiente "+ asr_numRecipiente); 
    	      break; 
    	      
    	   case 3:
    		   double totalLitros = Arrays.stream(asr_arrRecipientes).sum();
    		   System.out.println("Calculando total de litros: "+totalLitros); 
     	      break; 
    	     
    	}
    	 System.out.println("El estado actual de los recipientes es "+ Arrays.toString(asr_arrRecipientes)+"\n"); 
		 asr_numRecipiente = 0;
		 asr_litros = 0.0;
		 asr_nuevoEstado = 0.0; 
      }
    while (asr_seleccion !=0);
    
    System.out.println("Adios"); 
    System.exit(0);
    }
    
    public static int recogerValorRecipiente() {
    	boolean asr_Bandera=true;
    	int asr_seleccionRecipiente = 0;
    	while(asr_Bandera) {
        System.out.println("Indica el número de recipiente (0 a 4):");
        try{
        	Scanner asr_decisionRecipiente = new Scanner(System.in);
        	asr_seleccionRecipiente = Integer.parseInt(asr_decisionRecipiente.nextLine());
        	if(asr_seleccionRecipiente<=4 && asr_seleccionRecipiente>=0  ) {
	            asr_Bandera = false;
        	}else {
                System.out.println("Has seleccionado el recipiente número: "+asr_seleccionRecipiente); 
        	}
        }
        catch (NumberFormatException ex){
        	System.out.println("Introduzca únicamente valores entre 0 y 4"); 
            ex.printStackTrace();
        }
    	}
        return asr_seleccionRecipiente;
    }
    
    public static double recogerValorLitros() {
    	double asr_seleccionLitros = 0.0;
    	while(asr_seleccionLitros==0.0 || asr_seleccionLitros<0) {
            System.out.println("Indica el número de litros:");
            try{
            	Scanner asr_decisionLitros = new Scanner(System.in);
                asr_seleccionLitros = Double.parseDouble(asr_decisionLitros.nextLine());
                
                if(asr_seleccionLitros<0) {
                	System.out.println("Introduce un valor superior a 0");
                }else {
                    System.out.println("El número de litros seleccionado es de: "+asr_seleccionLitros);
                } 
            }
            catch (NumberFormatException ex){
            	System.out.println("Introduzca únicamente valores numéricos"); 
                ex.printStackTrace();
            }
    	}
        return asr_seleccionLitros;
    }
    
    public static double modificarRecipientes(String asr_accion,double[] asr_recipientes,int asr_recipiente,double asr_litros) {
		   double asr_nuevoEstado =  0.0;
		   if(asr_accion=="sumar") {
    		   asr_nuevoEstado = asr_recipientes[asr_recipiente] + asr_litros;
		   }else {
    		   asr_nuevoEstado = asr_recipientes[asr_recipiente] - asr_litros;
    		   if(asr_nuevoEstado<=0) {
    			   asr_nuevoEstado = 0.0;
    			   System.out.println("Dado que el resto en litros supera los existentes, el recipiente ha quedado vacio"); 
    		   }
		   }
		return asr_nuevoEstado;
    	
    }
    
}
