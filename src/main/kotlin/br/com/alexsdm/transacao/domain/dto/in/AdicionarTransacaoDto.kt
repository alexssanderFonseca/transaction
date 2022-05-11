package br.com.alexsdm.transacao.domain.dto.`in`

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate

data class AdicionarTransacaoDto(
    var numeroCartao: String,
    var nomeTitular: String = "",
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd"
    ) var dataVencimento: LocalDate,
    var cpf: String = "",
    var enderecoCobranca: String = "",
    var valor: BigDecimal = BigDecimal.ONE,
    var qtdParcelas: Int = 1,
    var estabelecimento: String = "teste"
)

