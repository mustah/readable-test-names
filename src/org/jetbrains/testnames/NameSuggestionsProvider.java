package org.jetbrains.testnames;

import java.util.LinkedHashSet;

import org.jetbrains.annotations.Nullable;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
class NameSuggestionsProvider {

  private static final int TEST_PREFIX_LENGTH = 5;

  private final String initialName;

  NameSuggestionsProvider(@Nullable String initialName) {
    this.initialName = initialName;
  }

  @Nullable
  public LinkedHashSet<String> get() {
    LinkedHashSet<String> nameSuggestions = null;
    if (initialName != null) {
      nameSuggestions = new LinkedHashSet<String>();
      String transformed = new CamelCaseToUnderScoreTransformer().transform(initialName);
      removeTestPrefixAndAddAsNewSuggestions(nameSuggestions, transformed);
      nameSuggestions.add(transformed);
    }
    return nameSuggestions;
  }

  private void removeTestPrefixAndAddAsNewSuggestions(LinkedHashSet<String> nameSuggestions, String transformed) {
    if (startsWithTest(transformed)) {
      nameSuggestions.add(transformed.substring(TEST_PREFIX_LENGTH));
    }
  }

  private boolean startsWithTest(String transformed) {
    return transformed != null && transformed.startsWith("test_") && transformed.length() > TEST_PREFIX_LENGTH;
  }
}
