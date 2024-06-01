package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Service.DollService
import com.example.utils.ImageUtils
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

@RestController
@RequestMapping("/api/dolls")
class DollRestController(
    private val dollService: DollService
) {

    @GetMapping
    fun getAllDolls(): List<Doll> = dollService.getAllDolls()

    @PostMapping
    fun addDoll(@RequestBody doll: Doll, @RequestParam wishlistId: Long?, @RequestParam allDollsListId: Long): Doll = dollService.saveDoll(doll, wishlistId, allDollsListId)

    @GetMapping("/search")
    fun searchDolls(@RequestParam name: String): List<Doll> = dollService.findDollsByName(name)

    @GetMapping("/image", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getImage(@RequestParam imageUrl: String): ResponseEntity<ByteArray> {
        val image = ImageUtils.loadImageFromUrl(imageUrl)
        return if (image != null) {
            val outputStream = ByteArrayOutputStream()
            ImageIO.write(image, "jpg", outputStream)
            ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(outputStream.toByteArray())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
