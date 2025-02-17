package study.kotlinannotationstudy.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import study.kotlinannotationstudy.domain.Account

@RestController("/v1/secret")
class SecretInfoController {

    @GetMapping("/accounts")
    fun getAccounts() : ResponseEntity<String> {
        return ResponseEntity.ok("Admin 성공")
    }
}