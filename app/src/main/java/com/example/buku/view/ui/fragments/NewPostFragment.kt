package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buku.databinding.FragmentNewPostBinding
import com.example.buku.model.Book
import com.example.buku.view.adapter.BooksListener


class NewPostFragment : Fragment(), BooksListener {

    private lateinit var newPostBinding: FragmentNewPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        newPostBinding = FragmentNewPostBinding.inflate(inflater,container,false)
        return newPostBinding.root
    }

    override fun onBooksClick(book: Book, position: Int) {

    }

}



