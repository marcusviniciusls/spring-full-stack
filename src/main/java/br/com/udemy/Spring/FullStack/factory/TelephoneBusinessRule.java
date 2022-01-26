package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Telephone;
import br.com.udemy.Spring.FullStack.form.salvar.ClientFormFull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém regra de negócio para a entidade Telephone
 */
@Service
public class TelephoneBusinessRule {

    /**
     * Método que transforma o ClientFormFull em Lista de Telephone
     * @param clientFormFull - Recebe o objeto completo
     * @return - Retorna uma lista de Telephone
     */
    public static List<Telephone> convertClientFormFullInTelephone(ClientFormFull clientFormFull){
        List<Telephone> listTelephone = new ArrayList<>();
        listTelephone.add(new Telephone(clientFormFull.getDdd(), clientFormFull.getTelephone()));
        listTelephone.add(new Telephone(clientFormFull.getDdd2(), clientFormFull.getTelephone2()));
        listTelephone.add(new Telephone(clientFormFull.getDdd3(), clientFormFull.getTelephone3()));

        return listTelephone;
    }

}
