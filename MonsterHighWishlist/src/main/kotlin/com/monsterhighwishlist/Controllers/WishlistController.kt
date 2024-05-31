package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/wishlists")
class WishlistController(private val wishlistService: WishlistService) {

    @GetMapping("/wishlist")
    fun showWishlist(model: Model): String {
        val wishlists = wishlistService.getWishlistByCategory(WishlistCategory.WISHLIST)
        model.addAttribute("dolls", wishlists.flatMap { it.dolls })
        model.addAttribute("listName", "Wishlist")
        return "wishlist"
    }

    @GetMapping("/considering")
    fun showConsidering(model: Model): String {
        val considering = wishlistService.getWishlistByCategory(WishlistCategory.CONSIDERING)
        model.addAttribute("dolls", considering.flatMap { it.dolls })
        model.addAttribute("listName", "Considering")
        return "considering"
    }

    @GetMapping("/already-secured")
    fun showAlreadySecured(model: Model): String {
        val alreadySecured = wishlistService.getWishlistByCategory(WishlistCategory.ALREADY_SECURED)
        model.addAttribute("dolls", alreadySecured.flatMap { it.dolls })
        model.addAttribute("listName", "Already Secured")
        return "already-secured"
    }
}
