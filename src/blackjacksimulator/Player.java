package blackjacksimulator;

import blackjacksimulator.CardDeck.Cards;

public class Player
{
    private int playerHandTotal, handsPlayed, handsWon, handsLost, handsPush;
    private float bankroll, bet;
    private Cards hand[][];
    private enum Action
    {
        HIT,
        STAND,
        DOUBLE_DOWN,
        SPLIT
    }

    public float getBankroll()
    {
        return (bankroll);
    }
    
    public void takeWinnings(float winnings)
    {
        bankroll += winnings;
    }
    
    public void playerWon(int hands)
    {
        handsWon += hands;
    }
    
    public void playerLost(int hands)
    {
        handsLost += hands;
    }
    
    public void playerPush(int hands)
    {
        handsPush += hands;
    }
    
    public float placeBet(float bet)
    {
        if (bankroll < bet)
            return (0);
        
        bankroll -= bet;
        return (bet);
    }
    
    private int countCards()
    {
        /* TODO: Have this function count cards based on the hi/low method. */
    }

    private Action determineAction(int hand)
    {
        /* TODO: Put blackjack basic strategy chart logic in here. */
    }

    Player(float startingCash)
    {
        bankroll = startingCash;
        handsWon = 0;
        handsLost = 0;
        handsPush = 0;
    }

}
