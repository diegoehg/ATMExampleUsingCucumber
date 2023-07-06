package org.diegoehg.atmapp

class AtmCard(var balance:Int) {
    fun withdraw(withdrawalAmmount:Int) {
        balance -= withdrawalAmmount
    }
}