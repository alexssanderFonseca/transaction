package br.com.alexsdm.transacao.domain.model

import br.com.alexsdm.transacao.domain.exception.NegocioException
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.util.*

class Transacao(
    var idTransacao: UUID? = null,
    private val numeroCartao: String,
    private val nomeTitular: String,
    private val dataVencimento: LocalDate,
    private val cpf: String,
    private val enderecoCobranca: String,
    val valor: BigDecimal,
    val qtdParcelas: Int,
    val estabelecimento: String,
    val cartao: Cartao,
    val momentoTransacao: Timestamp = Timestamp.from(Instant.now())
) {


    init {
        if (!this.isDadosValidos()) {
            throw NegocioException("Transacao invalida")
        }
    }


    fun isDadosValidos(): Boolean {
        return this.nomeTitular == cartao.nomeTitular &&
                this.cpf == cartao.cpfTitular &&
                this.enderecoCobranca == cartao.enderecoCobranca &&
                this.isDataVencimentoValida(cartao.vencimento) &&
                this.isLimiteValido()

    }

    fun isLimiteValido(): Boolean = this.valor.compareTo(cartao.saldo) < 1


    private fun isDataVencimentoValida(dataVencimento: LocalDate): Boolean = this.dataVencimento.isEqual(dataVencimento)

    fun getIdCartao() = this.cartao.id;

}

