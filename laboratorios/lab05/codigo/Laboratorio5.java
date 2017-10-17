public class Laboratorio5 {

   public static void dibujarArbol(BinaryTree a){
       System.out.println("http://www.webgraphviz.com/"); 
       dibujarArbolAux(a.root);
   }
   
   public static void dibujarArbolAux(Node nodo){
       if (nodo != null){
           //"x_\n__" -> "xo\n__";
           for(Node n: new Node[] {nodo.left, nodo.right} ){
               if (n != null){
                System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
               }
               dibujarArbolAux(n);
            }
       }
   }

    
   public static void main(String[] args) {
    
       //Crea el árbol familiar
       BinaryTree tree = new BinaryTree();
       // ...
        
       //Imprime el árbol familiar
       tree.recursivePrint();

       //Dibuja el árbol familiar
       dibujarArbol(tree);
   }
}
