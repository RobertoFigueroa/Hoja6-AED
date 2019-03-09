//Roberto Figueroa - 18306
//Fatima Albeño - 18060
//Factory: Esta clase se guia a un patron de diseño que permite crear instancias de objetos que comparten una misma interfaz


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory<K,V> {

    //metodo para instanciar TreeMap, HashMap o LinkedMap
    public Map<K,V> genMap(int op){
        if (op == 1) {
            return new HashMap<K,V>();
        } else if (op == 2) {
            return new TreeMap<K,V>();
        } else {
            return new LinkedHashMap<K,V>();
        }
    }


    //metodo para instanciar Map <Integer, String> para llevar el control de la cantidad de cartas de un tipo
    public Map<String, Integer> genCantMap(int op){
        if (op == 1) {
            return new HashMap<String, Integer>();
        } else if (op == 2) {
            return new TreeMap<String, Integer>();
        } else {
            return new LinkedHashMap<String, Integer>();
        }
    }

}
