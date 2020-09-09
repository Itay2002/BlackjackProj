import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{public static void main (String args[]){
        Shoe s1=new Shoe(7);
        Player p1=new Player();
        Dealer d1=new Dealer();

        Scanner sc= new Scanner(System.in);
        System.out.println("Do you want to play?(Yes/No)");
        String answer=sc.nextLine();
        while(answer.equals("Yes")){
            String outcome="Start";
            while(outcome.equals("Start")){
                System.out.println("Place your bet(multiple of ten)");
                outcome="";
                int i = sc.nextInt();
                while(i%10 != 0 || i == 0 || i<=0 || p1.getChips()<i)
                {
                    System.out.println("!BET HAS TO BE A MULTIPLE OF TEN AND SUFFICIENT! Place new bet:");
                    Scanner s2 = new Scanner(System.in);
                    int e = s2.nextInt();
                    i = e;

                }
                int bet=i;
                p1.addCard(s1);
                d1.addCard(s1);
                p1.addCard(s1);
                d1.addCard(s1);
                System.out.println(p1);
                System.out.println("Dealer has ");
                d1.printCard(1);
                d1.printCard(0);
                int playerTurn=0;
                if(p1.getHand().blackjack() && d1.getHand().blackjack()){
                    System.out.println("There is a push"); 

                    System.out.println("You still have "+p1.getChips());   
                    outcome="Done";

                }

                else if(p1.getHand().blackjack()){
                    System.out.println("You have Blackjack");
                    p1.addChips(bet);
                    System.out.println("You have "+p1.getChips());
                    outcome="Done";

                }
                else if(d1.getHand().blackjack()){
                    System.out.println("Dealer has Blackjack"); 
                    p1.addChips(-bet);
                    System.out.println("You have "+p1.getChips()+"chips");
                    outcome="Done";

                }

                playerTurn=1;
                while(playerTurn>0 &&!outcome.equals("Done")&& !p1.getHand().bust()){
                    System.out.println("What do you want to do(hit/doubleDown/stand)");
                    String result=sc.next();
                    if(result.equals("doubleDown")&&playerTurn==1){
                        bet*=2;
                        p1.addCard(s1);
                        System.out.println("Your bet is: "+bet);
                        //check for a bust
                    }
                    else if(result.equals("doubleDown")){
                        System.out.println("Past first turn. Cannot double down!");
                        System.out.println("What do you want to do(hit/doubleDown/stand)");
                        result=sc.next();

                    }

                    else if(result.equals("stand")){

                        d1.result(s1);
                        if(d1.getHand().bust()){
                            System.out.println("Player Wins");

                            p1.addChips(bet);
                            System.out.println("You have "+p1.getChips()+"chips");
                            outcome="Done";
                            playerTurn=0;    
                        }

                        else if(d1.getHand().getValue()>p1.getHand().getValue()){
                            System.out.println("Dealer Wins");
                            p1.addChips(-bet);

                            System.out.println("You have "+p1.getChips()+"chips");
                            System.out.println("Dealer has:\n");
                            for(int j=0;j<d1.getHand().getHand().size();j++){
                                d1.printCard(j);    
                            }
                            outcome="Done";
                            playerTurn=0;
                        }
                        else if(d1.getHand().getValue()<p1.getHand().getValue()){
                            System.out.println("Player Wins");
                            for(int j=0;j<d1.getHand().getHand().size();j++){

                                d1.printCard(j);

                            }
                            p1.addChips(bet);
                            System.out.println("You have "+p1.getChips()+"chips");
                            outcome="Done";
                            playerTurn=0;
                        }
                        else if(d1.getHand().getValue()==p1.getHand().getValue()){
                            System.out.println("There is a push");
                            playerTurn=0;
                            outcome="Done";
                            System.out.println("Dealer has");
                            for(int j=0;j<d1.getHand().getHand().size();j++){

                                d1.printCard(j);

                            }

                        }
                    }
                    while(result.equals("hit") && p1.getHand().getValue()<21){

                        p1.addCard(s1);
                        playerTurn++;
                        System.out.println(p1);  
                        d1.result(s1);

                        if(p1.getHand().bust()){
                            System.out.println("Dealer Wins");
                            System.out.println("You busted and have\n"+p1); 

                            p1.addChips(bet);
                            System.out.println("You have "+p1.getChips()+"chips");
                            outcome="Done";
                            result="Done";
                            playerTurn=0;    
                        }

                        else if(!p1.getHand().bust()){
                            System.out.println("What do you want to do(hit/stand)");
                            result=sc.next();    
                        }
                        else if(result.equals("stand")){
                        outcome="Done";
                    }


                    }
                }
            }
            p1.getHand().clearHand();
            d1.getHand().clearHand();
            System.out.println("Do you want to play?(Yes/No)");
            answer=sc.next();
        }
        System.out.println("Game Over");
        System.out.println("You have "+p1.getChips()+"chips");
    }
}

