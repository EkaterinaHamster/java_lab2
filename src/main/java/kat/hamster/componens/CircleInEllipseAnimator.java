package kat.hamster.componens;

import kat.hamster.componens.GraphicsPanel;
import kat.hamster.shapes.Shape;
import kat.hamster.shapes.CircleInEllipse;
import kat.hamster.shapes.animation.Animator;

import java.awt.Color;
import javax.swing.JComponent;

public class CircleInEllipseAnimator extends Animator {
    private double angle;
    private double radius;
    private Color[] colors;
    private int colorIndex;

    public CircleInEllipseAnimator(Shape shape, JComponent component) {
        super(shape, component);
        angle = 0.0;
        radius = 200;
        colors = new Color[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        colorIndex = 0;
    }

    @Override
    public void run() {
        while (true) {
            angle += 10.00;
            if (angle >= 360){
                angle = 0;
            }
         //   System.out.println(angle);
            int centerX = component.getWidth() / 2;
            int centerY = component.getHeight() / 2;
            int x = centerX +((int) (radius * Math.cos(angle*3.14/180)) - shape.getWidth() / 2);
            int y = centerY + (int) (radius * Math.sin(angle*3.14/180)) - shape.getHeight() / 2;
            shape.moveTo(x,y);
            System.out.println(x);
            System.out.println(y);

            if ( angle == 0) {
                colorIndex = (colorIndex + 1) % colors.length;
                shape.setColor(colors[colorIndex]);
                double scale = 1 + Math.random() / 4;
                shape.setHeight((int) (shape.getHeight() * scale));
                shape.setWidth((int) (shape.getWidth() * scale));

//                int width = shape.getWidth() == 100 ? 50 : 100;
//                int height = shape.getHeight() == 100 ? 50 : 100;
//                ((CircleInEllipse) shape).setWidth(width);
//                ((CircleInEllipse) shape).setHeight(height);
            }

            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}