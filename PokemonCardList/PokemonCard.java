 import ecs100.*;
/**
 * Support PokemonCard class.
 * making a class to create the pokemon card as an object that can passed into
 * other classes
 *
 * @author Sophie Moller
 * @version 20/5/22
 */
public class PokemonCard
{
    // fields
    private int id;
    private String name; // instialising name variable
    private int monValue; // instialising Monetary value variable
    private String image; // instialising image variable
    // sets default image if user doesnt select one
    static final String DEFAULT_IMAGE = "PokemonCard.jpeg"; 
    
    private double imageX = 100; // setting image X co-ordinates
    private double imageY = 100; // setting image Y co-ordinates 
    private int imageSize = 200; // setting image size
    private int imageHeight = 200; // setting image image height
    
    private double left; // setting image left
    private double top; // setting image top
    private double bottom; // setting image bottom

    /**
     * Constructor for objects of class PokemonCard
     * @param key for PokemonCard
     * @param nm for PokemonCard
     * @param mon for PokemonCard
     * @param img for PokemonCard
     */ 
    public PokemonCard(int key, String nm, int mon, String img)
    {
        // initialise instance variables
        id = key;
        name = nm;
        monValue = mon;
        if (img == null) {
            // add default image if user selects cancel
            this.image = DEFAULT_IMAGE; 
        } 
        else {
            this.image = img;
        }
    }

    /**
     * Constructor overloading
     * @param key for PokemonCard
     * @param nm for PokemonCard
     * @param mon for PokemonCard
     *
     * set default image
     */
    public PokemonCard(int key, String nm, int mon)
    {
        this(key, nm, mon, DEFAULT_IMAGE);
    }
    
    /**
     * DISPLAY IMAGE 
     */
    public void displayPokemonCard() {
        int locX = 100;
        int locY = 100;
        final double WIDTH = 200;
        final double HEIGHT = 200;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Getter for ID
     * @return id for PokemonCard
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter for name
     * @return name for PokemonCard
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter for monValue
     * @return monValue for PokemonCard
     */
    public int getMonValue() {
        return this.monValue;
    }
    
    /**
      * erase a rectangle around the image
      */
    public void erase() {
        UI.clearText();
        UI.clearGraphics();
    }
}
