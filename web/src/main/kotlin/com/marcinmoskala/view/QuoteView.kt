package com.marcinmoskala.view

import kotlinx.html.js.onClickFunction
import com.marcinmoskala.data.Quote
import react.RBuilder
import react.dom.button
import react.dom.div

fun RBuilder.quoteView(quote: Quote?, onNext: ()->Unit) = div(classes = "center") {
    if (quote == null) {
        +"No quote yet"
    } else {
        div(classes = "quotation-container") {
            div(classes = "text") { +quote.text }
            div(classes = "person") { +quote.person }
            button(classes = "next") {
                +"Next"
                attrs { onClickFunction = { onNext() } }
            }
        }
    }
}