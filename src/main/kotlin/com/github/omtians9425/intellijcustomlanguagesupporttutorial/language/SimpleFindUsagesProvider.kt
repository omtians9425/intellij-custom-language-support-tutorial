package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTokenSets
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet

class SimpleFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            SimpleLexerAdapter(),
            SimpleTokenSets.IDENTIFIERS,
            SimpleTokenSets.COMMENTS,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean = psiElement is PsiNamedElement

    override fun getHelpId(psiElement: PsiElement): String? = null

    override fun getType(element: PsiElement): String = if (element is SimpleProperty) "simple property" else ""

    override fun getDescriptiveName(element: PsiElement): String = (element as? SimpleProperty)?.key.orEmpty()

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        (element as? SimpleProperty)?.let {
            return it.key + SimpleAnnotator.SIMPLE_SEPARATOR_STR + it.value
        }
        return ""
    }
}