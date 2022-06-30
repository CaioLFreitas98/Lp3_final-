package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Funcionario;

public interface FuncionarioServiceInterface {

    Funcionario saveFuncionario(Funcionario funcionario);

    void deleteFuncionario(long id);

    Funcionario updateFuncionario(Funcionario funcionario);

    Funcionario findFuncionarioById(long id);

    List<Funcionario> listAllFuncionarios();
}
