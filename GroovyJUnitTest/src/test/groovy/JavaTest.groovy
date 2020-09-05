class JavaTest extends GroovyTestCase {

    def stringUtil = new ClassToTestTo()

    void testConcatenation() {
        def result = stringUtil.concat(['Luke', 'John'], '-')
        assertToString('Luke-John', result)
    }

    void testConcatenationWithEmptyList() {
        def result = stringUtil.concat([], ',')
        assertEquals('', result)
    }
}