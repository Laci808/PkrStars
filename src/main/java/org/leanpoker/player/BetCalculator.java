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

/**
 *
 * @author laci
 */
public class BetCalculator {

    private HandValue handValueCalculator;

    public BetCalculator() {
        handValueCalculator = new HandValue();
    }

    public int getCurrentBet(List<Card> cards) {
        List<Integer> cardValues = new ArrayList<>();
        for (Card card : cards) {
            cardValues.add(Cards.getValue(card.getRank()));
        }
        Integer handValue = handValueCalculator.getHandValue(cardValues);
        return handValue;
    }

}
