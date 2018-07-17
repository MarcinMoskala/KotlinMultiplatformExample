package org.kotlinacademy.view

import org.kotlinacademy.data.Quote

interface QuotationView {
    fun showQuote(quote: Quote)
}