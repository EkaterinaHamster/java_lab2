package kat.hamster;

import kat.hamster.shapes.Shape;
import kat.hamster.shapes.CircleInEllipse;
import kat.hamster.componens.GraphicsPanel;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new CircleInEllipse(0, 0, 200, 100));
        shapes.add(new CircleInEllipse(0, 0, 100, 200));



        GraphicsPanel canvas = new GraphicsPanel(shapes);

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);
    }

}