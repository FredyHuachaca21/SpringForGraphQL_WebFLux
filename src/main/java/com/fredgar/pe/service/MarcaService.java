package com.fredgar.pe.service;

import com.fredgar.pe.input.MarcaRecord;
import com.fredgar.pe.model.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
  Optional<Marca> getMarcaById(String id);
  List<Marca> getAllMarcas();
  Marca saveMarca(MarcaRecord marcaRecord);
  Marca updateMarca(String id, MarcaRecord marcaRecord);
  Boolean deleteMarcaById(String id);

}
