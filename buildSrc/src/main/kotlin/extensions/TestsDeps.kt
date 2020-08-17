package extensions

import Dependency
import constants.testImplementation
import constants.androidTestImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.testLibs() = with(this) {
    jUnitLib()
    androidxTestExtLib()
    espressoCoreLib()
    koinTestLib()
    kluentLib()

}

fun DependencyHandler.jUnitLib() = this.add(
    testImplementation,
    Dependency.Tests.jUnit
)

fun DependencyHandler.androidxTestExtLib() = this.add(
    androidTestImplementation,
    Dependency.Tests.androidxTestExt
)

fun DependencyHandler.espressoCoreLib() = this.add(
    androidTestImplementation,
    Dependency.Tests.espressoCore
)

fun DependencyHandler.koinTestLib() = this.add(
    testImplementation,
    Dependency.Koin.koinTest
)

fun DependencyHandler.kluentLib() = this.add(
    testImplementation,
    Dependency.Tests.kluent
)