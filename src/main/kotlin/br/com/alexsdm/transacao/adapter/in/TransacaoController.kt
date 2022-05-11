package br.com.alexsdm.transacao.adapter.`in`

import br.com.alexsdm.transacao.domain.dto.`in`.AdicionarTransacaoDto
import br.com.alexsdm.transacao.domain.exception.NegocioException
import br.com.alexsdm.transacao.port.`in`.AdicionarTransacaoPort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("transacoes")
class TransacaoController(
    private val adicionarTransacaoPort: AdicionarTransacaoPort,
) {

    @PostMapping
    fun adicionar(@RequestBody adicionarTransacaoDto: AdicionarTransacaoDto): ResponseEntity<Any> {
        try {
            var concluida = adicionarTransacaoPort.executar(adicionarTransacaoDto);
            var resposta = mapOf(Pair("concluida", concluida.toString()))
            return ResponseEntity.ok(resposta)
        } catch (negocioException: NegocioException) {
            return ResponseEntity.badRequest().build();
        }
    }

}