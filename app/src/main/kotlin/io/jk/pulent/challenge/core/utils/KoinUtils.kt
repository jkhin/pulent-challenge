package io.jk.pulent.challenge.core.utils

import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.parameter.parametersOf

inline fun <reified T: Any> KoinComponent.getComponent(vararg params: Any?): T =
    get(parameters = { parametersOf(*params)})

