package br.com.marketlist

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MarketListApplication

fun main(args: Array<String>) {
    SpringApplication.run(MarketListApplication::class.java, *args)
}
