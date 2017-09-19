public class Laboratorio3 {
        private static int maximoAux(Node nodo) {
        int max=0;
        if(nodo==null){
            return max;
        }
        else{
            max= nodo.data;
            max=Math.max(max, maximoAux(nodo.next));
        }
        return max; 
    }
    public static int maximo(LinkedListMauricio lista) {
        return maximoAux(lista.first);
    }
    public static boolean compararListas(LinkedListMauricio lista1,LinkedListMauricio lista2){
        boolean resp=false;
        if(lista1.first==null && lista2.first==null){
            return true;
        }
        if(lista1.first==null|| lista2.first==null){
           return resp;
        }
        for(int i=0; i< lista1.size -1;++i){
            if(lista1.get(i)==lista2.get(i)){
                resp= true;
            } else {
                resp=false;
            }
           
        }
        return resp; 
    }
 
    public static void main(String[] args)
    {       
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        
        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("Maximo: "+maximo(list));
        
        LinkedListMauricio list2 = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        
        LinkedListMauricio list3 = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        
        System.out.println(compararListas(list2, list3));
        
        LinkedListMauricio list4 = new LinkedListMauricio();
        list.insert(2, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        
        System.out.println(compararListas(list, list3));
    }   
}