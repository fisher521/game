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
    public static void main (String [] args) {
        Random generator = new Random();
        Scanner reader = new Scanner(System.in);
        boolean play = true;
        while (play == true) {
            System.out.println("Player 1, press enter to roll the dice. ");
            reader.nextLine();
          
            //player 1 dice roll variables
            int p1r1 = generator.nextInt(6) + 1;
            int p1r2 = generator.nextInt(6) + 1;
            int p1r3 = generator.nextInt(6) + 1;
            int p1r4 = generator.nextInt(6) + 1;
            int p1r5 = generator.nextInt(6) + 1;
            
            System.out.println ("Rolls: " + p1r1 + ", " + p1r2 + ", " + p1r3 + ", " + p1r4 + ", " + p1r5);
        
            System.out.println("Player 2, press enter to roll the dice. ");
            reader.nextLine();
            
            //player 2 dice roll variables
            int p2r1 = generator.nextInt(6) + 1;
            int p2r2 = generator.nextInt(6) + 1;
            int p2r3 = generator.nextInt(6) + 1;
            int p2r4 = generator.nextInt(6) + 1;
            int p2r5 = generator.nextInt(6) + 1;
            
            
            System.out.println("Player 1, it is your turn to bid.\nFace value: ");
            
            int faceValue = reader.nextInt();
            
            System.out.print("Quantity: ");
            
            int quantity = reader.nextInt();
            
            //int computerQuantity = generator.nextInt(6 - quantity + 1) + quantity;
              
            //System.out.println(computerQuantity);
            
            System.out.println("You bidded " + quantity + " " + faceValue + "'s.");
            
            int computerQuantity = quantity + 1;
            
            System.out.println("Your opponent bidded " + computerQuantity + " " + faceValue + "'s.");
            
            System.out.println("Would you like to challenge or continue bidding? (c/b)");
            
            reader.nextLine();
            
            String cont = reader.nextLine();
            
            int count = 1;
            int count2 = 1;
            
            while(count == 1){
              if(cont.equals("c")){
                
                count += 1;
              }
              else if(cont.equals("b")){
                System.out.println("Would you like to enter a higher face value or a higher quantity? (f/q)");
                String decision = reader.nextLine();
                while(count2 == 1){
                  if(decision.equals("f")){
                    System.out.println("Please enter the new face value: " );
                    faceValue = reader.nextInt();
                    count2 += 1;
                  }
                  else if(decision.equals("q")){
                    System.out.println("Please enter a new quantity: ");
                    quantity = reader.nextInt();
                    count2 += 1;
                  }
                  else{
                    System.out.println("Please enter f or q: ");
                    decision = reader.nextLine();
                  }
                }
               
                 }
              else{
                System.out.println("Please enter c or b: ");
                cont = reader.nextLine();
              }
            }
            reader.nextLine();
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
