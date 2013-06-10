package org.jetbrains.testnames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
public class CamelCaseToUnderScoreTransformerTest {

  private final CamelCaseToUnderScoreTransformer camelCaseToUnderScore = new CamelCaseToUnderScoreTransformer();

  @Test
  public void Should_Replace_Camel_Case_With_Underscore() throws Exception {
    String transformed = camelCaseToUnderScore.transform("ShouldReplaceCamelCaseWithUnderscore");
    assertEquals("Should_Replace_Camel_Case_With_Underscore", transformed);
  }

  @Test
  public void Should_Separate_On_Camel_Case_And_Numbers() throws Exception {
    String transformed = camelCaseToUnderScore.transform("testConvert2Map");
    assertEquals("test_Convert_2_Map", transformed);
  }
}
