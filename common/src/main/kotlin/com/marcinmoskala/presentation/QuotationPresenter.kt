package com.marcinmoskala.presentation

import com.marcinmoskala.repository.QuotationRepository
import com.marcinmoskala.view.QuotationView

class QuotationPresenter(
        private val view: QuotationView,
        private val repo: QuotationRepository
) {
    private var nextQuoteId = -1

    fun onStart() {
        onNext()
    }

    fun onNext() {
        nextQuoteId = (nextQuoteId + 1) % repo.quotesNumber
        val quote = repo.getQuote(nextQuoteId)
        view.showQuote(quote)
    }
}