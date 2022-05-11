package br.com.alexsdm.transacao.domain.event

import br.com.alexsdm.transacao.domain.model.Transacao
import java.math.BigDecimal
import java.sql.Timestamp

data class TransacaoAceita(val transacao: Transacao)  {
    val idTransacao: String = transacao.idTransacao.toString();
    var idCartao: String = transacao.getIdCartao().toString()
    var momentoTransacao: Timestamp = transacao.momentoTransacao;
    var estabelecimento: String = transacao.estabelecimento;
    var valor: BigDecimal = transacao.valor;
    var qtdParcelas: Int = transacao.qtdParcelas
}