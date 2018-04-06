import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class MultiPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MultiPlayer
{
    public static void main (String [] args) {
        Random generator = new Random();
        Scanner reader = new Scanner(System.in);
        boolean play = true;
        
        while (play == true) {
            int r1 = generator.nextInt(6) + 1;
            int r2 = generator.nextInt(6) + 1;
            System.out.println ("Roll: " + r1 + r2);
            while (true) {
                System.out.println ("Play again? (y/n)");
                String response = reader.nextLine();
                if (response.equals("y")){
                    break;
                }
                else if (response.equals("n")){
                    play = false;
                    break;
                }
            }
        }
    }    
}
