package study.kotlinannotationstudy.cache

import study.kotlinannotationstudy.annotation.AutoCache
import java.lang.Thread.sleep

class UserService {
    @AutoCache(key = "user_list", expiration = 3)
    fun getUsers(): List<String> {
        println("📡 DB에서 사용자 목록 조회...")
        return listOf("Alice", "Bob", "Charlie")
    }

    @AutoCache(key = "int_list", expiration = 3)
    fun getInts(): List<Int> {
        println("📡 DB에서 int 목록 조회...")
        return listOf(1,2,3)
    }
}

fun main() {
    val userService = UserService()
    val handleCache = HandleCache()

    print("-------------")
    println(handleCache.handleAutoCache(userService, "getUsers")) // 🆕 DB에서 가져옴
    print("-------------")
    println(handleCache.handleAutoCache(userService, "getUsers")) // ✅ 캐시된 값 반환

    sleep(5000)
    print("-------------")
    println(handleCache.handleAutoCache(userService, "getUsers"))


    print("---------")
    println(handleCache.handleAutoCache(userService, "getInts"))
    println(handleCache.handleAutoCache(userService, "getInts"))
}