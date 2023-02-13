package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleAnnotator.Companion.SIMPLE_PREFIX_STR
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleAnnotator.Companion.SIMPLE_SEPARATOR_STR
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext


class SimpleReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiLiteralExpression::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val value = (element as? PsiLiteralExpression)?.value as? String
                    if (value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
                        val property = TextRange(
                            SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length + 1,
                            value.length + 1
                        )
                        return arrayOf(SimpleReference(element, property))
                    }
                    return PsiReference.EMPTY_ARRAY
                }
            })
    }
}