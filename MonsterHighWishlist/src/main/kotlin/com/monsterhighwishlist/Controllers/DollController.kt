import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO
import com.example.utils.ImageUtils
import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Service.DollService

@RestController
@RequestMapping("/api/dolls")
class DollController(private val dollService: DollService) {

    @GetMapping
    fun getAllDolls(): List<Doll> = dollService.getAllDolls()

    @PostMapping
    fun addDoll(@RequestBody doll: Doll, @RequestParam wishlistId: Long?): Doll = dollService.saveDoll(doll, wishlistId)

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
