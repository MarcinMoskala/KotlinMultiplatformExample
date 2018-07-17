package org.kotlinacademy

import org.kotlinacademy.components.QuotesComponent
import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.onload = {
        render(document.getElementById("root")!!) {
            child(QuotesComponent::class) {}
        }
    }
}