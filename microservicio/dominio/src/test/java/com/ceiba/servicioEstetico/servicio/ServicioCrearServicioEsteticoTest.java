package com.ceiba.servicioEstetico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicioEstetico.builder.ServicioEsteticoTestBuilder;
import com.ceiba.servicioEstetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioEstetico.puerto.repositorio.RepositorioServicioEstetico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCrearServicioEsteticoTest {

    public static final String YA_EXISTE_SERVICIO_ESTETICO_REGISTRADO = "Ya existe el servicio estético registrado";
    public static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético es inválido";

    private RepositorioServicioEstetico repositorioServicioEstetico;

    @Before
    public void setUp(){
        repositorioServicioEstetico = mock(RepositorioServicioEstetico.class);
    }

    /**
     * Prueba que el sistema valida que no se guarden dos servicios estético con el mismo IS
     */
    @Test
    public void validarExistenciaPreviaServicioEsteticoTest(){
        //Arrange
        ServicioEstetico servicioEstetico = new ServicioEsteticoTestBuilder().build();
        when(repositorioServicioEstetico.existe(anyString())).thenReturn(true);
        ServicioCrearServicioEstetico servicioCrearServicioEstetico = new ServicioCrearServicioEstetico(repositorioServicioEstetico);
        //Act - Assert
        BasePrueba.assertThrows(
                () -> servicioCrearServicioEstetico.ejecutar(servicioEstetico),
                ExcepcionDuplicidad.class, YA_EXISTE_SERVICIO_ESTETICO_REGISTRADO
        );
    }

    /**
     * Prueba la creación de un servicio estético manipulando exitosamente los retornos del repositorio
     */
    @Test
    public void validarCreacionServicioEstetico(){
        //Arrange
        ServicioEstetico servicioEstetico = new ServicioEsteticoTestBuilder()
                .setIS("DP33")
                .setNombre("piernas")
                .setTipoServicioEstetico("Depilacion")
                .setCosto(12000)
                .setEstadoServicioEstetico(true)
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