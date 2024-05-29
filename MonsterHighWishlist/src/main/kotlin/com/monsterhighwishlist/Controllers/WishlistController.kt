package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/wishlists")
class WishlistController(private val wishlistService: WishlistService) {
    @GetMapping
    fun getAllWishlists(): List<Wishlist> = wishlistService.getAllWishlists()

    @PostMapping
    fun addWishlist(@RequestBody wishlist: Wishlist): Wishlist = wishlistService.saveWishlist(wishlist)

    @GetMapping("/category/{category}")
    fun getWishlistsByCategory(@PathVariable category: String): List<Wishlist> = wishlistService.getWishlistByCategory(category)
}