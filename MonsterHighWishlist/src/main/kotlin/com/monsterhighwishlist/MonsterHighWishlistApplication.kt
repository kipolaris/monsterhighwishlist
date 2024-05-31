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
        val frankieStein = Doll(name = "Frankie Stein", imageUrl = "/dolls/frankienewnobg.png")
        val cleoDeNyle = Doll(name = "Cleo De Nyle", imageUrl = "/dolls/cleodenylenobg.png")
        val lagoonaBlue = Doll(name = "Lagoona Blue", imageUrl = "/dolls/lagoonabluenobg.png")
        val venusMcFlytrap = Doll(name = "Venus McFlytrap", imageUrl = "/dolls/venusmcflytrapnobg.png")
        val torelaiStripe = Doll(name = "Torelai Stripe", imageUrl = "/dolls/toraleistripenobg.png")
        val abbeyBominable = Doll(name = "Abbey Bominable", imageUrl = "/dolls/abbeybominablenobg.png")

        dollService.saveDoll(clawdeenWolf)
        dollService.saveDoll(draculaura)
        dollService.saveDoll(frankieStein)
        dollService.saveDoll(cleoDeNyle)
        dollService.saveDoll(lagoonaBlue)
        dollService.saveDoll(venusMcFlytrap)
        dollService.saveDoll(torelaiStripe)
        dollService.saveDoll(abbeyBominable)
    }
}

fun main(args: Array<String>) {
    runApplication<MonsterHighWishlistApplication>(*args)
}