package study.kotlinannotationstudy.cache

import study.kotlinannotationstudy.annotation.AutoCache
import kotlin.reflect.full.callSuspend
import kotlin.reflect.full.findAnnotation

class HandleCache {

    fun handleAutoCache(target: Any, methodName: String, vararg args: Any?): Any? {
        val method = target::class.members.find { it.name == methodName } ?: return null
        val annotation = method.findAnnotation<AutoCache>() ?: return method.call(target, *args)

        val cacheKey = annotation.key
        val cachedValue = CacheManager.get(cacheKey)

        if (cachedValue != null) {
            println("✅ 캐시된 값 반환: $cachedValue")
            return cachedValue
        }

        // 원래 메서드 실행 (일반 함수만 지원)
        val result = method.call(target, *args) ?: return null
        CacheManager.put(cacheKey, result, annotation.expiration)
        println("🆕 캐시에 저장됨: $cacheKey")
        return result
    }
}