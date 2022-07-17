package com.gc.theobviousproject.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.gc.theobviousproject.data.ImageData
import dagger.hilt.android.lifecycle.HiltViewModel


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowImagesGrid(
    imagesViewModel: ImagesViewModel = hiltViewModel(),
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = imagesViewModel.state

        val allImages: List<ImageData> = state.imagesDataList

        LazyVerticalGrid(
            cells = GridCells.Adaptive(110.dp),
            contentPadding = PaddingValues()
        ) {
            items(allImages.size) { imagePosition ->
                val imageData = allImages[imagePosition]
                ShowGridItem(imageData = imageData, navController,imagePosition)


            }


        }


    }


}