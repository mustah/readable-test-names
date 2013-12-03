package org.jetbrains.testnames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
public class CamelCaseToUnderScoreTest {

  @Test
  public void Should_Replace_Camel_Case_With_Underscore() throws Exception {
    assertEqualsAfterTransformed("ShouldReplaceCamelCaseWithUnderscore", "Should_Replace_Camel_Case_With_Underscore");
  }

  @Test
  public void Should_Separate_On_Camel_Case_And_Numbers() throws Exception {
    assertEqualsAfterTransformed("testConvert2Map", "test_Convert_2_Map");
  }

  private void assertEqualsAfterTransformed(String actualToTransform, String expected) {
    assertEquals(expected, CamelCaseToUnderScore.transform(actualToTransform));
  }
}
