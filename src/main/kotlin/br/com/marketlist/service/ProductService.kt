package br.com.marketlist.service

import br.com.marketlist.commons.exceptions.ItemNotFoundDatabaseException
import br.com.marketlist.controller.request.ProductSaveRequest
import br.com.marketlist.repository.ProductRepository
import br.com.marketlist.repository.entity.ProductEntity
import br.com.marketlist.repository.entity.ProductTypeEntity
import br.com.marketlist.service.data.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository, ) {

    fun find() = productRepository.findAll().toList().map { Product(it) }

    fun findById(id: Long) = productRepository.findById(id).let { optionalProduct ->
        if(optionalProduct.isPresent) Product(optionalProduct.get())
        else throw ItemNotFoundDatabaseException()
    }

    fun save(request: ProductSaveRequest) = Product(
        productRepository.save(
            ProductEntity(
                name = request.name,
                productType = ProductTypeEntity(
                    id = request.productType.id,
                    name =  request.productType.name
                ),
                count = request.count,
                note = request.note
            )
        )
    )

    fun delete(id: Long) {
        if(productRepository.existsById(id)) productRepository.deleteById(id)
        else throw ItemNotFoundDatabaseException()
    }
}