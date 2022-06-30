package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Cadastro;
import br.com.ifms.tads5.lp3securityspring.repository.CadastroRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.CadastroServiceInterface;

@Service
public class CadastroService implements CadastroServiceInterface {

    @Autowired
    CadastroRepository cadastroRepository;

    @Override
    public Cadastro saveCadastro(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @Override
    public void deleteCadastro(long id) {
        cadastroRepository.deleteById(id);
    }

    @Override
    public Cadastro updateCadastro(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @Override
    public Cadastro findCadastroById(long id) {
        return cadastroRepository.findById(id);
    }

    @Override
    public Cadastro findCadastroByOwnerName(String ownerName) {
        return cadastroRepository.findByOwnerName(ownerName);
    }

    @Override
    public List<Cadastro> listAllCadastros() {
        return cadastroRepository.findAll();
    }
}
