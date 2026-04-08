package com.example.mod6sqlite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBooksViewModel(private val dbHelper: BookDbHelper) :
    ViewModel() {
    private val dao = BookDao(dbHelper.writableDatabase,
        dbHelper.readableDatabase)
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books.asStateFlow()
    init {
        viewModelScope.launch {
            insertBook(
                Book(
                    0L,
                    "La suite 33",
                    "9781408855652",
                    "19/08/2014",
                    "Bloomsburry",
                    "J.K. Rowling"
                )
            )
            insertBook(
                Book(
                    0L, "La suite 44", "1408855666", "19/08/2014",
                    "Bloomsburry",
                    "J.K. Rowling"
                )
            )
            loadBooks()
        }
    }
    //withContext nécessite le suspend
    private suspend fun loadBooks() {
        withContext(Dispatchers.IO) {
            val booksFromDb = dao.getAllBooks()
            _books.value = booksFromDb
        }
    }
    //ViewModelScope est de par nature async donc pas besoin de le précier
    //avec le mot clé suspend
    suspend fun insertBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertBook(book)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return ListBooksViewModel(
                    BookDbHelper(application.applicationContext),
                ) as T
            }
        }
    }
}
