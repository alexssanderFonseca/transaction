package br.com.alexsdm.transacao.port.out

import br.com.alexsdm.transacao.domain.model.Cartao
import br.com.alexsdm.transacao.domain.model.Transacao
import java.math.BigDecimal
import java.util.*

interface CartaoRepository {
    fun getTotalGasto(idCartao: UUID): BigDecimal
    fun getCartao(numeroCartao: String): Cartao?
    fun adicionarTransacao(transacao: Transacao): Transacao
}