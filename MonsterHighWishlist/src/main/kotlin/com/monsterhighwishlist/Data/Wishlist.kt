package com.monsterhighwishlist.Data

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
data class Wishlist(
    @jakarta.persistence.Id @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,

    @Enumerated(EnumType.STRING)
    val category: WishlistCategory,

    @OneToMany(mappedBy = "wishlist", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    val dolls: MutableList<Doll> = mutableListOf()
)


