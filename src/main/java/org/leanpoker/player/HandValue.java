/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import java.util.List;

/**
 *
 * @author laci
 */
public class HandValue {

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
    }

    public int getHandValue(List<Integer> cardValues) {
        for (int oneCard : cardValues) {
        }
        return 0;
    }
}
