package br.com.alexsdm.transacao.domain.dto.`in`

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class InfoCartaoDto(
    var nomeTitular: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") var dataVencimento: LocalDate,
    var cpf: String,
    var enderecoCobranca: String,
    var saldo: String,
    var limite: String
)
