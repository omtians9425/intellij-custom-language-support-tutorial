package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object SimpleElementFactory {

    @JvmStatic
    fun createProperty(project: Project, name: String): SimpleProperty {
        val file = createFile(project, name)
        return file.firstChild as SimpleProperty
    }

    @JvmStatic
    fun createFile(project: Project, text: String): SimpleFile {
        val name = "dummy.simple"
        return PsiFileFactory.getInstance(project).createFileFromText(name, SimpleFileType, text) as SimpleFile
    }
}