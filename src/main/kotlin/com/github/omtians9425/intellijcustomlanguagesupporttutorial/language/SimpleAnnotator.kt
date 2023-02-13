package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleUtil.findProperties
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression


class SimpleAnnotator : Annotator {

    companion object {
        // Define strings for the Simple language prefix - used for annotations, line markers, etc.
        const val SIMPLE_PREFIX_STR = "simple"
        const val SIMPLE_SEPARATOR_STR = ":"
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // Ensure the Psi Element is an expression
        val literalExpression = element as? PsiLiteralExpression ?: return

        // Ensure the Psi element contains a string that starts with the prefix and separator
        val value = literalExpression.value as? String
        if (value == null || !value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
            return
        }

        // Define the text ranges (start is inclusive, end is exclusive)
        // "simple:key"
        //  01234567890
        val prefixRange: TextRange =
            TextRange.from(element.getTextRange().startOffset, SIMPLE_PREFIX_STR.length + 1)
        val separatorRange: TextRange = TextRange.from(prefixRange.endOffset, SIMPLE_SEPARATOR_STR.length)
        val keyRange = TextRange(separatorRange.endOffset, element.getTextRange().endOffset - 1)

        // highlight "simple" prefix and ":" separator
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create()
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(separatorRange).textAttributes(SimpleSyntaxHighlighter.SEPARATOR).create()

        // Get the list of properties for given key
        val key = value.substring(SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length)
        val properties = findProperties(element.getProject(), key)
        if (properties.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
                .range(keyRange)
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                // ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
//                .withFix(SimpleCreatePropertyQuickFix(key))
                .create()
        } else {
            // Found at least one property, force the text attributes to Simple syntax value character
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(keyRange).textAttributes(SimpleSyntaxHighlighter.VALUE).create()
        }
    }
}