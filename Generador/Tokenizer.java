package Generador;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer
{
  private class TokenInfo
  {
    public final Pattern regex;
    //public final int token;
    public final String token;

    public TokenInfo(Pattern regex, String token)
    {
      super();
      this.regex = regex;
      this.token = token;
    }
  }
  
  public class Token
  {
    public final String token;
    public final String sequence;
    
    public Token(String token, String sequence)
    {
      super();
      this.token = token;
      this.sequence = sequence;
    }
    
  }

  private LinkedList<TokenInfo> tokenInfos;
  private LinkedList<Token> tokens;
  
  public Tokenizer()
  {
    tokenInfos = new LinkedList<TokenInfo>();
    tokens = new LinkedList<Token>();
  }
  
  public void add(String regex, String token)
  {
    tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
  }
  
  public void tokenize(String str)
  {
  	String b[] = new String[90];
  	int i = 0;
    String s = str.trim();
    tokens.clear();
  fuera:   
    while (!s.equals(""))
    {
      boolean match = false; 
    
      for (TokenInfo info : tokenInfos)
      {
        Matcher m = info.regex.matcher(s);
        if (m.find())
        {
          match = true;
          String tok = m.group().trim();
          s = m.replaceFirst("").trim();
          tokens.add(new Token(info.token, tok));
          break;
        }
       
      }
 if (!match) throw new ParserException("CARACTER NO DEFINIDO: "+s);
 //continue fuera;
 
    }
    
      
 
  }
  
  public LinkedList<Token> getTokens()
  {
    return tokens;
  }
  
}
