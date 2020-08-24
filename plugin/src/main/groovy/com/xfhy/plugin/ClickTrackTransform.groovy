package com.xfhy.plugin

import com.xfhy.plugin.base.BaseTransform
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

class ClickTrackTransform extends BaseTransform {

    @Override
    String getName() {
        return "ClickTrackTransform"
    }

    @Override
    ClassVisitor getClassVisitor(ClassWriter classWriter) {
        return new ClickTrackClassVisitor(classWriter)
    }

    @Override
    boolean isNeedTraceClass(File file) {
        def name = file.name
        if (!name.endsWith(".class")
                || name.startsWith("R.class")
                || name.startsWith('R$')) {
            return false
        }
        return true
    }
}