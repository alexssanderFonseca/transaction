package br.com.alexsdm.transacao.port.out

import br.com.alexsdm.transacao.domain.model.Transacao

interface TransacaoRealizadaEventPort {
    fun publicar(transacao: Transacao)
}