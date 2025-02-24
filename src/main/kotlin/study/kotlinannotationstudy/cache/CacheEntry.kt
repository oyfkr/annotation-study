package study.kotlinannotationstudy.cache

data class CacheEntry<T>(
    val value: T, // 제네릭 타입 -> 어떤 타입이라도 들어올 수 있음
    val expirationTime: Long,
) {
    fun isExpired(): Boolean = System.currentTimeMillis() > expirationTime
}


// 어떻게 하면 좋을까??