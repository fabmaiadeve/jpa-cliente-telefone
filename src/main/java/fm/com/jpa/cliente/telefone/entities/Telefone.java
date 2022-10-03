package fm.com.jpa.cliente.telefone.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_telefone")
public class Telefone  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;

    private Boolean ehCelular;

    @org.hibernate.annotations.ForeignKey(name = "usuario_id")
    @ManyToOne
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getEhCelular() {
        return ehCelular;
    }

    public void setEhCelular(Boolean ehCelular) {
        this.ehCelular = ehCelular;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
