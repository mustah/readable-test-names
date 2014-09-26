package org.jetbrains.testnames;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NameSuggestionsTest {

  private NameSuggestions nameSuggestions;

  @Before
  public void setup() {
    nameSuggestions = new NameSuggestions();
  }

  @Test
  public void Should_Return_Null_List_When_No_Initial_Name_Exists() throws Exception {
    assertNull(nameSuggestions.suggestionsFor(null));
  }

  @Test
  public void Should_Return_A_List_Of_Size_One_When_Initial_Name_Is_Provided() throws Exception {
    safeAssertEquals("Some_Camel_Case_Initial_Text", nameSuggestions.suggestionsFor("SomeCamelCaseInitialText"));
  }

  @Test
  public void Should_Return_The_Same_String_If_It_Is_Only_Test() throws Exception {
    safeAssertEquals("test", nameSuggestions.suggestionsFor("test"));
  }

  @Test
  public void Should_Add_One_More_Suggestion_That_Removes_The_Test_Prefix_Of_The_Name() throws Exception {
    Set<String> suggestions = nameSuggestions.suggestionsFor("testSomeCamelCaseInitialText");
    assertNotNull(suggestions);

    Iterator<String> iterator = suggestions.iterator();
    assertEquals(2, suggestions.size());
    assertEquals("Some_Camel_Case_Initial_Text", iterator.next());
    assertEquals("test_Some_Camel_Case_Initial_Text", iterator.next());
  }

  private void safeAssertEquals(String expected, Set<String> suggestions) {
    assertNotNull(suggestions);
    assertEquals(1, suggestions.size());
    assertEquals(expected, suggestions.iterator().next());
  }
}
