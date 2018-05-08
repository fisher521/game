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
        System.out.println("How many players? (1-6): ");
        int numberOfPlayers = reader.nextInt();
        reader.nextLine();
        
        Player[] player = new Player[6];
        
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + i + ", what is your name? ");
            player[i] = new Player(i, reader.nextLine());
        }
        
        System.out.println("Player 1, what is your name? ");
        Player player1 = new Player(1, reader.nextLine());
        
        System.out.println("Player 2, what is your name? ");
        Player player2 = new Player(2, reader.nextLine());
        
        while (player1.getNumberOfDice() > 0 && player2.getNumberOfDice() > 0) {
            System.out.println();
            
            for (int i = 0; i < numberOfPlayers; i++) {                
                player[i].printRolls("Rolls: ");
                System.out.println();
                Multiplayer.pause("continue");
            }
            
            //turn 1
            System.out.println(player1.getName().toUpperCase() + "'S TURN");
            System.out.println("Bid a quantity and face value.\nQuantity: ");
            int quantity = reader.nextInt();
            reader.nextLine();
            System.out.println("Face Value: ");
            int faceValue = reader.nextInt();
            reader.nextLine();
            System.out.println(player1.getName() + " bidded " + quantity + " " + faceValue + "'s.");
            
            //all subsequent turns
            int turn = 2;
            boolean round = true;
            while (round) {
                if (turn == 2) {
                    player2.turn();
                }
                else if (turn == 1) {
                    System.out.println("\n" + player1.getName().toUpperCase() + "'S TURN");
                    while (true) {
                        System.out.println("Would you like to challenge or make a higher bid? (c/b)");              
                        String decision = reader.nextLine();
                        if (decision.equals("c")){
                            int matchingFaces = 0;
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
                            System.out.println(player1.getName() + " bidded " + quantity + " " + faceValue + "'s.");
                            turn = 2;
                            break;
                            
                        }
                    }
                }
            }
        }
        if (player1.getNumberOfDice() == 0) {
            System.out.println(player2.getName() + " wins!");
        }
        else if (player2.getNumberOfDice() == 0) {
            System.out.println(player1.getName() + " wins!");
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
        for (int i = 1; i < 30; i++) {
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
    public static void printRolls (String player) {
    }
    public void challenge(int faceValue, int quantity, int numberOfPlayers) {
        //prints rolls
        for (int player = 0; player < numberOfPlayers; player++) {
            printRolls("\n" + player[1].getName() + "'s Rolls: ");
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

