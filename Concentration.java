/**
 * The game of Concentration (also called Memory or Match Match)
 * 
 * Create a gameboard of tiles. Each tile contains a card that has exactly
 * one match on the board. Cards are originally show "face down" on the board.
 * 
 * Player chooses two random cards from the board. The chosen cards
 * are temporarily shown face up. If the cards match, they are removed from board.
 * 
 * Play continues, matching two cards at a time, until all cards have been matched.
 */
import java.util.Random;
public class Concentration extends Board
{
    // create the game board
    private Tile[][] gameboard = makeBoard();
    int match = 0;
    /**
     * The constructor for the game. Creates the 2-dim gameboard
     * by populating it with tiles.
     */
    public Concentration() {
       //gmaeboard array
       String [] cards = getCards();
       int num = cards.length -1;
       Random random = new Random();
       
       //Subscribe to Emiliano Vlogs.
       for (int i = 0; i < gameboard.length; i++){
           for (int j = 0; j < gameboard[0].length; j++){
               int merchant = (int)(Math.random()*num);
               gameboard[i][j] = new Tile(cards[merchant]);
               cards[merchant] = cards[num];
               num--;
            }
           
       }
    }
    /**
     * Determine if the board is full of cards that have all been matched,
     * indicating the game is over
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return true if all pairs of cards have been matched, false otherwse
     */
    public boolean allTilesMatch() {
        // Iterate through all game tiles, check whether each one is matched.
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                // If ANY one tile is not matched yet, then the game is not
                // over and this method can return immediately.
                if (!gameboard[i][j].matched()) {
                    // returning here means we stop looping, and don't check
                    // the rest of the tiles. We don't need to check the rest
                    // because we know at least one tile is NOT matched yet,
                    // so the game's NOT over.
                    return false;
                }
                // Otherwise the loop continues checking the other tiles.
            }
        }

        // If we get here, it means the loops above have checked all tiles and
        // did not return false early.
        // That means ALL tiles are matched and the game is over.
        return true;
    }

    /**
     * Check for a match between the cards in the two tile locations.
     * For matched cards, remove from the board. For unmatched cares, them face down again.
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row1 the row value of Tile 1
     * @param column1 the column value of Tile 1
     * @param row2 the row value of Tile 2
     * @param column2 the column vlue of Tile 2
     * @return a message indicating whether or not a match occured
     */
    public String checkForMatch(int row1, int column1, int row2, int column2)
    {
        //This is Rebecca's completed code!!
        /*
        String card1 = gameboard[row1][column1].getFace();
        String card2 = gameboard[row2][column2].getFace();
        
        if (card1.equals(card2))
        {
            gameboard[row1][column1].foundMatch();
            gameboard[row2][column2].foundMatch();
            return "Matched!";
        }
        
        gameboard[row1][column1].faceUp(false);
        gameboard[row2][column2].faceUp(false);
        return "";
        */
       //The following code is the same as Rebecca's but this one is Christian's
        if (gameboard[row1][column1].getFace().equals(gameboard[row2][column2].getFace()))
        {
            gameboard[row1][column1].foundMatch();
            gameboard[row2][column2].foundMatch();
            match++;
  
            return "true";
        }
         else 
         {
             gameboard[row1][column1].faceUp(false);
             gameboard[row2][column2].faceUp(false);
             return "false";
         }
}

    /**
     * Set  tile to show its card in the face up state
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row the row value of Tile
     * @param column the column value of Tile
     */
    public void showFaceUp (int row, int column) {
        gameboard[row][column].faceUp(true);
        // to do 
    }

    /**
     * Returns a string representation of the board. A tab is placed between tiles,
     * and a newline is placed at the end of a row
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return a string represetation of the board
     */
    public String toString() {
        
       
       for (int i = 0; i < gameboard.length; i++){
           for (int j = 0; j < gameboard[0].length; j++){
               Tile t = gameboard[i][j];
               //System.out.print(t.getFace() + " ");
               //System.out.print(t.getBack() + " ");
               
               if (gameboard[i][j].isFaceUp() == true)
               {
                   System.out.print(gameboard[i][j].getFace() + " ");
                }
                else 
                {
                    System.out.print(gameboard[i][j].getBack() + " ");
                }
               
            }
           System.out.println();
       }
        
        return "";
    }

}

