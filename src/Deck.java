import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Inicia el juego con las 52 cartas de poker
    private void initializeDeck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    // Mezcla el deck
    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    // Muestra y remueve la primera carta del deck
    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    // Selecciona una carta aleatoria y la remueve del deck
    public void pick() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            Card card = cards.remove(rand.nextInt(cards.size()));
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    // Regresa 5 cartas del deck y las remueve
    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas para una mano.");
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();  // Paso 1 - Mezclar el deck
        deck.head();     // Paso 2 - Mostrar la primera carta
        deck.pick();     // Paso 3 - Seleccionar una carta al azar
        deck.hand();     // Paso 4 - Mostrar una mano de 5 cartas
    }
}

