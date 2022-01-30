package br.com.udemy.Spring.FullStack.services;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MockEmailService extends AbstractEmailService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage simpleEmailMessage) {
        LOGGER.info("Simulando o envio de e-mail");
        LOGGER.info(simpleEmailMessage.toString());
        LOGGER.info("E-mail enviado");
    }
}
