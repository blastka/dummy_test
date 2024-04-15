package com.example.dummy.presentation

import com.example.dummy.data.ProductApiService
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Singleton
@Component(modules = [NetWorkModule::class])
interface AppComponent{
    fun inject(activity: MainActivity)
}

@Module
object NetWorkModule{

    @Singleton
    @Provides
    fun provideProductRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ProductApiService {
        return retrofit.create(ProductApiService::class.java)
    }
}