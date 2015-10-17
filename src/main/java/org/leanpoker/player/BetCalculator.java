/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author laci
 */
public class BetCalculator {

    private HandValue handValue;

    public BetCalculator() {
        handValue = new HandValue();
    }

    public void getCurrentBet(List<Card> cards) {
        List<Integer> cardValues = new ArrayList<>();
        for (Card card : cards) {
            cardValues.add(Cards.getValue(card.getRank()));
        }
        handValue.getHandValue(cardValues);
    }

}
