package com.gc.theobviousproject.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

data class ImageData(
    @SerializedName("copyright")
    @Expose val copyright : String? = null,
    @SerializedName("date")
    @Expose val date: String,
    @SerializedName("explanation")
    @Expose val explanation: String,
    @SerializedName("hdurl")
    @Expose val hdUrl: String,
    @SerializedName("media_type")
    @Expose val mediaType: String,
    @SerializedName("service_version")
    @Expose val serviceVersion: String,
    @SerializedName("title")
    @Expose val title: String,
    @SerializedName("url")
    @Expose val url: String
)
