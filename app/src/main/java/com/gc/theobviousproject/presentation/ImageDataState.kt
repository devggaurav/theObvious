package com.gc.theobviousproject.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.gc.theobviousproject.data.ImageData


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

data class ImageDataState(
    val imagesDataList: List<ImageData> = mutableStateListOf(),
    val isLoading: Boolean = true,
    val error: String? = null

)
