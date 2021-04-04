package dev.viskar.lib.codegen.generator.utils;

import jdk.incubator.foreign.GroupLayout;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.SequenceLayout;
import jdk.incubator.foreign.ValueLayout;

public abstract class MemoryLayoutVisitor {

    public boolean visit(MemoryLayout layout) {
        if (layout instanceof ValueLayout) {
            return valueLayout((ValueLayout) layout);
        } else if (layout instanceof GroupLayout) {
            return groupLayout((GroupLayout) layout);
        } else if (layout instanceof SequenceLayout) {
            return sequenceLayout((SequenceLayout) layout);
        } else if (layout != null) {
            return otherLayout(layout);
        } else {
            return false;
        }
    }

    public boolean groupLayout(GroupLayout groupLayout) {
        return false;
    }

    public boolean valueLayout(ValueLayout valueLayout) {
        return false;
    }

    public boolean sequenceLayout(SequenceLayout layout) {
        return false;
    }

    public boolean otherLayout(MemoryLayout other) {
        return false;
    }

}
