package com.pros.third;




import processing.core.PVector;

import static com.pros.third.Main.Instance;


public class Mover {
    PVector location;
    PVector velocity;
    PVector acceleration;
    float mass;

    public Mover() {
        location = new PVector(10, 10);
        velocity = new PVector(0,0);
        acceleration = new PVector(0.0f,0);
        velocity.limit(1);
        Instance.noStroke();
        Instance.fill(255);
        mass = Instance.random(1, 2);
    }

    public void update(){
        velocity.add(acceleration);
        location.add(velocity);
    }

    public void increaseAcceleration(PVector acceleration){
        this.acceleration.add(acceleration);
        System.out.println("ex" + acceleration);
    }



     public void checkEdges() {

        if (location.x > Instance.width) {
            location.x =0;
        }
        else if (location.x < 0) {
            location.x = Instance.width;
        }

        if (location.y > Instance.height) {
            location.y = Instance.height;
            velocity.y *= -1;
        }
        else if (location.y < 0) {
            location.y = 0;
            velocity.y *= -1;
        }

    }

    public void displays() {
        Instance.rect(location.x, location.y, 50,20);
        Instance.circle(location.x +5,location.y + 25,10);
        Instance.circle(location.x +44,location.y + 25,10);

    }


}
