package com.ceiba.servicioEstetico.builder;

import com.ceiba.ComandoRespuesta;

import java.io.Serializable;

public class ObjetoRespuestaCreacion extends ComandoRespuesta<Integer> implements Serializable {

    private static final long serialVersionUID = -4067851575732571247L;

    public ObjetoRespuestaCreacion() {
        super(null);
    }

    public ObjetoRespuestaCreacion(Integer valor) {
        super(valor);
    }

    public Integer getValor(){
        return (Integer) super.getValor();
    }

}
