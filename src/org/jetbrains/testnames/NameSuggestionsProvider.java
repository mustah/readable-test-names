package org.jetbrains.testnames;

import java.util.LinkedHashSet;

import org.jetbrains.annotations.Nullable;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
class NameSuggestionsProvider {

  private final String initialName;

  NameSuggestionsProvider(@Nullable final String initialName) {
    this.initialName = initialName;
  }

  @Nullable
  public LinkedHashSet<String> get() {
    LinkedHashSet<String> nameSuggestions = null;
    if (initialName != null) {
      nameSuggestions = new LinkedHashSet<String>();
      nameSuggestions.add(new CamelCaseToUnderScoreTransformer().transform(initialName));
    }
    return nameSuggestions;
  }
}
