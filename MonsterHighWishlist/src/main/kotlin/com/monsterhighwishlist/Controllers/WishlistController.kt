package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/wishlists")
class WishlistThymeleafController(private val wishlistService: WishlistService) {

    @GetMapping
    fun showAllWishlists(model: Model): String {
        val wishlists = wishlistService.getAllWishlists()
        model.addAttribute("wishlists", wishlists)
        return "wishlists" // The name of the Thymeleaf template file (wishlists.html)
    }

    @GetMapping("/category/{category}")
    fun showWishlistsByCategory(@PathVariable category: String, model: Model): String {
        val wishlistCategory = WishlistCategory.valueOf(category.uppercase(Locale.getDefault()))
        val wishlists = wishlistService.getWishlistByCategory(wishlistCategory)
        model.addAttribute("wishlists", wishlists)
        return "wishlists" // The name of the Thymeleaf template file (wishlists.html)
    }
}
