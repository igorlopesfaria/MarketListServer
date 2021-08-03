package br.com.marketlist.controller


import br.com.marketlist.commons.base.BaseController
import br.com.marketlist.controller.request.ProductTypeSaveRequest
import br.com.marketlist.service.ProductTypeService
import br.com.marketlist.service.data.ProductType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/productType")
class ProductTypeController(private val service: ProductTypeService): BaseController() {

    @GetMapping("")
    fun getProductType(): List<ProductType> = service.find()

    @GetMapping("/{productId}")
    fun getProductTypeById(@PathVariable productId: Long): ProductType = try {
        service.findById(productId)
    } catch (ex: Exception) { throw handleException(ex) }

    @PostMapping("")
    fun postProductType(@RequestBody request:ProductTypeSaveRequest) = try {
        service.save(request)
    } catch (ex: Exception) { throw handleException(ex) }

    @DeleteMapping("/{productId}")
    fun deleteProductType(@PathVariable productId: Long) = try {
        service.delete(productId)
    } catch (ex: Exception) { throw handleException(ex) }
}
