package br.com.udemy.Spring.FullStack.services.validation;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.enums.Nature;
import br.com.udemy.Spring.FullStack.exception.FieldMessage;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.repositorys.ClientRepository;
import br.com.udemy.Spring.FullStack.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Tratamento de erro para CPF, CNPJ e E-mails
 */
public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientForm> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientInsert ann) {
    }
    @Override
    public boolean isValid(ClientForm clientForm, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (clientForm.getNature().equals(Nature.PESSOA_FISICA.getValue()) && !BR.isValidCPF(clientForm.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj","CPF inválid"));
        } if (clientForm.getNature().equals(Nature.PESSOA_JURIDICA.getValue()) && !BR.isValidCNPJ(clientForm.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj","CNPJ invalid"));
        }

        Client client = clientRepository.findByEmail(clientForm.getEmail());
        if (client != null){
            list.add(new FieldMessage("email","email already exists"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}