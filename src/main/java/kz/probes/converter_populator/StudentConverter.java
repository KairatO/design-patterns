package kz.probes.converter_populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentConverter<SOURCE, TARGET> {

    private Class<TARGET> targetClass;

    private List<Populator<SOURCE, TARGET>> populators = new ArrayList<>();

    public StudentConverter(Class<TARGET> targetClass) {
        this.targetClass = targetClass;
    }

    public static <SOURCE, TARGET> StudentConverter<SOURCE, TARGET> of(Class<TARGET> targetClass) {
        return new StudentConverter<>(targetClass);
    }

    public StudentConverter<SOURCE, TARGET> addPopulator(Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
            return this;
        } else {
            throw new IllegalArgumentException("populator cannot be null");
        }
    }

    public TARGET convert(SOURCE source) {
        TARGET target = createFromClass();
        if (populators == null || populators.size() <= 0) {
            throw new IllegalStateException("populators list is empty!");
        }
        for (Populator<SOURCE, TARGET> populator : populators) {
            populator.populate(source, target);
        }

        return target;
    }

    private TARGET createFromClass() {
        try {
            return targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
