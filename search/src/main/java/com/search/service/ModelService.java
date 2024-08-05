package com.search.service;

import com.search.model.Model;
import com.search.repository.ModelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
ModelService {
    private final ModelRepo modelRepository;

    public ModelService(ModelRepo modelRepository) {
        this.modelRepository = modelRepository;
    }

    // Method to get all models
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    // Method to get a model by ID
    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    // Method to save a new model
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    // Method to update an existing model
    public Model updateModel(Long id, Model model) {
        if (modelRepository.existsById(id)) {
            model.setId(id);
            return modelRepository.save(model);
        }
        return null;
    }

    // Method to delete a model by ID
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

}
