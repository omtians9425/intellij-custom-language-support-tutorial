package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.impl

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTypes

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
}