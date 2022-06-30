package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Cadastro;

public interface CadastroServiceInterface {

    Cadastro saveCadastro(Cadastro cadastro);

    void deleteCadastro(long id);

    Cadastro updateCadastro(Cadastro cadastro);

    Cadastro findCadastroById(long id);

    Cadastro findCadastroByOwnerName(String ownername);

    List<Cadastro> listAllCadastros();
}
