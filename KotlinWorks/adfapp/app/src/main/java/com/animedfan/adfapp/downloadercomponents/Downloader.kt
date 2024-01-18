package com.animedfan.adfapp.downloadercomponents

import java.net.URL

interface Downloader {
    fun downloadFile(url: String): Long
}