package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (Boolean) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = { onQueryChange(it) },
        onSearch = { onSearch(false) },
        active = false,
        onActiveChange = { onActiveChange(false) },
        modifier = modifier,
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Tune,
                    contentDescription = null
                )
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
        }
    ) {

    }
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(top = 11.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = null,
        )
    }
}