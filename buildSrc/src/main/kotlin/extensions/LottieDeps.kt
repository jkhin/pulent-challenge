package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.lottieLib() = this.add(
    implementation,
    Dependency.Lottie.lottie
)
