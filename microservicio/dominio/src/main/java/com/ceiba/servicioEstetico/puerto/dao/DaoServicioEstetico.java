package com.ceiba.servicioEstetico.puerto.dao;

import com.ceiba.servicioEstetico.modelo.dto.DtoServicioEstetico;

import java.util.List;

public interface DaoServicioEstetico {

    /**
     * Permite listar los servicios esteticos
     * @return los servicios esteticos
     */
    List<DtoServicioEstetico> listar();
}
