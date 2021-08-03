package br.com.marketlist.repository

import br.com.marketlist.repository.entity.ProductEntity
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<ProductEntity, Long>

