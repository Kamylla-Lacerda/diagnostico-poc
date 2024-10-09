package com.poc.diagnostico.mapper;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface DiagnosticoMapper {


}
