package com.techprd.views

import com.techprd.events.TodoEventEmitter
import com.techprd.model.Task
import com.techprd.services.StorageService
import com.techprd.utils.Utils.randomId
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.li
import kotlinx.html.js.onInputFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import kotlinx.browser.document

class Todo(var formContainer: HTMLDivElement) {

    var inputVal: String = ""
    private val eventEmitter = TodoEventEmitter()
    private val storage = StorageService(eventEmitter)

    // TODO
    private fun registerEvents() {
    }

    fun onInput(): (Event) -> Unit {
        return {
            val input = it.currentTarget as HTMLInputElement
            inputVal = input.value
        }
    }

    fun onSubmit(): (Event) -> Unit {
        return {
            it.preventDefault()
            val id = randomId()
            val task = Task(id, inputVal)
            storage[id] = task
            document.getElementById("task-collection")?.append(
                document.create.li("collection-item avatar dismissable") {
                    todoItem(storage, task) {

                    }
                }
            )
        }
    }

    fun render() {
        storage.getAll {
            formContainer.appendChild(getForm())
        }
    }

    fun getForm(): HTMLDivElement {
        return document.create.div("row")
        {
            div("col l12 m12 s12") {
                div("card collection") {
                    div("card-content") {
                        span("card-title") {
                            +"To-Do Sample app"
                        }
                        form("/", null) {
                            div("row") {
                                div("input-field") {
                                    i("material-icons prefix") {
                                        +"border_color"
                                    }
                                    inputView {
                                        onInputFunction = onInput()
                                    }
                                    label("active") {
                                        htmlFor = "icon_prefix"
                                        +"add a new task"
                                    }
                                }
                            }
                            onSubmitFunction = onSubmit()
                        }
                    }
                    div("card-action") {
                        listView(storage) {
                            id = "task-collection"
                        }
                    }
                }
            }

        }
    }
}
