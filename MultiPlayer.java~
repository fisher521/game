import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class SinglePlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Multiplayer
{
    public static final Random generator = new Random();
    public static final Scanner reader = new Scanner(System.in);
    public static void main (String [] args) {
        int p1NumberOfDice = 5;
        int p2NumberOfDice = 5;
        
        rollDicePrompt("Player 1");
        int [] player1Roll = new int[5];
        for(int i = 0; i < 5; i++) {
            player1Roll[i] = diceRoll();
        }
        System.out.print("Rolls: ");
        for(int i = 1; i <= p1NumberOfDice; i++) {     
            System.out.print (player1Roll[i - 1]);
            if (p1NumberOfDice - i >= 1) {
                System.out.print (", ");
            } 
        }    
        System.out.println();
        endTurn();
        
        rollDicePrompt("Player 2");
        int [] player2Roll = new int[5];
        for(int i = 0; i < 5; i++) {
            player2Roll[i] = diceRoll();
        }
        System.out.print("Rolls: ");
        for(int i = 1; i <= p2NumberOfDice; i++) {     
            System.out.print (player2Roll[i - 1]);
            if (p2NumberOfDice - i >= 1) { 
                System.out.print (", ");
            }
        }    
        System.out.println();
        endTurn();

        System.out.println("Player 1, it is your turn to bid.\nFace value: ");
        int faceValue = reader.nextInt();
        System.out.print("Quantity: ");
        int quantity = reader.nextInt();
        System.out.println("You bidded " + quantity + " " + faceValue + "'s.");
        
        while (true) {
            player2Turn(quantity, faceValue);
            player1Turn(quantity, faceValue);

        }
    }
    public static int challenge (int quantity, int faceValue) {
        return 5;
        
    }
    public static int diceRoll() {
        return generator.nextInt(6) + 1;
    }
    public static void rollDicePrompt(String playerToken) {
        System.out.println(playerToken + ", press enter to roll the dice");
        reader.nextLine();
    }
    public static void endTurn() {
        System.out.println ("Press any key to end turn...");
        reader.nextLine();
        //clears screen
        for (int i = 1; i < 20; i++) {
            System.out.println ("\n");
        }
    }
    private static void player1Turn(int quantity, int faceValue) {
        System.out.println("Player 1, would you like to challenge or make a higher bid? (c/b)");              
        String decision = reader.nextLine();
        if (decision.equals("c")){
            challenge(quantity, faceValue);
        }
        if (decision.equals("b")) {
            }
    }
    private static void player2Turn(int quantity, int faceValue) {
        System.out.println("Player 2, would you like to challenge or make a higher bid? (c/b)");              
        String decision = reader.nextLine();
        if (decision.equals("c")){
            challenge(quantity, faceValue);
        }
        if (decision.equals("b")) {
            }
    }
}
