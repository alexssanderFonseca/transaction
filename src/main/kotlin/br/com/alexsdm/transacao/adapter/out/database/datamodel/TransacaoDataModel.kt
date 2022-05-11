package br.com.alexsdm.transacao.adapter.out.database.datamodel

import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Table(name = "transacao")
@Entity
class TransacaoDataModel(
    @Id
    @GeneratedValue
    @Column(name = "id_transacao")
    var idTransacao: UUID?,
    @Column(name = "qtd_parcelas")
    var qtdParcelas: Int,
    @Column(name = "id_cartao")
    var idCartao: UUID,
    @Column(name = "momento_transacao")
    var momentoTransacao: Timestamp,
    var estabelecimento: String,
    var valor: BigDecimal,
) {


}
