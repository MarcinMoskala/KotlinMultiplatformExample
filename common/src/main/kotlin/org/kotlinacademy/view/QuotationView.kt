package org.kotlinacademy.view

import org.kotlinacademy.PlatformName
import org.kotlinacademy.data.Quote

interface QuotationView {
    @PlatformName("showQuote")
    fun showQuote(quote: Quote)
}