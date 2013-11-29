package blackjacksimulator;

import blackjacksimulator.CardDeck.Cards;

public class Dealer
{
    private int dealerHandTotal;
    private Cards[] dealerHand;
    private enum Action
    {
        HIT,
        STAND
    }
    
    /* Returns true if the hand is a soft hand, otherwise false. */
    private boolean softTotal()
    {
        if (dealerHand[0] == Cards.CA || dealerHand[0] == Cards.DA || dealerHand[0] == Cards.HA || dealerHand[0] == Cards.SA || dealerHand[1] == Cards.CA || dealerHand[1] == Cards.DA || dealerHand[1] == Cards.HA || dealerHand[1] == Cards.SA)
            return (true);
        else
            return (false);
    }
    
    /* Dealer stands on soft 17 and hits 16 or less. */
    private Action determineAction()
    {   
        if ((softTotal() && Game.handTotal(dealerHand) == 17) || Game.handTotal(dealerHand) >= 17)
            return (Action.STAND);
        else
            return (Action.HIT);
    }
    
    public Cards getUpCard()
    {
        /* The up card is always the first card that is delt to the dealer. */
        return (dealerHand[0]);
    }
}
