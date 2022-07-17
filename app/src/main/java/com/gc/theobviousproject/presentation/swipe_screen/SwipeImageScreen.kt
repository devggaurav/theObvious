package com.gc.theobviousproject.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwipeImages(
    imagesViewModel: ImagesViewModel = hiltViewModel(),
    navController: NavController,
    position: Int? = 0
) {

    val state = imagesViewModel.state

    val imageList = state.imagesDataList

    val pagerState = rememberPagerState()

    val scope = rememberCoroutineScope()



    HorizontalPager(count = imageList.size, state = pagerState) { page ->

        ShowSwipeItem(imageData = imageList[page], modifier = Modifier.fillMaxSize())


    }

    scope.launch {
        pagerState.animateScrollToPage(position!!)
    }


}