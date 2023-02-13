package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.impl

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleElementFactory
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTypes
import com.intellij.psi.PsiElement

object SimplePsiImplUtil {
    @JvmStatic
    fun getKey(element: SimpleProperty): String? {
        val keyNode = element.node.findChildByType(SimpleTypes.KEY)
        return keyNode?.text?.replace("\\\\ ".toRegex(), " ")
    }

    @JvmStatic
    fun getValue(element: SimpleProperty): String? {
        val valueNode = element.node.findChildByType(SimpleTypes.VALUE)
        return valueNode?.text
    }

    @JvmStatic
    fun getName(element: SimpleProperty): String? = getKey(element)

    @JvmStatic
    fun setName(element: SimpleProperty, newName: String): PsiElement {
        val keyNode = element.node.findChildByType(SimpleTypes.KEY)
        if (keyNode != null) {
            val property = SimpleElementFactory.createProperty(element.project, newName)
            val newKeyNode = property.firstChild.node
            element.node.replaceChild(keyNode, newKeyNode)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: SimpleProperty): PsiElement? = element.node.findChildByType(SimpleTypes.KEY)?.psi
}