//
//  ViewController.swift
//  ExampleMKP
//
//  Created by Marcin Moskala on 16.07.2018.
//  Copyright © 2018 Marcin Moskala. All rights reserved.
//

import UIKit
import QuotationsCommon

class ViewController: UIViewController, QCQuotationView {

    @IBOutlet weak var textView: UILabel!
    @IBOutlet weak var authorView: UILabel!
    
    let repo = QCQuotationRepositoryImpl()
    var presenter: QCQuotationPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = QCQuotationPresenter(view: self, repo: repo)
        presenter.onStart()
    }

    @IBAction func onNext() {
        presenter.onNext()
    }
    
    func showQuote(quote: QCQuote) {
        textView.text = quote.text
        authorView.text = quote.person
    }
}
