class Book                                      // line 1
{
  private int numPages;
  private String title;
  private String genre;
  private static int numBooks = 0;

  public Book()                                 // line 8
  {
    this(200, "Himura Kenshin", "Manga");
    numBooks++;
  }

  public Book(int p, String t, String g)        // line 14
  {
    numPages = p;
    title = t;
    genre = g;
    numBooks++;
  }

  public int getNumPages()                      // line 22
  {
    return numPages;
  }

  public String getTitle()                      // line 27
  {
    return title;
  }

  public String getGenre()                      // line 32
  {
    return genre;
  }

  private void setTitle(String t)               // line 37
  {
    title = t;
  }

  public static int getNumBooks()               // line 42
  {
    return numBooks;
  }
}
