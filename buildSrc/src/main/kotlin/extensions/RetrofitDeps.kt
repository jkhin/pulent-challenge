package extensions

import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.retrofitLibs() = with(this) {
    retrofitLib()
    retrofitMoshiLib()
}

fun DependencyHandlerScope.retrofitLib() = this.add(
    implementation,
    Dependency.Retrofit.retrofit
)

fun DependencyHandlerScope.retrofitMoshiLib() = this.add(
    implementation,
    Dependency.Retrofit.retrofitMoshi
)