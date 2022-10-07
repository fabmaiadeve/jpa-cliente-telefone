package fm.com.jpa.cliente.telefone.services;

import fm.com.jpa.cliente.telefone.dtos.ClienteDto;
import fm.com.jpa.cliente.telefone.entities.Cliente;
import fm.com.jpa.cliente.telefone.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository rep;

    public List<Cliente> listaTodosClientes() {
        return rep.findAll();
    }

    public Cliente salvaCliente(Cliente cliente){
        return rep.save(cliente);
    }

    public Boolean verifica(Long id){
        return rep.existsById(id);
    }

    public Cliente mudaCliente(ClienteDto dto){

        Cliente cliente = new Cliente();
        cliente.setDt_nascimento(dto.getDt_nascimento());
        cliente.setNome(dto.getNome());
        cliente = rep.save(cliente);
        return cliente;
    }

    public Optional<Cliente> encontraPeloID(Long id) {
        Optional<Cliente> opt = rep.findById(id);
        return opt;
    }

    public void deletaClientePorId(Long id) {
        rep.deleteById(id);
    }
}
