package org.example;

import java.awt.*;
import java.util.*;

/**
 * Lớp Rectangle mô tả một hình chữ nhật với chiều rộng, chiều dài, màu sắc và trạng thái filled.
 */
public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;
    protected double velocityX; // Tốc độ theo trục X
    protected double velocityY; // Tốc độ theo trục Y
    private static final Map<String, Color> COLOR_MAP = new HashMap<>();
    private int appWidth = 500;
    private int appHeight = 500;

    public Rectangle(int appWidth, int appHeight) {
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
     * Constructor mặc định không tham số cho lớp Rectangle.
     */
    public Rectangle() {

    }

    /**
     * Constructor với tham số chiều rộng và chiều dài cho lớp Rectangle.
     *
     * @param width  Chiều rộng của hình chữ nhật.
     * @param length Chiều dài của hình chữ nhật.
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor với tham số chiều rộng, chiều dài, màu sắc và trạng thái filled.
     *
     * @param width  Chiều rộng của hình chữ nhật.
     * @param length Chiều dài của hình chữ nhật.
     * @param color  Màu sắc của hình chữ nhật.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor với tham số chiều rộng, chiều dài, màu sắc và trạng thái filled.
     *
     * @param width  Chiều rộng của hình chữ nhật.
     * @param length Chiều dài của hình chữ nhật.
     * @param color  Màu sắc của hình chữ nhật.
     * @param filled Trạng thái filled (được tô màu hoặc không).
     * @param topLeft Góc trên bên trái của hình chữ nhật.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        Random random = new Random();
        this.velocityX = random.nextDouble() * 10 - 5;
        this.velocityY = random.nextDouble() * 10 - 5;
    }



    /**
     * Lấy chiều rộng của hình chữ nhật.
     *
     * @return Chiều rộng của hình chữ nhật.
     */
    public Point getTopLeft() {
        return topLeft;
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
     * Đặt chiều rộng của hình chữ nhật.
     *
     * @param topLeft Chiều rộng mới của hình chữ nhật.
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**
     * Lấy chiều rộng của hình chữ nhật.
     *
     * @return Chiều rộng của hình chữ nhật.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Đặt chiều rộng của hình chữ nhật.
     *
     * @param width Chiều rộng mới của hình chữ nhật.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Lấy chiều dài của hình chữ nhật.
     *
     * @return Chiều dài của hình chữ nhật.
     */
    public double getLength() {
        return length;
    }

    /**
     * Đặt chiều dài của hình chữ nhật.
     *
     * @param length Chiều dài mới của hình chữ nhật.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Tính diện tích của hình chữ nhật.
     *
     * @return Diện tích của hình chữ nhật.
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * Tính chu vi của hình chữ nhật.
     *
     * @return Chu vi của hình chữ nhật.
     */
    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0
                && Double.compare(length, rectangle.length) == 0
                && Objects.equals(topLeft, rectangle.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, topLeft);
    }

    /**
     * Chuyển đổi thông tin của hình chữ nhật thành chuỗi ký tự.
     *
     * @return Chuỗi ký tự biểu diễn thông tin của hình chữ nhật.
     */
    @Override
    public String toString() {
        return "Rectangle[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY()
                + "),width=" + width
                + ",length=" + length
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
            int w = (int) width;
            int h = (int) length;

            if (filled) {
                g2d.fillRect(x, y, w, h);
            } else {
                g2d.drawRect(x, y, w, h);
            }
        } catch (NumberFormatException e) {
            // Handle the exception (e.g., log an error) or provide a default color.
            // For now, I'm using Color.BLACK as a default.
            g2d.setColor(Color.BLACK);
            int x = (int) topLeft.getPointX();
            int y = (int) topLeft.getPointY();
            int w = (int) width;
            int h = (int) length;

            if (filled) {
                g2d.fillRect(x, y, w, h);
            } else {
                g2d.drawRect(x, y, w, h);
            }
        }
    }

    @Override
    public void move() {
        // Move the rectangle by updating the top-left coordinates based on velocity
        double newX = topLeft.getPointX() + velocityX;
        double newY = topLeft.getPointY() + velocityY;

        // Kiểm tra xem hình chữ nhật đã chạm vào cạnh của ứng dụng hay không
        if (newX < 0 || newX + width > appWidth) {
            // Nếu chạm vào biên theo trục X, đảo ngược hướng di chuyển
            velocityX = -velocityX;

            // Đặt lại vị trí để tránh việc rơi khỏi biên
            newX = newX < 0 ? 0 : (appWidth - width);
        }

        if (newY < 0 || newY + length > appHeight) {
            // Nếu chạm vào biên theo trục Y, đảo ngược hướng di chuyển
            velocityY = -velocityY;

            // Đặt lại vị trí để tránh việc rơi khỏi biên
            newY = newY < 0 ? 0 : (appHeight - length);
        }

        // Cập nhật vị trí mới của góc trên bên trái của hình chữ nhật
        topLeft = new Point(newX, newY);
    }
    @Override
    public boolean contains(java.awt.Point point) {
        double leftX = topLeft.getPointX();
        double topY = topLeft.getPointY();

        return point.getX() >= leftX && point.getX() <= leftX + width &&
                point.getY() >= topY && point.getY() <= topY + length;
    }



}
