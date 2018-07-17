package org.kotlinacademy.presentation

import org.kotlinacademy.repository.QuotationRepository
import org.kotlinacademy.view.QuotationView

class QuotationPresenter(
        private val view: QuotationView,
        private val repo: QuotationRepository
) {
    private var nextQuoteId = 0

    fun onStart() {
        onNext()
    }

    fun onNext() {
        nextQuoteId = (nextQuoteId + 1) % repo.quotesNumber
        val quote = repo.getQuote(nextQuoteId)
        view.showQuote(quote)
    }
}