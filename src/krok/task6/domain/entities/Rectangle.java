package krok.task6.domain.entities;

import krok.common.exceptions.ValidationException;

public class Rectangle extends Figure {
    private int x1, y1;
    private int x2, y2;
    public Rectangle(int x1, int y1, int x2, int y2) {
        if (x1 >= x2 || y1 >= y2) {
            throw new ValidationException("Invalid coordinates for Rectangle");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }
    @Override
    public String toString() {
        return String.format("Rectangle (%d, %d), (%d, %d)", x1, y1, x2, y2);
    }
    @Override
    public boolean contains(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}