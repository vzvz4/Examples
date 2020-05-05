package InnerNestedLocalClassesEx.AnonymousClassExample.Ex2;

public class ClassAnon {
    Count createCount() {
        return new Count() {
            @Override
            public int next() {
                return 2;
            }
        };
    }
}

//class ClassLocal {
//    Count createCount() {
//        class LocalCount implements Count {
//            @Override
//            public int next() {
//                return 0;
//            }
//        }
//        return new LocalCount();
//    }
//}
