package com.example.quickmathsafeargs.di

import com.example.quickmath.util.Constants
import com.example.quickmathsafeargs.remote.ApiService
import com.example.quickmathsafeargs.repo.Repository
import com.example.quickmathsafeargs.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesApisService(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryImpl(apiService: ApiService): Repository = RepositoryImpl(apiService)
}
