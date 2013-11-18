package org.jetbrains.testnames;

import java.util.Iterator;
import java.util.Set;

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
    safeAssertEquals("Some_Camel_Case_Initial_Text", new NameSuggestionsProvider("SomeCamelCaseInitialText").get());
  }

  @Test
  public void Should_Add_One_More_Suggestion_That_Removes_The_Test_Prefix_Of_The_Name() throws Exception {
    Set<String> suggestions = new NameSuggestionsProvider("testSomeCamelCaseInitialText").get();
    assertNotNull(suggestions);

    Iterator<String> iterator = suggestions.iterator();
    assertEquals(2, suggestions.size());
    assertEquals("Some_Camel_Case_Initial_Text", iterator.next());
    assertEquals("test_Some_Camel_Case_Initial_Text", iterator.next());
  }

  @Test
  public void Should_Return_The_Same_String_If_It_Is_Only_Test() throws Exception {
    safeAssertEquals("test", new NameSuggestionsProvider("test").get());
  }

  private void safeAssertEquals(String expected, Set<String> suggestions) {
    assertNotNull(suggestions);
    assertEquals(1, suggestions.size());
    assertEquals(expected, suggestions.iterator().next());
  }
}
