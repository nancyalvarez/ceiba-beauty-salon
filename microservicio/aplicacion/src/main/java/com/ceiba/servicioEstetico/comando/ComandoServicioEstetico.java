package com.ceiba.servicioEstetico.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoServicioEstetico {

    private Long id;
    private String id_servicio;
    private String nombre;
    private String tipoServicioEstetico;
    private int costo;
    private boolean estadoServicioEstetico;

}
