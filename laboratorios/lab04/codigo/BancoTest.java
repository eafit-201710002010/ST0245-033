

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class BancoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BancoTest
{
    public static void simular(){
    	Queue<String> cola1;
    	String[] a = {"Juan","Maria","Pedro","Mariana"};
    	cola1=toQueue(a);

    	Queue<String> cola2;
    	String[] b = {"Camilo","Ariana","Sara"};
    	cola2=toQueue(b);
    	
    	Queue<String> cola3;
    	String[] c = {"Mateo","Isabela","Camila","Raquel","Julieta"};
    	cola3=toQueue(c);
    	
    	Queue<String> cola4;
    	String[] d = {"luisa","Felipe"};
    	cola4=toQueue(d);
    	
    	    	
    	Queue<String> cola5;
    	String[] f = {};
    	cola5=toQueue(f);
    	
    	Queue<String> cola6;
    	String[] g = {"Laura", "Andres", "Sebastian"};
    	cola6=toQueue(g);

    	Queue<String> cola7;
    	String[] h = {"Valentina"};
    	cola7=toQueue(h);
    	
    	Queue<String> cola8;
    	String[] i = {};
    	cola8=toQueue(i);
    	
    	System.out.println("PRUEBA 1: ");
    	Banco.simular(cola1, cola2, cola3, cola4);
    	System.out.println("\nPRUEBA 2: ");
    	Banco.simular(cola5, cola6, cola7, cola8);
    }
    
    public static Queue<String> toQueue(String[]array){
        Queue<String> a=new LinkedList<String>();
        for(int i=0;i<array.length;i++){
            a.add(array[i]);
        }
        return a;
    }
}
