package com.example

import org.w3c.dom.HTMLDivElement
import com.example.views.Todo
import kotlin.browser.document

fun main(args: Array<String>) {
    val formContainer = document.getElementById("formContainer") as HTMLDivElement
    Todo(formContainer).render()
}