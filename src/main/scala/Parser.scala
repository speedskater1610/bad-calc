class Parser(tokens: List[Token]) {
  def parseExpr(ts: List[Token]): (AST, List[Token]) = {
    val (lhs, rest) = parseTerm(ts)
    rest match {
      case t :: tail if t.kind == Token.Kind.PLUS =>
        val (rhs, r2) = parseExpr(tail)
        (Add(lhs, rhs), r2)
      case _ => (lhs, rest)
    }
  }

  def parseTerm(ts: List[Token]): (AST, List[Token]) =
    ts match {
      case t :: tail if t.kind == Token.Kind.NUM =>
        (Num(t.text.toInt), tail)
      case _ => sys.error("parse error")
    }
}

