class Lexer(input: String) {
  def lex(pos: Int = 0): List[Token] =
    if (pos >= input.length)
      List(new Token(Token.Kind.EOF, ""))
    else input.charAt(pos) match {
      case '+' =>
        new Token(Token.Kind.PLUS, "+") :: lex(pos + 1)
      case c if c.isDigit =>
        new Token(Token.Kind.NUM, c.toString) :: lex(pos + 1)
      case _ =>
        lex(pos + 1)
    }
}

