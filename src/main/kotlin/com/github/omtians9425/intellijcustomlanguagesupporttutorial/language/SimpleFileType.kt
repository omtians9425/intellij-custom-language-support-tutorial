package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object SimpleFileType : LanguageFileType(SimpleLanguage) {

    override fun getName(): String = "Simple File"

    override fun getDescription(): String = "Simple language file"

    override fun getDefaultExtension(): String = "simple"

    override fun getIcon(): Icon = SimpleIcons.FILE
}