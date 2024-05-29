package com.monsterhighwishlist.Data

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
data class Doll(
    @jakarta.persistence.Id @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val imageUrl: String,

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    var wishlist: Wishlist? = null,

    @ManyToOne
    @JoinColumn(name = "all_dolls_list_id")
    var allDollsList: AllDollsList? = null
)


