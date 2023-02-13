package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.SimpleUtil.findProperties
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleProperty
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.impl.source.tree.java.PsiJavaTokenImpl

class SimpleLineMarkerProvider : RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(
        element: PsiElement,
        result: MutableCollection<in RelatedItemLineMarkerInfo<*>>
    ) {
        // This must be an element with a literal expression as a parent
        if (element !is PsiJavaTokenImpl || element.parent !is PsiLiteralExpression) return

        // The literal expression must start with the Simple language literal expression
        val literalExpression = element.parent as PsiLiteralExpression
        val value = literalExpression.value as? String ?: return
        if (!value.startsWith(SimpleAnnotator.SIMPLE_PREFIX_STR + SimpleAnnotator.SIMPLE_SEPARATOR_STR)) return

        // Get the Simple language property usage
        val project = element.project
        val possibleProperties = value.substring(
            SimpleAnnotator.SIMPLE_PREFIX_STR.length + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length
        )
        val properties = findProperties(project, possibleProperties)
        if (properties.isNotEmpty()) {
            // Add the property to a collection of line marker info
            val builder = NavigationGutterIconBuilder.create(SimpleIcons.FILE)
                .setTargets(properties)
                .setTooltipText("Navigate to Simple language property")
            result.add(builder.createLineMarkerInfo(element))
        }
    }
}