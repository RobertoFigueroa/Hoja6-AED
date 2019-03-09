import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


public class Main {

    public static void main(String[] args) throws IOException {
        //instacias utiles
        Factory<String,String> factory = new Factory<>();
        Scanner sc = new Scanner(System.in);
        Map<String, String> deck;
        Map<String, String> myDeck;
        Map<String,Integer> cardCant;
        String[] cards;
        String cadena;
        ArrayList<String> cardsSplitted = new ArrayList<>();
        String cardsReaded = "";
        int wantToRepeat = 1;

        System.out.println("Bienvenidos al lector de cartas!");


        System.out.println("1.HashMap\n2.TreeMap\n3.LinkedHashMap");
        System.out.println("Ingrese el numero de la implementacion que desee utilizar : ");
        int op = sc.nextInt();


        //factory:
        deck = factory.genMap(op);
        myDeck = factory.genMap(op);
        cardCant = factory.genCantMap(op);



        //leer cartas del archivo de texto
        //consultado de: https://geekytheory.com/como-leer-un-fichero-en-java
        FileReader f = new FileReader("C:\\Users\\rober\\OneDrive\\Documentos\\GitHub\\Hoja6-AED\\src\\cards_desc.txt");
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            cards = cadena.split("\\|");
            cardsSplitted.add(cards[0]);
            cardsSplitted.add(cards[1]);
        }
        b.close();

        System.out.println(cardsReaded);

        //separar las cartas por tipo .. .
        //cards = cardsReaded.split("[\\|\n]");

        //agregar las cartas a la implementacion de Map correspondiente...
        for (int i = 0; i < cardsSplitted.size(); i += 2) {
            deck.put(cardsSplitted.get(i), cardsSplitted.get(i + 1));
        }
        while(wantToRepeat != 0) {
            //desplegar menu de opciones
            System.out.println("1.Agregar una carta a la coleccion\n2.Mostrar el tipo de una carta\n3.Mostrara mi coleccion\n4.Mostrar mi coleccions " +
                    "ordenadamente\n5.Mostrar el nombre y tipo de todas las cartas existentes\n6.Mostrara todas las cartas existentes ordenadamente\n7." +
                    "Salir");
            int opc = sc.nextInt();
            switch (opc) {
                case 1://agregar cartas a mi coleccion
                    System.out.println("Ingrese el nombre de la carta que desee agregar : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println(name);
                    if (deck.containsKey(name)) {
                        myDeck.put(name, deck.get(name));
                        if (cardCant.containsKey(name)) {
                            int numOfCards = cardCant.get(name);
                            cardCant.put(name, numOfCards++);
                        } else {
                            cardCant.put(name, 1);
                        }
                    } else {
                        System.out.println("Esa carta no existe!");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta para saber su tipo : ");
                    sc.nextLine();
                    String nameCard = sc.nextLine();
                    if (deck.containsKey(nameCard)) {
                        System.out.println("La carta " + nameCard + " es de tipo " + deck.get(nameCard));
                    } else {
                        System.out.println("La carta " + nameCard + " no existe");
                    }

                    break;
                case 3:
                    System.out.println(" Mis cartas  : ");
                    Iterator<Map.Entry<String, String>> userMapIterator = myDeck.entrySet().iterator();
                    while (userMapIterator.hasNext()) {
                        Map.Entry<String, String> pair = userMapIterator.next();
                        System.out.println(pair.getKey() + " | " + pair.getValue() + " Cantidad: " + cardCant.get(pair.getKey()));
                    }
                case 4:
                    System.out.println(" Mis cartas  : ");
                    Map<String, String> sortedMap = myDeck
                            //access the entry Set
                            .entrySet()
                            //as a stream
                            .stream()
                            //sort with the comparingByValue Method
                            .sorted(comparingByValue())
                            .collect(
                                    //collect all the entries and set them in the LinkedHashMap object
                                    toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                            LinkedHashMap::new));
                    System.out.println(sortedMap);
                    Iterator<Map.Entry<String, String>> iterator = myDeck.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, String> pair = iterator.next();
                        System.out.println(pair.getKey() + " | " + pair.getValue() + " Cantidad: " + cardCant.get(pair.getKey()));
                    }
                    break;
                case 5:
                    System.out.println("Cartas existentens en la baraja : ");
                    Iterator<Map.Entry<String, String>> cardMap = deck.entrySet().iterator();
                    while (cardMap.hasNext()) {
                        Map.Entry<String, String> pair = cardMap.next();
                        System.out.println("Nombre: " + pair.getKey() + "\tTipo : " + pair.getValue());
                    }

                    break;
                case 6:
                    System.out.println("Cartas existentens en la baraja mostradas ordenadamentes : ");
                    Map<String, String> sortedGeneralMap = deck
                            //access the entry Set
                            .entrySet()
                            //as a stream
                            .stream()
                            //sort with the comparingByValue Method
                            .sorted(comparingByValue())
                            .collect(
                                    //collect all the entries and set them in the LinkedHashMap object
                                    toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                            LinkedHashMap::new));
                    for (Map.Entry<String, String> entry : sortedGeneralMap.entrySet()) {
                        System.out.println(entry.getKey() + "/" + entry.getValue());
                    }

                    break;

            }
            opc = 0;
            System.out.println("Ingrese 0 para terminar y cualquier otro numero para seguir: ");
            wantToRepeat = sc.nextInt();
        }

    }
    }



