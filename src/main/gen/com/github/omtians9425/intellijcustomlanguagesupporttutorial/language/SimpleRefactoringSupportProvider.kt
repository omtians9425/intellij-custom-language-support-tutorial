package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement


class SimpleRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(elementToRename: PsiElement, context: PsiElement?): Boolean {
        return elementToRename is SimpleProperty
    }
}