package com.kimbh.poke_data_remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kimbh.poke_sdk_data.model.PokeListDTO

class PokePagingSource(
    private val pokeDataSource: PokeDataSource
) : PagingSource<String, PokeListDTO>() {
    override fun getRefreshKey(state: PagingState<String, PokeListDTO>): String? {
        // 가장 최근 스크롤 위치 기준으로 refresh key
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PokeListDTO> {
        return try {
            val url = params.key ?: "https://pokeapi.co/api/v2/pokemon?offset=0&limit=20"
            val response = pokeDataSource.pokeList(url)
            val nextKey = response.body()?.next

            if (response.isSuccessful) {
                response.body()?.let { data ->

                    LoadResult.Page(
                        data = data.results.map { PokeListDTO(it.name, it.url) },
                        prevKey = null,
                        nextKey = nextKey
                    )
                } ?: let {
                    LoadResult.Error(Throwable("No Response"))
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "No Response"
                LoadResult.Error(Throwable(errorMessage))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}