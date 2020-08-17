package extensions

import Dependency
import constants.kapt
import constants.implementation
import constants.testImplementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.roomLibs() = with(this) {
    roomRuntimeLib()
    roomCompilerLib()
    roomKtxLib()
    roomTestsLib()
}

fun DependencyHandlerScope.roomRuntimeLib() = this.add(
    implementation,
    Dependency.Room.roomRuntime
)

fun DependencyHandlerScope.roomCompilerLib() = this.add(
    kapt,
    Dependency.Room.roomCompiler
)

fun DependencyHandlerScope.roomKtxLib() = this.add(
    implementation,
    Dependency.Room.roomKtx
)

fun DependencyHandlerScope.roomTestsLib() = this.add(
    testImplementation,
    Dependency.Room.roomTesting
)