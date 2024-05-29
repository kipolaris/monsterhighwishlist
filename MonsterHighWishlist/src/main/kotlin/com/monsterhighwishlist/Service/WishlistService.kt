package com.monsterhighwishlist.Service

import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Repositories.WishlistRepository
import org.springframework.stereotype.Service

@Service
class WishlistService(private val wishlistRepository: WishlistRepository) {
    fun getAllWishlists(): List<Wishlist> = wishlistRepository.findAll()
    fun saveWishlist(wishlist: Wishlist): Wishlist = wishlistRepository.save(wishlist)
    fun getWishlistByCategory(category: WishlistCategory): List<Wishlist> = wishlistRepository.findByCategory(category)
}