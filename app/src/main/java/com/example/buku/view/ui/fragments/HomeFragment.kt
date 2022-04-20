package com.example.buku.view.ui.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Book
import com.example.buku.model.BookList
import com.example.buku.model.Category
import com.example.buku.view.adapter.BooksAdapter
import com.example.buku.view.adapter.CategoriesAdapter
import com.google.gson.Gson



class HomeFragment : Fragment() {

    private lateinit var listBooks: ArrayList<Book>
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var booksRecyclerView: RecyclerView

    private lateinit var listCategories: ArrayList<Category>
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var categoriesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        booksRecyclerView = requireView().findViewById(R.id.rvBooksHome)
        listBooks = loadMockBooksFromJason()
        booksAdapter = BooksAdapter(listBooks)

        booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = BooksAdapter(listBooks)
            setHasFixedSize(false)
        }

        categoriesRecyclerView = requireView().findViewById(R.id.rvCategoriesHome)
        listCategories = createMockCategories()
        categoriesAdapter = CategoriesAdapter(listCategories)

        categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = CategoriesAdapter(listCategories)
            setHasFixedSize(false)
        }
    }

    private fun loadMockBooksFromJason(): ArrayList<Book> {
        val booksString: String =
            activity?.applicationContext?.assets?.open("books.json")?.bufferedReader()
                .use { it!!.readText() }
        val gson = Gson()
        return gson.fromJson(booksString, BookList::class.java)

    }


    private fun createMockCategories(): ArrayList<Category> {
        return arrayListOf(
            Category(name = "Novels"),
            Category(name = "Comics"),
            Category(name = "Statistics"),
            Category(name = "Thriller"),
            Category(name = "Science Fiction"),
            Category(name = "Kids"),
        )
    }
}