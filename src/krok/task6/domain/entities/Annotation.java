package krok.task6.domain.entities;

public class Annotation {
    private final String label;
    private final Figure figure;
    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }
    public boolean containsPoint(int x, int y) {
        return figure.contains(x, y);
    }
    public boolean labelContains(String substring) {
        return label.contains(substring);
    }
    public Figure getFigure() {
        return figure;
    }
    @Override
    public String toString() {
        return String.format("%s: %s", figure, label);
    }
}