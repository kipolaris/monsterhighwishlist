package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Data.Doll
import com.monsterhighwishlist.Service.DollService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/dolls")
class DollController(private val dollService: DollService) {
    @GetMapping
    fun getAllDolls(): List<Doll> = dollService.getAllDolls()

    @PostMapping
    fun addDoll(@RequestBody doll: Doll, @RequestParam wishlistId: Long?): Doll = dollService.saveDoll(doll, wishlistId)

    @GetMapping("/search")
    fun searchDolls(@RequestParam name: String): List<Doll> = dollService.findDollsByName(name)
}