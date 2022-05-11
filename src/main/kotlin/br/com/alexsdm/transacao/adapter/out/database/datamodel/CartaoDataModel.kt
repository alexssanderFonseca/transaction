package br.com.alexsdm.transacao.adapter.out.database.datamodel

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cartao")
class CartaoDataModel(
    @Id
    @GeneratedValue
    var id: UUID,
    @Column(name = "num_cartao", unique = true)
    var numCartao: String,
    var limite: BigDecimal,
    @Column(name = "nome_titular")
    var nomeTitular: String,
    @Column(name = "endereco_cobranca")
    var enderecoCobranca: String,
    var vencimento: LocalDate,
    var bandeira: String,
    var tipo: String,
    @Column(name = "cpf_titular")
    var cpfTitular: String
) {

}