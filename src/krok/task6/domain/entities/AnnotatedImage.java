package krok.task6.domain.entities;

public class AnnotatedImage {
    private final String imagePath;
    private final Annotation[] annotations;
    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }
    public String getImagePath() {
            return this.imagePath;
    }
    public Annotation[] getAnnotations() {
        return this.annotations;
    }
    public Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            if (annotation.containsPoint(x, y)) {
                return annotation;
            }
        }
        return null;
    }
    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.labelContains(label)) {
                return annotation;
            }
        }
        return null;
    }
}