import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player 
{
    private int chips;
    private Hand playerHand;

    /**
     * contructor for a player, creates a new hand and sets the chips value equal to 1000
     * @param: NONE
     * @return: NONE
     */
    public Player()
    { 
        chips = 1000;

        playerHand = new Hand();


    }

    /**
     * returns the players hand
     * @param: NONE
     * @return: hand - the players hand
     */
    public Hand getHand()
    {
        return playerHand;
    }

    /**
     * checks to see if the player has blackjack, a bust, if their value is equal to 21, and if the value is 
     * less than 21, when these conditions are met, chips are added and subtracted accordingly
     * @param: int - the amount of chips to be added or subtracted 
     * @return: NONE
     */
    public void addChips(int result)
    {
        if (playerHand.blackjack() == true)
        {
            chips+= result* 1.5;
        }
        else if(playerHand.getValue()==21)
        {
            chips+=result;
        }
        else if(playerHand.bust())
        {
            chips-=result;  
        }
        else if(playerHand.getValue()<21){
            chips+=result;    
        }
    }

    /**
     * adds a card to the players hand
     * @param: Shoe - the shoe that the cards aee being taken from
     * @return: NONE
     */
    public void addCard(Shoe s1)
    {
        playerHand.hit(s1);
    }

    /**
     * takes the players bet and multiplies it by two
     * @param: int - the players bet
     * @return: int - the players bet multiplied by 2
     */
    public int doubleDown(int bet){
        bet*=2;
        return bet;
    }

    /**
     * prints out the cards in tha players handsw
     * @param: NONE
     * @return: string - the cards in the players hand with their suit and rank
     */
    public String toString(){
        String result="Your Cards are\n";
        for(int i=0;i<playerHand.getHand().size();i++){

            result+=playerHand.getHand().get(i)+"\n";   
        }
        return result;
    }

    /**
     * gets the amount of chips that the player has
     * @param: NONE
     * @return: int - the number of chips the player has
     */
    public int getChips(){
        return chips;    
    }
}

