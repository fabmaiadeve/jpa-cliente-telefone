package fm.com.jpa.cliente.telefone.repositories;

import fm.com.jpa.cliente.telefone.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
