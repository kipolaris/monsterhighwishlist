package com.monsterhighwishlist.Controllers

import com.monsterhighwishlist.Service.DollService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/dolls")
class DollController(private val dollService: DollService) {

    @GetMapping
    fun showAllDolls(model: Model): String {
        val dolls = dollService.getAllDolls()
        model.addAttribute("dolls", dolls)
        model.addAttribute("listName", "All Dolls")
        return "dolls"
    }

    @GetMapping("/search")
    fun searchDolls(@RequestParam name: String, model: Model): String {
        val dolls = dollService.findDollsByName(name)
        model.addAttribute("dolls", dolls)
        model.addAttribute("listName", "Search Results")
        return "dolls"
    }

    @PostMapping("/changeWishlist")
    fun changeWishlist(@RequestParam dollId: Long, @RequestParam wishlist: String): String {
        dollService.updateDollWishlist(dollId, wishlist)
        return "redirect:/dolls"
    }
}
