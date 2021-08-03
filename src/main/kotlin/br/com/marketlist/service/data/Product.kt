package br.com.marketlist.service.data

import br.com.marketlist.repository.entity.ProductEntity

data class Product (
    var id: Long,
    var name: String,
    var count: Int,
    var type: ProductType,
    var note: String){

    constructor(productEntity: ProductEntity) : this(
        id = productEntity.id,
        name = productEntity.name,
        count = productEntity.count,
        type = ProductType(productEntity.productType),
        note =productEntity.note
    )
}

