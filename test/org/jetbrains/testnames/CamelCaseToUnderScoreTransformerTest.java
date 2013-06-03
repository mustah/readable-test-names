package org.jetbrains.testnames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
public class CamelCaseToUnderScoreTransformerTest {

  @Test
  public void Should_Replace_Camel_Case_With_Underscore() throws Exception {
    String withUnderscore = new CamelCaseToUnderScoreTransformer().transform("ShouldReplaceCamelCaseWithUnderscore");
    assertNotNull(withUnderscore);
    assertEquals("Should_Replace_Camel_Case_With_Underscore", withUnderscore);
  }
}
