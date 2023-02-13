package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleFile
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

object SimpleUtil {

    fun findProperties(project: Project, key: String): List<SimpleProperty> {
        val result = mutableListOf<SimpleProperty>()
        val virtualFiles = FileTypeIndex.getFiles(SimpleFileType, GlobalSearchScope.allScope(project))

        virtualFiles.forEach { virtualFile ->
            val simpleFile = PsiManager.getInstance(project).findFile(virtualFile) as? SimpleFile
            if (simpleFile != null) {
                val properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                properties?.forEach { property ->
                    if (key == property.key) result.add(property)
                }
            }
        }

        return result
    }

    fun findProperties(project: Project): List<SimpleProperty> {
        val result = mutableListOf<SimpleProperty>()
        val virtualFiles = FileTypeIndex.getFiles(SimpleFileType, GlobalSearchScope.allScope(project))

        virtualFiles.forEach { virtualFile ->
            val simpleFile = PsiManager.getInstance(project).findFile(virtualFile) as? SimpleFile
            if (simpleFile != null) {
                val properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                if (properties != null) result.addAll(properties)
            }
        }
        return result
    }

    fun findDocumentationComment(property: SimpleProperty): String {
        val result: MutableList<String> = LinkedList()
        var element: PsiElement = property.prevSibling

        while (element is PsiComment || element is PsiWhiteSpace) {
            if (element is PsiComment) {
                val commentText = element.getText().replaceFirst("[!# ]+", "")
                result.add(commentText)
            }
            element = element.prevSibling
        }
        return result.reversed().joinToString { "\n " }
    }
}