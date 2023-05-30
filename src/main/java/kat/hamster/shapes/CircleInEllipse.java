package kat.hamster.shapes;

import kat.hamster.shapes.animation.Animator;
import kat.hamster.componens.CircleInEllipseAnimator;

import javax.swing.*;
import java.awt.*;
public class CircleInEllipse extends Shape {

    public CircleInEllipse(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
        int diameter = Math.min(width, height);
        int circleX = x + (width - diameter) / 2;
        int circleY = y + (height - diameter) / 2;
        g.fillOval(circleX, circleY, diameter, diameter);
    }

    @Override
    public Animator getAnimator(JComponent component) {
        return new CircleInEllipseAnimator(this, component);
    }
}

