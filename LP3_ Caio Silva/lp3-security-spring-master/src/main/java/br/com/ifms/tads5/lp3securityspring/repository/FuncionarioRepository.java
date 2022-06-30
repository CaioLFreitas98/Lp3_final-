package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findById(long id);
}
