//
//  ViewController.kt
//  ios
//
//  Created by Marcin Moskala on 17.07.2018.
//  Copyright © 2018 marcinmoskala. All rights reserved.
//

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import org.kotlinacademy.data.Quote
import org.kotlinacademy.presentation.QuotationPresenter
import org.kotlinacademy.repository.QuotationRepositoryImpl
import org.kotlinacademy.view.QuotationView

@ExportObjCClass
class ViewController : UIViewController {

    constructor(aDecoder: NSCoder): super(aDecoder)
    override fun initWithCoder(aDecoder: NSCoder) = initBy(ViewController(aDecoder))

    @ObjCOutlet lateinit var textView: UILabel
    @ObjCOutlet lateinit var authorView: UILabel

    private val quotationView = object : QuotationView {
        override fun showQuote(quote: Quote) {
            textView.text = quote.text
            authorView.text = quote.person
        }
    }
    private val quotationsRepo = QuotationRepositoryImpl()
    private val presenter = QuotationPresenter(quotationView, quotationsRepo)

    override fun viewDidLoad() {
        presenter.onStart()
    }

    @ObjCAction
    fun onNext() {
        presenter.onNext()
    }
}
