package henrique.springboot2test.domain;

import henrique.springboot2test.enumeration.TipoTransacao;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "transacao")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transacao_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    private Double valor;

    @Column(name = "conta_corrente_id")
    private Long contaCorrenteId;

}
