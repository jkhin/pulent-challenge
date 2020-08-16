package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.okHttpsLibs() = with(this) {
    okHttpLib()
    okHttpInterceptorLib()
}

fun DependencyHandlerScope.okHttpLib() = this.add(
    implementation,
    Dependency.OkHttp.okHttp3
)

fun DependencyHandlerScope.okHttpInterceptorLib() = this.add(
    implementation,
    Dependency.OkHttp.okHttpInterceptor
)
