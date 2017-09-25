import java.util.*;
public class Taller8 {
    //Punto 1
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> aux = new Stack<Integer>();
        while(stack.size() > 0){
            aux.push(stack.pop());
        }
        return aux;
    }
    //Punto 2
    public static void cola (Queue<String> queue){
        while(queue.size() > 0){
            System.out.println("Atendiendo a " + queue.peek());
            queue.remove(queue.peek());
        }
    }
    //notacion polaca
    public static int polaca  (String string){
        String[] aux = string.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        int res;
        for(int i=0; i<aux.length; i++){
            if(aux[i].equals("+")){
                res=stack.pop();
                while(stack.size() > 0){
                     res += stack.pop(); 
                }
                stack.push(res);
            }
            else if(aux[i].equals("-")){
                res=stack.pop();
                while(stack.size() > 0){
                    res-=stack.pop(); 
                }
                stack.push(res);
            }
            else if(aux[i].equals("*")){
                res=stack.pop();
                while(stack.size() > 0){
                     res*=stack.pop(); 
                }
                stack.push(res);
            }
            else if(aux[i].equals("/")){
                res=stack.pop();
                while(stack.size() > 0){
                     res/=stack.pop(); 
                }
                stack.push(res);
            }
            else stack.push(Integer.parseInt(aux[i]));
        }
        return stack.peek();
    }
}