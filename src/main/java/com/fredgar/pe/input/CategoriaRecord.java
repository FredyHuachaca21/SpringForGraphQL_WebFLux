package com.fredgar.pe.input;

import com.fredgar.pe.enums.NombreCategoria;

public record CategoriaRecord(
    NombreCategoria nombre,
    String descripcion,
    String fechaCreacion,
    String fechaActualizacion
) {
}
