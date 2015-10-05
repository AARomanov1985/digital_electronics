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
public class NOT implements BasicElements_IN1_OUT1{
    private boolean in;
    private boolean out;

    public NOT(){};

    public NOT(boolean in){
        this.in = in;
        this.out = !in;
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
    public void set(IN1_OUT1 out, boolean s){
        if (out==IN1_OUT1.x1){
           this.in = s;
           this.out = !in;
        }
    }

    public static void main(String args[]){
        NOT n = new NOT(false);
        System.out.println(n.get(IN1_OUT1.x1)+" "+n.get(IN1_OUT1.y1));
        n.set(IN1_OUT1.x1, true);
        System.out.println(n.get(IN1_OUT1.x1)+" "+n.get(IN1_OUT1.y1));
    }
}
