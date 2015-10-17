/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.List;
import org.leanpoker.player.HandValue.PokerHands;

/**
 *
 * @author laci
 */
public class BetCalculator {

    private HandValue handValueCalculator;

    public BetCalculator() {
        handValueCalculator = new HandValue();
    }

    public int getCurrentBet(List<Card> commCards, List<Card> ownCards) {
        List<Card> allCard = ownCards;
        allCard.addAll(commCards);
        List<Integer> cardValues = new ArrayList<>();
        for (Card card : allCard) {
            cardValues.add(Cards.getValue(card.getRank()));
        }
        int returnValue = 0;
        PokerHands handValue = handValueCalculator.getHandValue(cardValues);
        if (handValue == null) {
            returnValue = handValueCalculator.getHandValueByRank(ownCards);
        } else {
            returnValue = handValue.getValue();
        }
        return returnValue;
    }

}
