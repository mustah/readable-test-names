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

/**
 * <br> User: must <br> Date: 2013-06-02
 */
public class ReadableTestNameAction extends BaseRefactoringAction {

  private final RenameElementAction renameElementAction = new RenameElementAction();

  @Override
  public boolean isAvailableInEditorOnly() {
    return renameElementAction.isAvailableInEditorOnly();
  }

  @Override
  public boolean isEnabledOnElements(@NotNull final PsiElement[] elements) {
    return renameElementAction.isEnabledOnElements(elements);
  }

  @Nullable
  @Override
  public RefactoringActionHandler getHandler(@NotNull final DataContext dataContext) {
    return new MyRenameHandler();
  }

  private static class MyRenameHandler extends MemberInplaceRenameHandler {

    @NotNull
    @Override
    protected MemberInplaceRenamer createMemberRenamer(@NotNull final PsiElement element,
                                                       final PsiNameIdentifierOwner elementToRename,
                                                       final Editor editor) {
      return new MyMemberInplaceRenamer(elementToRename, element, editor);
    }
  }

  private static class MyMemberInplaceRenamer extends MemberInplaceRenamer {

    private MyMemberInplaceRenamer(@NotNull final PsiNamedElement elementToRename,
                                   final PsiElement substituted,
                                   final Editor editor) {
      super(elementToRename, substituted, editor);
    }

    @Override
    public boolean performInplaceRename() {
      return performInplaceRefactoring(new NameSuggestionsProvider(myInitialName).get());
    }
  }
}
