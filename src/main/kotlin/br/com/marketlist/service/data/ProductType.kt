package br.com.marketlist.service.data

import br.com.marketlist.repository.entity.ProductTypeEntity

data class ProductType (
    val id: Long,
    val name: String) {
    constructor(productTypeEntity: ProductTypeEntity) : this(
        id = productTypeEntity.id,
        name =productTypeEntity.name
    )
}