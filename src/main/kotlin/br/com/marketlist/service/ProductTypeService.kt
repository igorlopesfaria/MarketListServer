package br.com.marketlist.service

import br.com.marketlist.commons.exceptions.InvalidParameterException
import br.com.marketlist.commons.exceptions.ItemNotFoundDatabaseException
import br.com.marketlist.controller.request.ProductTypeSaveRequest
import br.com.marketlist.repository.ProductTypeRepository
import br.com.marketlist.repository.entity.ProductTypeEntity
import br.com.marketlist.service.data.ProductType
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductTypeService(private val productTypeRepository: ProductTypeRepository) {

    fun find() = productTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).toList().map { ProductType(it) }

    fun findById(id: Long) = productTypeRepository.findById(id).let { optionalProductType ->
            if(optionalProductType.isPresent) ProductType(optionalProductType.get())
            else throw ItemNotFoundDatabaseException()
        }

    fun save(request: ProductTypeSaveRequest) {
        if(request.name.isEmpty()){ throw InvalidParameterException() }
        ProductType(productTypeRepository.save(ProductTypeEntity(name = request.name)))
    }

    fun delete(id: Long) {
        if(productTypeRepository.existsById(id)) productTypeRepository.deleteById(id)
        else throw ItemNotFoundDatabaseException()
    }
}