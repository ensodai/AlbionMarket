package com.example.albionmarket.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.albionmarket.data.database.albionItem.AlbionItemDescription
import com.example.albionmarket.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainSearchScreenViewModel @Inject constructor
    (private val repository: Repository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private var _description = MutableStateFlow("")
    val description = _description.asStateFlow()

    val albionItems = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 5
        ),
        pagingSourceFactory = { repository.pagingData() }
    ).flow.cachedIn(viewModelScope)


    init {
        getAlbionData()
    }

    fun getItemDescription(itemName: String, locale: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val itemDescription = repository.getItemDescription(itemName)
                val localizedDescription = itemDescription?.let { getLocalizedDescription(it, locale) }
                if (localizedDescription != null)
                    _description.value = localizedDescription
            }
        }
    }
    private fun getLocalizedDescription(itemDescription: AlbionItemDescription, locale: String): String? {
        return when (locale) {
            "DE-DE" -> itemDescription.dEDE
            "EN-US" -> itemDescription.eNUS
            "ES-ES" -> itemDescription.eSES
            "FR-FR" -> itemDescription.fRFR
            "ID-ID" -> itemDescription.iDID
            "IT-IT" -> itemDescription.iTIT
            "JA-JP" -> itemDescription.jAJP
            "KO-KR" -> itemDescription.kOKR
            "PL-PL" -> itemDescription.pLPL
            "PT-BR" -> itemDescription.pTBR
            "RU-RU" -> itemDescription.rURU
            "ZH-CN" -> itemDescription.zHCN
            "ZH-TW" -> itemDescription.zHTW
            else -> null
        }
    }

    fun getAlbionData() {
        _isLoading.value = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    repository.getAlbionData()
                    _isLoading.value = false
                } catch (e: Exception) {
                    Log.d("FAIL", e.toString())
                }
            }
        }
    }

    fun clearDatabase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.clearDatabase()
            }
        }
    }

}