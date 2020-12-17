package com.ceiba.servicioestetico.servicio;

import com.ceiba.servicioestetico.builder.ServicioEsteticoTestBuilder;
import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioestetico.puerto.repositorio.RepositorioServicioEstetico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCrearServicioEsteticoTest {

    public static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético es inválido";

    private RepositorioServicioEstetico repositorioServicioEstetico;

    @Before
    public void setUp(){
        repositorioServicioEstetico = mock(RepositorioServicioEstetico.class);
    }

    /**
     * Prueba la creación de un servicio estético manipulando exitosamente los retornos del repositorio
     */
    @Test
    public void validarCreacionServicioEstetico(){
        //Arrange
        ServicioEstetico servicioEstetico = new ServicioEsteticoTestBuilder()
                .setIdServicio("DP33")
                .setNombre("piernas")
                .setTipoServicio("Depilacion")
                .setCosto(12000)
                .setEstadoServicio(true)
                .build();
        when(repositorioServicioEstetico.existe(anyString())).thenReturn(false);
        when(repositorioServicioEstetico.crear(servicioEstetico)).thenReturn(2L);
        ServicioCrearServicioEstetico servicioCrearServicioEstetico = new ServicioCrearServicioEstetico(repositorioServicioEstetico);
        //Act
        long idServicioEstetico = servicioCrearServicioEstetico.ejecutar(servicioEstetico);
        //Assert
        Assert.assertEquals(2L, idServicioEstetico);
    }
}
