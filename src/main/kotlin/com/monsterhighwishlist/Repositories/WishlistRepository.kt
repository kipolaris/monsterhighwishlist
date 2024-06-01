package com.monsterhighwishlist.Repositories

import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Data.WishlistCategory
import org.springframework.data.jpa.repository.JpaRepository

interface WishlistRepository : JpaRepository<Wishlist, Long> {
    fun findByCategory(category: WishlistCategory): List<Wishlist>
    fun findByName(name: String): Wishlist?
}

