package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleLanguage
import com.intellij.psi.tree.IElementType

class SimpleElementType(debugName: String) : IElementType(debugName, SimpleLanguage)