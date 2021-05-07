package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class RefiniTraidin extends TestBase
{
  @Test
  public void testRefiniTraidin() throws Exception
  {
    perehodvavtocredit();
    traidin("123 456");
    refinansirovanie(new Refinansirovanie("56 000"));
    knopkapodboracredita();
  }
}

