package com.annotation.training;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes("sdc.assets.annotations.Complexity")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ComplexityProcessor extends AbstractProcessor {

    public ComplexityProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        for (Element elem : roundEnv.getElementsAnnotatedWith(Complexity.class)) {
            Complexity complexity = elem.getAnnotation(Complexity.class);
            //String message = "annotation found in " + elem.getSimpleName()
            //        + " with complexity " + complexity.value();
            //processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
            //System.out.println(message);
            File exportedFile = new File("class.java");
            FileWriter fileWriter;
            try {
                exportedFile.createNewFile();
                fileWriter = new FileWriter(exportedFile);
                fileWriter.write("package com.annotation.training;\n" +
                                    "\n" +
                                    "public class maclasse {\n" +
                                    "    private int nombre;\n" +
                                    "\n" +
                                    "    \n" +
                                    "    public maclasse(int n) {\n" +
                                    "        this.nombre = n;\n" +
                                    "    }\n" +
                                    "    \n" +
                                    "    public int getNombre() {\n" +
                                    "        return nombre;\n" +
                                    "    }\n" +
                                    "\n" +
                                    "    public void setNombre(int nombre) {\n" +
                                    "        this.nombre = nombre;\n" +
                                    "    }\n" +
                                    "}");
                fileWriter.close();

                System.out.println("file written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}