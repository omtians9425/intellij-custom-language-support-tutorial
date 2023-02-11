package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.intellij.lang.Language

class SimpleLanguage private constructor(id: String) : Language(id) {

    companion object {
        val INSTANCE = SimpleLanguage("Simple")
    }
}