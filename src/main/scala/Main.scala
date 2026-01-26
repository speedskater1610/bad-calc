import javax.swing._
import javax.swing.WindowConstants
import java.awt.event._
import scala.jdk.CollectionConverters._

object Main {
  def main(args: Array[String]): Unit = {
    val frame = new JFrame("Worst Calculator Ever")
    frame.setSize(400, 150)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    val panel = new JPanel()
    val inputBox = new JTextField(20)
    val runButton = new JButton("Run")
    val outputLabel = new JLabel("Output will appear here")

    panel.add(inputBox)
    panel.add(runButton)
    panel.add(outputLabel)
    frame.add(panel)
    frame.setVisible(true)

    runButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val input = inputBox.getText
        val tokens = new Lexer(input).lex()
        val (ast, _) = new Parser(tokens).parseExpr(tokens)
        val bytecode = BytecodeGen.gen(ast)
        val vm = new VM()
    
        val result = vm.run(bytecode.asJava, 0)
        outputLabel.setText("Result: " + result)
      }
    })
  }
}



