package org.openrewrite.visitors;

import org.openrewrite.java.AddAnnotation;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;

public class ReplaceAnnotationOnMethods extends JavaRefactorVisitor {
    private String annotationBefore;
    private String annotationAfter;

    public ReplaceAnnotationOnMethods(String annotationBefore, String annotationAfter) {
        this.annotationBefore = annotationBefore;
        this.annotationAfter = annotationAfter;
    }

    public J visitMethod(J.MethodDecl method) {
        if(!method.findAnnotations("@" + this.annotationBefore).isEmpty() &&
            method.findAnnotations("@" + this.annotationAfter).isEmpty()) {
            andThen(new RemoveAnnotationOnMethod.Scoped(method, this.annotationBefore));
            andThen(new AddAnnotation.Scoped(method, this.annotationAfter));
        }
        return super.visitMethod(method);
    }
}
