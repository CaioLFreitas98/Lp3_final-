package br.com.ifms.tads5.lp3securityspring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.tads5.lp3securityspring.javabeans.Cadastro;
import br.com.ifms.tads5.lp3securityspring.service.CadastroService;

@RestController
@RequestMapping(value = "/api/cadastro")
public class CadastroResource {

    @Autowired
    CadastroService cadastroService;

    @GetMapping(value = "/message")
    public String showMessage() {
        return "Free access to everybody!";
    }

    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Cadastro> listAll() {
        return cadastroService.listAllCadastros();
    }

    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Cadastro saveCadastro(@RequestBody Cadastro cadastro) {
        return cadastroService.saveCadastro(cadastro);
    }

    @GetMapping(value = "/")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Cadastro getCadastroById(@RequestParam long id) {
        return cadastroService.findCadastroById(id);
    }

    @GetMapping(value = "/{ownername}")
    public Cadastro getCadastroByOwnerName(@PathVariable String ownername) {
        return cadastroService.findCadastroByOwnerName(ownername);
    }

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    @ResponseBody
    public String deleteCadastroById(@RequestParam long id) {
        cadastroService.deleteCadastro(id);
        return "This cadastro has been deleted!";
    }

    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Cadastro updateCadastro(@RequestBody Cadastro cadastro) {
        return cadastroService.updateCadastro(cadastro);
    }
}
