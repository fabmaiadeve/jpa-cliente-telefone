package fm.com.jpa.cliente.telefone.controllers;

import fm.com.jpa.cliente.telefone.dtos.ClienteDto;
import fm.com.jpa.cliente.telefone.entities.Cliente;
import fm.com.jpa.cliente.telefone.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDto> listaClientes(){
        List<Cliente> clientes = service.listaTodosClientes();
        return ClienteDto.converte(clientes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionaCliente(@RequestBody Cliente cliente){

        return service.salvaCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraCliente(@PathVariable(value = "id") Long id, @RequestBody @Valid ClienteDto clienteDto){

        Optional<Cliente> opt = service.encontraPeloID(id);

        if (!opt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);
        cliente.setId(opt.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvaCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCliente(@PathVariable(value = "id") Long id){

        Boolean existe = service.verifica(id);

        if (!existe){
            return ResponseEntity.notFound().build();
        }
        service.deletaClientePorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaClientePorId(@PathVariable(value = "id") Long id){
        Optional<Cliente> optional = service.encontraPeloID(id);

        if (!optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        var clienteDto = new ClienteDto();
        BeanUtils.copyProperties(optional, clienteDto);
        //clienteDto.setId(optional.get().getId());
        clienteDto.setNome(optional.get().getNome());
        clienteDto.setDt_nascimento(optional.get().getDt_nascimento());
        return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
    }
}
