package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

public class Player {

    static final String VERSION = "0.1";
    private static BetCalculator betCalculator;

    public static int betRequest(GameState gameState) {
        com.wcs.poker.gamestate.Player me = getPlayer(gameState.getPlayers(), gameState.getInAction());
        List<Card> allCard = me.getHoleCards();
        allCard.addAll(gameState.getCommunityCards());
        betCalculator = new BetCalculator();
        betCalculator.getCurrentBet(allCard);
        return gameState.getCurrentBuyIn() - me.getBet();
    }

    public static void showdown(GameState gameState) {
    }

    private static com.wcs.poker.gamestate.Player getPlayer(List<com.wcs.poker.gamestate.Player> players, int inAction) {
        return players.get(inAction);
    }

}
