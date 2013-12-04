package org.jetbrains.testnames;

import org.jetbrains.annotations.NotNull;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
final class CamelCaseToUnderScore {

  private CamelCaseToUnderScore() {
  }

  @NotNull
  static String transform(@NotNull String stringToTransform) {
    return stringToTransform.replaceAll(
      String.format("%s|%s|%s",
                    "(?<=[A-Z])(?=[A-Z][a-z])",
                    "(?<=[^A-Z])(?=[A-Z])",
                    "(?<=[A-Za-z])(?=[^A-Za-z])"
      ),
      "_");
  }
}
