package com.ceiba.servicioEstetico.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicioEstetico.builder.ComandoServicioEsteticoTestBuilder;
import com.ceiba.servicioEstetico.builder.ObjetoRespuestaCreacion;
import com.ceiba.servicioEstetico.comando.ComandoServicioEstetico;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorServicioEstetico.class)
public class ComandoControladorServicioEsteticoTest {

    private static final String ENDPOINT = "/servicios_esteticos";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void validarCorrectaCreacionServicioEstetico() throws Exception{
        //Arrage
        ComandoServicioEstetico comandoServicioEstetico = new ComandoServicioEsteticoTestBuilder()
                .setId_servicio("TT02")
                .setNombre("Rayos")
                .setTipoServicioEstetico("Tinte")
                .setCosto(150000)
                .setEstadoServicioEstetico(true)
                .build();

        //Act
        MvcResult result = mocMvc.perform(post(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(comandoServicioEstetico)))
                    //Assert
                    .andExpect(status().isOk())
                    .andReturn();

        String json = result.getResponse().getContentAsString();

        ObjetoRespuestaCreacion comandoRespuesta = objectMapper.readValue(
                json, ObjetoRespuestaCreacion.class
        );
        //Assert.assertNotNull(comandoRepuesta.getValor());
        //Assert.assertThat(comandoRespuesta.getValor(), Matchers.greaterThan(0L));
        boolean isOK = comandoRespuesta.getValor() != null && (comandoRespuesta.getValor())>0;
        Assert.assertTrue(isOK);

    }

}
