package fm.com.jpa.cliente.telefone.dtos;


import fm.com.jpa.cliente.telefone.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;

    @NotBlank
    private String nome;
    private String dt_nascimento;


    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dt_nascimento = cliente.getDt_nascimento();
    }

    public static List<ClienteDto> converte(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}