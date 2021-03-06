package com.piapps.flashcardpro.features.main.interactor

import com.piapps.flashcardpro.core.db.DatabaseRepository
import com.piapps.flashcardpro.features.main.entity.SetView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

/**
 * Created by abduaziz on 2019-09-27 at 23:30.
 */

class GetTrashSets
@Inject constructor(private val repository: DatabaseRepository) {
    operator fun invoke(onResult: (ArrayList<SetView>) -> Unit = {}) {
        doAsync {
            val result = repository.getTrashSets()
            val list = arrayListOf<SetView>()
            result.forEach {
                list.add(it.toSetView())
            }
            uiThread {
                onResult(list)
            }
        }
    }
}