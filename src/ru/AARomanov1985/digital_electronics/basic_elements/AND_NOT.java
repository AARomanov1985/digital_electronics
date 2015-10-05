/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.AARomanov1985.digital_electronics.basic_elements;

import ru.AARomanov1985.digital_electronics.Element;

/**
 *
 * @author raan
 */
public class AND_NOT extends Element{
    private boolean in_1;
    private boolean in_2;
    private boolean out;

    public AND_NOT(){};

    public AND_NOT(boolean in_1, boolean in_2){
        this.in_1 = in_1;
        this.in_2 = in_2;
        this.out = !(in_1 & in_2);
    }

    public enum outputs{
        x1,x2,y1;
    }

    public boolean get(outputs o) {
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

    public void set(outputs o, boolean s) {
        switch(o){
            case x1:
                this.in_1 = s;break;
            case x2:
                this.in_2 = s;break;
        }
        this.out = !(in_1 & in_2);
    }
}
