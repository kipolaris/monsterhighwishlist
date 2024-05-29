package com.monsterhighwishlist.Repositories

import com.monsterhighwishlist.Data.Wishlist
import org.springframework.data.jpa.repository.JpaRepository

interface WishlistRepository : JpaRepository<Wishlist, Long> {
    fun findByCategory(category: String): List<Wishlist>
}

