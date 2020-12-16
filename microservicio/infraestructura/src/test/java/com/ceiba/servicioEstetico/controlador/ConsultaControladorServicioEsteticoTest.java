package com.ceiba.servicioEstetico.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorServicioEstetico.class)
public class ConsultaControladorServicioEsteticoTest {

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba el correcto funcionamiento del listar servicios esteticos
     */
    @Test
    public void validarListadoServicioEstetico() throws Exception{
        // Arrange - Act
        mocMvc.perform(get("/servicios_esteticos")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$[*].ise", hasItem("TT01")))
                .andExpect(jsonPath("$[*].nombre", hasItem("Rayos")))
                .andExpect(jsonPath("$[*].tipo", hasItem("Tinte")))
                .andExpect(jsonPath("$[*].costo", hasItem(150000)))
                .andExpect(jsonPath("$[*].estado", hasItem(true)));
    }
}
