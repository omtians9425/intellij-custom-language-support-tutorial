package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleFileType
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class SimpleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimpleLanguage) {
    override fun getFileType(): FileType {
        return SimpleFileType
    }

    override fun toString(): String {
        return "Simple File"
    }
}