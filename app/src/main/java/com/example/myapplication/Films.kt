package com.example.myapplication



sealed class Films{
    class BLOCK_ONE (var imagedrawable:Int, var title:String, var datacrete:Int, val genre:String):Films()
    class BLOCK_TWO (val imagedrawable:Int, val title:String, val datacrete:Int, val genre:String):Films()
}
