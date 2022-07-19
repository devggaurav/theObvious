package com.gc.theobviousproject.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.gc.theobviousproject.data.ImageData
import com.gc.theobviousproject.utils.Routes


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

@Composable
fun ShowGridItem(imageData: ImageData, navController: NavController, position: Int = 0) {


    SubcomposeAsyncImage(
        model = imageData.url,
        contentDescription = imageData.date,
        modifier = Modifier
            .size(200.dp)
            .clickable {
                navController.navigate("${Routes.SWIPE_SCREEN}/$position")
            }, contentScale = ContentScale.FillBounds
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(45.dp),
                strokeWidth = 5.dp

            )
        } else {
            SubcomposeAsyncImageContent()
        }

    }


}