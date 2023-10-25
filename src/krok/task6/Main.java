package krok.task6;

import krok.common.exceptions.ValidationException;
import krok.task6.domain.entities.AnnotatedImage;
import krok.task6.domain.entities.Annotation;
import krok.task6.domain.entities.Circle;
import krok.task6.domain.entities.Rectangle;
import krok.task6.service.AnnotationService;
import krok.task6.storage.AnnotationInMemRepository;
public class Main {
    public static void main(String[] args) {
        AnnotationInMemRepository repo = new AnnotationInMemRepository();
        AnnotationService svc = new AnnotationService(repo);

        Annotation treeAnnotation = new Annotation("ItSmosh",
                new Circle(100, 100, 10));
        Annotation carAnnotation = new Annotation("Krokodil",
                new Rectangle(100, 100, 150, 200));

        AnnotatedImage annotatedImage = new AnnotatedImage("image-krokidil-v-itmo.jpg", treeAnnotation, carAnnotation);

        svc.addAnnotatedImage(annotatedImage);

        System.out.println("All Annotated Images:");
        for (AnnotatedImage ai : svc.getAllAnnotatedImages()) {
            System.out.println("Image Path:" + ai.getImagePath());
            for (Annotation annotation : ai.getAnnotations()) {
                System.out.println(annotation);
            }
        }

        Annotation foundByPoint = annotatedImage.findByPoint(110, 110);
        System.out.println("Annotation found by point: " + foundByPoint);

        Annotation foundByLabel = annotatedImage.findByLabel("ItSmosh");
        System.out.println("Annotation found by label: " + foundByLabel);

        int dx = 10, dy = 10;
        System.out.printf("Moving annotation: %s By %d;%d%n", foundByPoint, dx, dy);
        foundByPoint.getFigure().move(dx, dy);
        System.out.println("After moving: " + foundByPoint);

        svc.updateAnnotatedImage(1, annotatedImage);

        try {
            Annotation invalidAnnotation = new Annotation("Invalid",
                    new Rectangle(-100, -100, -150, -200));
            new AnnotatedImage("avbababab.jpg", invalidAnnotation);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        try {
            foundByPoint.getFigure().move(-1000, -1000);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("All Annotated Images:");
        for (AnnotatedImage ai : svc.getAllAnnotatedImages()) {
            System.out.println("Image Path: " + ai.getImagePath());
            for (Annotation annotation : ai.getAnnotations()) {
                System.out.println(annotation);
            }
        }

        svc.deleteAnnotatedImage(1);

        System.out.println("All Annotated Images after deletion:");
        for (AnnotatedImage ai : svc.getAllAnnotatedImages()) {
            System.out.println("Image Path: " + ai.getImagePath());
            for (Annotation annotation : ai.getAnnotations()) {
                System.out.println(annotation);
            }
        }

        System.out.println("Attempting to access unknown ID: " + 100);
        try {
            System.out.println(svc.getAnnotatedImage(100));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Attempting to update unknown ID:");
        try {
            AnnotatedImage anotherAnnotatedImage = new AnnotatedImage("ssssss.jpg", new Annotation("Unknown", new Rectangle(200, 200, 250, 300)));
            svc.updateAnnotatedImage(100, anotherAnnotatedImage);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Attempting to delete unknown ID:");
        try {
            svc.deleteAnnotatedImage(100);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}