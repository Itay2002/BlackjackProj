
/**
 * Write a description of class Dealer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dealer
{
    private Hand dealerHand;
    
    /**
     * constructor for the dealer, creates a new hand
     * @param: NONE
     * @return: NONE
     */
    public Dealer(){
        dealerHand = new Hand();
    }

    /**
     * dtermines whether or not the dealer should hit or not, the dealer hits while the value of the hand is 
     * less than 17
     * @param: Shoe - the shoe that tha cards are being taken from
     * @return: NONE
     */
    public void result(Shoe s1){
        if(dealerHand.getValue()<17){
            dealerHand.hit(s1);
        }
    }

    /**
     * adds a card to the dealers hand
     * @param: Shoe - the shoe that the cards are being taken from
     * @return: NONE
     */
    public void addCard(Shoe s1){
        dealerHand.hit(s1);
    }

    /**
     * prints out a card at a certain position in the dealers hand
     * @param: int - the position of the card to be printed
     * @return: NONE
     */
    public void printCard(int i){
        
        System.out.println(dealerHand.getHand().get(i)+"\n");  
    }

    /**
     * returns the dealers hand
     * @param: NONE
     * @return: hand - the dealers hand
     */
    public Hand getHand()
    {
        return dealerHand;
    }
}

    
