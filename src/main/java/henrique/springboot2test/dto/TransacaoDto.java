package henrique.springboot2test.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class TransacaoDto {

    @NotNull
    @NotEmpty
    private Long numeroConta;
    private Double valor;

}
