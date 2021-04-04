package dev.viskar.lib.codegen.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLineConfig implements Cloneable {

    FromOptions from = new FromOptions();
    String template = "object";
    boolean accessors = true;
    LombokOptions lombok = new LombokOptions();
    Map<String, Object> rename = new HashMap<>();
    String staticInitializer = "";

    public FromOptions getFrom() {
        return from;
    }

    public void setFrom(FromOptions from) {
        this.from = from;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String tenmplate) {
        this.template = tenmplate;
    }

    public boolean isAccessors() {
        return accessors;
    }

    public void setAccessors(boolean accessors) {
        this.accessors = accessors;
    }

    public Map<String, Object> getRename() {
        return rename;
    }

    public void setRename(Map<String, Object> rename) {
        this.rename = rename;
    }

    public LombokOptions getLombok() {
        return lombok;
    }

    public void setLombok(LombokOptions lombok) {
        this.lombok = lombok;
    }

    public String getStaticInitializer() {
        return staticInitializer;
    }

    public void setStaticInitializer(String staticInitializer) {
        this.staticInitializer = staticInitializer;
    }

    public String toString(Class<?> cType) {
        return """
                from {
                %s}
                template = %s
                accessors = %s
                lombok {
                %s}""".formatted(
                from.toString(cType).indent(3),
                template,
                accessors ? "true" : "false",
                lombok.toString().indent(3));
    }

    public static class FromOptions {

        String packageName = "";
        String header = "";
        String constants = "";
        String type = "";
        boolean scan = false;
        List<String> exclude = new ArrayList<>();

        public String getPackage() {
            return packageName;
        }

        public void setPackage(String packageName) {
            this.packageName = packageName;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getConstants() {
            return constants;
        }

        public void setConstants(String constants) {
            this.constants = constants;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean getScan() {
            return scan;
        }

        public void setScan(boolean scan) {
            this.scan = scan;
        }

        public List<String> getExclude() {
            return exclude;
        }

        public void setExclude(List<String> exclude) {
            this.exclude = exclude;
        }

        public String toString(Class<?> cType) {
            String s = """
                    package = %s
                    header = %s
                    constants = %s
                    """.formatted(packageName, header, constants);
            if (scan) {
                s += """
                        scan = true
                        # Detected by scan:
                        """;
            }
            s += "type = %s".formatted(cType.getSimpleName());
            return s;
        }

        @Override
        public String toString() {
            return """
                    package = %s
                    header = %s
                    constants = %s
                    type = %s""".formatted(packageName, header, constants, type);
        }
    }

    public static class LombokOptions {

        private boolean sneakyThrows = false;

        public boolean isSneakyThrows() {
            return sneakyThrows;
        }

        public void setSneakyThrows(boolean sneakyThrows) {
            this.sneakyThrows = sneakyThrows;
        }

        @Override
        public String toString() {
            return "sneakyThrows = %b".formatted(sneakyThrows);
        }
    }

}
