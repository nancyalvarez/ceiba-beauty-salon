package com.ceiba.servicioEstetico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicioEstetico.adaptador.mapper.MapeoServicioEstetico;
import com.ceiba.servicioEstetico.modelo.dto.DtoServicioEstetico;
import com.ceiba.servicioEstetico.puerto.dao.DaoServicioEstetico;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioEsteticoEnMemoria implements DaoServicioEstetico {

    private final CustomNamedParameterJdbcTemplate customerNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicioEstetico", value="listar")
    private static String sqlListar;

    public DaoServicioEsteticoEnMemoria(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customerNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioEstetico> listar() {
        return this.customerNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicioEstetico());
    }
}
