/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author laci
 */
public class HandValue {

    private Map<Integer, Integer> matchList = new TreeMap<>();

    public Integer getHandValue(List<Integer> cardValues) {

        for (Integer oneCard : cardValues) {
            Integer existingCard = matchList.get(oneCard);
            if (existingCard != null) {
                matchList.put(oneCard, ++existingCard);
            } else {
                matchList.put(oneCard, 1);
            }

        }
        PokerHands highest = getResult();
        if (highest != null) {
            return highest.getValue();
        } else {
            return 0;
        }
    }

    private PokerHands getResult() {
        PokerHands highestValue = null;
        for (Integer key : matchList.keySet()) {
            Integer currentResult = matchList.get(key);
            switch (currentResult) {
                case 2: {
                    for (Integer inside : matchList.keySet()) {
                        if (inside != key) {
                            if (matchList.get(inside) == 2) {
                                if (highestValue == null || highestValue.getValue() < PokerHands.TWOPAIR.getValue()) {
                                    highestValue = PokerHands.TWOPAIR;
                                }
                            }
                            if (matchList.get(inside) == 3) {
                                if (highestValue == null || highestValue.getValue() < PokerHands.FULLHOUSE.getValue()) {
                                    highestValue = PokerHands.FULLHOUSE;
                                }
                            }
                        }
                    }

                    if (highestValue == null || highestValue.getValue() < PokerHands.PAIR.getValue()) {
                        highestValue = PokerHands.PAIR;
                    }
                    break;
                }
                case 3: {
                    if (highestValue == null || highestValue.getValue() < 3) {
                        highestValue = PokerHands.TOFK;
                    }
                    break;
                }
                case 4: {
                    if (highestValue == null || highestValue.getValue() < 4) {
                        highestValue = PokerHands.FOFK;
                    }
                    break;
                }
                default: {
                }
            }
        }
        return highestValue;
    }

    public enum PokerHands {

        PAIR(10),
        TWOPAIR(20),
        TOFK(30),
        STRAIGHT(40),
        FLUSH(50),
        FULLHOUSE(60),
        FOFK(70),
        STRAIGHTFLUSH(80);
        private int value;

        PokerHands(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
