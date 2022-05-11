package br.com.alexsdm.transacao

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class TransacaoApplication

fun main(args: Array<String>) {
    runApplication<TransacaoApplication>(*args)

}

