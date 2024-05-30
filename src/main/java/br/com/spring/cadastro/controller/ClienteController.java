package br.com.spring.cadastro.controller;

import br.com.spring.cadastro.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> getAllClientes(){
        return null;
    }

    @GetMapping("/id")
    public Cliente getClienteById(){
        Cliente c = new Cliente(1, "Anderson", 22);
        return c;
    }

    @PostMapping
    public Cliente createCliente(){
        return null;
    }

    @PutMapping("/id")
    public Cliente updateCliente(){
        return null;
    }

    @DeleteMapping("/id")
    public Cliente deleteCliente(){
        return null;
    }
}
