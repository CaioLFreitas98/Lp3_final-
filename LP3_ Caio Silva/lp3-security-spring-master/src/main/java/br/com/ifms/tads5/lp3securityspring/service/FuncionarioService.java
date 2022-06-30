package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Funcionario;
import br.com.ifms.tads5.lp3securityspring.repository.FuncionarioRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.FuncionarioServiceInterface;

@Service
public class FuncionarioService implements FuncionarioServiceInterface {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario findFuncionarioById(long id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public List<Funcionario> listAllFuncionarios() {
        return funcionarioRepository.findAll();
    }
}
