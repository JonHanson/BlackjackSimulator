package blackjacksimulator;

import blackjacksimulator.CardDeck.Cards;

public class Game
{
    public static boolean checkForBlackjack(Cards[] hand)
    {
        if ((hand[0] == Cards.CA || hand[0] == Cards.DA || hand[0] == Cards.HA || hand[0] == Cards.SA) &&
            (hand[1] == Cards.C10 || hand[1] == Cards.CJ || hand[1] == Cards.CQ || hand[1] == Cards.CK ||
            hand[1] == Cards.D10 || hand[1] == Cards.DJ || hand[1] == Cards.DQ || hand[1] == Cards.DK ||
            hand[1] == Cards.H10 || hand[1] == Cards.HJ || hand[1] == Cards.HQ || hand[1] == Cards.HK ||
            hand[1] == Cards.S10 || hand[1] == Cards.SJ || hand[1] == Cards.SQ || hand[1] == Cards.SK))
            return (true);
        
        if ((hand[0] == Cards.C10 || hand[0] == Cards.CJ || hand[0] == Cards.CQ || hand[0] == Cards.CK ||
            hand[0] == Cards.D10 || hand[0] == Cards.DJ || hand[0] == Cards.DQ || hand[0] == Cards.DK ||
            hand[0] == Cards.H10 || hand[0] == Cards.HJ || hand[0] == Cards.HQ || hand[0] == Cards.HK ||
            hand[0] == Cards.S10 || hand[0] == Cards.SJ || hand[0] == Cards.SQ || hand[0] == Cards.SK) &&
            (hand[1] == Cards.CA || hand[1] == Cards.DA || hand[1] == Cards.HA || hand[1] == Cards.SA))
            return (true);
        
        return (false);
    }
    
    public static int handTotal(Cards[] hand)
    {
        int total = 0, acesCount = 0;
                    
        for (int card = 0; card < hand.length; card++)
            switch (hand[card])
            {
                case C2: case D2: case H2: case S2:
                    total += 2;
                    break;
                    
                case C3: case D3: case H3: case S3:
                    total += 3;
                    break;
                    
                case C4: case D4: case H4: case S4:
                    total += 4;
                    break;
                    
                case C5: case D5: case H5: case S5:
                    total += 5;
                    break;
                    
                case C6: case D6: case H6: case S6:
                    total += 6;
                    break;
                    
                case C7: case D7: case H7: case S7:
                    total += 7;
                    break;
                    
                case C8: case D8: case H8: case S8:
                    total += 8;
                    break;
                    
                case C9: case D9: case H9: case S9:
                    total += 9;
                    break;
                    
                case C10: case D10: case H10: case S10:
                case CJ: case DJ: case HJ: case SJ:
                case CQ: case DQ: case HQ: case SQ:
                case CK: case DK: case HK: case SK:
                    total += 10;
                    break;
                    
                case CA: case DA: case HA: case SA:
                    acesCount++;
                    break;
            }
            
        if (total >= 11)
            total += acesCount;
        else
            total += 11 + acesCount - 1;
        
        return (total);
    }
    
    void runGame()
    {
        
    }
    
    Game(int decks, float startingPlayerBankroll)
    {
        CardDeck cardDeck = new CardDeck(decks);
        Player player = new Player(startingPlayerBankroll);
        Dealer dealer = new Dealer();
    }
}