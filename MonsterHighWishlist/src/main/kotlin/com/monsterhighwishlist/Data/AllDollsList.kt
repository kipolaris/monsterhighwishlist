package com.monsterhighwishlist.Data

import jakarta.persistence.*

@Entity
data class AllDollsList(
    @Id
    val id: Long = 1L,

    @OneToMany(mappedBy = "allDollsList", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    val dolls: MutableList<Doll> = mutableListOf()
)
