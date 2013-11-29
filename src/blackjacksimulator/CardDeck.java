package blackjacksimulator;

import java.util.Random;

public class CardDeck
{
    /* Cards are enumerated with the face value preceeded by the suit (S = spades, D = diamonds, H = hearts, C = clubs). SC is the card to indicate when to reshuffle the deck. */
    public enum Cards
    {   
        S2, S3, S4, S5, S6, S7, S8, S9, S10, SJ, SQ, SK, SA, 
        D2, D3, D4, D5, D6, D7, D8, D9, D10, DJ, DQ, DK, DA, 
        H2, H3, H4, H5, H6, H7, H8, H9, H10, HJ, HQ, HK, HA,
        C2, C3, C4, C5, C6, C7, C8, C9, C10, CJ, CQ, CK, CA,
        SC
    };
    
    private int numberOfDecks, cardsLeft;
    private int numberOfCards = 52;
    private boolean shuffleNext;
    private Cards[] shoe;
    
    /* The following variable says when to reshuffle the shoe. A value of 0.75 would
     * mean to shuffle when to shuffle after 75% of the cards have been delt. */
    private double deckPenetration = 0.5;
    
    public boolean getShuffleNext()
    {
        return (shuffleNext);
    }
    
    public Cards deal()
    {
        Cards deltCard;
        
        deltCard = shoe[numberOfCards * numberOfDecks - cardsLeft];
        cardsLeft--;
        if (deltCard == Cards.SC)
        {
            shuffleNext = true;
            deltCard = shoe[numberOfCards * numberOfDecks - cardsLeft];
            cardsLeft--;
        }
        
        return (deltCard);
    }
    
    public void shuffle()
    {
        Cards dummyCard;
        Random randomNumber = new Random();
        
        /* The following is an array that represents the number of all of the cards
         * in the above enum in that order. For example, array index 2 indicates 
         * the number of 4 of spades in the pool to be shuffled. */
        int[] cardPool = new int[numberOfCards];
        
        for (int i = 0; i < numberOfCards; i++)
            cardPool[i] = numberOfDecks;
        
        for (int card = 0; card < numberOfCards * numberOfDecks + 1; card++)
        {
            Cards shuffledCard = Cards.SC; // Dummy initialization to prevent a compiler warning
            int pickedNumber;
            
            /* Insert the special card that indicates that a suffle is to occur on
             * the next hand. */
            if (card >= numberOfCards * numberOfDecks * deckPenetration)
            {
                shoe[card] = Cards.SC;
                continue;
            }
                
            do
            {
                pickedNumber = randomNumber.nextInt(numberOfCards);
            } while (cardPool[pickedNumber] != 0);
            
            cardPool[pickedNumber]--;
            shoe[card] = shuffledCard.values()[pickedNumber];
        }
        
        cardsLeft = numberOfCards * numberOfDecks + 1;
        shuffleNext = false;
        
        /* Burn the top card on the deck. */
        dummyCard = deal();
    }
    
    CardDeck(int decks)
    {
        numberOfDecks = decks;
        shoe = new Cards[numberOfDecks * numberOfCards + 1];
        cardsLeft = numberOfDecks * numberOfCards;
        shuffleNext = false;
        shuffle();
    }
}
