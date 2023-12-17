package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Lớp Layer chứa danh sách các đối tượng hình học.
 */
public class Layer {
    private List<Shape> shapes;

    /**
     * Constructor mặc định của lớp Layer.
     * Khởi tạo danh sách shapes.
     */
    public Layer() {
        shapes = new ArrayList<>();
    }

    /**
     * Thêm một đối tượng hình học vào danh sách.
     *
     * @param shape Đối tượng hình học cần thêm.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Loại bỏ tất cả các hình tròn khỏi danh sách.
     */
    public void removeCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    /**
     * Loại bỏ các hình học trùng lặp khỏi danh sách.
     */
    public void removeDuplicates() {
        Set<Shape> uniqueShapes = new HashSet<>();
        List<Shape> newShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (!uniqueShapes.contains(shape)) {
                uniqueShapes.add(shape);
                newShapes.add(shape);
            }
        }
        shapes = newShapes;
    }

    /**
     * Lấy thông tin về các hình học trong danh sách dưới dạng chuỗi.
     *
     * @return Chuỗi chứa thông tin về các hình học trong danh sách.
     */
    public String getInfo() {
        StringBuilder info = new StringBuilder("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(shape.toString()).append("\n");
        }
        return info.toString();
    }
}
