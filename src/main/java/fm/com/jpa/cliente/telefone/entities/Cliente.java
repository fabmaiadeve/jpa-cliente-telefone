package fm.com.jpa.cliente.telefone.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dt_nascimento;

    private String nome;

    //@OneToMany(targetEntity=Telefone.class, mappedBy="telefone", orphanRemoval = true, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    public Cliente() {}

    public Cliente(String dt_nascimento, String nome) {
        this.dt_nascimento = dt_nascimento;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
