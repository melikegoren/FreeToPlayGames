package com.example.freetoplaygames.common

/**sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data = data)
}**/
sealed class Resource<out T : Any> {
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val result: T?) : Resource<T>()
    data class Error(val exception: String?) : Resource<Nothing>()
}