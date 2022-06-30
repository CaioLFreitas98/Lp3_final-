package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Função extends JpaRepository<Função, Long> {

    Função findById(long id);

    Função findByName(String name);
}
