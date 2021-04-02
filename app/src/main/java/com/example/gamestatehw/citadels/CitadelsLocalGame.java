import com.example.gamestatehw.GameFramework.actionMessage.GameAction;
import com.example.gamestatehw.GameFramework.game.LocalGame;
import com.example.gamestatehw.GameFramework.players.GamePlayer;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.Player;

import java.util.ArrayList;

public class CitadelsLocalGame extends LocalGame {
    //Tag for logging
    private static final String TAG = "TTTLocalGame";

    // the marks for player 0 and player 1, respectively
    private final static char[] mark = {'X','O'};

    // the number of moves that have been played so far, used to
    // determine whether the game is over
    protected int moveCount;

    /**
     * Constructor for the TTTLocalGame.
     */
    public CitadelsLocalGame() {

        // perform superclass initialization
        super();

        // create a new, unfilled-in TTTState object
        super.state = new CitadelsState();
    }

    /**
     * Constructor for the TTTLocalGame with loaded tttState
     * @param citadelsState
     */
    public CitadelsLocalGame(CitadelsState citadelsState){
        super();
        super.state = new CitadelsState(citadelsState);
    }

    /**
     * Check if the game is over. It is over, return a string that tells
     * who the winner(s), if any, are. If the game is not over, return null;
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        /*
        ArrayList<Player> players = getPlayers();
        for (int i = 0; i < players.size()) {
            Player p = players.get(i);
            int red = 0;
            int blue = 0;
            int green = 0;
            int yellow = 0;
            int unique = 0;
            for (int j = 0; j < p.getDistricts().size(); j++) {
                ArrayList<Card> district = p.getDistricts();
                Card districtCard = district.get(j);
                if (districtCard instanceof RedDistrict) {
                    red++;
                }
                if (districtCard instanceof BlueDistrict) {
                    blue++;
                }
                if (districtCard instanceof GreenDistrict) {
                    green++;
                }
                if (districtCard instanceof YellowDistrict) {
                    yellow++;
                }
                if (districtCard instanceof UniqueDistrictCard) {
                    unique++;
                }
            }
        }
         */
        ArrayList<Player> players = getPlayers();
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (p.getDistricts().size() >= 8) {
                return "Game Over";
            }
        }
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }

    /**
     * Notify the given player that its state has changed. This should involve sending
     * a GameInfo object to the player. If the game is not a perfect-information game
     * this method should remove any information from the game that the player is not
     * allowed to know.
     *
     * @param p
     * 			the player to notify
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        // make a copy of the state, and send it to the player
        p.sendInfo(new CitadelsState(((CitadelsState) state)));

    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    /**
     * Tell whether the given player is allowed to make a move at the
     * present point in the game.
     *
     * @param playerIdx
     * 		the player's player-number (ID)
     * @return
     * 		true iff the player is allowed to move
     */
    protected boolean canMove(int playerIdx) {
        return playerIdx == ((CitadelsState)state).getWhoseMove();
    }

    /**
     * Makes a move on behalf of a player.
     *
     * @param action
     * 			The move that the player has sent to the game
     * @return
     * 			Tells whether the move was a legal one.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }

    //TESTING

    public int whoWon(){
        String gameOver = checkIfGameOver();
        if(gameOver == null || gameOver.equals("It's a cat's game.")) return -1;
        return 0;
    }
}