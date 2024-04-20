package com.example.albionmarket.presentation.screen.mainScreen

import androidx.lifecycle.ViewModel
import com.example.albionmarket.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel@Inject constructor(
    private val repositoryImpl: RepositoryImpl
    ) : ViewModel()  {

//    val albionItems = Pager(
//        config = PagingConfig(
//            pageSize = 20,
//            prefetchDistance = 5
//        ),
//        pagingSourceFactory = { repository.pagingData() }
//    ).flow.cachedIn(viewModelScope)

}