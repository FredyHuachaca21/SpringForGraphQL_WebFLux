package com.fredgar.pe.service;

import com.fredgar.pe.input.CategoriaRecord;
import com.fredgar.pe.model.Categoria;
import reactor.core.publisher.Mono;

public interface CategoriaService extends CrudGeneric<Categoria, String>{

  Mono<Categoria> mutationGuardar(CategoriaRecord categoriaRecord);
  Mono<Categoria> mutationActualizar(String id, CategoriaRecord categoriaRecord);
}
