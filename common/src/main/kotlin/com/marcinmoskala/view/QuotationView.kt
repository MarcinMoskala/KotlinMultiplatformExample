package com.marcinmoskala.view

import com.marcinmoskala.JsName
import com.marcinmoskala.data.Quote

interface QuotationView {
    @JsName("showQuote")
    fun showQuote(quote: Quote)
}