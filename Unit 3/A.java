class A
{
  private String s;

  public A()
  {
    s = "abc";
  }

  public A(String s1)
  {
    s = s1;
  }

  public String getString()
  {
    return s;
  }

  public boolean equals(A a)
  {
    return s.equals(a.s);
  }
}
