package br.com.alexsdm.transacao.adapter.out.database.mapper

import br.com.alexsdm.transacao.adapter.out.database.datamodel.CartaoDataModel
import br.com.alexsdm.transacao.domain.model.Cartao
import org.mapstruct.Mapper

@Mapper
interface CartaoDataModelMapper {
    fun toCartao(cartaoDataModel: CartaoDataModel): Cartao
    fun deCartao(cartaoDataModel: Cartao): CartaoDataModel
}