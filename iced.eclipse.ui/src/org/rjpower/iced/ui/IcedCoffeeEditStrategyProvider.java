package org.rjpower.iced.ui;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.PartitionDeletionEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.PartitionEndSkippingEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.PartitionInsertEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

public class IcedCoffeeEditStrategyProvider extends
    AbstractEditStrategyProvider {
  public static class IndentBlock implements IAutoEditStrategy {

    @Override
    public void customizeDocumentCommand(IDocument document,
        DocumentCommand command) {

    }

  }

  protected void multiline(IEditStrategyAcceptor acceptor, String left,
      String indent, String right) {
    acceptor.accept(new MultiLineTerminalsEditStrategy(left, indent, right),
        IDocument.DEFAULT_CONTENT_TYPE);
  }

  protected void singleline(IEditStrategyAcceptor acceptor, String left,
      String right) {
    acceptor.accept(new SingleLineTerminalsStrategy(left, right,
        SingleLineTerminalsStrategy.DEFAULT), IDocument.DEFAULT_CONTENT_TYPE);
  }

  @Override
  protected void configure(IEditStrategyAcceptor acceptor) {
    System.err.println("Configuring editor...");
    String cType = IDocument.DEFAULT_CONTENT_TYPE;
    acceptor.accept(new DefaultIndentLineAutoEditStrategy(), cType);
    multiline(acceptor, "=", "  ", "\n");
    multiline(acceptor, "->", "  ", "\n");
    multiline(acceptor, "=>", "  ", "\n");
    multiline(acceptor, "(", "  ", ")");
    multiline(acceptor, "{", "  ", "}");
    singleline(acceptor, "(", ")");
    singleline(acceptor, "{", "}");
    acceptor.accept(new PartitionInsertEditStrategy("\"\"\"", "\"\"\""), cType);
    acceptor.accept(new PartitionInsertEditStrategy("\'\'\'", "\'\'\'"), cType);
    acceptor.accept(new PartitionInsertEditStrategy("\"", "\""), cType);
    acceptor.accept(new PartitionInsertEditStrategy("'", "'"), cType);
    acceptor.accept(new PartitionDeletionEditStrategy("\"\"\"", "\"\"\""),
        cType);
    acceptor.accept(new PartitionDeletionEditStrategy("'''", "''''"), cType);
    acceptor.accept(new PartitionDeletionEditStrategy("\"", "\""), cType);
    acceptor.accept(new PartitionDeletionEditStrategy("'", "'"), cType);
    PartitionEndSkippingEditStrategy endPart = new PartitionEndSkippingEditStrategy();
    endPart
        .withRightDelimiter(TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
    acceptor.accept(endPart, cType);
  }
}