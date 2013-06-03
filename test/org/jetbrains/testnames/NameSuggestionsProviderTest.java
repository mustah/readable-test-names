package org.jetbrains.testnames;

import java.util.LinkedHashSet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * <br> User: must <br> Date: 2013-06-02
 */
public class NameSuggestionsProviderTest {

  @Test
  public void Should_Return_Null_List_When_No_Initial_Name_Exists() throws Exception {
    assertNull(new NameSuggestionsProvider(null).get());
  }

  @Test
  public void Should_Return_A_List_Of_Size_One_When_Initial_Name_Is_Provided() throws Exception {
    LinkedHashSet<String> suggestions = new NameSuggestionsProvider("SomeCamelCaseInitialText").get();
    assertNotNull(suggestions);
    assertEquals(1, suggestions.size());
  }
}
