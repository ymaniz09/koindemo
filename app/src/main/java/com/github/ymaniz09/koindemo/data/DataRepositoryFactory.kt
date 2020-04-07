package com.github.ymaniz09.koindemo.data

class DataRepositoryFactory(
    private val localDataSource: DataRepository,
    private val remoteDataSource: DataRepository
) {

    fun retrieveRemoteSource(): DataRepository {
        return remoteDataSource
    }

    fun retrieveLocalSource(): DataRepository {
        return localDataSource
    }
}