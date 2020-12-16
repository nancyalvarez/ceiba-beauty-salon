package com.ceiba.servicioEstetico.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoServicioEstetico {

    private Long id;
    private String IS;
    private String nombre;
    private String tipoServicioEstetico;
    private int costo;
    private boolean estadoServicioEstetico;
}
