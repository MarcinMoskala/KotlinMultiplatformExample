package com.marcinmoskala.repository

import com.marcinmoskala.data.Quote

interface QuotationRepository {
    val quotesNumber: Int
    fun getQuote(quoteId: Int): Quote
}