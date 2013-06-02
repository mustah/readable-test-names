package org.jetbrains.testnames;

import org.jetbrains.annotations.NotNull;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
class CamelCaseToUnderScoreTransformer {

  public String transform(@NotNull final String stringToTransform) {
    return stringToTransform.replaceAll("([a-z])([A-Z])", "$1_$2");
  }
}
