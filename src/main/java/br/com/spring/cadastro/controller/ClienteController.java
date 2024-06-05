package br.com.spring.cadastro.controller;

import br.com.spring.cadastro.model.Cliente;
import br.com.spring.cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteDAO;

    @GetMapping()
    public ResponseEntity<?> getAllClientes(){
        List<Cliente> clienteList = clienteDAO.findAll();
        if (!clienteList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(clienteList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não há clientes cadastrados.");
    }

    @GetMapping("/id")
    public ResponseEntity<?> getClienteById(@RequestParam(value = "id") int id){
        Optional<Cliente> clienteOptional = clienteDAO.findById(id);
        if (clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("ID não localizado.");
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente){
        if (clienteDAO.save(cliente).getId() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Erro ao adicionar cliente.");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente){
        if (cliente.getId() != null && clienteDAO.findById(cliente.getId()).isPresent()) {
            clienteDAO.save(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Erro ao atualizar cliente.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //throw new ExceptionNotFound("ERRO: Não foi possivel atualizar o cliente");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCliente(@RequestParam(value = "id") int id){
        try {
            clienteDAO.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente Removido com exito.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
