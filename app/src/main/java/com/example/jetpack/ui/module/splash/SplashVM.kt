package com.example.jetpack.ui.module.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.data.database.dao.PostDao
import com.example.jetpack.data.model.PostDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    private val postDao: PostDao,
) : ViewModel() {

    init {
        savePosts()
    }

    private fun savePosts() {
        viewModelScope.launch {
            postDao.deleteAll()
            val list = arrayListOf<PostDTO>()
            for (i in 1..100) {
                list.add(PostDTO(i, "Title $i", "Description $i", ""))
            }
            postDao.insert(list)
        }
    }

}