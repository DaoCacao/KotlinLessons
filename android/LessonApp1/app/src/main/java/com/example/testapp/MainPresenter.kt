package com.example.testapp

public class MainPresenter(private val _view: MainActivity, private val fibo: Fibo) {
    var positionNumber: Int? = 0
    var fiboResult: Int=0


    fun onButtonClick(){
        this.fiboResult=fibo.fibonachi(positionNumber)
        _view.showResult(this.fiboResult)
    }

    fun onNumberInput(_positionNumber: String) {
        positionNumber = _positionNumber.toIntOrNull()
    }

}
