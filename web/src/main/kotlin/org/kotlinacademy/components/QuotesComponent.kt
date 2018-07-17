package org.kotlinacademy.components

import kotlinx.html.js.onClickFunction
import org.kotlinacademy.data.Quote
import org.kotlinacademy.presentation.QuotationPresenter
import org.kotlinacademy.repository.QuotationRepositoryImpl
import org.kotlinacademy.view.QuotationView
import react.*
import react.dom.button
import react.dom.div

class QuotesComponent : RComponent<RProps, ManagerComponentState>(), QuotationView {

    private val repo by lazy { QuotationRepositoryImpl() }
    private val presenter by lazy { QuotationPresenter(this, repo) }

    override fun componentDidMount() {
        presenter.onStart()
    }

    override fun RBuilder.render() {
        val quote = state.quote
        div(classes = "center") {
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
        print("Showing quote ${quote.text}")
        setState { this.quote = quote }
    }
}

external interface ManagerComponentState : RState {
    var quote: Quote?
}