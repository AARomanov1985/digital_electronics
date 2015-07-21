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
public class REPEATER implements BasicElements_IN1_OUT1{
    private boolean in;
    private boolean out;

    public REPEATER(){};

    public REPEATER(boolean in){
        this.in = in;
        this.out = in;
    }

    @Override
    public boolean get(IN1_OUT1 out){
        switch (out){
            case x1:
                return this.in;
            case y1:
                return this.out;
        }
        return false;
    }

    @Override
    public void set(IN1_OUT1 out, boolean in){
        this.in = in;
        this.out = this.in;
    }

    public static void main(String args[]){
        REPEATER n = new REPEATER(false);
        System.out.println(n.get(IN1_OUT1.x1)+" "+n.get(IN1_OUT1.y1));
    }
}
