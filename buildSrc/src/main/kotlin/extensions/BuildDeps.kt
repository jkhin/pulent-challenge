package extensions

import Dependency
import constants.implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidGradlePluginLib() =
    this.add(
        implementation,
        Dependency.BuildPlugins.androidGradle
    )
