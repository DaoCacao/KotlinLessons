package com.example.localremotestorage

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.localremotestorage.databinding.ActivityMainBinding
import com.google.gson.annotations.SerializedName
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var localStorage: LocalStorage
    lateinit var remoteStorage: RemoteStorage

    var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        localStorage = LocalStorage(getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE))
        remoteStorage = RemoteStorage()
        value = localStorage.getValue()

        setContentView(binding.root)

        binding.editValue.setText(value)
        binding.editValue.doAfterTextChanged {
            value = it.toString()
        }
        binding.buttonSave.setOnClickListener {
            localStorage.saveValue(value)

            remoteStorage.getAllFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { binding.progress.isVisible = true }
                .subscribe(
                    { response ->
                        binding.progress.isVisible = false
                        binding.textFilms.text = response.results.joinToString(separator = "\n") { it.title }
                    },
                    {
                        binding.progress.isVisible = false
                        binding.textFilms.text = it.message ?: it.toString()
                    },
                )
        }
    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "shared_preferences"
    }
}


class LocalStorage(
    private val sharedPreferences: SharedPreferences,
) {

    fun getValue(): String = sharedPreferences.getString(KEY_UNIQUE_VALUE, "")!!
    fun saveValue(value: String) = sharedPreferences.edit { putString(KEY_UNIQUE_VALUE, value) }

    companion object {
        const val KEY_UNIQUE_VALUE = "unique_value"
    }
}

class RemoteStorage {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                .build()
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: StarWarsService = retrofit.create(StarWarsService::class.java)

    fun getAllFilms() = service.getAllFilms()
}

interface StarWarsService {
    @GET("films/")
    fun getAllFilms(): Single<BaseRaw<List<FilmRaw>>>
}

data class BaseRaw<R>(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: R,
)

data class FilmRaw(
    @SerializedName("episode_id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("director") val director: String,
)
