package lenala.azure.gradle.functions.bindings;

import com.microsoft.azure.functions.annotation.CustomBinding;

import java.lang.annotation.Annotation;

public class ExtendedCustomBinding extends Binding {

    private CustomBinding customBindingAnnotation;

    public ExtendedCustomBinding(BindingEnum bindingEnum,
                                 CustomBinding customBindingAnnotation,
                                 Annotation annotation) {
        super(bindingEnum, annotation);
        this.customBindingAnnotation = customBindingAnnotation;
    }

    @Override
    public String getName() {
        final String name = super.getName();
        if (name != null) {
            return name;
        }
        return customBindingAnnotation.name();
    }

    @Override
    public String getDirection() {
        if (this.direction != null) {
            return direction.toString();
        }
        return customBindingAnnotation.direction();
    }

    @Override
    public String getType() {
        if (type != null) {
            return type;
        }
        return customBindingAnnotation.type();
    }
}
