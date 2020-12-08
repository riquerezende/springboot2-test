package henrique.springboot2test.service;

import henrique.springboot2test.domain.ContaCorrente;
import henrique.springboot2test.domain.Transacao;
import henrique.springboot2test.dto.ContaCorrenteDto;
import henrique.springboot2test.dto.TransacaoDto;
import henrique.springboot2test.enumeration.TipoTransacao;
import henrique.springboot2test.repository.ContaCorrenteRepository;
import henrique.springboot2test.util.GeradorSenhaSegura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;

    public ContaCorrente criarContaCorrente(ContaCorrenteDto contaCorrenteDto) {
        if (Optional.ofNullable(contaCorrenteRepository.findByNumeroConta(contaCorrenteDto.getNumeroConta())).isPresent()) {
            return null;
        }
        ContaCorrente contaCorrente = ContaCorrente.builder()
                .numeroConta(contaCorrenteDto.getNumeroConta())
                .nome(contaCorrenteDto.getNome())
                .senha(contaCorrenteDto.getSenha())
                .build();

        String senhaSegura = GeradorSenhaSegura.gerarSenhaSegura(contaCorrente.getSenha());
        contaCorrenteDto.setSenha(senhaSegura);
        contaCorrenteRepository.save(contaCorrente);
        contaCorrente.setSenha(null);
        return contaCorrente;
    }

    public String consultarExtrato(Long numeroConta) {
        String extrato = "";
        ContaCorrente contaCorrente = contaCorrenteRepository.findByNumeroConta(numeroConta);
        for (Transacao transacao : contaCorrente.getTransacoes()) {
            extrato = extrato + "\n" + transacao.getTipoTransacao() + " " + transacao.getValor();
        }
        extrato = extrato + ("\nSaldo atual: " + this.consultarSaldo(numeroConta));
        return extrato;
    }

    public Transacao efetuarSaque(TransacaoDto transacaoDto) {
        if (this.consultarSaldo(transacaoDto.getNumeroConta()) < transacaoDto.getValor()) {
            return null;
        }
        Transacao transacao = Transacao.builder().valor(transacaoDto.getValor()).tipoTransacao(TipoTransacao.SAQUE).build();
        ContaCorrente contaCorrente = contaCorrenteRepository.findByNumeroConta(transacaoDto.getNumeroConta());
        contaCorrente.getTransacoes().add(transacao);
        contaCorrenteRepository.save(contaCorrente);
        return transacao;
    }

    public Transacao efetuarDeposito(TransacaoDto transacaoDto) {
        Transacao transacao = Transacao.builder().valor(transacaoDto.getValor()).tipoTransacao(TipoTransacao.DEPOSITO).build();
        ContaCorrente contaCorrente = contaCorrenteRepository.findByNumeroConta(transacaoDto.getNumeroConta());
        contaCorrente.getTransacoes().add(transacao);
        contaCorrenteRepository.save(contaCorrente);
        return transacao;
    }

    public Double consultarSaldo(Long numeroConta) {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByNumeroConta(numeroConta);
        Double saldo = Double.valueOf(0);
        for (Transacao transacao : contaCorrente.getTransacoes()) {
            if (transacao.getTipoTransacao().equals(TipoTransacao.DEPOSITO)) {
                saldo += transacao.getValor();
            } else if (transacao.getTipoTransacao().equals(TipoTransacao.SAQUE)) {
                saldo -= transacao.getValor();
            }
        }
        return saldo;
    }

}
