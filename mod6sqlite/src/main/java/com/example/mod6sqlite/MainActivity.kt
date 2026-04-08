package com.example.mod6sqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6sqlite.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BooksScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BooksScreen(modifier: Modifier,viewModel: ListBooksViewModel = viewModel(factory =
    ListBooksViewModel.Factory)) {
    val books by viewModel.books.collectAsState()
    LazyColumn(modifier) {
        items(books) { book ->
            Text(text = "Name: ${book.name}, Author: ${book.author}")
        }
    }
}