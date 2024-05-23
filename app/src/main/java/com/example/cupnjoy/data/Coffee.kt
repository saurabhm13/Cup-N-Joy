package com.example.cupnjoy.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val ratingCount: Int,
    val image: String
): Parcelable

val coffeeList = listOf(
    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = "https://images.unsplash.com/photo-1507133750040-4a8f57021571?q=80&w=3687&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),

    Coffee(
        name = "Drizzled with Caramel",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 12.99,
        rating = 4.1,
        ratingCount = 123,
        image = "https://images.unsplash.com/photo-1574914629364-12e5ef9a6d6d?q=80&w=3687&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),

    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = "https://images.unsplash.com/photo-1621135177072-57c9b6242e7a?q=80&w=3687&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),

    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = "https://images.unsplash.com/photo-1615324606695-afaaf3a8554e?q=80&w=3474&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
)
