import java.util.*;
public class Banco
{
    Queue [] filas = new Queue[3];
    
    public static boolean isEmpty(Queue<String> cola){
        return cola.isEmpty();
    }

    public static void simular(Queue<String> fila1, Queue<String> fila2, Queue<String> fila3, Queue<String> fila4){
        boolean allEmpty = false;
        Queue[] filas = {fila1, fila2, fila3, fila4};        
        while(allEmpty != true){          
            for(int i = 0; i<filas.length; ++i){                       
                int j = 1;
                if(isEmpty(fila1) && isEmpty(fila2) && isEmpty(fila3) && isEmpty(fila4)){
                    allEmpty = true;
                    break;
                }
                if(isEmpty(filas[i])){
                    while(isEmpty(filas[i])){ 
                        if(i>=3){
                            i=0;
                        }
                        else{
                            ++i;
                        }
                    }
                    System.out.println(j + ". " + filas[i].poll());
                } 
                else{ 
                    System.out.println(j + ". " + filas[i].poll());
                }
                j = 2;
                ++i;
                if(i>3){
                    i=0;
                }
                if(isEmpty(filas[i])){ 
                    while(isEmpty(filas[i])){
                        if(i>=3){
                            i=0;
                        }
                        else{
                            ++i;
                        }
                    }
                    System.out.println(j + ". " + filas[i].poll());
                } 
                else{
                    System.out.println(j + ". " + filas[i].poll());
                }
            }  
        }
    }
}
