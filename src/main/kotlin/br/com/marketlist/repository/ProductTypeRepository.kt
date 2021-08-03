package br.com.marketlist.repository

import br.com.marketlist.repository.entity.ProductTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductTypeRepository: JpaRepository<ProductTypeEntity, Long>