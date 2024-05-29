package com.monsterhighwishlist.Service

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Repositories.DollRepository
import com.monsterhighwishlist.Repositories.WishlistRepository
import org.springframework.stereotype.Service

@Service
class DollService(private val dollRepository: DollRepository, private val wishlistRepository: WishlistRepository) {

    fun getAllDolls(): List<Doll> = dollRepository.findAll()

    fun saveDoll(doll: Doll, wishlistId: Long?): Doll {
        wishlistId?.let {
            val wishlist = wishlistRepository.findById(it).orElseThrow { IllegalArgumentException("Wishlist not found") }
            doll.wishlist = wishlist
            wishlist.dolls.add(doll)
            wishlistRepository.save(wishlist)
        }
        return dollRepository.save(doll)
    }

    fun findDollsByName(name: String): List<Doll> = dollRepository.findByNameContaining(name)
}