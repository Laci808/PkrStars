/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.leanpoker.player;

/**
 *
 * @author laci
 */
public class Logic {
    private int foldingLimit;
    private int raiseLimit;

    public Logic(int foldingLimit, int raiseLimit) {
        this.foldingLimit = foldingLimit;
        this.raiseLimit = raiseLimit;
    }

    public int getFoldingLimit() {
        return foldingLimit;
    }

    public void setFoldingLimit(int foldingLimit) {
        this.foldingLimit = foldingLimit;
    }

    public int getIntraiseLimit() {
        return raiseLimit;
    }

    public void setIntraiseLimit(int raiseLimit) {
        this.raiseLimit = raiseLimit;
    }
    
}
