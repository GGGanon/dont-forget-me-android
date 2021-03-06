package com.csming.dontforgetme.repository.impl

import com.csming.dontforgetme.api.BookApi
import com.csming.dontforgetme.api.DailyApi
import com.csming.dontforgetme.common.model.BookModel
import com.csming.dontforgetme.common.model.RecordingModel
import com.csming.dontforgetme.common.model.UserModel
import com.csming.dontforgetme.repository.BookRepository
import io.reactivex.Observer
import java.util.*
import javax.inject.Inject

/**
 * @author Created by csming on 2018/10/4.
 */
class BookRepositoryImpl @Inject constructor(
        private val bookApi: BookApi,
        private val dailyApi: DailyApi
) : BookRepository {


    override fun getBooks(token: String, observer: Observer<List<BookModel>?>) {
//        bookApi.getBooks(token)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer)

        val list = ArrayList<BookModel>(2)
        list.add(BookModel(
                owner = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                name = "喵子",
                cover = "",
                description = "云吸猫日记吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸",
                createTime = Date(1547727788791)
        ))
        list.add(BookModel(
                owner = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                name = "日常",
                cover = "",
                description = "吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸 嗝~~~",
                createTime = Date(1461500588791)
        ))
        observer.onNext(list)
    }

    override fun getDailies(token: String, observer: Observer<List<RecordingModel>?>) {
//        dailyApi.getDailies(token)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer)

        val list = ArrayList<RecordingModel>(2)
        list.add(RecordingModel(
                auther = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                book = BookModel(
                        owner = null,
                        name = "喵子",
                        cover = "",
                        description = "云吸猫日记吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸",
                        createTime = Date(1547727788791)
                ),
                text = "吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸 ",
                images = null,
                createTime = Date(1547727788791)
        ))

        list.add(RecordingModel(
                auther = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                book = BookModel(
                        owner = null,
                        name = "喵子",
                        cover = "",
                        description = "云吸猫日记吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸",
                        createTime = Date(1547727788791)
                ),
                text = "狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸",
                images = null,
                createTime = Date(1547727788791)
        ))
        observer.onNext(list)
    }

    override fun getDailies(token: String, bookName: String, observer: Observer<List<RecordingModel>?>) {
        //        dailyApi.getDailies(token)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer)

        val list = ArrayList<RecordingModel>(2)
        list.add(RecordingModel(
                auther = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                book = BookModel(
                        owner = null,
                        name = "喵子",
                        cover = "",
                        description = "云吸猫日记吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸",
                        createTime = Date(1547727788791)
                ),
                text = "吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸 ",
                images = null,
                createTime = Date(1547727788791)
        ))

        list.add(RecordingModel(
                auther = UserModel(
                        "",
                        "少棉",
                        "",
                        ""
                ),
                book = BookModel(
                        owner = null,
                        name = "喵子",
                        cover = "",
                        description = "云吸猫日记吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸吸",
                        createTime = Date(1547727788791)
                ),
                text = "狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸狂吸",
                images = null,
                createTime = Date(1547727788791)
        ))
        observer.onNext(list)
    }

}