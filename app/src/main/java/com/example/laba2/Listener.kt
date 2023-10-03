package com.example.laba2

interface Listener<T: IParam> {
    fun onClick(param: T)
}
interface IParam