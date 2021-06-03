package AnnotationAndClassLoading.compileFromMemory;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class CompileSourceInMemory {

    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println("public class HelloWorld {");
        out.println("  public static void main(String args[]) {");
        out.println("    System.out.println(\"This is in another java file\");");
        out.println("  }");
        out.println("}");
        out.flush();
        out.close();
        JavaFileObject file = new JavaSourceFromString("HelloWorld", writer.toString());
        System.out.println(file);

        Iterable<? extends JavaFileObject> compilationUnits = Collections.singletonList(file);
        CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics())
            System.out.println(diagnostic);
        System.out.println("Success: " + success);

        if (success) {
            try {
                MyClassLoader loader = new MyClassLoader();

                Class<?> my = loader.findClass("HelloWorld.class");

                Method m = my.getMethod("main", String[].class);

                Object o = my.newInstance();
                m.invoke(o, new Object[]{new String[0]});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

    static class MyClassLoader extends ClassLoader {

        @Override
        public Class<?> findClass(String f) throws ClassNotFoundException {
            try {
                byte[] raw = Files.readAllBytes(Paths.get(f));
                return defineClass(null, raw, 0, raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.findClass(f);
        }
    }
}
