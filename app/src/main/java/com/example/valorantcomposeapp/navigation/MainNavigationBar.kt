package com.example.valorantcomposeapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.radiant
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@Composable
fun MainNavigationBar(
    navController: NavHostController
) {

    val items = listOf(
        NavItem.Agents,
        NavItem.Maps,
        NavItem.Weapons,
        NavItem.Tiers
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = cupidEye
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route)
                },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = wildApothecary,
                    unselectedIconColor = radiant,
                    selectedTextColor = wildApothecary,
                    unselectedTextColor = radiant
                )
            )
        }
    }
}