import ecs100.*;
import java.util.HashMap;
/**
 * GUI class displays pokemon card and pokemon cards class visually.
 *
 * @author Sophie Moller
 * @version 24/5/22
 */
public class GUI
{
    // instance variables 
    private PokemonCards pokemonCards; // declear cards instance
    private PokemonCard pokemonCard; // declear card instance

  /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        // initiate the cards object
        pokemonCards = new PokemonCards();
        UI.initialise();
        // add print all button
        UI.addButton("Print All", pokemonCards::printAll); 
        UI.addButton("Add Card", this::addCard); // add card button
        UI.addButton("Find Card", this::findCard); // find card button
        UI.addButton("Hide Card", this::hideCard); //hide card button
        UI.addButton("Quit", UI::quit); // quit button
        UI.setMouseListener(this::doMouse); // mouse listener
    }

   /**
     * User adds card and its details
     */
    public void addCard()
    {
        final int INCREMENT = 1;// increment id by 1
        final int MAX_NUMBER = 999999999; // set max number
        int monValue; // intialise monValue
        
        // Asks user to card details
        UI.println();
        String name = UI.askString("Name: ").toLowerCase();
        // ensure monValue is appropriate
        do {
            monValue = UI.askInt("Monatery Value: ");
            if ((monValue > 0) && (monValue < MAX_NUMBER)) {
                UI.println("Added");
            } 
            else if (monValue > MAX_NUMBER) {
                UI.println("Must be less than 10 numbers");
                monValue = UI.askInt("Monatery Value: ");
            } 
            else if (monValue < 1) {
                UI.println("Must be greater than 0");
                monValue = UI.askInt("Monatery Value: ");
            } 
            else {
                UI.println("Must be a number");
                monValue = UI.askInt("Monatery Value: ");
            }
        } while (0 > monValue || monValue > MAX_NUMBER);
        //ask user to choose image file
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // Increment the card ID and add to hashmap
        pokemonCards.setPokemonCardId(); // increment id by 1
        pokemonCards.addCard(name, monValue, imgFileName);
    }
    
   /**
     * Find PokemonCard based on name
     */
    public void findCard() {
        UI.println();
        String name = UI.askString("Name of Pokemon Character: ").toLowerCase();
        if (pokemonCards.findCard(name.toLowerCase())) {
            UI.println();
            UI.println("Found Card!");
            pokemonCard = pokemonCards.getPokemonCard();
            UI.println("Name: " + pokemonCard.getName());
            UI.println("Monatery Value: " + pokemonCard.getMonValue());
        } 
        else {
            UI.println("Pokemon Card does not exist");
            findCard();
        }
    }

   /**
     * Hides current Pokemon cards details
     */
    public void hideCard() {
        UI.clearText();
        UI.clearGraphics();
        
    }
    
   /**
     * Select object based on where suer clicks and erases pokemon card details
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            pokemonCard.erase();
        }
        
    }
}
