package br.com.alexsdm.transacao.port.out

interface TransacaoErroEventPort {

    fun publicar(numCartao: String, motivo: String)
}