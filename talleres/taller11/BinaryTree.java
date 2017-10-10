public class BinaryTree {
    public Node root;
 
    public BinaryTree(){
        root = null;
    }
    
    private int max2(int i, int j)
    {
        if (i > j){
            return i;
        }
        return j;
    }
    
    private int maxheightAUX(Node node)
    {
        if (node == null){
            return 0;
        }
        else{ 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
            }
    }
    
    public int maxheight()
    {
       return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null){
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right); 
            System.out.println(node.data);
        } 
    }
    
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    
    private boolean buscar(Node nodo, int n){
        if(nodo == null){
            return false;
        }
        if(nodo.data == n){
            return true;
        }
        if(nodo.data < n){
            return buscar(nodo.left,n);
        }
        return buscar(nodo.right, n);
    }
    
    public boolean buscar(int n){
        return buscar(root, n);
    }
    
    private boolean insertar(Node nodo, int n){
        if(nodo.data == n){
            return false;
        }
        if(nodo.data > n){
            if(nodo.left == null){
                nodo.left = new Node(n);
                return true;
            }
            else{
                return insertar(nodo.left, n);
            }
        }
        if(nodo.data < n){
             if(nodo.right == null){
                nodo.right = new Node(n);
                return true;
            }
            else{
                return insertar(nodo.right, n);
            }
        }
        return false;
    }
    
    public void insertar(int n){
        if(root == null){
            root = new Node(n);
        }
        insertar(root, n);
    }
    
    private Node borrar(Node nodo, int n){
        if(nodo == null){
            return nodo;
        }
        if(n < nodo.data){
            nodo.left = borrar(nodo.left, n);
        }
        else if(n > nodo.data){
            nodo.right = borrar(nodo.right, n);
        }
        else{
            if(nodo.left == null){
                return nodo.right;
            }
            else if(nodo.right == null){
                return nodo.left;
            }
            nodo.data = minimo(nodo.right);
            nodo.right = borrar(nodo.right, nodo.data);
        }
        return nodo;
    }
    
    public void borrar(int n){
        borrar(root, n);
    }
    
    private int minimo(Node nodo){
        int min = nodo.data;
        while(nodo.left != null){
            min = nodo.left.data;
            nodo = nodo.left;
        }
        return min;
    }
}