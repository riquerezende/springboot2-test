package henrique.springboot2test.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conta_corrente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "conta_corrente_id")
    private Long id;
    private Long numeroConta;
    private String nome;
    private String senha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_corrente_id", referencedColumnName = "conta_corrente_id")
    private List<Transacao> transacoes;

}
