package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.intellij.lexer.FlexAdapter

class SimpleLexerAdapter : FlexAdapter(SimpleLexer(null))