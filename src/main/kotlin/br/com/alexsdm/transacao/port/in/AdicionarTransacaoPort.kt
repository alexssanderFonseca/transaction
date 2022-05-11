package br.com.alexsdm.transacao.port.`in`

import br.com.alexsdm.transacao.domain.dto.`in`.AdicionarTransacaoDto

interface AdicionarTransacaoPort {

    fun executar(adicionarTransacaoDto: AdicionarTransacaoDto):Boolean
}