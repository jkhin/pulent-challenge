package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.materialSearchLib() = this.add(
    implementation,
    Dependency.MaterialSearch.materialSearch
)
