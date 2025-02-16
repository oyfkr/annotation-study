package study.kotlinannotationstudy.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import study.kotlinannotationstudy.controller.request.CreateAccountRequest
import study.kotlinannotationstudy.domain.AccountDTO
import study.kotlinannotationstudy.service.AccountService

@RestController
@RequestMapping("/v1/accounts")
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping
    fun createAccount(
        @RequestBody request: CreateAccountRequest
    ): ResponseEntity<AccountDTO> {
        return ResponseEntity.ok(accountService.createAccount(request))
    }
}