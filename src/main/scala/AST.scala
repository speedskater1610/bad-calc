sealed trait AST
case class Num(value: Int) extends AST
case class Add(a: AST, b: AST) extends AST

