package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

public class Player {

    static final String VERSION = "0.3";
    private static BetCalculator betCalculator;

    public static int betRequest(GameState gameState) {
        com.wcs.poker.gamestate.Player me = getPlayer(gameState.getPlayers(), gameState.getInAction());
        List<Card> allCard = me.getHoleCards();
        allCard.addAll(gameState.getCommunityCards());
        betCalculator = new BetCalculator();
        boolean shouldRaise = betCalculator.getCurrentBet(allCard);
        int bet = 0;
        if (shouldRaise) {
            bet = getMinRaise(gameState, me);
        } else {
            bet = getCall(gameState, me);
        }
        return bet;
    }

    public static void showdown(GameState gameState) {
    }

    private static com.wcs.poker.gamestate.Player getPlayer(List<com.wcs.poker.gamestate.Player> players, int inAction) {
        return players.get(inAction);
    }

    public static int getCall(GameState gameState, com.wcs.poker.gamestate.Player me) {
        return getBetCount(gameState, me, 0);
    }

    public static int getMinRaise(GameState gameState, com.wcs.poker.gamestate.Player me) {
        return getBetCount(gameState, me, gameState.getMinimumRaise());
    }

    public static int getBetCount(GameState gameState, com.wcs.poker.gamestate.Player me, int additional) {
        return gameState.getCurrentBuyIn() - me.getBet() + additional;
    }
}
