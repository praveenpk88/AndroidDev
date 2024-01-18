package com.animedfan.adfapp.downloadercomponents

import android.app.DownloadManager
import android.os.Environment
import androidx.core.net.toUri
import com.animedfan.adfapp.MainActivity

class AndroidDownloader(
    private val context: MainActivity
): Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("application/pdf")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("Resume.pdf")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"Resume.pdf")
        return downloadManager.enqueue(request)
    }


}