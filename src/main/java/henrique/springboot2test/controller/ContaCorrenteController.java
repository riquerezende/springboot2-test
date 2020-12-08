package henrique.springboot2test.controller;

import henrique.springboot2test.constant.Constant;
import henrique.springboot2test.domain.ContaCorrente;
import henrique.springboot2test.domain.Transacao;
import henrique.springboot2test.dto.TransacaoDto;
import henrique.springboot2test.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.CONTA_CORRENTE)
@RequiredArgsConstructor
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping(path = Constant.CRIAR_CONTA_CORRENTE)
    public ResponseEntity<ContaCorrente> criarContaCorrente(@RequestBody ContaCorrente contaCorrente) {
        return new ResponseEntity<>(contaCorrenteService.criarContaCorrente(contaCorrente), HttpStatus.CREATED);
    }

    @GetMapping(path = Constant.CONSULTAR_EXTRATO)
    public ResponseEntity<String> consultarExtrato(@PathVariable(value = "numeroConta") Long numeroConta) {
        return new ResponseEntity<>(contaCorrenteService.consultarExtrato(numeroConta), HttpStatus.OK);
    }

    @GetMapping(path = Constant.CONSULTAR_SALDO)
    public ResponseEntity<Double> consultarSaldo(@PathVariable(value = "numeroConta") long numeroConta) {
        return new ResponseEntity<>(contaCorrenteService.consultarSaldo(numeroConta), HttpStatus.OK);
    }

    @PostMapping(path = Constant.EFETUAR_SAQUE)
    public ResponseEntity<Transacao> efetuarSaque(@RequestBody TransacaoDto transacaoDto) {
        return new ResponseEntity<>(contaCorrenteService.efetuarSaque(transacaoDto), HttpStatus.OK);
    }

    @PostMapping(path = Constant.EFETUAR_DEPOSITO)
    @ResponseBody
    public ResponseEntity<Transacao> efetuarDeposito(@RequestBody TransacaoDto transacaoDto) {
        return new ResponseEntity<>(contaCorrenteService.efetuarDeposito(transacaoDto), HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")
    // @PreAuthorize("hasRole('CORRENTISTA')")

}





























