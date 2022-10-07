package fm.com.jpa.cliente.telefone.controllers;


import fm.com.jpa.cliente.telefone.dtos.TelefoneDto;
import fm.com.jpa.cliente.telefone.entities.Telefone;
import fm.com.jpa.cliente.telefone.services.TelefoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService service;

    @GetMapping
    List<TelefoneDto> listaTelefones() {
        List<Telefone> listaTelefones = service.listaTodosTelefones();
        return TelefoneDto.converteListaTelefone(listaTelefones);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Telefone adicionaTelefone(@RequestBody Telefone telefone){

        return service.salvaTelefone(telefone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraTelefone(@PathVariable(value = "id") Long id, @RequestBody @Valid TelefoneDto telefoneDto){

        Optional<Telefone> opt = service.encontraTelefonePeloId(id);

        if(!opt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Telefone não encontrado");
        }

        var telefone = new Telefone();
        BeanUtils.copyProperties(telefoneDto, telefone);
        telefone.setId(opt.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvaTelefone(telefone));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTelefone(@PathVariable(value = "id") Long id){

        Boolean existe = service.verificaTelefone(id);

        if(!existe){
            return ResponseEntity.notFound().build();
        }
        service.deletaTelefonePorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaTelefonePorId(@PathVariable(value = "id") Long id){
        Optional<Telefone> optional = service.encontraTelefonePeloId(id);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Telefone não encontrado");
        }
        var telefoneDto = new TelefoneDto();
        BeanUtils.copyProperties(optional, telefoneDto);
        telefoneDto.setNumero(optional.get().getNumero());
        telefoneDto.setEhCelular(optional.get().getEhCelular());
        telefoneDto.setCliente(optional.get().getCliente());
        return ResponseEntity.status(HttpStatus.OK).body(telefoneDto);
    }
}
