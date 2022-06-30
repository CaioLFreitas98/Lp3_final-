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

import br.com.ifms.tads5.lp3securityspring.javabeans.Função;
import br.com.ifms.tads5.lp3securityspring.service.FunçãoService;

@RestController
@RequestMapping(value = "/api/função")
public class FunçãoResource {

    @Autowired
    FunçãoService funçãoService;

    @GetMapping(value = "/message")
    public String showMessage() {
        return "Free access to everybody!";
    }

    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Função> listAll() {
        return funçãoService.listAllFunçãos();
    }

    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Função saveFunção(@RequestBody Função função) {
        return funçãoService.saveFunção(função);
    }

    @GetMapping(value = "/")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Função getArtistById(@RequestParam long id) {
        return funçãoService.findFunçãoById(id);
    }

    @GetMapping(value = "/{name}")
    public Função getArtistByName(@PathVariable String name) {
        return funçãoService.findFunçãoByName(name);
    }

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    @ResponseBody
    public String deleteFunçãoById(@RequestParam long id) {
        funçãoService.deleteFunção(id);
        return "This função has been deleted!";
    }

    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Função updateFunção(@RequestBody Função função) {
        return funçãoService.updateFunção(função);
    }
}
