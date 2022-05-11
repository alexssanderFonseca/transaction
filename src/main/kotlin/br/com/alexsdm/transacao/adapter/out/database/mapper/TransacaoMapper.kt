package br.com.alexsdm.transacao.adapter.out.database.mapper

import br.com.alexsdm.transacao.adapter.out.database.datamodel.TransacaoDataModel
import br.com.alexsdm.transacao.domain.model.Transacao
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface TransacaoMapper {

    fun toTransacao(transacaoDto: TransacaoDataModel): Transacao;

    @Mapping(target = "idCartao", source = "cartao.id")
    fun deTransacao(transacao: Transacao): TransacaoDataModel
}