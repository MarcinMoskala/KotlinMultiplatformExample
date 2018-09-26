//
//  ViewController.swift
//  ExampleMKP
//
//  Created by Marcin Moskala on 16.07.2018.
//  Copyright © 2018 Marcin Moskala. All rights reserved.
//

import UIKit
import QuotationsCommon

class ViewController: UIViewController, QuotationView {

    @IBOutlet weak var textView: UILabel!
    @IBOutlet weak var authorView: UILabel!
    
    let repo = QuotationRepositoryImpl()
    var presenter: QuotationPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = QuotationPresenter(view: self, repo: repo)
        presenter.onStart()
    }

    @IBAction func onNext() {
        presenter.onNext()
    }
    
    func showQuote(quote: Quote) {
        textView.text = quote.text
        authorView.text = quote.person
    }
}
