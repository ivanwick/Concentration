import java.util.Random;

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
public class Concentration extends Board
{
    // create the game board
    private Tile[][] gameboard = makeBoard();

    /** 
     * The constructor for the game. Creates the 2-dim gameboard
     * by populating it with tiles.
     */
    public Concentration() {
        gameboard = makeBoard();

        String[] cards = getCards();

        // Fisher–Yates shuffle
        // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
        Random rand = new Random();

        for (int swapA = cards.length - 1; swapA > 0; swapA--) {
            int swapB = rand.nextInt(swapA + 1);

            String cardA = cards[swapA];
            String cardB = cards[swapB];

            cards[swapA] = cardB;
            cards[swapB] = cardA;
        }

        // place on board
        int cardIndex = 0;
        for (int row = 0; row < gameboard.length; row++) {
            for (int col = 0; col < gameboard[0].length; col++) {
                gameboard[row][col] = new Tile(cards[cardIndex]);
                cardIndex++;
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

        for (int row = 0; row < gameboard.length; row++) {
            for (int col = 0; col < gameboard[0].length; col++) {
                Tile t = gameboard[row][col];
                if (!t.matched()) {
                    return false;
                }
            }
        }

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
    public String checkForMatch(int row1, int column1, int row2, int column2) {
        Tile tile1 = gameboard[row1][column1];
        Tile tile2 = gameboard[row2][column2];

        if (tile1.equals(tile2)) {
            tile1.foundMatch();
            tile2.foundMatch();

            return "MATCH";
        } else {
            tile1.faceUp(false);
            tile2.faceUp(false);

            return "no match sorry";
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
        String boardString = "";

        for (int row = 0; row < gameboard.length; row++) {

            int numColumns = gameboard[row].length;

            for (int col = 0; col < numColumns; col++) {

                Tile t = gameboard[row][col];

                if (t.isFaceUp()) {
                    boardString += t.getFace();
                } else {
                    boardString += t.getBack();
                }

                if (col < numColumns - 1) {
                    boardString += "\t";
                }
            }
            boardString += "\n";
        }

        return boardString;
    }

}

