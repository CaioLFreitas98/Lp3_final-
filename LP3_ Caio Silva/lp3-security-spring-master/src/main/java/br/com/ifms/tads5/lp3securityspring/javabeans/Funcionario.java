package br.com.ifms.tads5.lp3securityspring.javabeans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Cadastro> licenses;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Função> artworks;
}
