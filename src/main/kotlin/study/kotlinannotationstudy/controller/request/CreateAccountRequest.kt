package study.kotlinannotationstudy.controller.request

import study.kotlinannotationstudy.domain.Account
import study.kotlinannotationstudy.domain.Role

data class CreateAccountRequest(
    var name: String,
    var role: Role
) {
    fun createAccount(): Account {
        return Account(null, name, role)
    }
}