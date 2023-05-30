package kat.hamster.shapes;

import kat.hamster.shapes.animation.Animator;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int dx;
    protected int dy;
    protected  int size;
    protected Color color;

    public int getSize() {return size;}

    public void setSize(int size) {this.size = size;}

    public int getDx() {return dx;}

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {return dy;}

    public void setDy(int dy) {
        this.dy = dy;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Shape(int x, int y,int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = (int)(Math.random() *10);
        this.dy = (int)(Math.random() *10);
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void draw(Graphics g);
    public abstract Animator getAnimator(JComponent component);

}
