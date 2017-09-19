import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    Node first;
    int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }
    
    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {   
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();           
        }
        if(index == 0){
            Node nuevo = new Node(data);
            nuevo.next = first;
            first = nuevo;
            ++size;
        } 
        else {
            Node nuevo = new Node(data);
            Node temp = first;
            for(int i=1; i<=index-1; ++i){
               temp = temp.next;
            }
            nuevo.next = temp.next;
            temp.next = nuevo;
            ++size;
        }
     }
    
    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();           
        }
        if(index == 0){
            Node temp = first;
            first = temp.next;
            --size;
        } 
        else {
            //Node nuevo = new Node(get(index));
            Node temp = first;
            for(int i=1; i<=index-1; ++i){
               temp = temp.next;
            }
            temp.next = temp.next.next;
            --size;
        }
    }
    
    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        for(int i = 0; i <= size-1; ++i){
            if(get(i)==data){
                return true;
            }
        }
        return false;
    }
}