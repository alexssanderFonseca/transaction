package br.com.alexsdm.transacao.adapter.out.database.repository

import br.com.alexsdm.transacao.adapter.out.database.mapper.CartaoDataModelMapper
import br.com.alexsdm.transacao.adapter.out.database.mapper.TransacaoMapper
import br.com.alexsdm.transacao.adapter.out.database.repository.jpa.CartaoRepositoryJpa
import br.com.alexsdm.transacao.adapter.out.database.repository.jpa.TransacaoRepositoryJpa
import br.com.alexsdm.transacao.domain.model.Cartao
import br.com.alexsdm.transacao.domain.model.Transacao
import br.com.alexsdm.transacao.port.out.CartaoRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.*

@Repository
class CartaoRepositoryImpl(
    private val cartaoRepositoryJpa: CartaoRepositoryJpa,
    private val cartaoDataModelMapper: CartaoDataModelMapper,
    private val transacaoRepositoryJpa: TransacaoRepositoryJpa,
    private val transacaoMapper: TransacaoMapper
) : CartaoRepository {

    override fun getTotalGasto(idCartao: UUID): BigDecimal {
        return transacaoRepositoryJpa.getValorTotalGasto(idCartao) ?: BigDecimal.ZERO
    }

    override fun getCartao(numeroCartao: String): Cartao? {
        val cartaoData = this.cartaoRepositoryJpa.findByNumCartao(numeroCartao);
        return cartaoData?.let {
            val cartao = cartaoDataModelMapper.toCartao(it)
            cartao.definirSaldo(this.getTotalGasto(cartao.id))
            return cartao;
        };
    }

    override fun adicionarTransacao(transacao: Transacao): Transacao {
        val transacaoDataModel = transacaoRepositoryJpa.save(transacaoMapper.deTransacao(transacao));
        transacao.idTransacao = transacaoDataModel.idTransacao;
        return transacao;
    }


}