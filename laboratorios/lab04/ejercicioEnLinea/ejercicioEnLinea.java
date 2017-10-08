
/**
 * Write a description of class Brazo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ejercicioEnLinea
{
    public static void pila(int n,  Stack [] array ){
        for (int i=0; i<n; ++i){
            Stack<Integer> pila = new Stack<Integer>();  
            pila.push(i);
            array [i] = pila;
        }
    }
    public static void moveOnto(int a, int b, Stack [] array){ 
        for(int j=0; j < array.length; ++j){
            if(array[j].contains(b)){
                if(array[j].contains(a)){
                    System.out.println("Comando ilegal");
                    break;
                }
                while(((int)array[j].peek())!=(b)){
                    for(int i =0; i< array.length;++i){
                        if(((int)array[j].peek())==(i)){
                            array[i].push(array[j].pop());
                        }
                    }
                }          
                for(int k=0; k < array.length; k++){
                    if(array[k].contains(a)){
                        while(((int)array[k].peek())!=(a)){
                            for(int i =0; i< array.length;++i){
                                if(((int)array[k].peek())==(i)){
                                    array[i].push(array[k].pop());
                                }
                            }   
                        }     
                        array[j].push(array[k].pop());   
                    }
                }
            }
        }   
    }
    
    public static void moveOver(int a, int b, Stack [] array){
        for (int i=0; i<array.length; ++i){
            if (array[i].contains(b)){
                if(array[i].contains(a)){
                    System.out.println("Comando ilegal");
                    break;
                }
                for(int j= 0; j< array.length; j++){
                    if(array[j].contains(a)){
                        while(((int)array[j].peek())!=(a)){
                            for(int k =0; k< array.length;++k){
                                if(((int)array[j].peek())==(k)){
                                    array[k].push(array[j].pop());
                
                                }
                            }
                        }     
                        array[i].push(array[j].pop());   
                    }              
                }
            }
        }   
    }
    
    public static void pilaOnto(int a, int b, Stack [] array){
        for(int j=0; j < array.length; ++j){
            if(array[j].contains(b)){
                if(array[j].contains(a)){
                    System.out.println("Comando ilegal");
                    break;
                }
                while(((int)array[j].peek())!=(b)){
                    for(int i =0; i< array.length;++i){
                        if(((int)array[j].peek())==(i)){
                            array[i].push(array[j].pop());
                        }
                    }
                }         
                for(int k=0; k < array.length; k++){
                    if(array[k].contains(a)){
                        Stack <Integer> tmp = new Stack <Integer>(); 
                        while(((int)array[k].peek())!=(a)){
                            tmp.push((int)array[k].pop());
                        }
                        array[j].push(array[k].pop());  
                        for(int l=0; l <= tmp.size(); l++){
                            array[j].push(tmp.pop());
                        } 
                    }
                }  
            }
        }   
    }
    
    public static void pilaOver(int a, int b, Stack [] array){
        for(int j=0; j < array.length; ++j){
            if(array[j].contains(b)){
                if(array[j].contains(a)){
                    System.out.println("Comando ilegal");
                    break;
                } 
                for(int k=0; k < array.length; k++){
                    if(array[k].contains(a)){
                        Stack <Integer> tmp = new Stack <Integer>(); 
                        while(((int)array[k].peek())!=(a)){
                            tmp.push((int)array[k].pop());    
                        }
                        array[j].push(array[k].pop());  
                        for(int l=0; l <= tmp.size(); l++){
                            array[j].push(tmp.pop());
                        } 
                    }
                }  
            }   
        }       
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);    
        int a;
        int b;
        int accion;
        System.out.println("Ingrese el número de bloques");
        int n = scan.nextInt();
        Stack [] bloques= new Stack [n];
        pila(n, bloques);
        do{
            System.out.println("Acciones:");
            System.out.println("1. Move a onto b");
            System.out.println("2. Move a over b");
            System.out.println("3. Pile a onto b");
            System.out.println("4. Pile a over b");
            System.out.println("5. Quit");
            
            accion = scan.nextInt();
            switch(accion){
                case 1:
                    System.out.println("ingrese el bloque que desea mover");
                    a = scan.nextInt();
                    System.out.println("ingrese a donde desea mover el bloque " + a);
                    b = scan.nextInt();
                    moveOnto(a,b,bloques);
                    break;                   
                case 2:
                    System.out.println("ingrese el bloque que desea mover");
                    a = scan.nextInt();
                    System.out.println("ingrese a donde desea mover el bloque " + a);
                    b = scan.nextInt();
                    moveOver(a,b,bloques);
                    break;
                case 3:
                    System.out.println("ingrese el bloque que desea mover");
                    a = scan.nextInt();
                    System.out.println("ingrese a donde desea mover el bloque " + a);
                    b = scan.nextInt();
                    pilaOnto(a,b,bloques);
                break;
                case 4:
                    System.out.println("ingrese el bloque que desea mover");
                    a = scan.nextInt();
                    System.out.println("ingrese a donde desea mover el bloque " + a);
                    b = scan.nextInt();
                    pilaOver(a,b,bloques);
                    break;
                case 5:
                    for (int i=0; i<bloques.length; ++i){
                        System.out.println(i +": "+bloques[i]);    
                    }  
                    break;
                default:
                    System.out.println("Entrada invalida");
                    break;
            }
        }while(accion!=5);
    }
}
