package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    Cadastro findById(long id);

    Cadastro findByOwnerName(String ownername);
}
