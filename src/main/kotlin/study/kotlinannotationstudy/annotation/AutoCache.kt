package study.kotlinannotationstudy.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoCache(
    val expiration: Long = 60L,
    val key: String
)
