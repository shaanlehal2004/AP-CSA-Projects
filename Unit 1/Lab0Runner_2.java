public class Lab0Runner_2{
public static void main(String args[]){

  System.out.println("-----Tests for getPWStrength-----");
  System.out.println(Lab0_2.getPWStrength("goBIGBLUE!!1!!"));
  System.out.println(Lab0_2.getPWStrength("pingry"));
  System.out.println(Lab0_2.getPWStrength("GoBigBlue"));
  System.out.println(Lab0_2.getPWStrength("B$e@k!n&b@d5<A>"));
  System.out.println();

  System.out.println("-----Tests for checkComplexity-----");
  System.out.println(Lab0_2.checkComplexity("Pingry123"));
  System.out.println(Lab0_2.checkComplexity("pingry"));
  System.out.println(Lab0_2.checkComplexity("GoBigBlue12"));
  System.out.println(Lab0_2.checkComplexity("B$e@k!n&b@d5<A>"));

  System.out.println("-----Tests for generatePW-----");
  System.out.println("To verify they meet the strength requirement, I ran getPWStrength on them too.");
  String a = Lab0_2.generatePW();
  System.out.println(a);
  System.out.println(Lab0_2.getPWStrength(a));
  String b = Lab0_2.generatePW();
  System.out.println(b);
  System.out.println(Lab0_2.getPWStrength(b));
  String c = Lab0_2.generatePW();
  System.out.println(c);
  System.out.println(Lab0_2.getPWStrength(c));
  String d = Lab0_2.generatePW();
  System.out.println(d);
  System.out.println(Lab0_2.getPWStrength(d));

  System.out.println("-----Tests for decryptPW and encryptPW-----");
  System.out.println("The first printed line is the encrypted password, and the second the decrypted version using the decrypt function");
  String e = Lab0_2.encryptPW("breakfast2", "fried!Eggs2Sunny*SideUp$$");
  System.out.println(e);
  System.out.println(Lab0_2.decryptPW("breakfast2",e));
  System.out.println();
  String f = Lab0_2.encryptPW("lunch@", "saladsAre@tasty7");
  System.out.println(f);
  System.out.println(Lab0_2.decryptPW("lunch@",f));
  System.out.println();
  String g = Lab0_2.encryptPW("dinner!", "chinese-Food2018");
  System.out.println(g);
  System.out.println(Lab0_2.decryptPW("dinner!",g));
  System.out.println();
  String h = Lab0_2.encryptPW("des2sert%", "chocolate10Cake^");
  System.out.println(h);
  System.out.println(Lab0_2.decryptPW("des2sert%",h));

}
}
