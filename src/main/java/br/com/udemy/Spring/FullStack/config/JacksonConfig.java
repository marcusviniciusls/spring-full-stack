package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.domain.PaymentCredit;
import br.com.udemy.Spring.FullStack.domain.PaymentTicket;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    // https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(PaymentCredit.class);
                objectMapper.registerSubtypes(PaymentTicket.class);
                super.configure(objectMapper);
            };
        };
        return builder;
    }
}