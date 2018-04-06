
import java.util.Scanner;
/**
 * Liars Dice Main Menu
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LiarsDice
{
    public static void main (String [] args) {
        System.out.println ("Welcome to Liar's Dice!");
        System.out.print ("\n");
        while (true) {
            Scanner reader = new Scanner (System.in);

            System.out.println ("Choose an option: ");
            System.out.println ("1) Play: One Player");
            System.out.println ("2) Play: Two Players");
            System.out.println ("2) View Rules");
            System.out.println ("3) View About");
            System.out.println ("4) Quit");
        
            String response = reader.nextLine();
            if (response.equals ("1")) {
                SinglePlayer.main(null);
            }
            else if (response.equals ("2")) {
                MultiPlayer.main(null);
            }
            else if (response.equals ("3")) {
                System.out.println ("Rules: ");
                System.out.println ("The game is played over multiple rounds.");
                System.out.println ("To begin each round, all players roll their dice simultaneously. " + 
                "\n Each player looks at their own dice after they roll, keeping them hidden from the other players. ");
                System.out.println ("The first player then states a bid consisting of a face (1's, 5's, etc.) and a quantity. " +
                "The quantity represents the player's guess as to how many of each face have been rolled by all the players at the table, including themselves. " +
                "For example, a player might bid \"five 2's.\"");
                System.out.println ("Each subsequent player can either then bid a higher quantity of any face, bid the same quantity of a higher face, or they can challenge the previous bid. ");
                System.out.println ("If the player challenges the previous bid, all players reveal their dice. " +
                "If the bid is matched or exceeded, the bidder wins. " + "Otherwise the challenger wins. ");
                System.out.println ("If the bidder loses, they remove one of their dice from the game by placing it in front of their dice cup. ");
                System.out.println ("The loser of the previous round begins the next round. ");
            }
            else if (response.equals ("4")) {
                System.out.println ("About: ");
            }
            else if (response.equals ("5")) {
                System.out.println ("See you another time!");                
                break;
            }
        }
    }
}
