package com.example.valorantcomposeapp.presentation.agents.agentDetail.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.data.dto.agents.Ability
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.radiant
import com.example.valorantcomposeapp.presentation.ui.theme.valoTertiary
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AgentAbilityItem(
    abilities: List<Ability>
) {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Card(
        colors = CardDefaults.cardColors(
            containerColor = cupidEye
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        Column {
            TabRow(selectedTabIndex = pagerState.currentPage,
                containerColor = cupidEye,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .tabIndicatorOffset(
                                tabPositions[pagerState.currentPage]
                            )
                            .width(0.dp)
                            .height(0.dp)
                    )
                }
            ) {
                abilities.forEachIndexed { index, ability ->
                    val color = remember {
                        Animatable(wildApothecary)
                    }
                    LaunchedEffect(key1 = pagerState.currentPage == index) {
                        color.animateTo(if (pagerState.currentPage == index) wildApothecary else cupidEye)
                    }
                    Tab(
                        icon = {
                            AsyncImage(
                                model = ability.displayIcon,
                                contentDescription = ability.description,
                                contentScale = ContentScale.Fit,
                                colorFilter = if (pagerState.currentPage == index) ColorFilter.tint(
                                    cupidEye
                                ) else ColorFilter.tint(valoTertiary),
                                modifier = Modifier.size(32.dp)
                            )
                        },
                        selected = pagerState.currentPage == index,
                        modifier = Modifier
                            .background(color = color.value),
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        HorizontalPager(count = abilities.size, state = pagerState) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = abilities[page].displayName.orEmpty(), style = TextStyle(
                        fontSize = 20.sp
                    )
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = abilities[page].description.orEmpty(), style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}