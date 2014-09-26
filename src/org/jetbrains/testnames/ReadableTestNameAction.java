package org.jetbrains.testnames;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.actions.BaseRefactoringAction;
import com.intellij.refactoring.actions.RenameElementAction;
import com.intellij.refactoring.rename.inplace.MemberInplaceRenameHandler;
import com.intellij.refactoring.rename.inplace.MemberInplaceRenamer;

public class ReadableTestNameAction extends BaseRefactoringAction {

  private static final NameSuggestions NAME_SUGGESTIONS = new NameSuggestions();

  private final RenameElementAction renameElementAction = new RenameElementAction();

  @Override
  public boolean isAvailableInEditorOnly() {
    return renameElementAction.isAvailableInEditorOnly();
  }

  @Override
  public boolean isEnabledOnElements(@NotNull PsiElement[] elements) {
    return renameElementAction.isEnabledOnElements(elements);
  }

  @Nullable
  @Override
  public RefactoringActionHandler getHandler(@NotNull DataContext dataContext) {
    return new MyRenameHandler();
  }

  private static class MyRenameHandler extends MemberInplaceRenameHandler {

    @NotNull
    @Override
    protected MemberInplaceRenamer createMemberRenamer(@NotNull PsiElement element,
                                                       PsiNameIdentifierOwner elementToRename,
                                                       Editor editor) {
      return new MyMemberInplaceRenamer(elementToRename, element, editor);
    }
  }

  private static class MyMemberInplaceRenamer extends MemberInplaceRenamer {

    private MyMemberInplaceRenamer(@NotNull PsiNamedElement elementToRename, PsiElement substituted, Editor editor) {
      super(elementToRename, substituted, editor);
    }

    @Override
    public boolean performInplaceRename() {
      return performInplaceRefactoring(NAME_SUGGESTIONS.suggestionsFor(myInitialName));
    }
  }
}
