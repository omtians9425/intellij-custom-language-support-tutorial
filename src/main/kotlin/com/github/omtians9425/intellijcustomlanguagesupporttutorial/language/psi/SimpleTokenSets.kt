package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi

import com.intellij.psi.tree.TokenSet

interface SimpleTokenSets {
    val IDENTIFIERS: TokenSet
        get() = TokenSet.create(SimpleTypes.KEY)

    val COMMENTS: TokenSet
        get() = TokenSet.create(SimpleTypes.COMMENT)
}