package extensions

import Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import constants.implementation


fun DependencyHandler.androidLibs() = with(this) {
    androidxKTX()
    constraintLayoutLib()
    appCompatLib()
    androidNavigationFragment()
    androidLifeCycleViewModel()
    androidNavigationUIKt()
    androidMaterial()
}

fun DependencyHandler.constraintLayoutLib() = this.add(
    implementation,
    Dependency.Android.constraintLayout
)

fun DependencyHandler.appCompatLib() = this.add(
    implementation,
    Dependency.Android.appCompat
)

fun DependencyHandler.androidxKTX() = this.add(
    implementation,
    Dependency.Android.androidKTX
)

fun DependencyHandler.androidNavigationFragment() = this.add(
    implementation,
    Dependency.Android.androidNavigationFragment
)

fun DependencyHandler.androidNavigationUIKt() = this.add(
    implementation,
    Dependency.Android.androidNavigationUIKt
)

fun DependencyHandler.androidMaterial() = this.add(
    implementation,
    Dependency.Android.androidMaterial
)

fun DependencyHandler.androidLifeCycleViewModel() = this.add(
    implementation,
    Dependency.Android.androidLifeCycleViewModel
)
