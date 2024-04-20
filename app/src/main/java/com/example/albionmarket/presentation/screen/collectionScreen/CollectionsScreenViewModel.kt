package com.example.albionmarket.presentation.screen.collectionScreen

import androidx.lifecycle.ViewModel
import com.example.albionmarket.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionsScreenViewModel@Inject constructor(repositoryImpl: RepositoryImpl): ViewModel() {
}