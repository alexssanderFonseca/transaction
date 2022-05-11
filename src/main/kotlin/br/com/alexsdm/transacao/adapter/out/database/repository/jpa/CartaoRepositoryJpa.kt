package br.com.alexsdm.transacao.adapter.out.database.repository.jpa

import br.com.alexsdm.transacao.adapter.out.database.datamodel.CartaoDataModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CartaoRepositoryJpa : JpaRepository<CartaoDataModel, UUID> {
    fun findByNumCartao(numeroCartao: String): CartaoDataModel?
}