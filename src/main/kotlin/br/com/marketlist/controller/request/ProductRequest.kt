package br.com.marketlist.controller.request

data class ProductSaveRequest(
    var name: String,
    var productType: ProductTypeSaveRequest,
    var count: Int,
    var note: String
)
