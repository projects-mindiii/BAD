package com.bad.data

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 *
 * It would be top layer for any network response
 * That will help with observers to identify network call status
 * */

class Resource<out T> private constructor(val status: Status, val message: String? = null, val data: T? = null) {

    /**
     * Enum for resource ype
     * */
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        /**
         * Create a successful resource of type T
         *
         * @param data
         * @return Resource<T>
         * */
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data = data)
        }

        /**
         * Create a successful resource of type T and message
         *
         * @param data
         * @param message
         * @return Resource<T>
         * */
        fun <T> success(data: T?, message: String?): Resource<T> {
            return Resource(Status.SUCCESS, message = message, data = data)
        }

        /**
         * Create an error resource of type T
         *
         * @param data
         * @return Resource<T>
         * */
        fun <T> error(data: T?): Resource<T> {
            return Resource(Status.ERROR, data = data)
        }

        /**
         * Create an error resource of type T
         *
         * @param message
         * @return Resource<T>
         * */
        fun <T> error(message: String?): Resource<T> {
            return Resource(Status.ERROR, message = message)
        }

        /**
         * Create an error resource of type T and message
         *
         * @param data
         * @param message
         * @return Resource<T>
         * */
        fun <T> error(data: T?, message: String?): Resource<T> {
            return Resource(Status.ERROR, message = message, data = data)
        }

        /**
         * Create a loading resource of type T
         * */
        fun <T> loading(): Resource<T> = Resource(Status.LOADING)
    }
}