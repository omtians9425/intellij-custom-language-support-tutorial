// This is a generated file. Not intended for manual editing.
package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.SimpleTypes.*;
import com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi.*;

public class SimplePropertyImpl extends SimpleNamedElementImpl implements SimpleProperty {

  public SimplePropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public String getKey() {
    return SimplePsiImplUtil.getKey(this);
  }

  @Override
  @Nullable
  public String getValue() {
    return SimplePsiImplUtil.getValue(this);
  }

  @Override
  @Nullable
  public String getName() {
    return SimplePsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newName) {
    return SimplePsiImplUtil.setName(this, newName);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return SimplePsiImplUtil.getNameIdentifier(this);
  }

}
