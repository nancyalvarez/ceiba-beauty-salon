package com.ceiba.servicioEstetico.consulta;

import com.ceiba.servicioEstetico.modelo.dto.DtoServicioEstetico;
import com.ceiba.servicioEstetico.puerto.dao.DaoServicioEstetico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicioEstetico {

    private final DaoServicioEstetico daoServicioEstetico;

    public ManejadorListarServicioEstetico(DaoServicioEstetico daoServicioEstetico){
        this.daoServicioEstetico = daoServicioEstetico;
    }

    public List<DtoServicioEstetico> ejecutar(){
        return this.daoServicioEstetico.listar();
    }

}
