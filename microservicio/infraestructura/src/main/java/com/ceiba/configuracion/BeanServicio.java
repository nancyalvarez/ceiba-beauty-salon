package com.ceiba.configuracion;

import com.ceiba.servicioEstetico.puerto.repositorio.RepositorioServicioEstetico;
import com.ceiba.servicioEstetico.servicio.ServicioCrearServicioEstetico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearServicioEstetico servicioCrearServicioEstetico(RepositorioServicioEstetico repositorioServicioEstetico){
        return new ServicioCrearServicioEstetico(repositorioServicioEstetico);
    }
	

}
