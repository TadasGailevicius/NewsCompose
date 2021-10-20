package com.tedm.newscompose.di

import android.content.Context
import androidx.room.Room
import com.tedm.newscompose.domain.local.HistoryItemDao
import com.tedm.newscompose.domain.local.HistoryItemDatabase
import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.domain.use_case.GetWeatherUseCase
import com.tedm.newscompose.domain.use_case.WeatherUseCases
import com.tedm.newscompose.repository.WeatherRepository
import com.tedm.newscompose.repository.WeatherRepositoryImpl
import com.tedm.newscompose.util.Constants.BASE_URL
import com.tedm.newscompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHistoryItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, HistoryItemDatabase::class.java, DATABASE_NAME)
        .allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideHistoryItemDao(db: HistoryItemDatabase) = db.historyItemDao()

    @Provides
    @Singleton
    fun provideWeatherRepository(
        dao: HistoryItemDao,
        api: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(dao, api)
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