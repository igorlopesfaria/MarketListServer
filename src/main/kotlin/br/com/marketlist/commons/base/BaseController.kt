package br.com.marketlist.commons.base

import br.com.marketlist.commons.exceptions.InvalidParameterException
import br.com.marketlist.commons.exceptions.ItemNotFoundDatabaseException
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

open class BaseController {
    fun handleException(ex: Exception) =
        when (ex) {
            is ItemNotFoundDatabaseException -> ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Item não encontrado"
            )
            is InvalidParameterException -> ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Parametros inválidos"
            )
            else -> ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.message
            )
        }
}