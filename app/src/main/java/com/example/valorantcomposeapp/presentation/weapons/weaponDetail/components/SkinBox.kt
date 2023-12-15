package com.example.valorantcomposeapp.presentation.weapons.weaponDetail.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.data.dto.weapons.Skin
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.valoTertiary
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkinBox(
    skins: List<Skin>
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Card(
        colors = CardDefaults.cardColors(
            containerColor = cupidEye
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        Column {
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                            .tabIndicatorOffset(
                                tabPositions[pagerState.currentPage]
                            )
                            .width(0.dp)
                            .height(3.dp),
                        color = azul
                    )
                },
                containerColor = cupidEye
            ) {
                skins.forEachIndexed { index, skin ->
                    val color = remember {
                        Animatable(wildApothecary)
                    }
                    LaunchedEffect(key1 = pagerState.currentPage == index) {
                        color.animateTo(if (pagerState.currentPage == index) wildApothecary else cupidEye)
                    }
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        icon = {
                            AsyncImage(
                                model = skin.displayIcon,
                                contentDescription = skin.displayName,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.size(80.dp)
                            )
                        },
                        modifier = Modifier.background(color.value)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(12.dp))

        HorizontalPager(count = skins.size, state = pagerState) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(cupidEye)
            ) {
                AsyncImage(
                    model = skins[page].displayIcon,
                    contentDescription = skins[page].displayName,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                )
                Text(
                    text = skins[page].displayName.orEmpty(),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    color = wildApothecary,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}