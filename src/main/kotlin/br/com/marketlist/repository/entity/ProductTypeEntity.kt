package br.com.marketlist.repository.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ProductTypeEntity (
    @Id @GeneratedValue var id: Long = 0,
    var name: String
)