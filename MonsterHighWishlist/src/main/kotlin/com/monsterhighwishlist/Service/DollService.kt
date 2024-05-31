package com.monsterhighwishlist.Service

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Repositories.DollRepository
import com.monsterhighwishlist.Repositories.WishlistRepository
import org.springframework.stereotype.Service

@Service
class DollService(private val dollRepository: DollRepository, private val wishlistRepository: WishlistRepository) {

    fun getAllDolls(): List<Doll> = dollRepository.findAll()

    fun saveDoll(doll: Doll, wishlistId: Long? = null, allDollsListId: Long = 1L): Doll {
        if (wishlistId != null) {
            val wishlist = wishlistRepository.findById(wishlistId).orElseThrow { IllegalArgumentException("Wishlist not found") }
            doll.wishlist = wishlist
            wishlist.dolls.add(doll)
            wishlistRepository.save(wishlist)
        }
        return dollRepository.save(doll)
    }

    fun findDollsByName(name: String): List<Doll> = dollRepository.findByNameContaining(name)

    fun updateDollWishlist(dollId: Long, wishlistName: String) {
        val doll = dollRepository.findById(dollId).orElseThrow { Exception("Doll not found") }
        val wishlist = wishlistRepository.findByName(wishlistName)
        doll.wishlist = wishlist
        dollRepository.save(doll)
    }

}