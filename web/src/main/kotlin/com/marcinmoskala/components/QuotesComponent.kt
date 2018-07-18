package com.marcinmoskala.components

import com.marcinmoskala.data.Quote
import com.marcinmoskala.presentation.QuotationPresenter
import com.marcinmoskala.repository.QuotationRepositoryImpl
import com.marcinmoskala.view.QuotationView
import com.marcinmoskala.view.quoteView
import react.*

class QuotesComponent : RComponent<RProps, ManagerComponentState>(), QuotationView {

    private val repo = QuotationRepositoryImpl()
    private val presenter = QuotationPresenter(this, repo)

    override fun componentDidMount() {
        presenter.onStart()
    }

    override fun RBuilder.render() {
        quoteView(state.quote, presenter::onNext)
    }

    override fun showQuote(quote: Quote) {
        setState { this.quote = quote }
    }
}

external interface ManagerComponentState : RState {
    var quote: Quote?
}