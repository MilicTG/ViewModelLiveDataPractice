package dev.milic.viewmodellivedatapractice

import androidx.lifecycle.ViewModel

class TotalsViewModel : ViewModel() {

    var total = 0

    fun increaseTotal(): Int {
        total++
        return total
    }
}