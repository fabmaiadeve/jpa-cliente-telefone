package fm.com.jpa.cliente.telefone.entities;

import lombok.Data;

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

    //@org.hibernate.annotations.ForeignKey(name = "cliente_id")
    //@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    //@JoinColumn(name="id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Telefone(){}

    public Telefone(String numero, Boolean ehCelular, Cliente cliente) {
        this.numero = numero;
        this.ehCelular = ehCelular;
        this.cliente = cliente;
    }

    public Long getId() { return id; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public Boolean getEhCelular() { return ehCelular; }

    public void setEhCelular(Boolean ehCelular) { this.ehCelular = ehCelular; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", ehCelular=" + ehCelular +
                ", cliente=" + cliente +
                '}';
    }
}
