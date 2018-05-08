
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
    private int quantity;
    private int faceValue;
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
    public int getQuantity() {
        return quantity;
    }
    public int getFaceValue() {
        return faceValue;
    }
    public void turn(int turnNumber, int faceValue, int quantity) {
        System.out.println("\n" + playerName.toUpperCase() + "'S TURN");
        while (true) {
            System.out.println("Would you like to challenge or make a higher bid? (c/b)");              
            String decision = Multiplayer.reader.nextLine();
            if (decision.equals("c")){
                challenge(faceValue, quantity);
            }
            if (decision.equals("b")) {
                bid(faceValue, quantity);
            }
        }
    }
    public void bid(int faceValue, int quantity){
        while(true){
            System.out.println("Would you like to enter a higher face value or a higher quantity? (f/q)");
            String bidDecision = Multiplayer.reader.nextLine();
            if(bidDecision.equals("f")){
                faceValue = Multiplayer.higherValue("face value", faceValue);
                break;
            }
            else if(bidDecision.equals("q")){
                quantity = Multiplayer.higherValue("quantity", quantity);
                break;
            }
        }
        System.out.println(playerName + " bidded " + quantity + " " + faceValue + "'s.");
    }
    public void challenge(int faceValue, int quantity, int numberOfPlayers) {
        //prints rolls
        for (int player = 0; player < numberOfPlayers; player++) {
            System.out.print("\n" + player1.getName() + "'s Rolls: ");
            for(int i = 0; i < numberOfDice; i++) {
                System.out.print(playerRoll[i - 1]);
                if (player1.getNumberOfDice() - i >= 1) {
                    System.out.print(", ");
                } 
            }
        }
        
        System.out.print("\n" + player1.getName() + "'s Rolls: ");
        for(int i = 1; i <= player1.getNumberOfDice(); i++) {     
            System.out.print(player1Roll[i - 1]);
            if (player1.getNumberOfDice() - i >= 1) {
                System.out.print(", ");
            } 
        }
        System.out.print("\n" + player2.getName() + "'s Rolls: ");
        for(int i = 1; i <= player2.getNumberOfDice(); i++) {     
            System.out.print(player2Roll[i - 1]);
            if (player2.getNumberOfDice() - i >= 1) {
                System.out.print(", ");
            } 
        }
        
        //checks rolls
        for (int i = 0; i < player1.getNumberOfDice(); i++) {
            if (player1Roll[i] == faceValue) {
                matchingFaces++;
            }
        }
        for (int i = 0; i < player2.getNumberOfDice(); i++) {
            if (player2Roll[i] == faceValue) {
                matchingFaces++;
            }
        }
        System.out.println("\nMatching faces: " + matchingFaces);
        if (matchingFaces >= quantity) {
            player1.loseDice();
            System.out.println(player1.getName() + " has lost a die and now has " + player1.getNumberOfDice() + " dice!");
        }
        else {
            player2.loseDice();
            System.out.println(player2.getName() + " has lost a die and now has " + player2.getNumberOfDice() + " dice!");
        }
        round = false;
        System.out.println();
        if (player1.getNumberOfDice() > 0 && player2.getNumberOfDice() > 0) {
            pause("begin new round");
        }
        turn = 2;
        break;
    }
}
