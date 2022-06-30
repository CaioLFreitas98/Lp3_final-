package br.com.ifms.tads5.lp3securityspring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.tads5.lp3securityspring.javabeans.Funcionario;
import br.com.ifms.tads5.lp3securityspring.service.FuncionarioService;

@RestController
@RequestMapping(value = "/api/funcionario")
public class FuncionarioResource {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping(value = "/message")
    public String showMessage() {
        return "Free access to everybody!";
    }

    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Funcionario> listAll() {
        return funcionarioService.listAllFuncionarios();
    }

    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }

    @GetMapping(value = "/")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Funcionario getFuncionarioById(@RequestParam long id) {
        return funcionarioService.findFuncionarioById(id);
    }

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    @ResponseBody
    public String deleteFuncionarioById(@RequestParam long id) {
        funcionarioService.deleteFuncionario(id);
        return "This funcionario has been deleted!";
    }

    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Funcionario updateFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.updateFuncionario(funcionario);
    }
}
