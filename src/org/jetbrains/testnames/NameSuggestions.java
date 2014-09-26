package org.jetbrains.testnames;

import java.util.LinkedHashSet;

import org.jetbrains.annotations.Nullable;

class NameSuggestions {

  private static final int TEST_PREFIX_LENGTH = 5;

  @Nullable
  public LinkedHashSet<String> suggestionsFor(String initialName) {
    LinkedHashSet<String> nameSuggestions = null;
    if (initialName != null) {
      nameSuggestions = new LinkedHashSet<String>();
      String transformed = CamelCaseToUnderScore.transform(initialName);
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
    return transformed != null &&
           transformed.startsWith("test_") &&
           transformed.length() > TEST_PREFIX_LENGTH;
  }
}
