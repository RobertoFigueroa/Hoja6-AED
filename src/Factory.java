import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory<K,V> {

    public Map<K,V> genMap(int op){
        if (op == 1) {
            return new HashMap<K,V>();
        } else if (op == 2) {
            return new TreeMap<K,V>();
        } else {
            return new LinkedHashMap<K,V>();
        }
    }

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
