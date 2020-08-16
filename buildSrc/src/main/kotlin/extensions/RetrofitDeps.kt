package extensions

import constants.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.retrofitLibs() = with(this) {
    retrofitLib()
    retrofitConverterMoshiLib()
    retrofitConverterScalarsiLib()
}

fun DependencyHandlerScope.retrofitLib() = this.add(
    implementation,
    Dependency.Retrofit.retrofit
)

fun DependencyHandlerScope.retrofitConverterMoshiLib() = this.add(
    implementation,
    Dependency.Retrofit.retrofitConverterMoshi
)

fun DependencyHandlerScope.retrofitConverterScalarsiLib() = this.add(
    implementation,
    Dependency.Retrofit.retrofitConverterScalars
)