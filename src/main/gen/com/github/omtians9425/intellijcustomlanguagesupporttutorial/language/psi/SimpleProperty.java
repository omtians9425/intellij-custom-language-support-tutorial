// This is a generated file. Not intended for manual editing.
package com.github.omtians9425.intellijcustomlanguagesupporttutorial.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleProperty extends SimpleNamedElement {

  @Nullable
  String getKey();

  @Nullable
  String getValue();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
