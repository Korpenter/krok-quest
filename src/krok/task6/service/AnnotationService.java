package krok.task6.service;

import krok.task6.domain.entities.AnnotatedImage;

import java.util.List;

public class AnnotationService {
    private final AnnotationRepository annotationRepository;
    public AnnotationService(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }
    public void addAnnotatedImage(AnnotatedImage annotatedImage) {
        annotationRepository.save(annotatedImage);
    }
    public AnnotatedImage getAnnotatedImage(int id) {
        return annotationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("AnnotatedImage with id " + id + " not found"));
    }
    public List<AnnotatedImage> getAllAnnotatedImages() {
        return annotationRepository.findAll();
    }
    public void updateAnnotatedImage(int id, AnnotatedImage updatedAnnotatedImage) {
        annotationRepository.update(id, updatedAnnotatedImage);
    }
    public void deleteAnnotatedImage(int id) {
        annotationRepository.delete(id);
    }
}
