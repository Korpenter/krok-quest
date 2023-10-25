package krok.task6.domain.entities;


import krok.common.exceptions.ValidationException;

public class Circle extends Figure {
    private int x, y;
    private final int r;
    public Circle(int x, int y, int r) {
        if (r <= 0) {
            throw new ValidationException("Radius must be a positive value");
        }
        this.x = x;
        this.y = y;
        this.r = r;
    }
    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    @Override
    public boolean contains(int px, int py) {
        int dx = x - px;
        int dy = y - py;
        return dx * dx + dy * dy <= r * r;
    }
    @Override
    public String toString() {
        return String.format("Circle (%d, %d), %d", x, y, r);
    }
}