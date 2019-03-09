package com.annotation.training;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;


@SupportedAnnotationTypes("com.annotation.training.ClassCreator")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ClassCreatorProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (Element elem : roundEnv.getElementsAnnotatedWith(ClassCreator.class)) {
            System.out.println("J'ai réussi 1");
        }

        Filer filer = processingEnv.getFiler();
        System.out.println("J'ai réussi 2");
        Elements eltUtils = processingEnv.getElementUtils();
        TypeElement element = eltUtils.getTypeElement("com.annotation.training.ClassCreator");
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(element);
        if(!elements.isEmpty()) {
            try {
                PrintWriter pw = new PrintWriter(filer.createResource(
                        StandardLocation.SOURCE_OUTPUT, "", "Class.java")
                        .openOutputStream());
                        /*filer.createClassFile(
                        "Employe", null)
                        .openOutputStream());*/

                        pw.println("\"package com.annotation.training;\\n\" +\n" +
                                "\\n\" +\n" +
                                "public class maclasse {\\n\" +\n" +
                                "    private int nombre;\\n\" +\n" +
                                "\\n\" +\n" +
                                "    \\n\" +\n" +
                                "    public maclasse(int n) {\\n\" +\n" +
                                "        this.nombre = n;\\n\" +\n" +
                                "    }\\n\" +\n" +
                                "    \\n\" +\n" +
                                "    public int getNombre() {\\n\" +\n" +
                                "        return nombre;\\n\" +\n" +
                                "    }\\n\" +\n" +
                                "\\n\" +\n" +
                                "    public void setNombre(int nombre) {\\n\" +\n" +
                                "        this.nombre = nombre;\\n\" +\n" +
                                "    }\\n\" +\n" +
                                "}\"");

                        pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
