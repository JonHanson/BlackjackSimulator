package blackjacksimulator;

public class Main
{
    /* Usage: blackjacksimulator [number of decks] [number of trials] [starting cash] */
    public static void main(String[] args)
    {
        if (args.length != 4)
        {
            System.out.println("Usage:");
            System.out.println("\tblackjacksimulator [number of decks] [number of trials] [starting cash]");
        }
        
        int trialsToRun = Integer.parseInt(args[1]);
        Game game = new Game(Integer.parseInt(args[0]), Float.parseFloat(args[2]));
        for (int trial = 1; trial <= trialsToRun; trial++)
        {
            game.runGame();

        }
    }

}
