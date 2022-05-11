package br.com.alexsdm.transacao.domain.usecase

import br.com.alexsdm.transacao.domain.dto.`in`.AdicionarTransacaoDto
import br.com.alexsdm.transacao.domain.exception.NegocioException
import br.com.alexsdm.transacao.domain.model.Cartao
import br.com.alexsdm.transacao.domain.model.Transacao
import br.com.alexsdm.transacao.port.`in`.AdicionarTransacaoPort
import br.com.alexsdm.transacao.port.out.CartaoRepository
import org.springframework.stereotype.Service

@Service
class AdicionarTransacaoUseCase(
    private val cartaoRepositoryPort: CartaoRepository,
) : AdicionarTransacaoPort {

    private lateinit var cartao: Cartao;


    override fun executar(adicionarTransacaoDto: AdicionarTransacaoDto): Boolean {
        this.cartao = getCartao(adicionarTransacaoDto.numeroCartao)
        try {
            val transacao = criaTransacao(adicionarTransacaoDto);
            cartao.atualizarSaldo(transacao.valor);
            cartaoRepositoryPort.adicionarTransacao(transacao);
            return true;
        } catch (exception: NegocioException) {
            return false;
        }

    }

    private fun getCartao(numeroCartao: String): Cartao {
        return this.cartaoRepositoryPort.getCartao(numeroCartao) ?: throw NegocioException("Cartao invalido");
    }


    private fun criaTransacao(adicionarTransacaoDto: AdicionarTransacaoDto): Transacao {
        return Transacao(
            numeroCartao = adicionarTransacaoDto.numeroCartao,
            enderecoCobranca = adicionarTransacaoDto.enderecoCobranca,
            cpf = adicionarTransacaoDto.cpf,
            dataVencimento = adicionarTransacaoDto.dataVencimento,
            qtdParcelas = adicionarTransacaoDto.qtdParcelas,
            nomeTitular = adicionarTransacaoDto.nomeTitular,
            valor = adicionarTransacaoDto.valor,
            estabelecimento = adicionarTransacaoDto.estabelecimento,
            cartao = getCartao(cartao.numCartao)
        )

    }


};

