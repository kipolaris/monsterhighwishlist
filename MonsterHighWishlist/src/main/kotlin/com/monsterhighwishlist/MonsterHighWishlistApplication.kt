package com.monsterhighwishlist

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Data.Wishlist
import com.monsterhighwishlist.Data.WishlistCategory
import com.monsterhighwishlist.Service.DollService
import com.monsterhighwishlist.Service.WishlistService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

@SpringBootApplication
class MonsterHighWishlistApplication(private val wishlistService: WishlistService, private val dollService: DollService) :
    ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        // Initialize some sample data when the application starts
        val wishlist = Wishlist(name = "My Wishlist", category = WishlistCategory.WISHLIST)
        wishlistService.saveWishlist(wishlist)

        val clawdeenWolf = Doll(name = "Clawdeen Wolf", imageUrl = "https://example.com/doll1.jpg")
        val draculaura = Doll(name = "Draculaura", imageUrl = "https://example.com/doll2.jpg")

        dollService.saveDoll(clawdeenWolf)
        dollService.saveDoll(draculaura)
    }
}

fun main(args: Array<String>) {
    runApplication<MonsterHighWishlistApplication>(*args)
}