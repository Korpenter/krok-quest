package krok.task6.storage;

import krok.task6.domain.entities.AnnotatedImage;
import krok.task6.service.AnnotationRepository;

import java.util.*;

public class AnnotationInMemRepository implements AnnotationRepository {
    private final Map<Integer, AnnotatedImage> storage = new HashMap<>();
    private int idCounter = 1;
    @Override
    public void save(AnnotatedImage annotatedImage) {
        storage.put(idCounter++, annotatedImage);
    }
    @Override
    public Optional<AnnotatedImage> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }
    @Override
    public List<AnnotatedImage> findAll() {
        return new ArrayList<>(storage.values());
    }
    @Override
    public void update(int id, AnnotatedImage updatedAnnotatedImage) {
        if (storage.containsKey(id)) {
            storage.put(id, updatedAnnotatedImage);
        } else {
            throw new IllegalArgumentException("AnnotatedImage with id " + id + " not found");
        }
    }
    @Override
    public void delete(int id) {
        if (storage.remove(id) == null) {
            throw new IllegalArgumentException("AnnotatedImage with id " + id + " not found");
        }
    }
}