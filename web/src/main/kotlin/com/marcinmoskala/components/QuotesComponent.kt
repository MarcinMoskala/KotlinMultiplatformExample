package com.marcinmoskala.components

import com.marcinmoskala.data.*
import com.marcinmoskala.presentation.*
import com.marcinmoskala.repository.*
import com.marcinmoskala.view.*
import kotlinx.html.js.*
import react.*
import react.dom.*

class QuotesComponent : RComponent<RProps, ManagerComponentState>(), QuotationView {

    private val repo = QuotationRepositoryImpl()
    private val presenter = QuotationPresenter(this, repo)

    override fun componentDidMount() {
        presenter.onStart()
    }

    override fun RBuilder.render() {
        div(classes = "center") {
            val quote = state.quote
            if (quote == null) {
                +"No quote yet"
            } else {
                div(classes = "quotation-container") {
                    div(classes = "text") { +quote.text }
                    div(classes = "person") { +quote.person }
                    button(classes = "next") {
                        +"Next"
                        attrs { onClickFunction = { presenter.onNext() } }
                    }
                }
            }
        }
    }

    override fun showQuote(quote: Quote) {
        setState { this.quote = quote }
    }
}

external interface ManagerComponentState : RState {
    var quote: Quote?
}