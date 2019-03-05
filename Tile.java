import java.util.Random;
import java.util.ArrayList;

/**
 * A tile in the game of Concentration, i
 * Tiles are arranged on an n x m board, represented in a 2-dim array
 * 
 * In this version, a tile contains a card, similar to a playing card. Cards
 * have string values for their "face up" and "face down" state. Each tile
 * is shown face up or face down on the board.
 * 
 * A tile can also have a "cardMatched", indicateing the card has been matched
 * with another card and has been removed from the board. We use this value 
 * instead of a blank value or a missing tile because it helps to represent
 * the m x n game board when tiles would otherwise be blank or missing.
 * 
 */
public class Tile
{
    private boolean faceUp;
    private boolean matched;
    private String cardFace; 
    private String cardBack = "_____";
    private String cardMatched = "  *  ";
    
    /**
     * Construct a tile with a string value. The default state
     * of a tile is unmatched and face down on the board.
     * 
     * @param  word the word that represents the card face
     */
    public Tile(String word) 
    {
        cardFace = word;
    }
    
    /**
     * Return the value of the tile in its face up state
     *  
     * @return faceUp 
     */
    public String getFace() {
        return cardFace;
    }
    
    /**
     * Return the value of the tile in its face down state
     * 
     * @return the face (as a String value)
     */
    public String getBack() {
        return cardBack;
    }
    
    /**
     * Set the card to either a face up or face down state
     * 
     * @param b set to true to show the card face up, set to false to show face down
     */
    public void faceUp(boolean b)
    {
        faceUp = b;
    }
    
    /**
     * Determine if the card is currently face up
     * 
     * @return true if the card is currently in the faceUp state, false otherwise
     */
    public boolean isFaceUp() {
        return faceUp;
    }
 
    /**
     * A matching pair of cards has been found, set matched to true
     * and change the way the card is shown 
     */
    public void foundMatch() {
       matched = true;
       cardFace = cardMatched;
       cardBack = cardMatched;
    }
    
    /**
     * Determine if this tile has been matched
     * 
     * @return true of the card was previously matched, false otherwise
     */
    public boolean matched() {
        return matched;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile otherTile = (Tile)obj;
            return cardFace.equals(otherTile.getFace());
        } else {
            return false;
        }
    }
}

