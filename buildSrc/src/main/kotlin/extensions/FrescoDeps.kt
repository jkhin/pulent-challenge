package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.frescoLibs() = with(this) {
    frescoLib()
}

fun DependencyHandlerScope.frescoLib() = this.add(
    implementation,
    Dependency.Fresco.fresco
)
