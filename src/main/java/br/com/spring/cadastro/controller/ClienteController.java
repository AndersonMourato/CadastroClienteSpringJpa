package br.com.spring.cadastro.controller;

import br.com.spring.cadastro.model.Cliente;
import br.com.spring.cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteDAO;

    @GetMapping()
    public List<Cliente> getAllClientes(){
        return clienteDAO.findAll();
    }

    @GetMapping("/id")
    public Cliente getClienteById(){
        //Cliente c = new Cliente();
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente){
        clienteDAO.save(cliente);
        return ResponseEntity.ok(cliente);
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
