package com.marcinmoskala.mkpexample

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quotations.*
import com.marcinmoskala.data.Quote
import com.marcinmoskala.presentation.QuotationPresenter
import com.marcinmoskala.repository.QuotationRepositoryImpl
import com.marcinmoskala.view.QuotationView

class QuotationsActivity : Activity(), QuotationView {

    private val quotationsRepo = QuotationRepositoryImpl()
    private val presenter = QuotationPresenter(this, quotationsRepo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotations)
        presenter.onStart()
        nextButton.setOnClickListener { presenter.onNext() }
    }

    override fun showQuote(quote: Quote) {
        textView.text = quote.text
        authorView.text = quote.person
    }
}
