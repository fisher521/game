
import java.util.Random;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int numberOfDice;
    private int playerNumber;
    private String playerName;
    int [] playerRoll = new int[5];
    
    public Player(int inputPlayerNumber, String inputPlayerName)
    {
        numberOfDice = 5;
        playerNumber = inputPlayerNumber;
        playerName = inputPlayerName;
        Multiplayer.rollDicePrompt(playerName);

        //dice rolls
        for(int i = 0; i < numberOfDice; i++) {
            playerRoll[i] = Multiplayer.diceRoll();
        }
    }
    public void printRolls(String prompt) {
        System.out.print(prompt);
        for(int i = 1; i <= numberOfDice; i++) {     
            System.out.print(playerRoll[i - 1]);
            if (numberOfDice - i >= 1) {
                System.out.print(", ");
            } 
        }    
    }
    public String getName() {
        return playerName;
    }
    public int getNumberOfDice() {
        return numberOfDice;
    }
    public void loseDice() {
        numberOfDice--;
    }

}
