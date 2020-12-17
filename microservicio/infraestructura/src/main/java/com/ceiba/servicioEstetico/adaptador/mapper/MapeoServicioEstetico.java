package com.ceiba.servicioEstetico.adaptador.mapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicioEstetico.modelo.dto.DtoServicioEstetico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServicioEstetico implements RowMapper<DtoServicioEstetico>, MapperResult {

    @Override
    public DtoServicioEstetico mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String ise= rs.getString("id_servicio");
        String nombre= rs.getString("nombre");
        String tipo = rs.getString("tipo_servicio_estetico");
        int costo = rs.getInt("costo");
        boolean estado= rs.getBoolean("estado");

        return new DtoServicioEstetico(
                id, ise, nombre, tipo, costo, estado
        );
    }
}
