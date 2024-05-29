package com.example.utils

import java.awt.image.BufferedImage
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO

object ImageUtils {
    fun loadImageFromUrl(imageUrl: String): BufferedImage? {
        return try {
            val url = URL(imageUrl)
            ImageIO.read(url)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
