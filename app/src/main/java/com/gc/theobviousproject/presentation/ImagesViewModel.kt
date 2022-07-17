package com.gc.theobviousproject.presentation

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gc.theobviousproject.data.ImageData
import com.gc.theobviousproject.domain.repository.ImageDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//
@HiltViewModel
class ImagesViewModel @Inject constructor(private val repository: ImageDataRepository) :
    ViewModel() {


    var state by mutableStateOf(ImageDataState())
        private set


    init {
        viewModelScope.launch {
            val imageList = repository.getAllImageData()
            state = state.copy(
                imagesDataList = imageList,
                isLoading = false,
            )

        }

    }


}