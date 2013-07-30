package org.jetbrains.testnames;

import java.util.Iterator;
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
    assertEquals("Some_Camel_Case_Initial_Text", suggestions.iterator().next());
  }

  @Test
  public void test_Should_Add_One_More_Suggestion_That_Removes_The_Test_Prefix_Of_The_Name() throws Exception {
    LinkedHashSet<String> suggestions = new NameSuggestionsProvider("testSomeCamelCaseInitialText").get();
    assertNotNull(suggestions);
    assertEquals(2, suggestions.size());
    Iterator<String> iterator = suggestions.iterator();
    assertEquals("Some_Camel_Case_Initial_Text", iterator.next());
    assertEquals("test_Some_Camel_Case_Initial_Text", iterator.next());
  }

  @Test
  public void Should_Return_The_Same_String_If_It_Is_Only_Test() throws Exception {
    LinkedHashSet<String> suggestions = new NameSuggestionsProvider("test").get();
    assertNotNull(suggestions);
    assertEquals(1, suggestions.size());
    assertEquals("test", suggestions.iterator().next());
  }
}
