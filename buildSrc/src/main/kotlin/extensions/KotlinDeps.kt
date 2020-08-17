package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.kotlinLibs() = with(this) {
    kotlinLib()
    kotlinCoroutinesLib()
}

fun DependencyHandlerScope.kotlinLib() = this.add(
    implementation,
    Dependency.Kotlin.kotlin
)

fun DependencyHandlerScope.kotlinCoroutinesLib() = this.add(
    implementation,
    Dependency.Kotlin.kotlinCoroutines
)
