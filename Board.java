/**
 * Board: A n x m game board made of of individualab tiles.
 * 
 * For the game of concentraiton",the board is made up of
 * pairs of matching strings, one string per tile. 
 * 
 * Precondition: the size of the cards array must fit into the rows/columns shape of the board
 */
public abstract class Board
{
    //The cards that will be placed in the tiles
    public String[] cards = new String[] {"dog", "dog", "cat", "cat", "mouse", "mouse",
        "wolf", "wolf", "monkey", "monkey", "bird", "bird"}; 

    // The  shape of the board
    private int rows = 3;
    private int columns = 4;  
        
    /**
     * Create a 2-dim array to represent a game board and return it
     *  
     * @return a game board of tiles with dimension rows x columns
     */
    public Tile[][] makeBoard() {
        return new Tile[rows][columns];
     }
    
    /**
     * Return the array of cards
     * 
     * @return a String array of card values
     * 
     */
    public String[] getCards () {   
        return cards;
    }

}
