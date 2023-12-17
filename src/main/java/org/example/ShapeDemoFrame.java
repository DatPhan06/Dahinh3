package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JFrame hiển thị demo các hình học và cung cấp chức năng thêm hình mới
 * thông qua các phím tắt (R - hình chữ nhật, S - hình vuông, C - hình tròn).
 */
public class ShapeDemoFrame extends JFrame {

    private final List<Shape> shapes;
    private final ShapePanel shapePanel;

    /**
     * Constructor của lớp ShapeDemoFrame.
     *
     * @param shapes Danh sách các hình học.
     */
    public ShapeDemoFrame(List<Shape> shapes) {
        this.shapes = shapes;
        setTitle("Shape Demo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một ShapePanel và thêm vào các hình
        shapePanel = new ShapePanel(shapes);
        add(shapePanel);

        // Thiết lập Timer để di chuyển và vẽ lại các hình liên tục
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Di chuyển liên tục và vẽ lại mỗi hình trong danh sách
                for (Shape shape : shapes) {
                    shape.move();
                }
                shapePanel.repaint();
            }
        });
        timer.start();

        // Thêm KeyListener để xử lý sự kiện phím
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_R:
                        addRandomRectangle();
                        break;
                    case KeyEvent.VK_S:
                        addRandomSquare();
                        break;
                    case KeyEvent.VK_C:
                        addRandomCircle();
                        break;
                }
                shapePanel.repaint();
            }
        });

        // Thêm MouseListener để xử lý sự kiện chuột
        shapePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Kiểm tra xem điểm chuột có nằm trong hình nào không
                for (int i = shapes.size() - 1; i >= 0; i--) {
                    if (shapes.get(i).contains(e.getPoint())) {
                        // Nếu điểm chuột nằm trong hình, xóa hình đó
                        shapes.remove(i);
                        shapePanel.repaint();
                        break;
                    }
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    /**
     * Thêm một hình chữ nhật mới vào danh sách với thông số ngẫu nhiên.
     */
    private void addRandomRectangle() {
        int x = (int) (Math.random() * getWidth());
        int y = (int) (Math.random() * getHeight());
        int width = (int) (Math.random() * 50) + 20;
        int height = (int) (Math.random() * 50) + 20;
        String color = getRandomColor();
        shapes.add(new Rectangle(new Point(x, y), width, height, color, true));
    }

    /**
     * Thêm một hình vuông mới vào danh sách với thông số ngẫu nhiên.
     */
    private void addRandomSquare() {
        int x = (int) (Math.random() * getWidth());
        int y = (int) (Math.random() * getHeight());
        int side = (int) (Math.random() * 50) + 20;
        String color = getRandomColor();
        shapes.add(new Square(new Point(x, y), side, color, true));
    }

    /**
     * Thêm một hình tròn mới vào danh sách với thông số ngẫu nhiên.
     */
    private void addRandomCircle() {
        int x = (int) (Math.random() * getWidth());
        int y = (int) (Math.random() * getHeight());
        int radius = (int) (Math.random() * 50) + 20;
        String color = getRandomColor();
        shapes.add(new Circle(new Point(x, y), radius, color, true));
    }

    /**
     * Lấy một tên màu ngẫu nhiên từ danh sách màu có sẵn.
     *
     * @return Tên của màu ngẫu nhiên.
     */
    private String getRandomColor() {
        String[] colorArray = {"Red", "Blue", "Green", "Yellow", "Orange", "Cyan", "Magenta", "Pink", "LightGray", "DarkGray", "Gray", "Black"};
        return colorArray[(int) (Math.random() * colorArray.length)];
    }

    /**
     * Phương thức main để chạy ứng dụng.
     *
     * @param args Tham số dòng lệnh (không sử dụng trong trường hợp này).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo danh sách các hình
            List<Shape> shapes = new ArrayList<>();
            shapes.add(new Circle(new Point(50, 50), 30, "Red", true));
            shapes.add(new Square(new Point(100, 100), 40, "Blue", true));
            shapes.add(new Rectangle(new Point(200, 150), 60, 30, "Green", true));
            shapes.add(new Circle(new Point(150, 510), 40, "Magenta", true));
            shapes.add(new Square(new Point(400, 130), 30, "Pink", true));
            shapes.add(new Rectangle(new Point(290, 320), 30, 20, "Cyan", true));

            // Tạo một đối tượng ShapeDemoFrame và truyền vào danh sách các hình
            new ShapeDemoFrame(shapes);
        });
    }
}
