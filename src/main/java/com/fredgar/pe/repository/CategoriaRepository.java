package com.fredgar.pe.repository;

import com.fredgar.pe.model.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoriaRepository extends ReactiveMongoRepository<Categoria, String> {
}
