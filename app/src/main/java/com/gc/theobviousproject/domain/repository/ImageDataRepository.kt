package com.gc.theobviousproject.domain.repository

import com.gc.theobviousproject.data.ImageData
import kotlinx.coroutines.flow.Flow


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

interface ImageDataRepository {

    suspend fun getAllImageData(): List<ImageData>
}