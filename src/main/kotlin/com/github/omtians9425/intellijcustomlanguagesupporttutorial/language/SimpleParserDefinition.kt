package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language

import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.parser.SimpleParser
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleFile
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTokenSets
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class SimpleParserDefinition : ParserDefinition {

    private val FILE = IFileElementType(SimpleLanguage)

    override fun createLexer(project: Project?): Lexer = SimpleLexerAdapter()

    override fun createParser(project: Project?): PsiParser = SimpleParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = SimpleTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = SimpleTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = SimpleFile(viewProvider)
}