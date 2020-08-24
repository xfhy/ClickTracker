package com.xfhy.plugin


import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.commons.AdviceAdapter

/**
 * 防止快速点击
 */
class ClickTrackClassVisitor extends ClassVisitor {

    ClickTrackClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor)
    }

    @Override
    MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        def methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions)
        if (name == "onClick" && descriptor == "(Landroid/view/View;)V") {
            return new FastMethodVisitor(api, methodVisitor, access, name, descriptor)
        } else {
            return methodVisitor
        }
    }

    class FastMethodVisitor extends AdviceAdapter {

        FastMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
            super(api, methodVisitor, access, name, descriptor)
        }

        //方法进入
        @Override
        protected void onMethodEnter() {
            super.onMethodEnter()
            mv.visitVarInsn(ALOAD, 1)
            mv.visitMethodInsn(INVOKESTATIC, "com/xfhy/library/FastClickUtil", "shouldDoClick", "(Landroid/view/View;)Z", false);
            Label l1 = new Label()
            mv.visitJumpInsn(IFNE, l1)
            mv.visitInsn(RETURN)
            mv.visitLabel(l1)
            mv.visitFrame(F_SAME, 0, null, 0, null)
        }

        /*
        插入之后的代码如下:
         public void onClick(View view) {
            if (FastClickUtil.shouldDoClick(view)) {
                Log.d("xfhy777", "按钮2 点击事件");
            }
        }
         */

    }

}
