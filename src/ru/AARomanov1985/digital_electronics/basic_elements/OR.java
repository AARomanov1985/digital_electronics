/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.AARomanov1985.digital_electronics.basic_elements;

/**
 *
 * @author raan
 */
public class OR implements BasicElements_IN2_OUT1{
    private boolean in_1;
    private boolean in_2;
    private boolean out;

    public OR(){};

    public OR(boolean in_1, boolean in_2){
        this.in_1 = in_1;
        this.in_2 = in_2;
        this.out = (in_1 | in_2);
    }

    @Override
    public boolean get(IN2_OUT1 o) {
        switch(o){
            case x1:
                return this.in_1;
            case x2:
                return this.in_2;
            case y1:
                return this.out;
            default:
                return false;
        }
    }

    @Override
    public void set(IN2_OUT1 o, boolean s) {
        switch(o){
            case x1:
                this.in_1 = s;break;
            case x2:
                this.in_2 = s;break;
        }
        this.out = (in_1 | in_2);
    }
}
