package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Lớp Square mô tả một hình vuông dựa trên lớp Rectangle.
 */
public class Square extends Rectangle {

    private static final Map<String, Color> COLOR_MAP = new HashMap<>();
    private int appWidth = 500;
    private int appHeight = 500;

    public Square(int appWidth, int appHeight) {
        this.appWidth = appWidth;
        this.appHeight = appHeight;
    }

    public int getAppWidth() {
        return appWidth;
    }

    public int getAppHeight() {
        return appHeight;
    }

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
     * Constructor mặc định không tham số cho lớp Square.
     */
    public Square() {

    }

    /**
     * Constructor với tham số chiều dài cạnh cho lớp Square.
     *
     * @param side Chiều dài cạnh của hình vuông.
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Constructor với tham số chiều dài cạnh, màu sắc và trạng thái filled cho lớp Square.
     *
     * @param side   Chiều dài cạnh của hình vuông.
     * @param color  Màu sắc của hình vuông.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    /**
     * Constructor với tham số chiều dài cạnh, màu sắc và trạng thái filled cho lớp Square.
     *
     * @param side   Chiều dài cạnh của hình vuông.
     * @param color  Màu sắc của hình vuông.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     * @param velocityX Tốc độ theo trục X.
     * @param velocityY Tốc độ theo trục Y.
     */
    public Square(Point topLeft, double side, String color, boolean filled, double velocityX, double velocityY) {
        super(topLeft, side, side, color, filled);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    /**
     * Đặt chiều dài cạnh của hình vuông.
     *
     * @param side Chiều dài cạnh mới của hình vuông.
     */
    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

    /**
     * Lấy chiều dài cạnh của hình vuông.
     *
     * @return Chiều dài cạnh của hình vuông.
     */
    public double getSide() {
        return getLength();
    }

    /**
     * Ghi đè phương thức setWidth của lớp Rectangle để đặt chiều dài cạnh của hình vuông.
     *
     * @param side Chiều dài cạnh mới của hình vuông.
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Ghi đè phương thức setLength của lớp Rectangle để đặt chiều dài cạnh của hình vuông.
     *
     * @param side Chiều dài cạnh mới của hình vuông.
     */
    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Tính chu vi của hình vuông.
     *
     * @return Chu vi của hình vuông.
     */
    @Override
    public double getPerimeter() {
        return getSide() * 4;
    }

    /**
     * Tính diện tích của hình vuông.
     *
     * @return Diện tích của hình vuông.
     */
    @Override
    public double getArea() {
        return getSide() * getSide();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return Double.compare(square.getSide(), getSide()) == 0 && topLeft.equals(square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSide(), topLeft);
    }


    /**
     * Chuyển đổi thông tin của hình vuông thành chuỗi ký tự.
     *
     * @return Chuỗi ký tự biểu diễn thông tin của hình vuông.
     */
    @Override
    public String toString() {
        return "Square[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY()
                + "),side=" + getSide()
                + ",color=" + color
                + ",filled=" + filled + ']';
    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            Color color = COLOR_MAP.get(this.color);
            g2d.setColor(color != null ? color : Color.BLACK);

            int x = (int) topLeft.getPointX();
            int y = (int) topLeft.getPointY();
            int side = (int) getSide();

            if (filled) {
                g2d.fillRect(x, y, side, side);
            } else {
                g2d.drawRect(x, y, side, side);
            }
        } catch (NumberFormatException e) {
            g2d.setColor(Color.BLACK);
            int x = (int) topLeft.getPointX();
            int y = (int) topLeft.getPointY();
            int side = (int) getSide();

            if (filled) {
                g2d.fillRect(x, y, side, side);
            } else {
                g2d.drawRect(x, y, side, side);
            }
        }
    }

    @Override
    public boolean contains(java.awt.Point point) {
        double halfWidth = width / 2.0;
        double halfHeight = length / 2.0;
        double leftX = topLeft.getPointX();
        double topY = topLeft.getPointY();

        return point.getX() >= leftX && point.getX() <= leftX + halfWidth &&
                point.getY() >= topY && point.getY() <= topY + halfHeight;
    }


}
