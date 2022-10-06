package fm.com.jpa.cliente.telefone.repositories;

import fm.com.jpa.cliente.telefone.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository  extends JpaRepository<Telefone, Long> {
}
