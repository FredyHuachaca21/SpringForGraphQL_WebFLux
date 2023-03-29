package com.fredgar.pe.repository;

import com.fredgar.pe.model.Marca;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MarcaRepository extends ReactiveMongoRepository<Marca, String> {
}
