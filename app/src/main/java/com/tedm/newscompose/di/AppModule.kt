package com.tedm.newscompose.di

import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.domain.use_case.GetWeatherUseCase
import com.tedm.newscompose.domain.use_case.WeatherUseCases
import com.tedm.newscompose.repository.WeatherRepository
import com.tedm.newscompose.repository.WeatherRepositoryImpl
import com.tedm.newscompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCases(repository: WeatherRepository): WeatherUseCases {
        return WeatherUseCases(
            getWeather = GetWeatherUseCase(repository = repository)
        )
    }


}