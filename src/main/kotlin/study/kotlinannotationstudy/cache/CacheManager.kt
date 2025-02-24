package study.kotlinannotationstudy.cache

import java.util.concurrent.ConcurrentHashMap

object CacheManager {

    private val cache = ConcurrentHashMap<String, CacheEntry<Any>>()
    // 모든 클래스를 상속 받을 수 있어야 하기 떄문에 Any 사용, 타입 안전성을 보장하지 않기 때문에, 값을 꺼낼 때 캐스팅 필요

    fun get(key: String): Any? {
        val entry = cache[key] ?: return null
        return if (!entry.isExpired()) entry.value else {
            cache.remove(key)
            null
        }
    }

    // put 함수 만들기
}