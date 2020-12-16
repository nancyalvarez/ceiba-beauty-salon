package com.ceiba.servicioEstetico.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.*;
import com.ceiba.servicioEstetico.constant.TipoServicio;

@Getter
@Setter
public class ServicioEstetico {
    //Constants
    private static final String IS_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el IS del servicio estético";
    private static final String NOMBRE_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el nombre del servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_REQUERIDO = "Se debe definir el tipo de servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético no corresponde";
    private static final String COSTO_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el costo del servicio estetico";

    private Long id;
    private String IS;
    private String nombre;
    private String tipoServicioEstetico;
    private int costo;
    private boolean estadoServicioEstetico;

    public ServicioEstetico(Long id, String IS, String nombre, String tipoServicioEstetico, int costo, boolean estadoServicioEstetico) {
        validarObligatorio(IS, IS_SERVICIO_ESTETICO_REQUERIDO);
        validarObligatorio(nombre, NOMBRE_SERVICIO_ESTETICO_REQUERIDO);
        validarObligatorio(tipoServicioEstetico, TIPO_SERVICIO_ESTETICO_REQUERIDO);
        validarValido(tipoServicioEstetico, TipoServicio.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
        validarObligatorio(costo, COSTO_SERVICIO_ESTETICO_REQUERIDO);

        this.id = id;
        this.IS = IS;
        this.nombre = nombre;
        this.tipoServicioEstetico = tipoServicioEstetico;
        this.costo = costo;
        this.estadoServicioEstetico = estadoServicioEstetico;

    }
}
