package org.kotlinacademy.repository

import org.kotlinacademy.data.Quote

interface QuotationRepository {
    val quotesNumber: Int
    fun getQuote(quoteId: Int): Quote
}