import java.util.Scanner;
import java.util.Random;
/**
 * 1 Player version of Liar's dice, where you play against the CPU.
 *
 * @author Justin
 * @author Fisher
 * @version 4/10/18
 */
public class Singleplayer {
    public static Random generator = new Random();
    public static Scanner reader = new Scanner(System.in);
    public static void main (String [] args) {
        System.out.println();
        int p1NumberOfDice = 5;
        int p2NumberOfDice = 5;
        
        System.out.println("What's your name, player?");
        String player1 = reader.nextLine();
        
        System.out.println("What do you want your opponent's name to be?");
        String player2 = reader.nextLine();
        
        while (p1NumberOfDice > 0 && p2NumberOfDice > 0) {
            System.out.println();
            
            //dice rolls for player 1
            Multiplayer.rollDicePrompt(player1);
            int [] player1Roll = new int[5];
            for(int i = 0; i < 5; i++) {
                player1Roll[i] = Multiplayer.diceRoll();
            }
            System.out.print("Rolls: ");
            for(int i = 1; i <= p1NumberOfDice; i++) {     
                System.out.print(player1Roll[i - 1]);
                if (p1NumberOfDice - i >= 1) {
                    System.out.print(", ");
                } 
            }    
            System.out.println();
            Multiplayer.pause("continue");
            
            //Player 2 is computer
            int [] player2Roll = new int[5];
            for(int i = 0; i < 5; i++) {
                player2Roll[i] = Multiplayer.diceRoll();
            }    
            
            //turn 1
            System.out.println(player1.toUpperCase() + "'S TURN");
            System.out.println("Bid a quantity and face value.\nQuantity: ");
            int quantity = reader.nextInt();
            reader.nextLine();
            System.out.println("Face Value: ");
            int faceValue = reader.nextInt();
            reader.nextLine();
            System.out.println(player1 + " bidded " + quantity + " " + faceValue + "'s.");
            
            //all subsequent turns
            int player = 2;
            boolean round = true;
            while (round) {
                if (player == 2) {
                    System.out.println("\n" + player2.toUpperCase() + "'S TURN");
                    int p2MatchingFaces = 0;
                    //counts how many of the current face the computer has
                    for (int i = 0; i < p2NumberOfDice; i++) {
                        if (player2Roll[i] == faceValue) {
                            p2MatchingFaces++;
                        }
                    }
                    //the computer's guess on how many of the current face the player has
                    int guess = generator.nextInt(3) + 1;
                    if (quantity > p2MatchingFaces + guess || faceValue > 6 || quantity >= p2MatchingFaces + p1NumberOfDice){
                        System.out.println(player2 + " challenged your bid!");
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
                            Multiplayer.pause("begin new round");
                        }
                    }
                    else {
                        //computer bids
                        String bidDecision = "q";
                        if(bidDecision.equals("f")){
                            //bids a higher face value
                            int newFaceValue = reader.nextInt();
                        }
                        else if(bidDecision.equals("q")){
                            //bids a higher quantity
                            int chance = generator.nextInt(4) + 1;
                            if (chance <= 3) {
                                quantity++;
                            }
                            else if (chance == 4) {
                                quantity += 2;
                            }
                        }
                        System.out.println(player2 + " bidded " + quantity + " " + faceValue + "'s.");
                    }
                    player = 1;
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
                                Multiplayer.pause("begin new round");
                            }
                            player = 2;
                            break;
                        }
                        if (decision.equals("b")) {
                            while(true){
                                System.out.println("Would you like to enter a higher face value or a higher quantity? (f/q)");
                                String bidDecision = reader.nextLine();
                                if(bidDecision.equals("f")){
                                    faceValue = Multiplayer.higherValue("face value", faceValue);
                                    break;
                                }
                                else if(bidDecision.equals("q")){
                                    quantity = Multiplayer.higherValue("quantity", quantity);
                                    break;
                                }
                            }
                            System.out.println(player1 + " bidded " + quantity + " " + faceValue + "'s.");
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
}
