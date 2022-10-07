package fm.com.jpa.cliente.telefone.services;

import fm.com.jpa.cliente.telefone.entities.Telefone;
import fm.com.jpa.cliente.telefone.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

TelefoneRepository rep;

    public List<Telefone> listaTodosTelefones() { return rep.findAll(); }

    public Telefone salvaTelefone(Telefone telefone) { return rep.save(telefone); }

    public Boolean verificaTelefone(Long id) { return rep.existsById(id); }

    public Optional<Telefone> encontraTelefonePeloId(Long id){
        Optional<Telefone> opt = rep.findById(id);
        return opt;
    }

    public void deletaTelefonePorId(Long id) {
        rep.deleteById(id);
    }
}
