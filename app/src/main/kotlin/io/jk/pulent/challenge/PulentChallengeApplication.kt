package io.jk.pulent.challenge

import android.app.Application
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.common.util.ByteConstants
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.cache.MemoryCacheParams
import com.facebook.imagepipeline.core.ImagePipelineConfig
import injectModules

class PulentChallengeApplication: Application() {

    companion object {
        private val MAX_HEAP_SIZE = Runtime.getRuntime().maxMemory().toInt()
        private val MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 4
        private const val MAX_DISK_CACHE_SIZE = 100L * ByteConstants.MB
        private const val MAX_DISK_CACHE_SIZE_LOW_DISK = 10L * ByteConstants.MB
        private const val MAX_DISK_CACHE_SIZE_VERY_LOW_DISK = 5L * ByteConstants.MB
    }

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
        initializeFresco()
    }

    private fun initializeKoin() {
        injectModules(this)
    }

    private fun initializeFresco() {
        val diskCacheConfig = DiskCacheConfig.newBuilder(this@PulentChallengeApplication)
            .setBaseDirectoryPath(cacheDir)
            .setBaseDirectoryName("imgCache")
            .setMaxCacheSize(MAX_DISK_CACHE_SIZE)
            .setMaxCacheSizeOnLowDiskSpace(MAX_DISK_CACHE_SIZE_LOW_DISK)
            .setMaxCacheSizeOnVeryLowDiskSpace(MAX_DISK_CACHE_SIZE_VERY_LOW_DISK)
            .build()
        val imagePipelineConfig = ImagePipelineConfig
            .newBuilder(this)
            .setBitmapMemoryCacheParamsSupplier {
                MemoryCacheParams(
                    MAX_MEMORY_CACHE_SIZE,
                    Int.MAX_VALUE,
                    MAX_MEMORY_CACHE_SIZE,
                    Int.MAX_VALUE,
                    Int.MAX_VALUE
                )
            }
            .setDiskCacheEnabled(true)
            .setDownsampleEnabled(true)
            .setMainDiskCacheConfig(diskCacheConfig)
            .build()

        Fresco.initialize(this@PulentChallengeApplication, imagePipelineConfig)
    }

}