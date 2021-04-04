package dev.viskar.lib.codegen.generator.utils;

import jdk.incubator.foreign.GroupLayout;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.SequenceLayout;
import jdk.incubator.foreign.ValueLayout;

import java.nio.ByteOrder;

public class MemoryLayoutPrinter {

    public static String format(MemoryLayout layout) {

        StringBuilder sb = new StringBuilder();
        String open = "{";
        String close = "}";

        new MemoryLayoutVisitor() {
            int indent = 0;
            boolean shouldIndent = false;

            void indent() {
                if (shouldIndent) {
                    for (int i = 0; i < indent; i++) {
                        sb.append(' ');
                    }
                    shouldIndent = false;
                }
            }

            // Add a space if there isn't already whitespace at the end of the buffer
            void whitespace() {
                int pos = sb.length() - 1;
                if (pos >= 0) {
                    char c = sb.charAt(pos);
                    if (c != ' ' && c != '\n') {
                        sb.append(' ');
                    }
                }
            }

            void newline() {
                sb.append('\n');
                shouldIndent = true;
            }

            @Override
            public boolean groupLayout(GroupLayout groupLayout) {
                indent();
                whitespace();
                appendName(sb, groupLayout);
                whitespace();
                sb.append(open);
                if (!groupLayout.memberLayouts().isEmpty()) {
                    indent += 2;
                    newline();
                    for (MemoryLayout layout : groupLayout.memberLayouts()) {
                        if (visit(layout)) {
                            newline();
                        }
                    }
                    indent -= 2;
                    indent();
                }
                sb.append(close);
                return true;
            }

            @Override
            public boolean valueLayout(ValueLayout valueLayout) {
                indent();
                whitespace();
                sb.append(valueLayout.order() == ByteOrder.BIG_ENDIAN
                        ? "B" + valueLayout.bitSize()
                        : "b" + valueLayout.bitSize());
                appendName(sb, " ", valueLayout);
                return true;
            }

            @Override
            public boolean sequenceLayout(SequenceLayout sequenceLayout) {
                visit(sequenceLayout.elementLayout());
                indent();
                sb.append(sequenceLayout.elementCount().isPresent()
                        ? "[" + sequenceLayout.elementCount().getAsLong() + "]"
                        : "[?]");
                appendName(sb, " ", sequenceLayout);
                return true;
            }
        }.visit(layout);

        return sb.toString().trim();
    }

    protected static void appendName(StringBuilder sb, MemoryLayout layout) {
        appendName(sb, "", layout);
    }

    protected static void appendName(StringBuilder sb, String prefixIfPresent, MemoryLayout layout) {
        if (layout.name().isPresent()) {
            sb.append(prefixIfPresent);
            prefixIfPresent = "";
            sb.append(layout.name().get());
        }
        if (layout instanceof GroupLayout && ((GroupLayout) layout).isUnion()) {
            sb.append(prefixIfPresent);
            prefixIfPresent = "";
            sb.append("(union)");
        }
        if (layout.isPadding()) {
            sb.append(prefixIfPresent);
            prefixIfPresent = "";
            sb.append("(padding)");
        }
    }

}
