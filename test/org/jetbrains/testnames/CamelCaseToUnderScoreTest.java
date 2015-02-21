package org.jetbrains.testnames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CamelCaseToUnderScoreTest {

  @Test
  public void Should_Replace_Camel_Case_With_Underscore() throws Exception {
    assertEqualsAfterTransformed("ShouldReplaceCamelCaseWithUnderscore", "Should_Replace_Camel_Case_With_Underscore");
  }

  @Test
  public void Should_Separate_On_Camel_Case_And_Numbers() throws Exception {
    assertEqualsAfterTransformed("testConvert2Map", "test_Convert_2_Map");
  }

  @Test
  public void Do_Not_Add_More_Underscores_If_Already_Transformed() {
    assertEqualsAfterTransformed("a__a", "a_a");
    assertEqualsAfterTransformed("a___a", "a_a");
    assertEqualsAfterTransformed("__a___a", "_a_a");
    assertEqualsAfterTransformed("a___b_________c", "a_b_c");
    assertEqualsAfterTransformed("When_Exception_Is_Thrown_During_Command_Creation_Then_Perform_Should_Throw_Exception",
                                 "When_Exception_Is_Thrown_During_Command_Creation_Then_Perform_Should_Throw_Exception");
  }

  private void assertEqualsAfterTransformed(String actualToTransform, String expected) {
    assertEquals(expected, CamelCaseToUnderScore.transform(actualToTransform));
  }
}
