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

        val clawdeenWolf = Doll(name = "Clawdeen Wolf", imageUrl = "/dolls/clawdeenwolf.png")
        val draculaura = Doll(name = "Draculaura", imageUrl = "/dolls/draculaura.png")
        val frankieStein = Doll(name = "Frankie Stein", imageUrl = "/dolls/frankiestein.png")
        val cleoDeNyle = Doll(name = "Cleo de Nyle", imageUrl = "/dolls/cleodenyle.png")
        val lagoonaBlue = Doll(name = "Lagoona Blue", imageUrl = "/dolls/lagoonablue.png")
        val venusMcFlytrap = Doll(name = "Venus McFlytrap", imageUrl = "/dolls/venusmcflytrap.png")
        val torelaiStripe = Doll(name = "Torelai Stripe", imageUrl = "/dolls/toraleistripe.png")
        val abbeyBominable = Doll(name = "Abbey Bominable", imageUrl = "/dolls/abbeybominable.png")

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