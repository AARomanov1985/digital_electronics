/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.AARomanov1985.digital_electronics.chips;

import ru.AARomanov1985.digital_electronics.basic_elements.*;

/**
 * Полусумматор
 *
 *
 * x1   x2  y2  y1
 * 0    0   0   0
 * 0    1   0   1
 * 1    0   0   1
 * 1    1   1   0
 *
 * y2 - флаг переноса
 *
 * @author raan
 */
public class HS {
    private final XOR xor = new XOR();
    private final AND and = new AND();
    private boolean in1,in2;
    private boolean out1,out2;

    public HS(){
        this.setData();
    }

    public void set(IN2_OUT2 out, boolean s){
        switch(out){
            case x1:
                in1 = s;
                break;
            case x2:
                in2 = s;
                break;
        }
        this.setData();
    }

    private void setData(){
        xor.set(IN2_OUT1.x1, in1);
        xor.set(IN2_OUT1.x2, in2);
        and.set(IN2_OUT1.x1, in1);
        and.set(IN2_OUT1.x2, in2);
        in1 = xor.get(IN2_OUT1.x1);
        in2 = xor.get(IN2_OUT1.x2);
        out1 = xor.get(IN2_OUT1.y1);
        out2 = and.get(IN2_OUT1.y1);
    }

    public boolean get(IN2_OUT2 out){
        switch(out){
            case x1:
                return in1;
            case x2:
                return in2;
            case y1:
                return out1;
            case y2:
                return out2;
        }
        return false;
    }

    public static void main(String args[]){
        HS hs = new HS();
        hs.set(IN2_OUT2.x1, true);
        hs.set(IN2_OUT2.x2, false);
        System.out.println(hs.get(IN2_OUT2.y2)+" "+hs.get(IN2_OUT2.y1));
    }

}
