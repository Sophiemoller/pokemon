import java.util.HashMap;
import ecs100.*;
/**
 * Driver class.
 * Holds a collection of pokemon cards and their details in a hashmap
 * allows user to add, find, print all pokemon cards
 *
 * @author Sophie Moller
 * @version 23/5/22
 */
public class PokemonCards
{
    // fields
    private HashMap<Integer, PokemonCard> PokemonCardList; // declaring hashMap
    private int currCardId; // store instance of current card id
    // store instance of current pokemon card
    private PokemonCard currCard; 
    /**
     * Constructor for objects of class PokemonCards
     */
    public PokemonCards()
    {
        // initialise intance variables
        // initalise hashmap
        PokemonCardList = new HashMap<Integer, PokemonCard>(); 
        
        // create cards
        PokemonCard p1 = new PokemonCard(1, "Pikachu", 18605 , "Pikachu.png"); 
        PokemonCard p2 = new PokemonCard(2, "Charizard", 19999,
                                            "Charizard.jpeg");
        PokemonCard p3 = new PokemonCard(3, "Shaymin", 208605, "Shaymin.png"); 
        
        // add cards to the card collection
        PokemonCardList.put(1, p1);
        PokemonCardList.put(2, p2);
        PokemonCardList.put(3, p3);
        
        // store the current card id
        this.currCardId = 3;
        
    }
    
    /**
     * set card id
     */
    public void setPokemonCardId() {
        this.currCardId += 1;
    }
    
    /**
     * Add card to Pokemon card list function
     * Adding card to hashmap
     * @param name for PokemonCards
     * @param mon for PokemonCards
     * @param img for PokemonCards
     */
    public void addCard(String name, int mon, String img)
    {
        // adding book to hashmap
        PokemonCardList.put(currCardId, new PokemonCard(currCardId, 
                            name, mon, img));
        
    }
    
    /**
     * Find a pokemon card based on the name
     * returns boolean false if the card isnt found
     * @param name for PokemonCards
     * @return name for PokemonCards
     */
    public boolean findCard(String name) {
        for (int pokemonCardId : PokemonCardList.keySet()) {
            if (PokemonCardList.get(pokemonCardId).getName().toLowerCase()
                .equals(name.toLowerCase())) {
                currCard = PokemonCardList.get(pokemonCardId);
                currCard.displayPokemonCard();
                return true;
            } 
        } 
        return false;
    }
    
    /**
     * getter for current card instance
     * @return currCard for PokemonCards
     */
    public PokemonCard getPokemonCard() {
        return this.currCard;
    }
    
    /**
     * print details of all cards and their details
     */
    public void printAll() {
        // traverse map
        for (int pokemonCardId : PokemonCardList.keySet()) {
            UI.println("Details: ");
            UI.println("ID: " + pokemonCardId);
            UI.println("Name: " + PokemonCardList.get(pokemonCardId).getName());
            UI.println("Monatery Value: " + PokemonCardList.get(pokemonCardId)
                        .getMonValue());
            UI.println();
        }
    }
}
