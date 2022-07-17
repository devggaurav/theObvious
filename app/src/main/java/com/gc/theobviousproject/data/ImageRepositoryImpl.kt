package com.gc.theobviousproject.data

import android.content.Context
import com.gc.theobviousproject.domain.repository.ImageDataRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

class ImageRepositoryImpl(private val context: Context) : ImageDataRepository {

    override suspend fun getAllImageData(): List<ImageData> {

        lateinit var imageString: String
        try {
            imageString = context.assets.open("data.json").bufferedReader().use {
                it.readText()
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        val listImages = object : TypeToken<List<ImageData>>() {}.type
        return Gson().fromJson(imageString, listImages)
    }


}