package study.kotlinannotationstudy.annotation

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoCache(
    val expiration: Long = 60L,
    val key: String,
    val clazz: KClass<*>
)
