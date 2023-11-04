package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.albionmarket.presentation.viewModel.MainSearchScreenViewModel

@Composable
fun MainSearchScreen(
    locale: String
) {

    val viewModel = hiltViewModel<MainSearchScreenViewModel>()
    val loadingState by viewModel.isLoading.collectAsState()
    val itemsList by rememberUpdatedState(viewModel.albionItems.collectAsLazyPagingItems())
    val lazyColumnState = rememberLazyListState()
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }


    Scaffold(
        modifier = Modifier
            .padding(horizontal = 11.dp),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TopSearchBar(
                    query = query,
                    onQueryChange = {
                        query = it
                    },
                    onSearch = {
                        active = false
                    },
                    onActiveChange = { active = false },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    ) { topPaddingValues ->
        Column(
            modifier = Modifier.padding(
                top = topPaddingValues.calculateTopPadding()
            )
        ) {
            CityInfoBar(loadingState)
            LazyColumn(
                state = lazyColumnState
            ) {
                items(
                    count = itemsList.itemCount,
                ) { index ->
                    val item = itemsList[index]
                    ContentForItem(
                        itemsList = item,
                        locale = locale
                    )
                }
            }
        }
    }
}