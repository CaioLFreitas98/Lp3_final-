package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Função;

public interface FunçãoServiceInterface {

    Função saveFunção(Função função);

    void deleteFunção(long id);

    Função updateFunção(Função função);

    Função findFunçãoById(long id);

    Função findFunçãoByName(String name);

    List<Função> listAllFunçãos();
}
