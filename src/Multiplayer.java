import java.util.Scanner;
import java.util.Random;
/**
 * 2 Player version of Liar's dice.
 *
 * @author Fisher
 * @author Justin
 * @version 4/10/18
 */
public class Multiplayer {
    public static Random generator = new Random();
    public static Scanner reader = new Scanner(System.in);
    public static void main (String [] args) {
        System.out.println();
        int p1NumberOfDice = 5;
        int p2NumberOfDice = 5;
        
        System.out.println("Player 1, what is your name? ");
        String player1 = reader.nextLine();
        
        System.out.println("Player 2, what is your name? ");
        String player2 = reader.nextLine();
        
        while (p1NumberOfDice > 0 && p2NumberOfDice > 0) {
            System.out.println();
            
            //dice rolls for player 1
            rollDicePrompt(player1);
            int [] player1Roll = new int[5];
            for(int i = 0; i < p1NumberOfDice; i++) {
                player1Roll[i] = diceRoll();
            }
            System.out.print("Rolls: ");
            for(int i = 1; i <= p1NumberOfDice; i++) {     
                System.out.print(player1Roll[i - 1]);
                if (p1NumberOfDice - i >= 1) {
                    System.out.print(", ");
                } 
            }    
            System.out.println();
            pause("continue");
            
            //dice rolls for player 2
            rollDicePrompt(player2);
            int [] player2Roll = new int[5];
            for(int i = 0; i < p2NumberOfDice; i++) {
                player2Roll[i] = diceRoll();
            }
            System.out.print("Rolls: ");
            for(int i = 1; i <= p2NumberOfDice; i++) {     
                System.out.print(player2Roll[i - 1]);
                if (p2NumberOfDice - i >= 1) { 
                    System.out.print(", ");
                }
            }    
            System.out.println();
            pause("continue");
            
            //turn 1
            System.out.println(player1.toUpperCase() + "'S TURN");
            System.out.println("Bid a quantity and face value.\nQuantity: ");
            int quantity = reader.nextInt();
            reader.nextLine();
            System.out.println("Face Value: ");
            int faceValue = reader.nextInt();
            reader.nextLine();
            System.out.println(player1 + " bid " + quantity + " " + faceValue + "'s.");
            
            //all subsequent turns
            int player = 2;
            boolean round = true;
            while (round) {
                if (player == 2) {
                    System.out.println("\n" + player2.toUpperCase() + "'S TURN");
                    while (true) {
                        System.out.println("Would you like to challenge or make a higher bid? (c/b)");              
                        String decision = reader.nextLine();
                        if (decision.equals("c")){
                            int matchingFaces = 0;
                            System.out.print("\n" + player1 + "'s Rolls: ");
                            for(int i = 1; i <= p1NumberOfDice; i++) {     
                                System.out.print(player1Roll[i - 1]);
                                if (p1NumberOfDice - i >= 1) {
                                    System.out.print(", ");
                                } 
                            }
                            System.out.print("\n" + player2 + "'s Rolls: ");
                            for(int i = 1; i <= p2NumberOfDice; i++) {     
                                System.out.print(player2Roll[i - 1]);
                                if (p2NumberOfDice - i >= 1) {
                                    System.out.print(", ");
                                } 
                            }
                            for (int i = 0; i < p1NumberOfDice; i++) {
                                if (player1Roll[i] == faceValue) {
                                    matchingFaces++;
                                }
                            }
                            for (int i = 0; i < p2NumberOfDice; i++) {
                                if (player2Roll[i] == faceValue) {
                                    matchingFaces++;
                                }
                            }
                            System.out.println("\nMatching faces: " + matchingFaces);
                            if (matchingFaces >= quantity) {
                                p2NumberOfDice--;
                                System.out.println(player2 + " has lost a die and now has " + p2NumberOfDice + " dice!");
                            }
                            else {
                                p1NumberOfDice--;
                                System.out.println(player1 + " has lost a die and now has " + p1NumberOfDice + " dice!");
                            }
                            round = false;
                            System.out.println();
                            if (p1NumberOfDice > 0 && p2NumberOfDice > 0) {
                                pause("begin new round");
                            }
                            player = 1;
                            break;
                        }
                        if (decision.equals("b")) {
                            while(true){
                                System.out.println("Would you like to enter a higher face value or a higher quantity? (f/q)");
                                String bidDecision = reader.nextLine();
                                if(bidDecision.equals("f")){
                                    faceValue = higherValue("face value", faceValue);
                                    break;
                                }
                                else if(bidDecision.equals("q")){
                                    quantity = higherValue("quantity", quantity);
                                    break;
                                }
                            }
                            System.out.println(player2 + " bid " + quantity + " " + faceValue + "'s.");
                            player = 1;
                            break;
                        }
                    }
                }
                else if (player == 1) {
                    System.out.println("\n" + player1.toUpperCase() + "'S TURN");
                    while (true) {
                        System.out.println("Would you like to challenge or make a higher bid? (c/b)");              
                        String decision = reader.nextLine();
                        if (decision.equals("c")){
                            int matchingFaces = 0;
                            System.out.print("\n" + player1 + "'s Rolls: ");
                            for(int i = 1; i <= p1NumberOfDice; i++) {     
                                System.out.print(player1Roll[i - 1]);
                                if (p1NumberOfDice - i >= 1) {
                                    System.out.print(", ");
                                } 
                            }
                            System.out.print("\n" + player2 + "'s Rolls: ");
                            for(int i = 1; i <= p2NumberOfDice; i++) {     
                                System.out.print(player2Roll[i - 1]);
                                if (p2NumberOfDice - i >= 1) {
                                    System.out.print(", ");
                                } 
                            }
                            for (int i = 0; i < p1NumberOfDice; i++) {
                                if (player1Roll[i] == faceValue) {
                                    matchingFaces++;
                                }
                            }
                            for (int i = 0; i < p2NumberOfDice; i++) {
                                if (player2Roll[i] == faceValue) {
                                    matchingFaces++;
                                }
                            }
                            System.out.println("\nMatching faces: " + matchingFaces);
                            if (matchingFaces >= quantity) {
                                p1NumberOfDice--;
                                System.out.println(player1 + " has lost a die and now has " + p1NumberOfDice + " dice!");
                            }
                            else {
                                p2NumberOfDice--;
                                System.out.println(player2 + " has lost a die and now has " + p2NumberOfDice + " dice!");
                            }
                            round = false;
                            System.out.println();
                            if (p1NumberOfDice > 0 && p2NumberOfDice > 0) {
                                pause("begin new round");
                            }
                            player = 2;
                            break;
                        }
                        if (decision.equals("b")) {
                            while(true){
                                System.out.println("Would you like to enter a higher face value or a higher quantity? (f/q)");
                                String bidDecision = reader.nextLine();
                                if(bidDecision.equals("f")){
                                    faceValue = higherValue("face value", faceValue);
                                    break;
                                }
                                else if(bidDecision.equals("q")){
                                    quantity = higherValue("quantity", quantity);
                                    break;
                                }
                            }
                            System.out.println(player1 + " bid " + quantity + " " + faceValue + "'s.");
                            player = 2;
                            break;
                        }
                    }
                }
            }
        }
        if (p1NumberOfDice == 0) {
            System.out.println(player2 + " wins!");
        }
        else if (p2NumberOfDice == 0) {
            System.out.println(player1 + " wins!");
        }
    }
    public static void rollDicePrompt(String player) {
        System.out.println(player + ", press enter to roll the dice.");
        reader.nextLine();
    }
    public static int diceRoll() {
        return generator.nextInt(6) + 1;
    }
    public static void pause(String reason) {
        System.out.println("Press enter to " + reason + "...");
        reader.nextLine();
        //clears screen
        for (int i = 1; i < 20; i++) {
            System.out.println("\n");
        }
    }
    public static int higherValue (String something, int oldValue) {
        while (true) {
            System.out.println("Enter a higher " + something + ":");
            int newValue = reader.nextInt();
            reader.nextLine();
            if (newValue > oldValue) {
                return newValue;
            }
        }
    }
}

