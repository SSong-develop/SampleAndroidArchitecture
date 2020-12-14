package com.example.samplemvc.model

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.jvm.Throws

class Model(lifecycle: Lifecycle) : Observable() , LifecycleObserver {
    // Int형 리스트 선언
    val list : MutableList<Int>

    // list 초기화
    init {
        lifecycle.addObserver(this)

        // 리스트 크기 할당
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(_index : Int) : Int{
        return list[_index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(_index: Int){
        list[_index] = list[_index] + 1 // 특정 index의 리스트 값을 1 증가
        setChanged() // list안의 데이터가 변경되었음을 알려줌
        notifyObservers() // observer에게도 알려줌
    }

    // SharedPreference or Room Database에서 값을 가져온다면 이와 같은 방법으로 가져오면 될 것 같다.
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun saveValueAtSharedPref(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun emitValueAtSharedPref(){

    }

}