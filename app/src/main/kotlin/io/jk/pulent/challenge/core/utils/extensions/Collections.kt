package io.jk.pulent.challenge.core.utils.extensions

inline fun <reified T : Any> listByElementOf(vararg elements: Any): List<T> {
    val mLst: MutableList<T>  = mutableListOf()

    elements.forEach { element ->
        if (element is T) mLst.add(element)
        else if (element is List<*>) mLst.addAll(element.mapNotNull { it as? T })
    }

    return mLst
}