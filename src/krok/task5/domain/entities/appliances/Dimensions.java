package krok.task5.domain.entities.appliances;

import krok.common.exceptions.ValidationException;

public class Dimensions {
    private final double width;
    private final double height;
    private final double depth;

    public Dimensions(double width, double height, double depth) {
        if (width <= 0 || height <= 0 || depth <= 0) {
            throw new ValidationException("Dimensions must be positive values");
        }
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return String.format("Width: %.2f, Height: %.2f, Depth: %.2f", width, height, depth);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }
}
