package com.monsterhighwishlist.Repositories

import com.monsterhighwishlist.Data.AllDollsList
import org.springframework.data.jpa.repository.JpaRepository

interface AllDollsListRepository : JpaRepository<AllDollsList, Long> {
    // Define additional methods for managing AllDollsList entities if needed
}