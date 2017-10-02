import java.util.Hashtable;

/**
 *
 * @author 
 */
public class Taller9{    
    //pedrito 1    
    public static void agregar(Hashtable empresas,String key, String value){
        empresas.put(key, value);
    }
    
    //pedrito 2
    public static void buscar(Hashtable empresas,String key){
        System.out.println(empresas.get(key));
    }
    //pedrito 3
    public static boolean contienekey(Hashtable empresas,String key){
        if(empresas.containsKey(key)){
            buscar(empresas, key);
            return true;
        }
        return false;
    } 
    
    public static boolean contienePais(Hashtable empresas, String value){
        if(empresas.containsValue(value)){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        Hashtable empresas = new Hashtable();
        agregar(empresas, "Google", "Estados Unidos");
        agregar(empresas, "La locura", "Colombia");
        agregar(empresas, "Nokia", "Finlandia");
        agregar(empresas, "Sonny", "Japon");
        
        System.out.println(contienekey(empresas, "La locura"));
        System.out.println(contienekey(empresas, "Goo"));
        
        System.out.println(contienePais(empresas, "India"));
        System.out.println(contienePais(empresas, "Colombia"));
    }
} 