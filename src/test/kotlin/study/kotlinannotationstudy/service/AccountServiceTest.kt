package study.kotlinannotationstudy.service

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.*
import study.kotlinannotationstudy.controller.request.CreateAccountRequest
import study.kotlinannotationstudy.domain.Account
import study.kotlinannotationstudy.domain.Role
import study.kotlinannotationstudy.domain.repository.AccountRepository

class AccountServiceTest {

    @MockK
    private lateinit var accountRepository: AccountRepository

    @InjectMockKs
    private lateinit var accountService: AccountService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Nested
    @DisplayName("createAccount")
    inner class CreateAccount{

        private val account = Account(1L, "오근혁", Role.ADMIN)
        private val request = CreateAccountRequest("오근혁", Role.ADMIN)

        @Test
        fun 계정_생성_테스트() {
            // given
            every {
                accountRepository.save(any())
            } returns account

            // when
            val accountDTO = accountService.createAccount(request)

            // then
            Assertions.assertEquals(accountDTO.name, account.name)
        }
    }

}