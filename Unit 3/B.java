class B extends A
{
  private String s1;

  public B()
  {
    s1 = "b";
  }

  public String getString()
  {
    return super.getString() + s1;
  }
}
