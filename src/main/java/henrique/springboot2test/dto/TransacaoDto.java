package henrique.springboot2test.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TransacaoDto {

    @NotNull
    @NotEmpty
    private Long numeroConta;
    private Double valor;

}
