package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Função;
import br.com.ifms.tads5.lp3securityspring.repository.Função;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.FunçãoServiceInterface;

@Service
public class FunçãoService implements FunçãoServiceInterface {

    @Autowired
    Função funçãoRepository;

    @Override
    public Função saveFunção(Função função) {
        return funçãoRepository.save(função);
    }

    @Override
    public void deleteFunção(long id) {
        funçãoRepository.deleteById(id);
    }

    @Override
    public Função updateFunção(Função função) {
        return funçãoRepository.save(função);
    }

    @Override
    public Função findFunçãoById(long id) {
        return funçãoRepository.findById(id);
    }

    @Override
    public Função findFunçãoByName(String name) {
        return funçãoRepository.findByName(name);
    }

    @Override
    public List<Função> listAllFunçãos() {
        return funçãoRepository.findAll();
    }
}
