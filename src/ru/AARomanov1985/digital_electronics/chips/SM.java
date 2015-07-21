/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.AARomanov1985.digital_electronics.chips;

import ru.AARomanov1985.digital_electronics.basic_elements.*;

/**
 * Полный сумматор
 * x1, x2 - числа
 * x3 - перенос
 * y1 - сумма
 * y2 - перенос
 *
 * @author raan
 */
public class SM {
    private final HS h1 = new HS();
    private final HS h2 = new HS();
    private final OR or = new OR();
    private boolean in1,in2, in3;
    private boolean out1,out2;

    public SM(){
        this.setData();
    }

    public void set(IN3_OUT2 out, boolean s){
        switch(out){
            case x1:
                in1 = s;
                break;
            case x2:
                in2 = s;
                break;
            case x3:
                in3 = s;
                break;
        }
        this.setData();
    }

    public boolean get(IN3_OUT2 out){
        switch(out){
            case x1:
                return in1;
            case x2:
                return in2;
            case x3:
                return in3;
            case y1:
                return out1;
            case y2:
                return out2;
        }
        return false;
    }

    private void setData(){
        h1.set(IN2_OUT2.x1, in1);
        h1.set(IN2_OUT2.x2, in2);
        h2.set(IN2_OUT2.x1, h1.get(IN2_OUT2.y1));
        h2.set(IN2_OUT2.x2, in3);
        or.set(IN2_OUT1.x1, h1.get(IN2_OUT2.y2));
        or.set(IN2_OUT1.x2, h2.get(IN2_OUT2.y2));
        out1 = h2.get(IN2_OUT2.y1);
        out2 = or.get(IN2_OUT1.y1);
    }

    public static void main(String args[]){
        SM s = new SM();
        s.set(IN3_OUT2.x1,false);
        s.set(IN3_OUT2.x2,false);
        s.set(IN3_OUT2.x3,false);
        System.out.println(s.get(IN3_OUT2.y2)+" "+s.get(IN3_OUT2.y1));
        s.set(IN3_OUT2.x1,false);
        s.set(IN3_OUT2.x2,false);
        s.set(IN3_OUT2.x3,true);
        System.out.println(s.get(IN3_OUT2.y2)+" "+s.get(IN3_OUT2.y1));
        s.set(IN3_OUT2.x1,false);
        s.set(IN3_OUT2.x2,true);
        s.set(IN3_OUT2.x3,false);
        System.out.println(s.get(IN3_OUT2.y2)+" "+s.get(IN3_OUT2.y1));
    }
}
