package com.gc.theobviousproject.di

import android.content.Context
import com.gc.theobviousproject.data.ImageRepositoryImpl
import com.gc.theobviousproject.domain.repository.ImageDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//
// Created by Gaurav on 17/07/22.
// Copyright (c) 2022 GC. All rights reserved.
//

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideImageDataRepository(@ApplicationContext context: Context): ImageDataRepository {
        return ImageRepositoryImpl(context)
    }


}