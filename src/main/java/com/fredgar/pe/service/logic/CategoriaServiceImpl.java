package com.fredgar.pe.service.logic;

import com.fredgar.pe.input.CategoriaRecord;
import com.fredgar.pe.model.Categoria;
import com.fredgar.pe.repository.CategoriaRepository;
import com.fredgar.pe.service.CategoriaService;
import graphql.GraphqlErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.graphql.execution.ErrorType.BAD_REQUEST;
import static org.springframework.graphql.execution.ErrorType.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

  private final CategoriaRepository categoriaRepository;

  @Override
  public Mono<Categoria> mutationGuardar(CategoriaRecord categoriaRecord) {

    Categoria categoriaDB = new Categoria();
    categoriaDB.setNombre(categoriaRecord.nombre());
    categoriaDB.setDescripcion(categoriaRecord.descripcion());
    categoriaDB.setFechaCreacion(LocalDate.now().toString());
    categoriaDB.setFechaActualizacion(LocalDate.now().toString());

    if (categoriaDB == null) {
      throw GraphqlErrorException.newErrorException()
          .message("Error al guardar la Categoría")
          .errorClassification(BAD_REQUEST)
          .build();
    }
    return categoriaRepository.save(categoriaDB);
  }

  @Override
  public Mono<Categoria> mutationActualizar(String id, CategoriaRecord categoriaRecord) {
    return categoriaRepository.findById(id)
        .switchIfEmpty(Mono.error(GraphqlErrorException.newErrorException()
                .message("Categoria no encontrado con id: " + id)
                .errorClassification(NOT_FOUND)
            .build()))
        .flatMap(categoriaDB -> {
          categoriaDB.setNombre(categoriaRecord.nombre());
          categoriaDB.setDescripcion(categoriaRecord.descripcion());
          categoriaDB.setFechaActualizacion(LocalDate.now().toString());
          return categoriaRepository.save(categoriaDB);
        });
  }

  @Override
  public Mono<Categoria> queryBuscarPorId(String ID) {
    return categoriaRepository.findById(ID)
        .switchIfEmpty(Mono.error(GraphqlErrorException.newErrorException()
                .message("Categoria no encontrado con ID: " + ID)
                .cause(new RuntimeException("No se encontró la categoría con el ID proporcionado"))
                .path(Arrays.asList("queryBuscarPorId", "categoria"))
                .errorClassification(BAD_REQUEST)
            .build()));
  }

  @Override
  public Flux<Categoria> queryListarTodos() {
    return categoriaRepository.findAll()
        .switchIfEmpty(Mono.error(GraphqlErrorException.newErrorException()
            .message("Categoría no encontrada")
            .cause(new RuntimeException("No se encontró ninguna categoría"))
            .path(Arrays.asList("queryListarTodos", "categoria"))
            .errorClassification(BAD_REQUEST)
            .build()));
  }

  @Override
  public Mono<Boolean> mutationEliminarPorId(String ID) {
    return categoriaRepository.findById(ID)
        .flatMap(categoria -> categoriaRepository.deleteById(ID).thenReturn(true))
        .switchIfEmpty(Mono.error(GraphqlErrorException.newErrorException()
            .message("Categoria no encontrada con ID: " + ID)
            .errorClassification(BAD_REQUEST)
            .build()));
  }
}
