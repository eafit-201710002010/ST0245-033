import java.util.*;

public class Laboratory3 {
    /**
     * Returns the product of the numbers in the array. 
     * @param array - Array of integers.
     * @return An integer.
     */
    public static int multiplyArray(ArrayList<Integer> array){
        int res = 1;
        for(int i=0; i<array.size(); ++i){
            res*=array.get(i);
        }
        return res;
    }

    /**
     * Returns the product of the numbers in the list. 
     * @param list - List of integers.
     * @return An integer.
     */
    public static int multiplyList(List<Integer> list) {
        int res = 1;
        for(int i=0; i<list.size(); ++i){
            res*=list.get(i);
        }
        return res;
    }
    
    public static void smartInsert(ArrayList<Integer> array, List<Integer> list, int data){
        if(!array.contains(data)){
            array.add(data);
        }
        else System.out.println("El número ya existe");
        if(!list.contains(data)){
            list.add(data);
        }
        else System.out.println("El número ya existe");
    }

    public static int pivote(List<Integer> list){
      return 0;  
    }
    
    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));
        
        // Multiply
        
        System.out.println(multiplyList(linked));
        System.out.println(multiplyList(array));
        System.out.println(multiplyArray(array));
    }
}
