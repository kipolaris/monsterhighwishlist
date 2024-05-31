package com.monsterhighwishlist

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Service.DollService
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

@SpringBootApplication
@EntityScan("com.monsterhighwishlist.Data")
class MonsterHighWishlistApplication(private val wishlistService: WishlistService, private val dollService: DollService) :
    ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        // Initialize some sample data when the application starts
        val wishlist = Wishlist(name = "wishlist", category = WishlistCategory.WISHLIST)
        val considering = Wishlist(name = "considering", category = WishlistCategory.CONSIDERING)
        val alreadySecured = Wishlist(name = "already-secured", category = WishlistCategory.ALREADY_SECURED)
        wishlistService.saveWishlist(wishlist)
        wishlistService.saveWishlist(considering)
        wishlistService.saveWishlist(alreadySecured)

        val clawdeenWolf = Doll(name = "Clawdeen Wolf", imageUrl = "/dolls/clawdeennobg.png")
        val draculaura = Doll(name = "Draculaura", imageUrl = "/dolls/draculauranobg.png")
        val frankieStein = Doll(name = "FrankieStein", imageUrl = "/dolls/frankienobg.png")

        dollService.saveDoll(clawdeenWolf)
        dollService.saveDoll(draculaura)
        dollService.saveDoll(frankieStein)
    }
}

fun main(args: Array<String>) {
    runApplication<MonsterHighWishlistApplication>(*args)
}