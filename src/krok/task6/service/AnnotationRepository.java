package krok.task6.service;


import krok.task6.domain.entities.AnnotatedImage;

import java.util.List;
import java.util.Optional;

public interface AnnotationRepository {
    void save(AnnotatedImage annotatedImage);
    Optional<AnnotatedImage> findById(int id);
    List<AnnotatedImage> findAll();
    void update(int id, AnnotatedImage updatedAnnotatedImage);
    void delete(int id);
}