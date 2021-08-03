package br.com.marketlist.repository.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ProductEntity (
    @Id @GeneratedValue var id: Long = 0,
    var name: String,
    var count: Int,
    var note: String,
    @ManyToOne var productType: ProductTypeEntity
)
