package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class VhodsParametrami extends TestBase{

  @Test
  public void testVhodsParametrami() throws Exception
  {
    //выделели вспомогательные методы, которые описаны ниже
    perehodvavtocredit();
    vvodgodaavto(new Vvodimiedanniegoda("2018"));
    vvodstoimostiavto(new Vvodimiedanniesumm("200 001"));
    knopkapodboracredita();
  }

}
