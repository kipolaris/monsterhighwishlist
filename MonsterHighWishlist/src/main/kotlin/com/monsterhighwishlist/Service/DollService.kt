package com.monsterhighwishlist.Service

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Repositories.AllDollsListRepository
import com.monsterhighwishlist.Repositories.DollRepository
import com.monsterhighwishlist.Repositories.WishlistRepository
import org.springframework.stereotype.Service

@Service
class DollService(private val dollRepository: DollRepository, private val wishlistRepository: WishlistRepository, private val allDollsListRepository: AllDollsListRepository) {

    fun getAllDolls(): List<Doll> = dollRepository.findAll()

    fun saveDoll(doll: Doll, wishlistId: Long? = null, allDollsListId: Long = 1L): Doll {
        if (wishlistId != null) {
            val wishlist = wishlistRepository.findById(wishlistId).orElseThrow { IllegalArgumentException("Wishlist not found") }
            doll.wishlist = wishlist
            wishlist.dolls.add(doll)
            wishlistRepository.save(wishlist)
        }
        val allDollsList = allDollsListId.let { allDollsListRepository.findById(it).orElseThrow { IllegalArgumentException("AllDollsList not found") } }
        doll.allDollsList = allDollsList
        return dollRepository.save(doll)
    }

    fun findDollsByName(name: String): List<Doll> = dollRepository.findByNameContaining(name)
}