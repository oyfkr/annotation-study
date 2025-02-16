package study.kotlinannotationstudy.service

import org.springframework.stereotype.Service
import study.kotlinannotationstudy.controller.request.CreateAccountRequest
import study.kotlinannotationstudy.domain.AccountDTO
import study.kotlinannotationstudy.domain.repository.AccountRepository

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {

    fun createAccount(request: CreateAccountRequest): AccountDTO {
        val account = request.createAccount()
        val savedAccount = accountRepository.save(account)

        return AccountDTO.from(savedAccount)
    }
}