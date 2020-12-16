package com.ceiba.servicioEstetico.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioEstetico.puerto.repositorio.RepositorioServicioEstetico;

public class ServicioCrearServicioEstetico {

    private static final String EL_SERVICIO_ESTETICO_YA_EXISTE_EN_EL_SISTEMA = "El servicio estético ya existe en el sistema";

    private final RepositorioServicioEstetico repositorioServicioEstetico;

    public ServicioCrearServicioEstetico(RepositorioServicioEstetico repositorioServicioEstetico){
        this.repositorioServicioEstetico=repositorioServicioEstetico;
    }

    public Long ejecutar(ServicioEstetico servicioEstetico){
        validarExistenciaPrevia(servicioEstetico);
        return this.repositorioServicioEstetico.crear(servicioEstetico);
    }

    private void validarExistenciaPrevia(ServicioEstetico servicioEstetico){
        boolean existe = this.repositorioServicioEstetico.existe(servicioEstetico.getIS());

        if (existe){
            throw new ExcepcionDuplicidad(EL_SERVICIO_ESTETICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


}
