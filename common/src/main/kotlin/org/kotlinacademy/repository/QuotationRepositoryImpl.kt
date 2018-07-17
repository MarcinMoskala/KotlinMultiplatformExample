package org.kotlinacademy.repository

import org.kotlinacademy.data.Quote

class QuotationRepositoryImpl : QuotationRepository {

    override val quotesNumber: Int
        get() = quotes.size

    override fun getQuote(quoteId: Int): Quote = quotes[quoteId]

    companion object {
        private val quotes = listOf(
                Quote("I skate to where the puck is going to be, not where it has been.", "Wayne Gretzky"),
                Quote("The future is already here — it's just not very evenly distributed.", "William Gibson"),
                Quote("I want to impact the world through futuristic yet affordable technologies to make the world a better place.", "Pranav Mistry"),
                Quote("Every once in a while, a new technology, an old problem, and a big idea turn into an innovation.", "Dean Kamen"),
                Quote("Seven thousand years is just one day at a time.", "Terry Pratchett")
        )
    }
}