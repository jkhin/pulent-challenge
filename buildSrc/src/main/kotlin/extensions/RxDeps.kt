package extensions

import Dependency
import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.rxLibs() = with(this){
    rxKotlinLib()
    rxAndroidLib()
}

fun DependencyHandlerScope.rxKotlinLib() = this.add(
    implementation,
    Dependency.Rx.rxKotlin
)

fun DependencyHandlerScope.rxAndroidLib() = this.add(
    implementation,
    Dependency.Rx.rxAndroid
)
