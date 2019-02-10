package com.train

import java.lang.Exception
import java.util.*

fun main(args: Array<String>) {
    var ticketNumber = 0
    var roundNumber = 0
    val singleTripPrice = 1000
    val roundTripPrice = (2000 *0.9).toInt()
    do {
        print("歡迎使用此訂票系統，請輸入欲購買的張數:\t")
        val scanner = Scanner(System.`in`)
        try {
            ticketNumber = scanner.nextInt()
            print("是否有來回票 ? 是(Y), 否(N):\t")
            val command = scanner.next()
            if(command.contains("y", true)){
                print("請輸入來回票張數:\t")
                roundNumber = scanner.nextInt()
            }
            val ticket = TrainTicket(ticketNumber, roundNumber)
            val total = ticket.getTotal(singleTripPrice, roundTripPrice)
            ticket.showMessage(total)
        }catch (e: Exception){
            println("錯誤，輸入僅接受數值")
        }

    }while (ticketNumber == 0)
}

class TrainTicket(var ticketNumber: Int, var roundTripNumber: Int){

    fun getTotal(priceSingle: Int, priceRound: Int): Int {
        val singleTripNumber = ticketNumber-roundTripNumber
        return singleTripNumber * priceSingle + roundTripNumber * priceRound
    }

    fun showMessage(total: Int){
        println("以下為您的訂票資訊，請確認:")
        println("總票數: $ticketNumber")
        println("來回票數: $roundTripNumber")
        println("總金額: $total")
    }
}