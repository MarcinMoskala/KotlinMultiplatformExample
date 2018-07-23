@file:Suppress("TestFunctionName")

package com.marcinmoskala

import com.marcinmoskala.data.Quote
import com.marcinmoskala.presentation.QuotationPresenter
import com.marcinmoskala.repository.QuotationRepository
import com.marcinmoskala.view.QuotationView
import io.mockk.*
import kotlin.test.Test
import kotlin.test.assertEquals

class QuotePresenterUnitTest {

    @Test
    // After started, is shows a first quote on a view
    fun After_started_shows_a_first_quote() {
        val quote = someQuote
        val view = mockk<QuotationView>()
        val repo = mockk<QuotationRepository>()
        every { view.showQuote(any()) } just runs
        every { repo.quotesNumber } returns 1
        every { repo.getQuote(0) } returns quote

        val presenter = QuotationPresenter(view, repo)
        // When
        presenter.onStart()
        // Then
        verifyAll { view.showQuote(quote) }
    }

    @Test
    // After on next, is shows second quote on a view
    fun On_next_clicked_shows_another_quote() {
        val quote1 = someQuote
        val quote2 = anotherQuote
        val view = mockk<QuotationView>()
        val repo = mockk<QuotationRepository>()
        every { view.showQuote(any()) } just runs
        every { repo.quotesNumber } returns 2
        every { repo.getQuote(0) } returns quote1
        every { repo.getQuote(1) } returns quote2

        val presenter = QuotationPresenter(view, repo)
        // When
        presenter.onStart()
        presenter.onNext()
        // Then
        verifyOrder {
            view.showQuote(quote1)
            view.showQuote(quote2)
        }
    }

    // After last quote, first quote is displayed
    @Test
    fun Quotes_are_circling() {
        val quote1 = someQuote
        val quote2 = anotherQuote
        val view = mockk<QuotationView>()
        val repo = mockk<QuotationRepository>()
        every { view.showQuote(any()) } just runs
        every { repo.quotesNumber } returns 2
        every { repo.getQuote(0) } returns quote1
        every { repo.getQuote(1) } returns quote2

        val presenter = QuotationPresenter(view, repo)
        // When
        presenter.onStart()
        repeat(4) {
            presenter.onNext()
        }
        // Then
        verifyOrder {
            view.showQuote(quote1)
            view.showQuote(quote2)
            view.showQuote(quote1)
            view.showQuote(quote2)
            view.showQuote(quote1)
        }
    }

    companion object {
        val someQuote = Quote("AAA", "BBB")
        val anotherQuote = Quote("CCC", "DDD")
    }
}