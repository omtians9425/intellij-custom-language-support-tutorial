package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.impl

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class SimpleNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), SimpleNamedElement