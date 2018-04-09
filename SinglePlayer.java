import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class SinglePlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Singleplayer
{
    public static void main (String [] args) {
        Random generator = new Random();
        Scanner reader = new Scanner(System.in);
        int challenge = generator.nextInt(3) + 1;
        
        int p1NumberOfDice = 5;
        int p2NumberOfDice = 5;
        
        boolean play = true;
        while (play == true) {
            System.out.println("Enter your name: ");
            String name = reader.nextLine();

          
            /*int r1 = generator.nextInt(6) + 1;
            int r2 = generator.nextInt(6) + 1;
            int r3 = generator.nextInt(6) + 1;
            int r4 = generator.nextInt(6) + 1;
            int r5 = generator.nextInt(6) + 1;
            
            int c1 = generator.nextInt(6) + 1;
            int c2 = generator.nextInt(6) + 1;
            int c3 = generator.nextInt(6) + 1;
            int c4 = generator.nextInt(6) + 1;
            int c5 = generator.nextInt(6) + 1;*/
            
            Multiplayer.rollDicePrompt(name);
            int [] player1Roll = new int[5];
            for(int i = 0; i < 5; i++) {
              player1Roll[i] = Multiplayer.diceRoll();
            }
            System.out.print("Rolls: ");
            for(int i = 1; i <= p1NumberOfDice; i++) {     
              System.out.print (player1Roll[i - 1]);
              if (p1NumberOfDice - i >= 1) {
                System.out.print (", ");
              }
              if (p1NumberOfDice - i == 0)
                System.out.println();
            }
            
            System.out.println("It is your turn to bid.\nFace value: ");
            
            int faceValue = reader.nextInt();
            
            System.out.print("Quantity: ");
            
            int quantity = reader.nextInt();
            
            int computerCount = generator.nextInt(2) + 1;
            
            System.out.println(computerCount);
                              
            
            int computerQuantity = generator.nextInt(6 - (quantity + 1) + 1) + (quantity + 1);
            
            int computerFaceValue = generator.nextInt(6 - (faceValue + 1) + 1) + (faceValue + 1);

            
            System.out.println("You bidded " + quantity + " " + faceValue + "'s.");

            if(challenge == 1){
              System.out.println("Your opponent challenged your bid.");
              //if(
            }
            
            else{
              
              if(computerCount == 1){
                
              System.out.println("Your opponent bidded " + computerQuantity + " " + faceValue + "'s.");     
                
              }
              else{
                System.out.println("Your opponent bidded " + quantity + " " + computerFaceValue + "'s.");
              }
                
              System.out.println("Would you like to challenge or continue bidding? (c/b)");
            }

            
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
            /*while (true) {
                System.out.println ("Play again? (y/n)");
                String response = reader.nextLine();
                if (response.equals("y")){
                    break;
                }
                else if (response.equals("n")){
                    play = false;
                    break;
                }
            }*/
        }
    }
    
}
