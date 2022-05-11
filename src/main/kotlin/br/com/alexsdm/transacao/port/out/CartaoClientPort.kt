package br.com.alexsdm.transacao.port.out

import br.com.alexsdm.transacao.domain.dto.`in`.InfoCartaoDto

interface CartaoClientPort {
    fun getInfoCartao(numeroCartao: String): InfoCartaoDto
}