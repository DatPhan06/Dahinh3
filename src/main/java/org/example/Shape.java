package org.example;

import java.awt.*;
import java.awt.Point;

/**
 * Lớp Shape là lớp cơ sở trừu tượng đại diện cho các hình học.
 */
public abstract class Shape {
    protected String color;
    protected boolean filled;
    protected double velocityX;
    protected double velocityY;


    /**
     * Constructor mặc định không tham số cho lớp Shape.
     */
    public Shape() {
    }

    /**
     * Constructor với tham số màu sắc và trạng thái filled cho lớp Shape.
     *
     * @param color  Màu sắc của hình.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Lấy màu sắc của hình.
     *
     * @return Màu sắc của hình.
     */
    public String getColor() {
        return color;
    }

    /**
     * Đặt màu sắc của hình.
     *
     * @param color Màu sắc mới của hình.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Kiểm tra xem hình có được tô màu (filled) hay không.
     *
     * @return `true` nếu hình được tô màu, ngược lại `false`.
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Đặt trạng thái filled (tô màu) của hình.
     *
     * @param filled Trạng thái filled mới của hình.
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Lấy tốc độ theo trục X của hình.
     *
     * @return Tốc độ theo trục X của hình.
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * Đặt tốc độ theo trục X của hình.
     *
     * @param velocityX Tốc độ mới theo trục X của hình.
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * Lấy tốc độ theo trục Y của hình.
     *
     * @return Tốc độ theo trục Y của hình.
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * Đặt tốc độ theo trục Y của hình.
     *
     * @param velocityY Tốc độ mới theo trục Y của hình.
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * Phương thức trừu tượng để tính diện tích của hình.
     *
     * @return Diện tích của hình.
     */
    public abstract double getArea();

    /**
     * Phương thức trừu tượng để tính chu vi của hình.
     *
     * @return Chu vi của hình.
     */
    public abstract double getPerimeter();

    /**
     * Chuyển đổi thông tin của hình thành chuỗi ký tự.
     *
     * @return Chuỗi ký tự biểu diễn thông tin của hình.
     */
    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled +
                ", velocityX=" + velocityX + ", velocityY=" + velocityY + ']';
    }

    /**
     * Phương thức trừu tượng để vẽ hình.
     *
     * @param g2d Đối tượng Graphics2D để vẽ hình.
     */
    public abstract void draw(Graphics2D g2d);

    /**
     * Phương thức trừu tượng để di chuyển hình.
     */
    public abstract void move();

    public abstract boolean contains(Point point);
}
