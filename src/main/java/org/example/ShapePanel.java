package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class ShapePanel extends JPanel {
    private final List<Shape> shapes;

    public ShapePanel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Chuyển đổi Graphics thành Graphics2D để có thêm tính năng
        Graphics2D g2d = (Graphics2D) g;

        // Vẽ các hình trên panel
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }
}
