package extensions

import constants.implementation
import constants.kapt
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.moshiLibs() = with(this) {
    moshiLib()
    moshiKotlinLib()
    moshiKotlinCodeGen()
}

fun DependencyHandlerScope.moshiLib() = this.add(
    implementation,
    Dependency.Moshi.moshi
)

fun DependencyHandlerScope.moshiKotlinLib() = this.add(
    implementation,
    Dependency.Moshi.moshiKotlin
)
fun DependencyHandlerScope.moshiKotlinCodeGen() = this.add(
    kapt,
    Dependency.Moshi.moshiCodeGen
)