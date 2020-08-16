import android.app.Application
import io.jk.pulent.challenge.core.extensions.listByElementOf
import io.jk.pulent.challenge.core.network.core.networkModule
import io.jk.pulent.challenge.features.di.featuresModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal fun injectModules(app: Application) {
    startKoin{
        androidLogger()
        androidContext(app)
        modules(applicationModules)
    }
}

internal val applicationModules by lazy {
    listByElementOf<Module>(
        featuresModule,
        networkModule
    )
}