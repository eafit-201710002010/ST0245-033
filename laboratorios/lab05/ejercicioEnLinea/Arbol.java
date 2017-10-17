
/**
 * Write a description of class EjercicioEnLinea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Arbol
{
    public Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    private boolean insertar(Nodo nodo, int n){
        if(nodo.data == n){
            return false;
        }
        if(nodo.data > n){
            if(nodo.left == null){
                nodo.left = new Nodo(n);
                return true;
            }
            else{
                return insertar(nodo.left, n);
            }
        }
        if(nodo.data < n){
             if(nodo.right == null){
                nodo.right = new Nodo(n);
                return true;
            }
            else{
                return insertar(nodo.right, n);
            }
        }
        return false;
    }
    
    public void insertar(int n){
        if(raiz == null){
            raiz = new Nodo(n);
        }
        insertar(raiz, n);
    }
    
    public void postorden(){
        auxPostorden(raiz);
    }
    
    private void auxPostorden(Nodo nodo){
      if (nodo == null){
          return ;
        }
        auxPostorden(nodo.left);
        auxPostorden(nodo.right);
        System.out.println(nodo.data+ " "); 
    }
    
    public static void dibujarArbol(Arbol a){
       System.out.println("\nhttp://www.webgraphviz.com/"); 
       dibujarArbolAux(a.raiz);
    }
   
    public static void dibujarArbolAux(Nodo nodo){
       if (nodo != null){
           //"x_\n__" -> "xo\n__";
           for(Nodo n: new Nodo[] {nodo.left, nodo.right} ){
               if (n != null){
                System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
               }
               dibujarArbolAux(n);
            }
       }
    }
    
    public static void main(String[] args){
        Arbol tree = new Arbol();
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el número de nodos: ");
        int n = scan.nextInt();
        System.out.println("Introduzca " + n + " enteros:\n ");
        for(int i=0; i<n; ++i){           
            int num = scan.nextInt();
            tree.insertar(num);
        }
        System.out.println("\nPos-order: ");
        tree.postorden();
        tree.dibujarArbol(tree);
    }
}
