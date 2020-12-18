package com.ceiba.servicioestetico.builder;

import com.ceiba.ComandoRespuesta;

import java.io.Serializable;

public class ComandoRespuestaCrear extends ComandoRespuesta<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ComandoRespuestaCrear() {
        super(null);
    }

    public ComandoRespuestaCrear(Integer valor) {
        super(valor);
    }

    public Integer getValor(){
        return (Integer) super.getValor();
    }

}
