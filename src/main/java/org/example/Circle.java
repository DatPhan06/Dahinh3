package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Lớp Circle mô tả một hình tròn với bán kính và màu sắc.
 */
public class Circle extends Shape {
    protected double radius;
    protected Point center;
    protected double velocityX; // Tốc độ theo trục X
    protected double velocityY; // Tốc độ theo trục Y
    private int appWidth = 500;
    private int appHeight = 500;

    public Circle(int appWidth, int appHeight) {
        this.appWidth = appWidth;
        this.appHeight = appHeight;
    }

    public int getAppWidth() {
        return appWidth;
    }

    public int getAppHeight() {
        return appHeight;
    }

    private static final Map<String, Color> COLOR_MAP = new HashMap<>();

    static {
        // Initialize the color map with basic colors
        COLOR_MAP.put("Red", Color.RED);
        COLOR_MAP.put("Blue", Color.BLUE);
        COLOR_MAP.put("Green", Color.GREEN);
        COLOR_MAP.put("Yellow", Color.YELLOW);
        COLOR_MAP.put("Orange", Color.ORANGE);
        COLOR_MAP.put("Cyan", Color.CYAN);
        COLOR_MAP.put("Magenta", Color.MAGENTA);
        COLOR_MAP.put("Pink", Color.PINK);
        COLOR_MAP.put("LightGray", Color.LIGHT_GRAY);
        COLOR_MAP.put("DarkGray", Color.DARK_GRAY);
        COLOR_MAP.put("Gray", Color.GRAY);
        COLOR_MAP.put("Black", Color.BLACK);
    }


    /**
     * Constructor mặc định không tham số cho lớp Circle.
     */
    public Circle() {

    }

    /**
     * Constructor với tham số bán kính cho lớp Circle.
     *
     * @param radius Bán kính của hình tròn.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor với tham số bán kính, màu sắc và trạng thái filled cho lớp Circle.
     *
     * @param radius Bán kính của hình tròn.
     * @param color  Màu sắc của hình tròn.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public double getVelocityX() {
        return velocityX;
    }

    @Override
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    @Override
    public double getVelocityY() {
        return velocityY;
    }

    @Override
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * Constructor với tham số bán kính, màu sắc và trạng thái filled cho lớp Circle.
     *
     * @param radius Bán kính của hình tròn.
     * @param color  Màu sắc của hình tròn.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     * @param center tâm của hình tròn.
     */
    public Circle(Point center, double radius, String color, boolean filled) {

        super(color, filled);
        Random random = new Random();
        this.radius = radius;
        this.center = center;
        this.velocityX = random.nextDouble() * 10 - 5;
        this.velocityY = random.nextDouble() * 10 - 5;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Lấy bán kính của hình tròn.
     *
     * @return Bán kính của hình tròn.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Đặt bán kính của hình tròn.
     *
     * @param radius Bán kính mới của hình tròn.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Tính diện tích của hình tròn.
     *
     * @return Diện tích của hình tròn.
     */
    @Override
    public double getArea() {
        return radius * radius * 3.14159265;
    }

    /**
     * Tính chu vi của hình tròn.
     *
     * @return Chu vi của hình tròn.
     */
    @Override
    public double getPerimeter() {
        return radius * 2 * 3.14159265;
    }

    /**
     * Chuyển đổi thông tin của hình tròn thành chuỗi ký tự.
     *
     * @return Chuỗi ký tự biểu diễn thông tin của hình tròn.
     */
    @Override
    public String toString() {
        return "Circle[center=(" + center.getPointX() + "," + center.getPointY()
                + "),radius=" + radius
                + ",color=" + color
                + ",filled=" + filled + ']';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Get the color based on the color name
        Color shapeColor = COLOR_MAP.get(color);

        // Set the drawing color
        g2d.setColor(shapeColor);

        // Draw the circle using the specified color
        int x = (int) center.getPointX();
        int y = (int) center.getPointY();
        int diameter = (int) (2 * radius);
        g2d.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void move() {
        // Move the circle by updating the center coordinates based on velocity
        double newX = center.getPointX() + velocityX;
        double newY = center.getPointY() + velocityY;

        // Check for collision with the left or right border
        if (newX < 0 || newX > appWidth - radius) {
            // Reverse the X-direction velocity to bounce off the border
            velocityX = -velocityX;
        }

        // Check for collision with the top or bottom border
        if (newY < 0 || newY > appHeight - radius) {
            // Reverse the Y-direction velocity to bounce off the border
            velocityY = -velocityY;
        }

        // Update the center with the new coordinates
        center = new Point(newX, newY);
    }


    public boolean contains(java.awt.Point point) {
        double distance = Math.sqrt(Math.pow(point.getX() - center.getPointX(), 2) +
                Math.pow(point.getY() - center.getPointY(), 2));
        return distance <= radius;
    }



}
