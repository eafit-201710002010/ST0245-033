public class BinaryTree {
    public Node root;
 
    public BinaryTree(){
        root = null;
    }
    
    private int max2(int i, int j){
        if (i > j){
            return i;
        }
        return j;
    }
    
    private int maxheightAUX(Node node){
        if (node == null){
            return 0;
        }
        else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
        }
    }
    
    public int maxheight(){
       return maxheightAUX(root);
    }
    
    private boolean insertar(Node nodo, String nombre, String genero){
        if(nodo.data == nombre){
            return false;
        }
        if(genero.equalsIgnoreCase("mujer")){
            if(nodo.left == null){
                nodo.left = new Node(nombre);
                return true;
            }
            else{
                return insertar(nodo.left, nombre, genero);
            }
        }
        if(genero.equalsIgnoreCase("hombre")){
            if(nodo.right == null){
                nodo.right = new Node(nombre);
                return true;
            }
            else{
                return insertar(nodo.right, nombre, genero);
            }
        }
        return false;
    }
    
    public void insertar(String nombre, String genero){
        if(root == null){
            root = new Node(nombre);;
        }
        insertar(root, nombre, genero);
    }
    
    private Node buscar(Node nodo, String nombre){
        if(nodo == null){
            return null;
        }
        else{
            if(nodo.data.equals(nombre)){
                return nodo;
            }
            Node izq = buscar(nodo.left, nombre);
            if(izq != null){
                return izq;
            }
            Node der = buscar(nodo.right, nombre);
            if(der != null){
                return der;
            }
            return null;
        }
    }
    
    public boolean buscar(String nombre){
        if(buscar(root, nombre) == null){
            return false;
        }
        return true;
    }
    
    public String getGrandMothersName(Node nodo, String nombre){
        Node nieto = buscar(nodo, nombre);
        if(nieto == null){
            return "";
        }
        else{
            if(nieto.left == null){
                return "";
            }
            else{
                if(nieto.left.left == null){
                    return "";
                }
                else{
                    return nieto.left.left.data;
                }
            }
        }
    }
    
    public String getGrandMothersName(String nombre){
        if(root == null){
            root = new Node(nombre);
        }
        return getGrandMothersName(root, nombre);
    }

    private void recursivePrintAUX(Node node){
        if (node != null){
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }
    
    public void recursivePrint(){
        recursivePrintAUX(root);
    }
    
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        Node yo = new Node("Isabela");
        Node mama = new Node("Nora");
        Node papa = new Node("Mauricio");
        Node abuelaP = new Node("Ines");
        Node abueloP = new Node("Bernardo");
        Node abuelaM = new Node("Socorro");
        Node abueloM = new Node("Miguel");
        
        tree.insertar(yo.data, "mujer"); 
        tree.insertar(mama.data, "mujer"); 
        tree.insertar(papa.data, "Hombre");
        
        tree.insertar(tree.root.right, abuelaP.data, "mujer");
        tree.insertar(tree.root.right, abueloP.data, "hombre");
        
        tree.insertar(tree.root.left, abuelaM.data, "mujer");
        tree.insertar(tree.root.left, abueloM.data, "Hombre");
        
        Laboratorio5.dibujarArbol(tree);
        //1.2
        System.out.println("Altura: " + tree. maxheight());
        System.out.println(tree.buscar("Ines"));
        System.out.println(tree.buscar("Camilo"));
        System.out.println(tree.buscar("Mauricio"));
        //1.3
        System.out.println("Abuela materna de " + yo.data + ": " + tree.getGrandMothersName(yo.data));
    }
}
