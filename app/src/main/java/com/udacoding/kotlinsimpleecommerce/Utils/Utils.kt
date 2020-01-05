package com.udacoding.kotlinsimpleecommerce.Utils

import java.text.NumberFormat
import java.util.*

fun formatToRupiah(nominal: String) : String {
    val localeId = Locale("in","ID")
    val formatRupiah = NumberFormat.getCurrencyInstance(localeId)
    return formatRupiah.format(nominal.toDouble())
}