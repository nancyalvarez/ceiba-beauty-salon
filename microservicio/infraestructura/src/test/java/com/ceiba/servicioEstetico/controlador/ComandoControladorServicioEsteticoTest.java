package com.ceiba.servicioestetico.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicioestetico.builder.ComandoRespuestaCrear;
import com.ceiba.servicioestetico.builder.ComandoServicioEsteticoTestBuilder;
import com.ceiba.servicioestetico.comando.ComandoServicioEstetico;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.sql.DataSource;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorServicioEstetico.class)
public class ComandoControladorServicioEsteticoTest {

    private static final String ENDPOINT = "/beauty-services";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void validarCreacionServicioEstetico() throws Exception{
        //Arrange
        ComandoServicioEstetico comandoServicioEstetico = new ComandoServicioEsteticoTestBuilder()
                .setIdServicio("TT02")
                .setNombre("Rayos")
                .setTipoServicio("TINTE")
                .setCosto(150000)
                .setEstadoServicio(true)
                .build();
        //Act
        MvcResult result = mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoServicioEstetico)))
                //Assert
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();

        ComandoRespuestaCrear comandoRespuesta = objectMapper.readValue(
                json, ComandoRespuestaCrear.class
        );
        //Assert.assertNotNull(comandoRepuesta.getValor());
        //Assert.assertThat(comandoRespuesta.getValor(), Matchers.greaterThan(0L));
        boolean isOK = comandoRespuesta.getValor() != null && (comandoRespuesta.getValor())>0;
        Assert.assertTrue(isOK);


    }

}
