import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //instacias utiles
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> dict;


        System.out.println("Bienvenidos al lector de cartas!");
        System.out.println("1.HashMap\n2.TreeMap\n3.LinkedHashMap");
        System.out.println("Ingrese el numero de la implementacion que desee utilizar : ");
        int op = sc.nextInt();

        //factory:
        if(op==1){ dict = new HashMap<>(); }
        else if(op == 2){dict = new TreeMap<>();}
        else {dict = new LinkedHashMap<>(); }

        //leer cartas del archivo de texto
        //consultado de: https://geekytheory.com/como-leer-un-fichero-en-java
        String cadena;
        FileReader f = new FileReader("C:\\Users\\rober\\OneDrive\\Documentos\\GitHub\\Hoja6-AED\\src\\cards_desc.txt");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();

        //agregar cartas ... 

    }

}
