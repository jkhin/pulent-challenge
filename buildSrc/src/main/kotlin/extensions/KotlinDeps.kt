package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.kotlinLibs() = with(this) {
    kotlinLib()
    kotlinCoroutinesCore()
}

fun DependencyHandlerScope.kotlinLib() = this.add(
    implementation,
    Dependency.Kotlin.kotlin
)

fun DependencyHandlerScope.kotlinCoroutinesCore() = this.add(
    implementation,
    Dependency.Android.appCompat
)
