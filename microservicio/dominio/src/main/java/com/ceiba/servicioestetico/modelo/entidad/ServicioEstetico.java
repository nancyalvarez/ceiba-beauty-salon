package com.ceiba.servicioestetico.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.*;
import com.ceiba.servicioestetico.constant.TipoServicio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioEstetico {
    //Constants
    private static final String ID_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el identificador del servicio estético";
    private static final String NOMBRE_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el nombre del servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_REQUERIDO = "Se debe definir el tipo de servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético no corresponde";
    private static final String COSTO_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el costo del servicio estetico";

    private Long id;
    private String idServicio;
    private String nombre;
    private String tipoServicio;
    private int costo;
    private boolean estadoServicio;

    public ServicioEstetico(Long id, String idServicio, String nombre, String tipoServicio, int costo, boolean estadoServicio) {
        validarObligatorio(idServicio, ID_SERVICIO_ESTETICO_REQUERIDO);
        validarObligatorio(nombre, NOMBRE_SERVICIO_ESTETICO_REQUERIDO);
        validarObligatorio(tipoServicio, TIPO_SERVICIO_ESTETICO_REQUERIDO);
        validarValido(tipoServicio, TipoServicio.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
        validarObligatorio(costo, COSTO_SERVICIO_ESTETICO_REQUERIDO);

        this.id = id;
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.estadoServicio = estadoServicio;

    }
}
