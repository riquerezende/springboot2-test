package henrique.springboot2test.controller;

import henrique.springboot2test.constant.Constant;
import henrique.springboot2test.domain.ContaCorrente;
import henrique.springboot2test.domain.Transacao;
import henrique.springboot2test.dto.ContaCorrenteDto;
import henrique.springboot2test.dto.TransacaoDto;
import henrique.springboot2test.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.CONTA_CORRENTE)
@RequiredArgsConstructor
@Log4j2
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping(path = Constant.CRIAR_CONTA_CORRENTE)
    public ResponseEntity<ContaCorrente> criarContaCorrente(@RequestBody ContaCorrenteDto contaCorrenteDto) {
        log.info("Criar conta corrente {} ", contaCorrenteDto);
        return new ResponseEntity<>(contaCorrenteService.criarContaCorrente(contaCorrenteDto), HttpStatus.CREATED);
    }

    @GetMapping(path = Constant.CONSULTAR_EXTRATO)
    public ResponseEntity<String> consultarExtrato(@PathVariable(value = "numeroConta") Long numeroConta) {
        log.info("Consultar extrato {} ", numeroConta);
        return new ResponseEntity<>(contaCorrenteService.consultarExtrato(numeroConta), HttpStatus.OK);
    }

    @GetMapping(path = Constant.CONSULTAR_SALDO)
    public ResponseEntity<Double> consultarSaldo(@PathVariable(value = "numeroConta") long numeroConta) {
        log.info("Consultar saldo {} ", numeroConta);
        return new ResponseEntity<>(contaCorrenteService.consultarSaldo(numeroConta), HttpStatus.OK);
    }

    @PostMapping(path = Constant.EFETUAR_SAQUE)
    public ResponseEntity<Transacao> efetuarSaque(@RequestBody TransacaoDto transacaoDto) {
        log.info("Efetuar saque {} ", transacaoDto);
        return new ResponseEntity<>(contaCorrenteService.efetuarSaque(transacaoDto), HttpStatus.OK);
    }

    @PostMapping(path = Constant.EFETUAR_DEPOSITO)
    @ResponseBody
    public ResponseEntity<Transacao> efetuarDeposito(@RequestBody TransacaoDto transacaoDto) {
        log.info("Efetuar depósito {} ", transacaoDto);
        return new ResponseEntity<>(contaCorrenteService.efetuarDeposito(transacaoDto), HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")

}





























