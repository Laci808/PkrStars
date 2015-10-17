/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Rank;

/**
 *
 * @author laci
 */
public enum Cards {

    A(Rank.ACE, 14),
    K(Rank.KING, 13),
    Q(Rank.QUEEN, 12),
    J(Rank.JACK, 11),
    T(Rank.TEN, 10),
    N(Rank.NINE, 9),
    E(Rank.EIGHT, 8),
    S(Rank.SEVEN, 7),
    Si(Rank.SIX, 6),
    F(Rank.FIVE, 5),
    Fo(Rank.FOUR, 4),
    Th(Rank.THREE, 3),
    Tw(Rank.TWO, 2);

    private Rank rank;
    private int value;

    Cards(Rank rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static int getValue(Rank rank) {
        Cards[] cards = Cards.values();
        int value = 0;
        for (Cards oneCard : cards) {
            if (oneCard.getRank().equals(rank)) {
                value = oneCard.getValue();
            }
        }
        return value;
    }
}
