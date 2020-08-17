package io.jk.pulent.challenge.core.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun io(f: suspend () -> Unit){
    withContext(Dispatchers.IO) { f.invoke() }
}
suspend fun ui(f: suspend () -> Unit){
    withContext(Dispatchers.Main) { f.invoke() }
}

fun Any.ui(f: suspend () -> Unit) {
    GlobalScope.launch(Dispatchers.Main) { f.invoke()}
}