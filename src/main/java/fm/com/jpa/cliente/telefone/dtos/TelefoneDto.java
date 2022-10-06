package fm.com.jpa.cliente.telefone.dtos;

import fm.com.jpa.cliente.telefone.entities.Cliente;
import fm.com.jpa.cliente.telefone.entities.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDto {

    private Long id;

    @NotBlank
    private String numero;

    private Boolean ehCelular;

    private Cliente cliente;

    public TelefoneDto(Telefone telefone) {
        this.id = telefone.getId();
        this.numero = telefone.getNumero();
        this.ehCelular = telefone.getEhCelular();
        this.cliente = telefone.getCliente();
    }

    public static List<TelefoneDto> converteListaTelefone (List<Telefone> telefones){
        return telefones.stream().map(TelefoneDto::new).collect(Collectors.toList());
    }
}
