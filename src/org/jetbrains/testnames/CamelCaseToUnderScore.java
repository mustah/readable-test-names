package org.jetbrains.testnames;

final class CamelCaseToUnderScore {

  private CamelCaseToUnderScore() {
  }

  static String transform(String stringToTransform) {
    return stringToTransform.replaceAll(
      String.format("%s|%s|%s",
                    "(?<=[A-Z])(?=[A-Z][a-z])",
                    "(?<=[^A-Z])(?=[A-Z])",
                    "(?<=[A-Za-z])(?=[^A-Za-z])"
      ),
      "_");
  }
}
