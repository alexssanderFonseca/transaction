package br.com.alexsdm.transacao.domain.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

class Cartao(
    val id: UUID,
    val nomeTitular: String,
    val numCartao: String,
    var limite: BigDecimal,
    val enderecoCobranca: String,
    var vencimento: LocalDate,
    var bandeira: String,
    var tipo: String,
    var cpfTitular: String
) {

    lateinit var saldo: BigDecimal;

    fun definirSaldo(totalTransacoes: BigDecimal) {
        this.saldo = this.limite.minus(totalTransacoes);
    }

    fun atualizarSaldo(valorTransacao: BigDecimal) {
        saldo = this.saldo.minus(valorTransacao);
    }


}