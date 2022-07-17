package com.gc.theobviousproject.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.gc.theobviousproject.data.ImageData
import java.time.format.DateTimeFormatter


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

@Composable
fun ShowSwipeItem(imageData: ImageData, modifier: Modifier = Modifier, showHd: Boolean = false) {

    Box(modifier = Modifier.fillMaxSize()) {



        SubcomposeAsyncImage(
            model = imageData.hdUrl,
            contentDescription = imageData.date,
            modifier = modifier
                .fillMaxSize()
                .clickable {

                }, contentScale = ContentScale.FillBounds
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(100.dp)
                        .align(alignment = Alignment.Center),
                    strokeWidth = 5.dp

                )
            } else {
                SubcomposeAsyncImageContent()
            }

        }

         Column(modifier = Modifier.align(alignment = Alignment.TopStart)) {
             Text(
                 text = " ${imageData.title}",
                 textAlign = TextAlign.Center,
                 fontSize = 20.sp,
                 modifier = Modifier
                     .padding(start = 10.dp, top = 20.dp, end = 10.dp),
                 color = Color.White
             )

             Text(
                 text = " ${imageData.date}",
                 fontSize = 16.sp,
                 modifier = Modifier
                     .padding(start = 10.dp, top = 10.dp),
                 color = Color.White
             )

         }

        Column(modifier = Modifier.align(alignment = Alignment.BottomStart)) {
            Text(
                text = " ${imageData.explanation}",
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
                maxLines = 7,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, end = 10.dp),
                color = Color.White
            )

            imageData.copyright.let {
                Text(
                    text = "CopyRight:  ${imageData.copyright}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 30.dp),
                    color = Color.White
                )

            }


        }








    }


}