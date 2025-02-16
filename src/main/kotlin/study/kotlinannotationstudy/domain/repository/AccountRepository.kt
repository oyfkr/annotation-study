package study.kotlinannotationstudy.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.kotlinannotationstudy.domain.Account

interface AccountRepository: JpaRepository<Account, Long> {
}