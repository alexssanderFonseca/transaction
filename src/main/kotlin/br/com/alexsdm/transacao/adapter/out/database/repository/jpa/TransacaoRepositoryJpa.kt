package br.com.alexsdm.transacao.adapter.out.database.repository.jpa

import br.com.alexsdm.transacao.adapter.out.database.datamodel.TransacaoDataModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal
import java.util.*

interface TransacaoRepositoryJpa : JpaRepository<TransacaoDataModel, String> {

    @Query("SELECT SUM(t.valor) FROM TransacaoDataModel t WHERE t.idCartao =:idCartao")
    fun getValorTotalGasto(idCartao: UUID): BigDecimal?

}