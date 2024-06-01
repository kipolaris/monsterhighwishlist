package com.monsterhighwishlist.Repositories

import com.monsterhighwishlist.Data.Doll
import org.springframework.data.jpa.repository.JpaRepository

interface DollRepository : JpaRepository<Doll, Long> {
    fun findByNameContaining(name: String): List<Doll>
}