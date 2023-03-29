package com.fredgar.pe.controller;

import com.fredgar.pe.input.CategoriaInput;
import com.fredgar.pe.model.Categoria;
import com.fredgar.pe.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CategoriaController {

  private final CategoriaService service;


}
