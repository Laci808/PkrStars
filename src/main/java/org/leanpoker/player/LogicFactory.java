/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

/**
 *
 * @author laci
 */
public class LogicFactory {

    public static Logic createLogic(GameState gameState) {
        List<Card> communityCards = gameState.getCommunityCards();
        int cardsOnDesk = communityCards.size();
        int chips = gameState.getActualPlayer().getStack();
        int chipsOnDesk = gameState.getPot();
        int currentBuyIn = gameState.getCurrentBuyIn();

        Logic logicToreturn = new Logic(1, 10);
        switch (cardsOnDesk) {
            case 0: {
                if (currentBuyIn > chips / 4) {
                    logicToreturn = new Logic(1, 1);
                }
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                logicToreturn = new Logic(1, 20);
            }
        }
        return logicToreturn;
    }

}
