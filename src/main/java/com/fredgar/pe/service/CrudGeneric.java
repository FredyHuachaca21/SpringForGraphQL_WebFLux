package com.fredgar.pe.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudGeneric<T, ID> {

  Mono<T> queryBuscarPorId(String ID);
  Flux<T> queryListarTodos();
  Mono<Boolean> mutationEliminarPorId(String ID);

}
