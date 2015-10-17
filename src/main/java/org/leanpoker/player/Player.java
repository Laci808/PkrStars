package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

public class Player {

    static final String VERSION = "0.8";
    private static BetCalculator betCalculator;

    public static int betRequest(GameState gameState) {
        betCalculator = new BetCalculator();
        int value = betCalculator.getCurrentBet(gameState.getActualPlayer().getHoleCards(), gameState.getCommunityCards());
        return calculateBetAmmount(LogicFactory.createLogic(gameState), value, gameState);
    }

    public static void showdown(GameState gameState) {
    }

    private static int calculateBetAmmount(Logic logic, int value, GameState gameState) {
        if (value < logic.getFoldingLimit()) {
            return 0;
        } else if (value < logic.getIntraiseLimit()) {
            return getCall(gameState);
        } else {
            return getRaise(gameState, value / 10);
        }
    }

    public static int getCall(GameState gameState) {
        return getBetCount(gameState, 0);
    }

    public static int getMinRaise(GameState gameState) {
        return getBetCount(gameState, gameState.getMinimumRaise());
    }

    public static int getRaise(GameState gameState, int alpha) {
        return getBetCount(gameState, alpha * gameState.getMinimumRaise());
    }

    public static int getBetCount(GameState gameState, int additional) {
        return gameState.getCurrentBuyIn() - gameState.getActualPlayer().getBet() + additional;
    }
}
