package henrique.springboot2test.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ContaCorrenteDto {

    @NotNull
    @NotEmpty
    private Long numeroConta;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String senha;

}
