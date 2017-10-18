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
        Node isabela = new Node("Isabela");
        Node mama = new Node("Nora");
        Node papa = new Node("Mauricio");
        Node abuelaP = new Node("Ines");
        Node BabuelaPM = new Node("Rosa María");
        Node BabueloPM = new Node("Gabriel");
        Node abueloP = new Node("Bernardo");
        Node BabuelaPP = new Node("Teresa");
        Node BabueloPP = new Node("Martín");
        Node abuelaM = new Node("Socorro");
        Node BabuelaMM = new Node("Rosa María ");
        Node BabueloMM = new Node("Pedro Rafael");
        Node abueloM = new Node("Miguel");
        Node BabuelaMP = new Node("Carmen");
        Node BabueloMP = new Node("");
        
        tree.insertar(isabela.data, "mujer"); 
        tree.insertar(mama.data, "mujer"); 
        tree.insertar(papa.data, "Hombre");
        
        tree.insertar(tree.root.right, abuelaP.data, "mujer");
        tree.insertar(tree.root.right.left, BabuelaPM.data, "Mujer");
        tree.insertar(tree.root.right.left, BabueloPM.data, "Hombre");
        
        tree.insertar(tree.root.right, abueloP.data, "hombre");
        tree.insertar(tree.root.right.right, BabuelaPP.data, "Mujer");
        tree.insertar(tree.root.right.right, BabueloPP.data, "hombre");
        
        tree.insertar(tree.root.left, abuelaM.data, "mujer");
        tree.insertar(tree.root.left.left, BabuelaMM.data, "Mujer");
        tree.insertar(tree.root.left.left, BabueloMM.data, "Hombre");
        
        tree.insertar(tree.root.left, abueloM.data, "Hombre");
        tree.insertar(tree.root.left.right, BabuelaMP.data, "Mujer");
        tree.insertar(tree.root.left.right, BabueloMP.data, "Hombre");
        
        System.out.println("Árbol 1: \n");
        Laboratorio5.dibujarArbol(tree);
        
        BinaryTree tree2 = new BinaryTree();
        Node mateo = new Node("Mateo");
        Node mama2 = new Node("Gloria");
        Node papa2 = new Node("Raúl");
        Node abuelaP2 = new Node("Olga");
        Node BabuelaPM2 = new Node("");
        Node BabueloPM2 = new Node(" ");
        Node abueloP2 = new Node("José Raúl");
        Node BabuelaPP2 = new Node("   ");
        Node BabueloPP2 = new Node("José");
        Node abuelaM2 = new Node("Ofelia");
        Node BabuelaMM2 = new Node("Candelaria");
        Node BabueloMM2 = new Node("Joaquín");
        Node abueloM2 = new Node("Enrique");
        Node BabuelaMP2 = new Node("Raquel");
        Node BabueloMP2 = new Node("Carlos");
        
        tree2.insertar(mateo.data, "Hombre"); 
        tree2.insertar(mama2.data, "mujer"); 
        tree2.insertar(papa2.data, "Hombre");
        
        tree2.insertar(tree2.root.right, abuelaP2.data, "mujer");
        tree2.insertar(tree2.root.right.left, BabuelaPM2.data, "Mujer");
        tree2.insertar(tree2.root.right.left, BabueloPM2.data, "Hombre");
        
        tree2.insertar(tree2.root.right, abueloP2.data, "hombre");
        tree2.insertar(tree2.root.right.right, BabuelaPP2.data, "Mujer");
        tree2.insertar(tree2.root.right.right, BabueloPP2.data, "hombre");
        
        tree2.insertar(tree2.root.left, abuelaM2.data, "mujer");
        tree2.insertar(tree2.root.left.left, BabuelaMM2.data, "Mujer");
        tree2.insertar(tree2.root.left.left, BabueloMM2.data, "Hombre");
        
        tree2.insertar(tree2.root.left, abueloM2.data, "Hombre");
        tree2.insertar(tree2.root.left.right, BabuelaMP2.data, "Mujer");
        tree2.insertar(tree2.root.left.right, BabueloMP2.data, "Hombre");
        
        System.out.println("\nÁrbol 2: \n");
        Laboratorio5.dibujarArbol(tree2);
        //1.2
        System.out.println("Altura árbol 1: " + tree. maxheight());
        System.out.println(tree.buscar("Ines"));
        System.out.println(tree.buscar("Camilo"));
        System.out.println(tree.buscar("Mauricio"));
        
        System.out.println("Altura árbol 2: " + tree2. maxheight());
        System.out.println(tree2.buscar("Ofelia"));
        System.out.println(tree2.buscar("Raúl"));
        System.out.println(tree2.buscar("Laura"));
        //1.3
        System.out.println("Abuela materna de " + isabela.data + ": " + tree.getGrandMothersName(isabela.data));
        System.out.println("Abuela materna de " + mateo.data + ": " + tree2.getGrandMothersName(mateo.data));
    }
}
