
import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hand
{
    private ArrayList<Card> hand;

    /**
     * contructor for a hand, creates a new arraylist full of cards
     * @param: NONE
     * @return: NONE
     */
    public Hand()
    {
        hand = new ArrayList<Card>();

    }

    /**
    * determines the value of the hand by taking the value of each card and adding it to a total 
    * @param: NONE
    * @return: the total value of all the cards in a hand
    */
    public int getValue(){
        int value = 0;
        for(int i=0;i<hand.size();i++){
            value+=hand.get(i).getCardValue();
            if(value >21 && hand.get(i).isAce() )
            //Set current card position value to 1
                hand.get(i).setAceToOne(true);

        }
        return value;
    }

    /**
    * checks if the hand value is equal to 21 and has 2 cardsand if it is, then it returns blackjack as true,
    * if it does not, then false is returned
    * @param: NONE
    * @return: boolean - true if blackjack false if not
    */
    public boolean blackjack()
    {
        if (getValue() == 21 && hand.size() == 2)
        {
            return true;
        }
        return false;
    }

    /**
    * checks if the hand value is greater than 21, if so, then the method returns true, if not, then 
    * false is returned
    * @param: NONE
    * @return: boolean - true if bust, false if not
    */
    public boolean bust()
    {
        if(getValue() > 21)
        {
            return true;
        }
        return false;
    }

    /**
    * adds a card the the hand 
    * @param: NONE
    * @return: NONE
    */
    public void hit(Shoe s1)
    {
        hand.add(s1.dealCard());
    }
    /**
    * gets the hand
    * @param: NONE
    * @return: ArrayList - the hand full of cards
    */
    public ArrayList<Card> getHand(){
    return hand;    
    }
    /**
    * "clears" the hand by creating a new one so the hand is empty
    * @param: NONE
    * @return: NONE
    */
    public void clearHand(){
    hand=new ArrayList<Card>();    
    }
}
