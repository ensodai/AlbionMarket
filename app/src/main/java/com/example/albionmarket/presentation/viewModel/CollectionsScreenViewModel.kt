package com.example.albionmarket.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.albionmarket.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionsScreenViewModel@Inject constructor(repository: Repository): ViewModel() {
}