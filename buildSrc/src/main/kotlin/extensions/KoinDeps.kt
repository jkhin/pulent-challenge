package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.koinLibs() = with(this) {
    koinLib()
    koinViewModelLib()
}

fun DependencyHandlerScope.koinLib() = this.add(
    implementation,
    Dependency.Koin.koin
)
fun DependencyHandlerScope.koinViewModelLib() = this.add(
    implementation,
    Dependency.Koin.koinViewModel
)
