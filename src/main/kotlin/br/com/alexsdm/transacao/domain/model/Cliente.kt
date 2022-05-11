package br.com.alexsdm.transacao.domain.model

import java.util.*

class Cliente(
    val id: UUID,
    val nome: String,
    val sobrenome: String,
    val enderecoCobranca: String,
    val cpf: String
) {
}
