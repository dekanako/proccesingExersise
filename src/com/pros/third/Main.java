package com.pros.third;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

public class Main extends PApplet {
    public static PApplet Instance;
    public static void main(String[] args) {
	    PApplet.main(Main.class, args);
     }

    @Override
    public void settings() {
        super.settings();
        size(700,700);
    }

    @Override
    public void setup() {

        Instance = this;
        background(0);
        mover = new Mover();
    }
    private Mover mover;
    @Override
    public void draw() {
        background(0);
        text("Velocity "+String.valueOf(mover.velocity.x),0,Instance.height -10);
        mover.update();
        mover.checkEdges();
        mover.displays();
     }

    @Override
    public void keyPressed() {

        if (keyCode == UP)mover.increaseAcceleration(new PVector(0.01f,0));

        if (keyCode == DOWN)mover.increaseAcceleration(new PVector(-0.01f,0));

        System.out.println(mover.acceleration);

    }
}
