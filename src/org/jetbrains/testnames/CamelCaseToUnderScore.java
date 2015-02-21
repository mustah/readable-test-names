package org.jetbrains.testnames;

final class CamelCaseToUnderScore {

  private CamelCaseToUnderScore() {
  }

  static String transform(String str) {
    String transformed = camelCaseToUnderscore(str);
    return allowOnlySingleUnderscore(transformed);
  }

  private static String camelCaseToUnderscore(String str) {
    return str.replaceAll(
      String.format("%s|%s|%s",
                    "(?<=[A-Z])(?=[A-Z][a-z])",
                    "(?<=[^A-Z])(?=[A-Z])",
                    "(?<=[A-Za-z])(?=[^A-Za-z])"
      ),
      "_");
  }

  private static String allowOnlySingleUnderscore(String str) {
    return str.replaceAll(String.format("%s", "\\_+"), "_");
  }
}
