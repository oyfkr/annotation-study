package study.kotlinannotationstudy.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiredRole(vararg val roles: String)
