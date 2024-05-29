package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/wishlists")
class WishlistController(private val wishlistService: WishlistService) {
    @GetMapping
    fun getAllWishlists(): List<Wishlist> = wishlistService.getAllWishlists()

    @PostMapping
    fun addWishlist(@RequestBody wishlist: Wishlist): Wishlist = wishlistService.saveWishlist(wishlist)

    @GetMapping("/category/{category}")
    fun getWishlistsByCategory(@PathVariable category: String): ResponseEntity<List<Wishlist>> {
        return try {
            val wishlistCategory = WishlistCategory.valueOf(category.uppercase(Locale.getDefault()))
            ResponseEntity.ok(wishlistService.getWishlistByCategory(wishlistCategory))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().build()
        }
    }
}