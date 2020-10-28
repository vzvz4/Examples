package InnerNestedLocalClassesEx.LocalInner.Ex2;


class ClassLocal {
    Count createCount() {

        //локальный внутренни класс может иметь конструктор, анонимный класс нет
        class LocalCount implements Count {
            public LocalCount() {

            }

            @Override
            public int next() {
                return 0;
            }
        }
        return new LocalCount();
    }
}
