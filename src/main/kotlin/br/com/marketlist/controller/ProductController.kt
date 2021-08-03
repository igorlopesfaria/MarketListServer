package br.com.marketlist.controller

import br.com.marketlist.commons.base.BaseController
import br.com.marketlist.controller.request.ProductSaveRequest
import br.com.marketlist.service.ProductService
import br.com.marketlist.service.data.Product
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val service: ProductService): BaseController() {

    @GetMapping("")
    fun getProductType(): List<Product> = service.find()

    @GetMapping("/{productId}")
    fun getProductTypeById(@PathVariable productId: Long): Product = try {
        service.findById(productId)
    } catch (ex: Exception) { throw handleException(ex) }

    @PostMapping("")
    fun postProductType(@RequestBody request: ProductSaveRequest) = try {
        service.save(request)
    } catch (ex: Exception) { throw handleException(ex) }

    @DeleteMapping("/{productId}")
    fun deleteProductType(@PathVariable productId: Long) = try {
        service.delete(productId)
    } catch (ex: Exception) { throw handleException(ex) }
}
