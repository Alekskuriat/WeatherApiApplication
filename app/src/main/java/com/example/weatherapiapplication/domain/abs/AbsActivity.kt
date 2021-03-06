package com.example.popularlibraries.domain.abs

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.example.popularlibraries.domain.schedulers.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import moxy.MvpAppCompatActivity
import javax.inject.Inject


abstract class AbsActivity(
    @LayoutRes contentLayoutId: Int
) : MvpAppCompatActivity(contentLayoutId),
    HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var router : Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var schedulers: Schedulers


    override fun onCreate(savedInstanceState: Bundle?) {
            AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }


}
