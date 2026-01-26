object BytecodeGen {
  def gen(ast: AST): List[Bytecode] = ast match {
    case Num(v) =>
      List(
        new Bytecode(Bytecode.Op.PUSH_NUM, v),
        new Bytecode(Bytecode.Op.BF, v)
      )
    case Add(a, b) =>
      gen(a) ::: gen(b) ::: List(
        new Bytecode(Bytecode.Op.XFER, 0),
        new Bytecode(Bytecode.Op.HEAP, 0)
      )
  }
}

